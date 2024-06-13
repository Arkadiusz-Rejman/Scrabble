package amk.scrabble.servlets;



import amk.scrabble.model.*;
import amk.scrabble.utils.IndexesHolder;
import amk.scrabble.utils.PolishDictionaryChecker;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(name = "turnManagerServlet", urlPatterns = "/turnManagerServlet")
public class TurnManagerServlet extends HttpServlet {

    private PolishDictionaryChecker checker;
    public List<Word> wordLetters;


    @Override
    public void init() throws ServletException {
        try {
            checker = new PolishDictionaryChecker(getServletContext(), "/WEB-INF/slowa.txt");
        } catch (IOException e) {
            throw new ServletException("Nie udało się załadować pliku słownika", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //WCZYTANIE DANYCH DO PRZETWORZENIA
        Player previousPlayer = GameSession.get().getTurn().getPlayerTurn();
        List<Integer> indexesToRemove = new ArrayList<>(GameSession.get().getTurn().getTilesIndexesToRemove());
        List<IndexesHolder> boardIndexesToAdd = new ArrayList<>(GameSession.get().getTurn().getBoardIndexesToAdd());
        //

        //WCZYTYWANIE PRZENIESIONYCH SKRABLI DO GAME BOARD
        for(IndexesHolder indexesHolder : boardIndexesToAdd) {
            Tile tile = previousPlayer.getDock()[indexesHolder.getStoredIndex()];
            GameSession.get().getGameBoard().getBoardField(indexesHolder.getI1(), indexesHolder.getI2()).setTileOnField(tile);
        }

        //SZUKANIE NOWO POWSTALYCH SLOW I LICZENIE PKT
        System.out.println("ZNALEZIONO " + GameSession.get().getGameBoard().getNewWords().size() + " NOWYCH!");

        wordLetters = GameSession.get().getGameBoard().getNewWords();



        for (Word word : wordLetters) {
            System.out.println("Przetwarzane słowo: " + word);
            if(checker.isWordInDictionary(word.toString().toLowerCase())){
                System.out.println("Słowo intnieje :)");

                int totalPoints = 0;
                int wordMultiplier = 1;

                for (BoardField boardField : word.getBoardFields()) {
                    int tilePoints = boardField.getTileOnField().getPoints();

                    boolean hasBonus = boardIndexesToAdd.stream()
                            .anyMatch(indexesHolder -> boardField.getI1() == indexesHolder.getI1() && boardField.getI2() == indexesHolder.getI2());

                    if (hasBonus) {
                        switch (boardField.getBonusType()) {
                            case DOUBLE_LETTER_SCORE:
                                tilePoints *= 2;
                                break;
                            case DOUBLE_WORD_SCORE:
                                wordMultiplier *= 2;
                                break;
                            case TRIPLE_LETTER_SCORE:
                                tilePoints *= 3;
                                break;
                            case TRIPLE_WORD_SCORE:
                                wordMultiplier *= 3;
                                break;
                            case NONE:
                            case START:
                                break;
                        }
                    }

                    totalPoints += tilePoints;
                }

                System.out.println("Mnoze " + totalPoints + " razy " + wordMultiplier);

                totalPoints *= wordMultiplier;

                System.out.println("Gracz uzyskał w tej rundzie " + totalPoints + " punktow");
                previousPlayer.addPoints(totalPoints);
                System.out.println("Gracz ma teraz " + previousPlayer.getScore() + " punktow");



            }else System.out.println("Słowo nie istnieje :(");
        }


        GameSession.get().getGameBoard().saveWords();

        //


        //USUWANIE SKRABLI Z DOKU GRACZA
        for(int index : indexesToRemove) previousPlayer.getDock()[index] = null;

        //LOSOWANIE NOWYCH TILES
        int missingTiles = previousPlayer.getMissingTiles();
        Tile[] newTiles = GameSession.get().getTileSack().drawTiles(missingTiles);
        previousPlayer.fillDock(newTiles);



        //ZMIANA TURY (NA KONCU)
        GameSession.get().changeTurn();



        //PRZESYLANIE DANYCH DO JSP
        request.setAttribute("tiles", GameSession.get().getTurn().getPlayerTurn().getDock());
        request.setAttribute("gameBoard", GameSession.get().getGameBoard());
        request.getRequestDispatcher("/JSP/gameBoard.jsp").forward(request, response);

        response.setContentType("text/plain");
        response.getWriter().write("Player " + GameSession.get().getTurn().getPlayerTurn().getName() + " turn");



    }
}
