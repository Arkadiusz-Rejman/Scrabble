package amk.scrabble.servlets;

import amk.scrabble.model.GameSession;
import amk.scrabble.utils.IndexesHolder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "moveTileServlet", urlPatterns = "/moveTileServlet")
public class MoveTileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String tileIndexString = req.getParameter("tileIndex");
        String targetId = req.getParameter("targetID");

//        System.out.println(tileIndexString);


        boolean isBoardTarget = !targetId.startsWith("cell_20");
        Integer tileIndex = Integer.parseInt(tileIndexString);

        GameSession.get().getTurn().getBoardIndexesToAdd().removeIf(indexesHolder1 -> indexesHolder1.getStoredIndex() == tileIndex);

        if(isBoardTarget) {
            if(!GameSession.get().getTurn().getTilesIndexesToRemove().contains(tileIndex)){
                GameSession.get().getTurn().getTilesIndexesToRemove().add(tileIndex);
            }

            String[] parts = targetId.split("_");
            int index1 = Integer.parseInt(parts[1]);
            int index2 = Integer.parseInt(parts[2]);
            IndexesHolder indexesHolder = new IndexesHolder(index1, index2, tileIndex);
            GameSession.get().getTurn().getBoardIndexesToAdd().add(indexesHolder);
        }
        else {
            GameSession.get().getTurn().getTilesIndexesToRemove().remove(tileIndex);
        }




        // Send a simple text response back
        resp.setContentType("text/plain");
        resp.getWriter().write("Received tileIndex: " + tileIndexString);


    }
}
