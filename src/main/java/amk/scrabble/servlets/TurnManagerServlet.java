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
import java.util.stream.Collectors;

@WebServlet(name = "turnManagerServlet", urlPatterns = "/turnManagerServlet")
public class TurnManagerServlet extends HttpServlet {

    private PolishDictionaryChecker checker;
    public List<Word> newWords;


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

        // WCZYTANIE DANYCH DO PRZETWORZENIA
        Player previousPlayer = GameSession.get().getTurn().getPlayerTurn();
        List<IndexesHolder> boardIndexesToAdd = new ArrayList<>(GameSession.get().getTurn().getBoardIndexesToAdd());

        // USUWANIE PŁYTEK Z DOKU GRACZA I DODAWANIE ICH DO PLANSZY
        for (IndexesHolder indexesHolder : boardIndexesToAdd) {
            Tile tile = previousPlayer.getDock()[indexesHolder.getStoredIndex()];
            GameSession.get().getGameBoard().getBoardField(indexesHolder.getI1(), indexesHolder.getI2()).setTileOnField(tile);
            previousPlayer.getDock()[indexesHolder.getStoredIndex()] = null;
        }

        //USUWANIE PŁYTEK Z DOKU GRACZA NA PODSTAWIE LOSOWANIA NOWYCH
        List<Integer> toChange = previousPlayer.getTilesIndexesToChange();
        toChange.forEach(i -> previousPlayer.getDock()[i] = null);


        // SZUKANIE NOWO POWSTAŁYCH SŁÓW
        List<Word> newWords = GameSession.get().getGameBoard().getNewWords();

        List<Word> correctWords = new ArrayList<>();
        List<Word> incorrectWords = new ArrayList<>();
        StringBuilder acceptedWordsString = new StringBuilder();
        StringBuilder rejectedWordsString = new StringBuilder();

        int totalPoints = 0;

        for (Word word : newWords) {
            if (checker.isWordInDictionary(word.toString().toLowerCase())) {
                correctWords.add(word);
                acceptedWordsString.append(word.toString()).append(" ");
            } else {
                incorrectWords.add(word);
                rejectedWordsString.append(word.toString()).append(" ");
            }
        }

        // OBSŁUGA POPRAWNOSCI STAWIANIA SŁÓW
        // SPRAWDZENIE CZY STAWIANE SLOWO JEST CZESCIA SLOWA Z POPRZEDNIEJ TURY
        List<Word> wordsPlacedCorrectly = new ArrayList<>();
        List<Word> wordsPlacedIncorrectly = new ArrayList<>();

            for (Word word : newWords) {

                boolean wordPlacedCorrectly = false;

                if(word.isStartWord()) wordPlacedCorrectly = true;

                else{
                    for (BoardField boardField : word.getBoardFields()) {
                        boolean alone = boardIndexesToAdd.stream().anyMatch(ih ->
                                ih.getI1() == boardField.getI1() && ih.getI2() == boardField.getI2());

                        if (!alone) {
                            wordPlacedCorrectly = true;
                            break;
                        }
                    }
                }

                if(wordPlacedCorrectly) wordsPlacedCorrectly.add(word);
                else wordsPlacedIncorrectly.add(word);
            }

       //USUWANIE NIEPOPRAWNIE POSTAWIONYCH SLOW JEZELI SA ONE CZESCIA DOBRZE POSTAWIONYCH SLOW W TEJ TURZE
        wordsPlacedIncorrectly.removeIf(incorrectWord ->
                wordsPlacedCorrectly.stream().anyMatch(correctWord ->
                        correctWord.hasCommonFields(incorrectWord)
                )
        );

        //USUWANIE POJEDYNCZYCH Z BOARD INDEXES
        List<IndexesHolder> soloIndexes = new ArrayList<>();
        for(IndexesHolder indexesHolder : boardIndexesToAdd) {
            BoardField boardField = GameSession.get().getGameBoard().getBoardField(indexesHolder.getI1(), indexesHolder.getI2());
            if(GameSession.get().getGameBoard().isBoardFieldAlone(boardField)) soloIndexes.add(indexesHolder);
        }

        boolean soloWordsFound = !soloIndexes.isEmpty();


        // FINALNA OBSŁUGA POPRAWNOŚCI WPISANYCH/STAWIANYCH SŁÓW
        if (!incorrectWords.isEmpty() || soloWordsFound || !wordsPlacedIncorrectly.isEmpty()) {
            if(!incorrectWords.isEmpty()) GameSession.get().getMessagesManager().addMessage("Words rejected: " + rejectedWordsString);
            if(soloWordsFound) GameSession.get().getMessagesManager().addMessage("Letters found");
            if(!wordsPlacedIncorrectly.isEmpty()) GameSession.get().getMessagesManager().addMessage("Wrong letters placement");

            GameSession.get().getMessagesManager().addMessage("TURN IS CANCELED!");

            for (IndexesHolder indexesHolder : boardIndexesToAdd) {
                Tile tile = GameSession.get().getGameBoard().getBoardField(indexesHolder.getI1(), indexesHolder.getI2()).getTileOnField();
                GameSession.get().getGameBoard().getBoardField(indexesHolder.getI1(), indexesHolder.getI2()).removeTileOnField();
                previousPlayer.getDock()[indexesHolder.getStoredIndex()] = tile;
            }
        } else {
            if(!correctWords.isEmpty()) GameSession.get().getMessagesManager().addMessage("Words approved: " + acceptedWordsString);
            for (Word correctWord : correctWords) totalPoints += calculateWordScore(correctWord, boardIndexesToAdd);

            previousPlayer.addPoints(totalPoints);
            GameSession.get().getMessagesManager().addMessage("Points gained: " + totalPoints + "p.");
        }

        //ZAPISANIE ZMIAN W GAME BOARD
        GameSession.get().getGameBoard().saveWords();

        //LOSOWANIE NOWYCH TILES
        int missingTiles = previousPlayer.getMissingTiles();
        Tile[] newTiles = GameSession.get().getTileSack().drawTiles(missingTiles);
        previousPlayer.fillDock(newTiles);

        //WRZUCANIE DO WORECZKA ZAMIENIONYCH TILES
        List<Tile> returningTiles = previousPlayer.getTilesToChange();
        GameSession.get().getTileSack().addTiles(returningTiles);
        previousPlayer.clearTilesIndexesToChange();

        //ZMIANA TURY (NA KONCU)

        GameSession.get().changeTurn();
        GameSession.get().getMessagesManager().addMessage("----------------------------------------------------------");
        GameSession.get().getMessagesManager().addMessage("PLAYER " + GameSession.get().getTurn().getPlayerTurn().getName() + "TURN");

        //PRZESYLANIE DANYCH DO NOWEJ TURY);
        request.setAttribute("tiles", GameSession.get().getTurn().getPlayerTurn().getDock());
        request.setAttribute("gameBoard", GameSession.get().getGameBoard());
        request.getRequestDispatcher("/JSP/gameBoard.jsp").forward(request, response);

        response.setContentType("text/plain");
        response.getWriter().write("Player " + GameSession.get().getTurn().getPlayerTurn().getName() + " turn");





    }

    private int calculateWordScore(Word word, List<IndexesHolder> boardIndexesToAdd) {
        int wordPoints = 0;
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

            wordPoints += tilePoints;
        }


        wordPoints *= wordMultiplier;

        return wordPoints;
    }
}
