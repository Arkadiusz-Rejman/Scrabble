package amk.scrabble.model;

import amk.scrabble.enums.WordDirection;
import amk.scrabble.utils.IndexesHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Word {
    List<BoardField> boardFields = new ArrayList<>();
    WordDirection wordDirection;

    public Word(WordDirection wordDirection) {
        boardFields = new ArrayList<>();
    }

    public void append(BoardField boardField) {
        boardFields.add(boardField);
    }


    public List<BoardField> getBoardFields() {
        return boardFields;
    }

    public WordDirection getWordDirection() {
        return wordDirection;
    }

    public boolean compare(Word word){
        boolean result = false;
        List<BoardField> targetFields = word.getBoardFields();

        if(this.boardFields.size() != targetFields.size()){
            return false;
        }


        for(int i = 0; i < targetFields.size(); i++){
            BoardField targetField = targetFields.get(i);
            BoardField thisField = boardFields.get(i);

            result = targetField.getI1() == thisField.getI1() && targetField.getI2() == thisField.getI2();
        }

        return result;
    }


    @Override
    public String toString() {
        return "Word{" +
                "tiles=" + boardFields +
                '}';
    }


}
