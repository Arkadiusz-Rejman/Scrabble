package amk.scrabble.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TileSack {
    List<Tile> tiles;

    public TileSack(){
        tiles = new ArrayList<>();
        for(int i=0; i<9; i++) tiles.add(new Tile('A', 1));
        for(int i=0; i<7; i++) tiles.add(new Tile('E', 1));
        for(int i=0; i<8; i++) tiles.add(new Tile('I', 1));
        for(int i=0; i<5; i++) tiles.add(new Tile('N', 1));
        for(int i=0; i<6; i++) tiles.add(new Tile('O', 1));
        for(int i=0; i<4; i++) tiles.add(new Tile('R', 1));
        for(int i=0; i<4; i++) tiles.add(new Tile('S', 1));
        for(int i=0; i<4; i++) tiles.add(new Tile('W', 1));
        for(int i=0; i<5; i++) tiles.add(new Tile('Z', 1));
        for(int i=0; i<3; i++) tiles.add(new Tile('C', 2));
        for(int i=0; i<3; i++) tiles.add(new Tile('D', 2));
        for(int i=0; i<3; i++) tiles.add(new Tile('K', 2));
        for(int i=0; i<3; i++) tiles.add(new Tile('L', 2));
        for(int i=0; i<3; i++) tiles.add(new Tile('M', 2));
        for(int i=0; i<3; i++) tiles.add(new Tile('P', 2));
        for(int i=0; i<3; i++) tiles.add(new Tile('T', 2));
        for(int i=0; i<4; i++) tiles.add(new Tile('Y', 2));
        for(int i=0; i<2; i++) tiles.add(new Tile('B', 3));
        for(int i=0; i<2; i++) tiles.add(new Tile('G', 3));
        for(int i=0; i<2; i++) tiles.add(new Tile('H', 3));
        for(int i=0; i<2; i++) tiles.add(new Tile('J', 3));
        for(int i=0; i<2; i++) tiles.add(new Tile('Ł', 3));
        for(int i=0; i<2; i++) tiles.add(new Tile('U', 3));
        tiles.add(new Tile('Ą', 5));
        tiles.add(new Tile('Ę', 5));
        tiles.add(new Tile('F', 5));
        tiles.add(new Tile('Ó', 5));
        tiles.add(new Tile('Ś', 5));
        tiles.add(new Tile('Ż', 5));
        tiles.add(new Tile('Ć', 6));
        tiles.add(new Tile('Ń', 7));
        tiles.add(new Tile('Ź', 9));
    }

    public Tile[] drawTiles(int amount){

        Tile[] drawnTiles = new Tile[amount];
        Random random = new Random();

        for(int i = 0; i < amount; i++){
            int randomIndex = random.nextInt(tiles.size());
            drawnTiles[i] = tiles.get(randomIndex);
            tiles.remove(randomIndex);
        }

        return drawnTiles;
    }
}
