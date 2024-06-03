package amk.scrabble.servlets;

import amk.scrabble.model.GameSession;
import amk.scrabble.model.Tile;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "moveTileServlet", urlPatterns = "/moveTileServlet")
public class MoveTileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tileIndexString = req.getParameter("tileIndex");
        int tileIndex = Integer.parseInt(tileIndexString);

        GameSession.get().getTurn().getPlayerTurn().getDock()[tileIndex] = null;

        System.out.println(Arrays.toString(GameSession.get().getTurn().getPlayerTurn().getDock()));





        // Send a simple text response back
        resp.setContentType("text/plain");
        resp.getWriter().write("Received tileIndex: " + tileIndexString);


    }
}
