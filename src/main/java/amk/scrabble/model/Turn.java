package amk.scrabble.model;

import java.util.ArrayList;
import java.util.List;

public class Turn {
    private Player playerTurn;
    private final List<Integer> tilesIndexesToRemove;

    public Turn(Player playerTurn) {
        this.playerTurn = playerTurn;
        tilesIndexesToRemove = new ArrayList<>();
    }


    public Player getPlayerTurn() {
        return playerTurn;
    }

    public List<Integer> getTilesIndexesToRemove() {
        return tilesIndexesToRemove;
    }


    public void setPlayerTurn(Player playerTurn) {
        this.playerTurn = playerTurn;
    }



}
