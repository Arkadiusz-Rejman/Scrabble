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
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        // Ustawienie nagłówków HTTP, aby zapobiec buforowaniu strony
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0
        response.setDateHeader("Expires", 0); // Proxies




        request.setAttribute("tiles", GameSession.get().getTurn().getPlayerTurn().getDock());
        request.setAttribute("gameBoard", GameSession.get().getGameBoard());
        getServletContext().getRequestDispatcher("/JSP/gameBoard.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
