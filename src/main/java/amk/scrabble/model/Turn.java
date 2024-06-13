package amk.scrabble.model;

import amk.scrabble.utils.IndexesHolder;

import java.util.ArrayList;
import java.util.List;

public class Turn {
    private Player playerTurn;
    private final List<Integer> tilesIndexesToRemove;
    private final List<IndexesHolder> boardIndexesToAdd;

    public Turn(Player playerTurn) {
        this.playerTurn = playerTurn;
        tilesIndexesToRemove = new ArrayList<>();
        boardIndexesToAdd = new ArrayList<>();
    }


    public Player getPlayerTurn() {
        return playerTurn;
    }

    public List<Integer> getTilesIndexesToRemove() {
        return tilesIndexesToRemove;
    }

    public List<IndexesHolder> getBoardIndexesToAdd() {
        return boardIndexesToAdd;
    }

    public void setPlayerTurn(Player playerTurn) {
        this.playerTurn = playerTurn;
    }

}
