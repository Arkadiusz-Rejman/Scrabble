package amk.scrabble.servlets;

import amk.scrabble.model.GameSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "changeTilesServlet", urlPatterns = "/changeTilesServlet")
public class ChangeTilesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tileIndexParam = req.getParameter("tileIndex");

        System.out.println(tileIndexParam);

        String[] tileIds = tileIndexParam.split(",");


        if(tileIds.length > 0){

            List<Integer> numericTileIds = new ArrayList<>();

            for (String tileId : tileIds) {
                try {
                    int numericId = Integer.parseInt(tileId.replace("tile_", ""));
                    numericTileIds.add(numericId);
                } catch (NumberFormatException e) {
                    System.err.println("Nie udało się sparsować wartości liczbowej z: " + tileId);
                }
            }


            GameSession.get().getTurn().getPlayerTurn().setTilesIndexesToChange(numericTileIds);
        }

    }
}
