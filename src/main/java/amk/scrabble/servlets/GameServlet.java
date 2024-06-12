package amk.scrabble.servlets;

import amk.scrabble.model.GameSession;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "gameServlet", urlPatterns = "/game")
public class GameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("tiles", GameSession.get().getTurn().getPlayerTurn().getDock());
        request.setAttribute("gameBoard", GameSession.get().getGameBoard());
        getServletContext().getRequestDispatcher("/JSP/gameBoard.jsp").forward(request,response);
        response.setHeader("Cache-Control", "no-cache");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
