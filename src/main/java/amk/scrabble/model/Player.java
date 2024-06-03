package amk.scrabble.model;

import java.util.ArrayList;
import java.util.List;

public class Player {


    String name;
    Tile[] dock = new Tile[8];
    Tile selectedTile;


    public Player(String name) {
        this.name = name;
    }

    public Tile[] getDock() {
        return dock;
    }

    public Tile getSelectedTile() {
        return selectedTile;
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

    public void setName(String name) {
        this.name = name;
    }
}
