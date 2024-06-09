package amk.scrabble.model;

import amk.scrabble.enums.BonusType;

public class BoardField {
    private final BonusType bonusType;
    private Tile tileOnField;

    public BoardField(BonusType bonusType){
        this.bonusType = bonusType;
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
