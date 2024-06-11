package amk.scrabble.servlets;



import amk.scrabble.model.*;
import amk.scrabble.utils.IndexesHolder;
import amk.scrabble.utils.PolishDictionaryChecker;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.didion.jwnl.JWNL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "turnManagerServlet", urlPatterns = "/turnManagerServlet")
public class TurnManagerServlet extends HttpServlet {

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
        System.out.println(GameSession.get().getGameBoard().getNewWords());

        //PolishDictionaryChecker polishDictionaryChecker = new PolishDictionaryChecker("/WEB-INF/slowa.txt");





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
