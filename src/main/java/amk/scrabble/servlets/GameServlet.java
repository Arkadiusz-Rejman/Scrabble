package amk.scrabble.servlets;

import amk.scrabble.model.Tile;
import amk.scrabble.model.TileSack;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "gameServlet", urlPatterns = "/game")
public class GameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TileSack tileSack = new TileSack();
        List<Tile> tiles = tileSack.drawTiles(8);
        request.setAttribute("tiles", tiles);
        getServletContext().getRequestDispatcher("/JSP/gameBoard.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}