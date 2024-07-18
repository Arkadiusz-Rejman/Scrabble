package amk.scrabble.servlets;

import amk.scrabble.model.GameSession;
import amk.scrabble.model.Player;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "resignServlet", urlPatterns = "/resignServlet")
public class ResignServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Player player = GameSession.get().getTurn().getPlayerTurn();

        player.setResigned(true);

        GameSession.get().getMessagesManager().addMessage("Player " + player.getName() + " has resigned");
        GameSession.get().changeTurn();
        GameSession.get().getMessagesManager().addMessage("----------------------------------------------------------");
        GameSession.get().getMessagesManager().addMessage("PLAYER " + GameSession.get().getTurn().getPlayerTurn().getName() + "TURN");

        if(GameSession.get().getActivePlayersCount() < 2){
            getServletContext().getRequestDispatcher("/JSP/gameSummary.jsp").forward(req,resp);
        }else{
            resp.sendRedirect("game");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



    }
}
