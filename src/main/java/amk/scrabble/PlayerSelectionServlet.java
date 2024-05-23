package amk.scrabble;

import amk.scrabble.model.GameSession;
import amk.scrabble.model.Player;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/playerSelection")
public class PlayerSelectionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int playerCount = Integer.parseInt(request.getParameter("playerCount"));

        GameSession gameSession = new GameSession();

        for (int i = 1; i <= playerCount; i++) {
            String playerName = request.getParameter("player" + i);
            Player player = new Player(playerName);
            gameSession.getPlayers().add(player);
        }

        for (Player player : gameSession.getPlayers()) {
            System.out.println("Player name: " + player.getName());
        }

        DrawTilesServlet drawTilesServlet = new DrawTilesServlet();
        drawTilesServlet.doGet(request, response);

        response.sendRedirect("gameBoard.jsp");
    }
}
