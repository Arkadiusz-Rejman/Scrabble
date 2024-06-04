package amk.scrabble.servlets;

import amk.scrabble.model.GameSession;
import amk.scrabble.model.Player;
import amk.scrabble.model.Tile;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Player previousPlayer = GameSession.get().getTurn().getPlayerTurn();
        List<Integer> indexesToRemove = new ArrayList<>(GameSession.get().getTurn().getTilesIndexesToRemove());

        for(int index : indexesToRemove) previousPlayer.getDock()[index] = null;

        System.out.println("Dock before Fill: " + Arrays.toString(previousPlayer.getDock()));


        int missingTiles = previousPlayer.getMissingTiles();
        Tile[] newTiles = GameSession.get().getTileSack().drawTiles(missingTiles);
        previousPlayer.fillDock(newTiles);


        System.out.println("Dock after Fill: " + Arrays.toString(previousPlayer.getDock()));
        GameSession.get().changeTurn();


        response.setContentType("text/plain");
        response.getWriter().write("Player " + GameSession.get().getTurn().getPlayerTurn().getName() + " turn");
    }
}
