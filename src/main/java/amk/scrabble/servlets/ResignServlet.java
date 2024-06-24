package amk.scrabble.servlets;

import amk.scrabble.model.GameSession;
import amk.scrabble.model.Player;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "resignServlet", urlPatterns = "/resignServlet")
public class ResignServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Player player = GameSession.get().getTurn().getPlayerTurn();

        player.setResigned(true);

        GameSession.get().getMessagesManager().addMessage("Player " + player.getName() + " has resigned");

        if(GameSession.get().getActivePlayersCount() < 2){
            System.out.println("ELO");
            resp.setContentType("text/plain");
            resp.sendRedirect("/JSP/gameSummary.jsp");
        }


    }
}
