package amk.scrabble.model;

import java.util.ArrayList;

public class GameBoard {
    private Tile[][] table;

    public GameBoard(Tile[][] table) {
        this.table = table;
    }

    public void placeTile(int row, int column, Tile tile) {
        table[row][column] = tile;
    }

    public Tile getTile(int row, int column) {
        return table[row][column];
    }

    public void displayTable() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
}
