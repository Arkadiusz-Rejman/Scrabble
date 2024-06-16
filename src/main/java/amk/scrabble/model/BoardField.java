package amk.scrabble.model;

import amk.scrabble.enums.BonusType;

import java.util.Objects;

public class BoardField {
    private final BonusType bonusType;
    private Tile tileOnField;
    private int i1;
    private int i2;

    public BoardField(int i1, int i2, BonusType bonusType){
        this.bonusType = bonusType;
        this.i1 = i1;
        this.i2 = i2;
    }

    public int getI1() {
        return i1;
    }

    public int getI2() {
        return i2;
    }

    public BonusType getBonusType(){
        return this.bonusType;
    }

    public boolean isOccupied(){
        return tileOnField != null;
    }

    public Tile getTileOnField(){
        return this.tileOnField;
    }

    public void setTileOnField(Tile tileOnField) {
        this.tileOnField = tileOnField;
    }

    public void removeTileOnField(){
        this.tileOnField = null;
    }

    public String getImage(){
        String imageURL = "";
        switch (this.bonusType){
            case START: imageURL = "images/startField.jpg"; break;
            case DOUBLE_LETTER_SCORE: imageURL = "images/doubleLetterScore.jpg"; break;
            case DOUBLE_WORD_SCORE: imageURL = "images/doubleWordScore.jpg"; break;
            case TRIPLE_LETTER_SCORE: imageURL = "images/tripleLetterScore.jpg"; break;
            case TRIPLE_WORD_SCORE:imageURL = "images/tripleWordScore.jpg"; break;
            case NONE: imageURL = ""; break;
        }

        return imageURL;
    }

    @Override
    public String toString() {
        return "BoardField{" +
                "bonusType=" + bonusType +
                ", tileOnField=" + tileOnField +
                '}';
    }

}
