package amk.scrabble.model;

import java.util.ArrayList;
import java.util.List;

public class Player {


    private List<Integer> tilesIndexesToChange = new ArrayList<>();
    private String name;
    private Tile[] dock = new Tile[8];
    private Tile selectedTile; //Tego nie uzywam?
    private int score = 0;
    private boolean resigned = false;


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

    public boolean isResigned() {
        return resigned;
    }

    public void setResigned(boolean resigned) {
        this.resigned = resigned;
    }

    public void setDock(Tile[] tiles) { this.dock = tiles; }
    public void selectTile(Tile tile) { this.selectedTile = tile; }

    public List<Integer> getTilesIndexesToChange() {
        return tilesIndexesToChange;
    }

    public void clearTilesIndexesToChange() {
        tilesIndexesToChange.clear();
    }

    public List<Tile> getTilesToChange(){
        List<Tile> tilesToChange = new ArrayList<>();
        for(Integer index : tilesIndexesToChange){
            tilesToChange.add(dock[index]);
        }
        return tilesToChange;
    }

    public void setTilesIndexesToChange(List<Integer> tilesIndexes) {
        tilesIndexesToChange.clear();
        tilesIndexesToChange.addAll(tilesIndexes);

    }

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
