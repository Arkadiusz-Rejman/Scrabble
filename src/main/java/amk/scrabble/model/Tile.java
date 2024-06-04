package amk.scrabble.model;

public class Tile {
    private String backgroundImagePath;
    private char character;
    private int points;

    public Tile(char character, int points){
        this.character = character;
        this.backgroundImagePath = "images/tile.png";
        this.points = points;
    }

    public String getBackgroundImagePath() {
        return backgroundImagePath;
    }

    public void setBackgroundImagePath(String backgroundImagePath) {
        this.backgroundImagePath = backgroundImagePath;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return " " + character;
    }
}
