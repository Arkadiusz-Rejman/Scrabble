package amk.scrabble.model;

import java.util.List;

public class Turn {
    private Player playerTurn;
    private List<Tile> tilesToRemove;
    private int tilesToAdd;

    public Turn(Player playerTurn) {
        this.playerTurn = playerTurn;
    }


    public Player getPlayerTurn() {
        return playerTurn;
    }

    public void setPlayerTurn(Player playerTurn) {
        this.playerTurn = playerTurn;
    }

    public List<Tile> getTilesToRemove() {
        return tilesToRemove;
    }

    public void setTilesToRemove(List<Tile> tilesToRemove) {
        this.tilesToRemove = tilesToRemove;
    }

    public int getTilesToAdd() {
        return tilesToAdd;
    }

    public void setTilesToAdd(int tilesToAdd) {
        this.tilesToAdd = tilesToAdd;
    }
}
