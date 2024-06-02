package amk.scrabble.model;

import java.util.ArrayList;
import java.util.List;

public class Player {


    String name;
    List<Tile> dock;
    Tile selectedTile;


    public Player(String name) {
        dock = new ArrayList<>();
        this.name = name;
    }

    public List<Tile> getDock() {
        return dock;
    }

    public Tile getSelectedTile() {
        return selectedTile;
    }

    public void setDock(List<Tile> tiles) { this.dock = tiles; }
    public void selectTile(Tile tile) { this.selectedTile = tile; }
    public void addTilesToDock(List<Tile> tiles) { this.dock.addAll(tiles); }
    public void removeTilesFromDock(List<Tile> tiles) { this.dock.removeAll(tiles); }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
