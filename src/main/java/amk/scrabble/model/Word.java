package amk.scrabble.model;

import amk.scrabble.enums.BonusType;
import amk.scrabble.enums.WordDirection;
import amk.scrabble.utils.IndexesHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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


    public List<BoardField> getCommonFields(Word word) {
        return boardFields.stream()
                .filter(boardField -> word.getBoardFields().stream()
                        .anyMatch(otherBoardField ->
                                boardField.getI1() == otherBoardField.getI1() &&
                                        boardField.getI2() == otherBoardField.getI2()))
                .collect(Collectors.toList());
    }

    public boolean isStartWord(){
        return boardFields.stream().anyMatch(bf -> bf.getBonusType() == BonusType.START);
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
        StringBuilder sb = new StringBuilder();
        for(BoardField boardField : boardFields){
            sb.append(boardField.getTileOnField().getCharacter());
        }

        return sb.toString();
    }


}
