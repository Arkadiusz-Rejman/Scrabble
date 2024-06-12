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
import java.util.Arrays;
import java.util.List;

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


//        for (int i=0; i<  ;i++){
//            System.out.println(wordLetters.get(i).getBoardFields().get(i).getTileOnField().getCharacter());
//        }


        for (Word word : wordLetters) {
            List<BoardField> boardFields = word.getBoardFields();
            List<Character> characterList = new ArrayList<>();

            for (BoardField boardField : boardFields) {
                Tile tile = boardField.getTileOnField();

                if (tile != null) {
                    char character = tile.getCharacter();
                    //System.out.print(character); to pomaga przy bugach z odczytaniem słowa
                    characterList.add(character);

                }
            }
            System.out.println(" ");
            //Budowanie String'a z kafelków na planszy
            StringBuilder sb = new StringBuilder();
            for (char ch : characterList) {
                sb.append(ch);
            }
            String str = sb.toString().toLowerCase();
            System.out.println("String: " + str);

            //Sprawdzenie czy istnieje narazie bez funckjonalności
            if(checker.isWordInDictionary(str)){
                System.out.println("Słowo intnieje :)");
            }
            //Pomysł na sprawdzanie z brakującymi literami, pierwszy dodatkowy warunek to sprawdzenie na podstawie w jakim
            //kierunku jest stawiane słowo czy nie brakuje pierwszej lub osattniej jeżeli dalej nie istenieje to 3ci warunek
            //sprawdzenie od pierwszego do ostatniego indexy na planszy to będzie trudniejsze bo integracja z jsp :)

        }




        GameSession.get().getGameBoard().saveWords();




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
