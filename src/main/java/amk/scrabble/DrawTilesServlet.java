package amk.scrabble;

import amk.scrabble.model.Tile;
import amk.scrabble.model.TileSack;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/drawTiles")
public class DrawTilesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TileSack tileSack = new TileSack();
        List<Tile> tiles = tileSack.drawTiles(8);
        request.setAttribute("tiles", tiles);
        request.getRequestDispatcher("gameBoard.jsp").forward(request, response);
    }
}
