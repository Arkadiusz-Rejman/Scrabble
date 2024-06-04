package amk.scrabble.servlets;

import amk.scrabble.model.GameSession;
import amk.scrabble.model.Player;
import amk.scrabble.model.TileSack;
import amk.scrabble.model.Turn;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "playerSelectionServlet", urlPatterns = "/playerSelection")
public class PlayerSelectionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int playerCount = Integer.parseInt(request.getParameter("playerCount"));

        GameSession.createNew();

        List<Player> playerList = new ArrayList<>();
        for (int i = 1; i <= playerCount; i++) {
            String playerName = request.getParameter("player" + i);
            Player player = new Player(playerName);
            playerList.add(player);
        }



        GameSession.get().setTurn(new Turn(playerList.get(0)));
        GameSession.get().setTileSack(new TileSack());
        playerList.forEach(player -> player.setDock(GameSession.get().getTileSack().drawTiles(8)));
        GameSession.get().setPlayers(playerList);


        response.sendRedirect("game");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/JSP/playerSelection.jsp").forward(req,resp);
    }
}
