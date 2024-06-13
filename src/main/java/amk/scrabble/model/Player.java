package amk.scrabble.model;

import java.util.ArrayList;
import java.util.List;

public class Player {


    private String name;
    private Tile[] dock = new Tile[8];
    private Tile selectedTile; //Tego nie uzywam?
    private int score = 0;


    public Player(String name) {
        this.name = name;
    }

    public Tile[] getDock() {
        return dock;
    }

    public Tile getSelectedTile() {
        return selectedTile;
    }

    public int getScore(){
        return score;
    }

    public void setDock(Tile[] tiles) { this.dock = tiles; }
    public void selectTile(Tile tile) { this.selectedTile = tile; }

    public String getName() {
        return name;
    }

    public int getMissingTiles(){
        int missing = 0;
        for (Tile tile : dock) {
            if (tile == null) missing++;
        }
        return missing;
    }

    public void fillDock(Tile[] tiles) {
        int fillingTileIndex = 0;
        for(int i =0; i<dock.length; i++){
            if (dock[i] == null){
                dock[i] = tiles[fillingTileIndex];
                fillingTileIndex++;
            }
        }

    }

    public void addPoints(int points) {
        score += points;
    }

    public void setName(String name) {
        this.name = name;
    }
}
