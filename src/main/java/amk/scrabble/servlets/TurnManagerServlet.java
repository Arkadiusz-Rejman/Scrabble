package amk.scrabble.servlets;

import amk.scrabble.model.GameSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "turnManagerServlet", urlPatterns = "/turnManagerServlet")
public class TurnManagerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        System.out.println(GameSession.get().getPlayerTurn().getDock());
        GameSession.get().changeTurn();

        response.setContentType("text/plain");
        response.getWriter().write("Player " + GameSession.get().getPlayerTurn().getName() + " turn");
    }
}
