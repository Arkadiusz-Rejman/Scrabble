package amk.scrabble.model;

import amk.scrabble.enums.BonusType;
import amk.scrabble.enums.WordDirection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameBoard {
    private BoardField[][] boardFields;
    private List<Word> savedWordsOnBoard;

    public GameBoard() {

        boardFields = new BoardField[15][15];
        savedWordsOnBoard = new ArrayList<>();

        boardFields[0][0] = new BoardField(0, 0, BonusType.TRIPLE_WORD_SCORE);
        boardFields[0][1] = new BoardField(0, 1, BonusType.NONE);
        boardFields[0][2] = new BoardField(0, 2, BonusType.NONE);
        boardFields[0][3] = new BoardField(0, 3, BonusType.DOUBLE_LETTER_SCORE);
        boardFields[0][4] = new BoardField(0, 4, BonusType.NONE);
        boardFields[0][5] = new BoardField(0, 5, BonusType.NONE);
        boardFields[0][6] = new BoardField(0, 6, BonusType.NONE);
        boardFields[0][7] = new BoardField(0, 7, BonusType.TRIPLE_WORD_SCORE);
        boardFields[0][8] = new BoardField(0, 8, BonusType.NONE);
        boardFields[0][9] = new BoardField(0, 9, BonusType.NONE);
        boardFields[0][10] = new BoardField(0, 10, BonusType.NONE);
        boardFields[0][11] = new BoardField(0, 11, BonusType.DOUBLE_LETTER_SCORE);
        boardFields[0][12] = new BoardField(0, 12, BonusType.NONE);
        boardFields[0][13] = new BoardField(0, 13, BonusType.NONE);
        boardFields[0][14] = new BoardField(0, 14, BonusType.TRIPLE_WORD_SCORE);

        boardFields[1][0] = new BoardField(1, 0, BonusType.NONE);
        boardFields[1][1] = new BoardField(1, 1, BonusType.DOUBLE_WORD_SCORE);
        boardFields[1][2] = new BoardField(1, 2, BonusType.NONE);
        boardFields[1][3] = new BoardField(1, 3, BonusType.NONE);
        boardFields[1][4] = new BoardField(1, 4, BonusType.NONE);
        boardFields[1][5] = new BoardField(1, 5, BonusType.TRIPLE_LETTER_SCORE);
        boardFields[1][6] = new BoardField(1, 6, BonusType.NONE);
        boardFields[1][7] = new BoardField(1, 7, BonusType.NONE);
        boardFields[1][8] = new BoardField(1, 8, BonusType.NONE);
        boardFields[1][9] = new BoardField(1, 9, BonusType.TRIPLE_LETTER_SCORE);
        boardFields[1][10] = new BoardField(1, 10, BonusType.NONE);
        boardFields[1][11] = new BoardField(1, 11, BonusType.NONE);
        boardFields[1][12] = new BoardField(1, 12, BonusType.NONE);
        boardFields[1][13] = new BoardField(1, 13, BonusType.DOUBLE_WORD_SCORE);
        boardFields[1][14] = new BoardField(1, 14, BonusType.NONE);

        boardFields[2][0] = new BoardField(2, 0, BonusType.NONE);
        boardFields[2][1] = new BoardField(2, 1, BonusType.NONE);
        boardFields[2][2] = new BoardField(2, 2, BonusType.DOUBLE_WORD_SCORE);
        boardFields[2][3] = new BoardField(2, 3, BonusType.NONE);
        boardFields[2][4] = new BoardField(2, 4, BonusType.NONE);
        boardFields[2][5] = new BoardField(2, 5, BonusType.NONE);
        boardFields[2][6] = new BoardField(2, 6, BonusType.DOUBLE_LETTER_SCORE);
        boardFields[2][7] = new BoardField(2, 7, BonusType.NONE);
        boardFields[2][8] = new BoardField(2, 8, BonusType.DOUBLE_LETTER_SCORE);
        boardFields[2][9] = new BoardField(2, 9, BonusType.NONE);
        boardFields[2][10] = new BoardField(2, 10, BonusType.NONE);
        boardFields[2][11] = new BoardField(2, 11, BonusType.NONE);
        boardFields[2][12] = new BoardField(2, 12, BonusType.DOUBLE_WORD_SCORE);
        boardFields[2][13] = new BoardField(2, 13, BonusType.NONE);
        boardFields[2][14] = new BoardField(2, 14, BonusType.NONE);

        boardFields[3][0] = new BoardField(3, 0, BonusType.DOUBLE_LETTER_SCORE);
        boardFields[3][1] = new BoardField(3, 1, BonusType.NONE);
        boardFields[3][2] = new BoardField(3, 2, BonusType.NONE);
        boardFields[3][3] = new BoardField(3, 3, BonusType.DOUBLE_WORD_SCORE);
        boardFields[3][4] = new BoardField(3, 4, BonusType.NONE);
        boardFields[3][5] = new BoardField(3, 5, BonusType.NONE);
        boardFields[3][6] = new BoardField(3, 6, BonusType.NONE);
        boardFields[3][7] = new BoardField(3, 7, BonusType.DOUBLE_LETTER_SCORE);
        boardFields[3][8] = new BoardField(3, 8, BonusType.NONE);
        boardFields[3][9] = new BoardField(3, 9, BonusType.NONE);
        boardFields[3][10] = new BoardField(3, 10, BonusType.NONE);
        boardFields[3][11] = new BoardField(3, 11, BonusType.DOUBLE_WORD_SCORE);
        boardFields[3][12] = new BoardField(3, 12, BonusType.NONE);
        boardFields[3][13] = new BoardField(3, 13, BonusType.NONE);
        boardFields[3][14] = new BoardField(3, 14, BonusType.DOUBLE_LETTER_SCORE);

        boardFields[4][0] = new BoardField(4, 0, BonusType.NONE);
        boardFields[4][1] = new BoardField(4, 1, BonusType.NONE);
        boardFields[4][2] = new BoardField(4, 2, BonusType.NONE);
        boardFields[4][3] = new BoardField(4, 3, BonusType.NONE);
        boardFields[4][4] = new BoardField(4, 4, BonusType.DOUBLE_WORD_SCORE);
        boardFields[4][5] = new BoardField(4, 5, BonusType.NONE);
        boardFields[4][6] = new BoardField(4, 6, BonusType.NONE);
        boardFields[4][7] = new BoardField(4, 7, BonusType.NONE);
        boardFields[4][8] = new BoardField(4, 8, BonusType.NONE);
        boardFields[4][9] = new BoardField(4, 9, BonusType.NONE);
        boardFields[4][10] = new BoardField(4, 10, BonusType.DOUBLE_WORD_SCORE);
        boardFields[4][11] = new BoardField(4, 11, BonusType.NONE);
        boardFields[4][12] = new BoardField(4, 12, BonusType.NONE);
        boardFields[4][13] = new BoardField(4, 13, BonusType.NONE);
        boardFields[4][14] = new BoardField(4, 14, BonusType.NONE);

        boardFields[5][0] = new BoardField(5, 0, BonusType.NONE);
        boardFields[5][1] = new BoardField(5, 1, BonusType.TRIPLE_LETTER_SCORE);
        boardFields[5][2] = new BoardField(5, 2, BonusType.NONE);
        boardFields[5][3] = new BoardField(5, 3, BonusType.NONE);
        boardFields[5][4] = new BoardField(5, 4, BonusType.NONE);
        boardFields[5][5] = new BoardField(5, 5, BonusType.TRIPLE_LETTER_SCORE);
        boardFields[5][6] = new BoardField(5, 6, BonusType.NONE);
        boardFields[5][7] = new BoardField(5, 7, BonusType.NONE);
        boardFields[5][8] = new BoardField(5, 8, BonusType.NONE);
        boardFields[5][9] = new BoardField(5, 9, BonusType.TRIPLE_LETTER_SCORE);
        boardFields[5][10] = new BoardField(5, 10, BonusType.NONE);
        boardFields[5][11] = new BoardField(5, 11, BonusType.NONE);
        boardFields[5][12] = new BoardField(5, 12, BonusType.NONE);
        boardFields[5][13] = new BoardField(5, 13, BonusType.TRIPLE_LETTER_SCORE);
        boardFields[5][14] = new BoardField(5, 14, BonusType.NONE);

        boardFields[6][0] = new BoardField(6, 0, BonusType.NONE);
        boardFields[6][1] = new BoardField(6, 1, BonusType.NONE);
        boardFields[6][2] = new BoardField(6, 2, BonusType.DOUBLE_LETTER_SCORE);
        boardFields[6][3] = new BoardField(6, 3, BonusType.NONE);
        boardFields[6][4] = new BoardField(6, 4, BonusType.NONE);
        boardFields[6][5] = new BoardField(6, 5, BonusType.NONE);
        boardFields[6][6] = new BoardField(6, 6, BonusType.DOUBLE_LETTER_SCORE);
        boardFields[6][7] = new BoardField(6, 7, BonusType.NONE);
        boardFields[6][8] = new BoardField(6, 8, BonusType.DOUBLE_LETTER_SCORE);
        boardFields[6][9] = new BoardField(6, 9, BonusType.NONE);
        boardFields[6][10] = new BoardField(6, 10, BonusType.NONE);
        boardFields[6][11] = new BoardField(6, 11, BonusType.NONE);
        boardFields[6][12] = new BoardField(6, 12, BonusType.DOUBLE_LETTER_SCORE);
        boardFields[6][13] = new BoardField(6, 13, BonusType.NONE);
        boardFields[6][14] = new BoardField(6, 14, BonusType.NONE);

        boardFields[7][0] = new BoardField(7, 0, BonusType.TRIPLE_WORD_SCORE);
        boardFields[7][1] = new BoardField(7, 1, BonusType.NONE);
        boardFields[7][2] = new BoardField(7, 2, BonusType.NONE);
        boardFields[7][3] = new BoardField(7, 3, BonusType.DOUBLE_LETTER_SCORE);
        boardFields[7][4] = new BoardField(7, 4, BonusType.NONE);
        boardFields[7][5] = new BoardField(7, 5, BonusType.NONE);
        boardFields[7][6] = new BoardField(7, 6, BonusType.NONE);
        boardFields[7][7] = new BoardField(7, 7, BonusType.START);
        boardFields[7][8] = new BoardField(7, 8, BonusType.NONE);
        boardFields[7][9] = new BoardField(7, 9, BonusType.NONE);
        boardFields[7][10] = new BoardField(7, 10, BonusType.NONE);
        boardFields[7][11] = new BoardField(7, 11, BonusType.DOUBLE_LETTER_SCORE);
        boardFields[7][12] = new BoardField(7, 12, BonusType.NONE);
        boardFields[7][13] = new BoardField(7, 13, BonusType.NONE);
        boardFields[7][14] = new BoardField(7, 14, BonusType.TRIPLE_WORD_SCORE);

        boardFields[8][0] = new BoardField(8, 0, BonusType.NONE);
        boardFields[8][1] = new BoardField(8, 1, BonusType.NONE);
        boardFields[8][2] = new BoardField(8, 2, BonusType.DOUBLE_LETTER_SCORE);
        boardFields[8][3] = new BoardField(8, 3, BonusType.NONE);
        boardFields[8][4] = new BoardField(8, 4, BonusType.NONE);
        boardFields[8][5] = new BoardField(8, 5, BonusType.NONE);
        boardFields[8][6] = new BoardField(8, 6, BonusType.DOUBLE_LETTER_SCORE);
        boardFields[8][7] = new BoardField(8, 7, BonusType.NONE);
        boardFields[8][8] = new BoardField(8, 8, BonusType.DOUBLE_LETTER_SCORE);
        boardFields[8][9] = new BoardField(8, 9, BonusType.NONE);
        boardFields[8][10] = new BoardField(8, 10, BonusType.NONE);
        boardFields[8][11] = new BoardField(8, 11, BonusType.NONE);
        boardFields[8][12] = new BoardField(8, 12, BonusType.DOUBLE_LETTER_SCORE);
        boardFields[8][13] = new BoardField(8, 13, BonusType.NONE);
        boardFields[8][14] = new BoardField(8, 14, BonusType.NONE);

        boardFields[9][0] = new BoardField(9, 0, BonusType.NONE);
        boardFields[9][1] = new BoardField(9, 1, BonusType.TRIPLE_LETTER_SCORE);
        boardFields[9][2] = new BoardField(9, 2, BonusType.NONE);
        boardFields[9][3] = new BoardField(9, 3, BonusType.NONE);
        boardFields[9][4] = new BoardField(9, 4, BonusType.NONE);
        boardFields[9][5] = new BoardField(9, 5, BonusType.TRIPLE_LETTER_SCORE);
        boardFields[9][6] = new BoardField(9, 6, BonusType.NONE);
        boardFields[9][7] = new BoardField(9, 7, BonusType.NONE);
        boardFields[9][8] = new BoardField(9, 8, BonusType.NONE);
        boardFields[9][9] = new BoardField(9, 9, BonusType.TRIPLE_LETTER_SCORE);
        boardFields[9][10] = new BoardField(9, 10, BonusType.NONE);
        boardFields[9][11] = new BoardField(9, 11, BonusType.NONE);
        boardFields[9][12] = new BoardField(9, 12, BonusType.NONE);
        boardFields[9][13] = new BoardField(9, 13, BonusType.TRIPLE_LETTER_SCORE);
        boardFields[9][14] = new BoardField(9, 14, BonusType.NONE);

        boardFields[10][0] = new BoardField(10, 0, BonusType.NONE);
        boardFields[10][1] = new BoardField(10, 1, BonusType.NONE);
        boardFields[10][2] = new BoardField(10, 2, BonusType.NONE);
        boardFields[10][3] = new BoardField(10, 3, BonusType.NONE);
        boardFields[10][4] = new BoardField(10, 4, BonusType.DOUBLE_WORD_SCORE);
        boardFields[10][5] = new BoardField(10, 5, BonusType.NONE);
        boardFields[10][6] = new BoardField(10, 6, BonusType.NONE);
        boardFields[10][7] = new BoardField(10, 7, BonusType.NONE);
        boardFields[10][8] = new BoardField(10, 8, BonusType.NONE);
        boardFields[10][9] = new BoardField(10, 9, BonusType.NONE);
        boardFields[10][10] = new BoardField(10, 10, BonusType.DOUBLE_WORD_SCORE);
        boardFields[10][11] = new BoardField(10, 11, BonusType.NONE);
        boardFields[10][12] = new BoardField(10, 12, BonusType.NONE);
        boardFields[10][13] = new BoardField(10, 13, BonusType.NONE);
        boardFields[10][14] = new BoardField(10, 14, BonusType.NONE);

        boardFields[11][0] = new BoardField(11, 0, BonusType.DOUBLE_LETTER_SCORE);
        boardFields[11][1] = new BoardField(11, 1, BonusType.NONE);
        boardFields[11][2] = new BoardField(11, 2, BonusType.NONE);
        boardFields[11][3] = new BoardField(11, 3, BonusType.DOUBLE_WORD_SCORE);
        boardFields[11][4] = new BoardField(11, 4, BonusType.NONE);
        boardFields[11][5] = new BoardField(11, 5, BonusType.NONE);
        boardFields[11][6] = new BoardField(11, 6, BonusType.NONE);
        boardFields[11][7] = new BoardField(11, 7, BonusType.DOUBLE_LETTER_SCORE);
        boardFields[11][8] = new BoardField(11, 8, BonusType.NONE);
        boardFields[11][9] = new BoardField(11, 9, BonusType.NONE);
        boardFields[11][10] = new BoardField(11, 10, BonusType.NONE);
        boardFields[11][11] = new BoardField(11, 11, BonusType.DOUBLE_WORD_SCORE);
        boardFields[11][12] = new BoardField(11, 12, BonusType.NONE);
        boardFields[11][13] = new BoardField(11, 13, BonusType.NONE);
        boardFields[11][14] = new BoardField(11, 14, BonusType.DOUBLE_LETTER_SCORE);

        boardFields[12][0] = new BoardField(12, 0, BonusType.NONE);
        boardFields[12][1] = new BoardField(12, 1, BonusType.NONE);
        boardFields[12][2] = new BoardField(12, 2, BonusType.DOUBLE_WORD_SCORE);
        boardFields[12][3] = new BoardField(12, 3, BonusType.NONE);
        boardFields[12][4] = new BoardField(12, 4, BonusType.NONE);
        boardFields[12][5] = new BoardField(12, 5, BonusType.NONE);
        boardFields[12][6] = new BoardField(12, 6, BonusType.DOUBLE_LETTER_SCORE);
        boardFields[12][7] = new BoardField(12, 7, BonusType.NONE);
        boardFields[12][8] = new BoardField(12, 8, BonusType.DOUBLE_LETTER_SCORE);
        boardFields[12][9] = new BoardField(12, 9, BonusType.NONE);
        boardFields[12][10] = new BoardField(12, 10, BonusType.NONE);
        boardFields[12][11] = new BoardField(12, 11, BonusType.NONE);
        boardFields[12][12] = new BoardField(12, 12, BonusType.DOUBLE_WORD_SCORE);
        boardFields[12][13] = new BoardField(12, 13, BonusType.NONE);
        boardFields[12][14] = new BoardField(12, 14, BonusType.NONE);

        boardFields[13][0] = new BoardField(13, 0, BonusType.NONE);
        boardFields[13][1] = new BoardField(13, 1, BonusType.DOUBLE_WORD_SCORE);
        boardFields[13][2] = new BoardField(13, 2, BonusType.NONE);
        boardFields[13][3] = new BoardField(13, 3, BonusType.NONE);
        boardFields[13][4] = new BoardField(13, 4, BonusType.NONE);
        boardFields[13][5] = new BoardField(13, 5, BonusType.TRIPLE_LETTER_SCORE);
        boardFields[13][6] = new BoardField(13, 6, BonusType.NONE);
        boardFields[13][7] = new BoardField(13, 7, BonusType.NONE);
        boardFields[13][8] = new BoardField(13, 8, BonusType.NONE);
        boardFields[13][9] = new BoardField(13, 9, BonusType.TRIPLE_LETTER_SCORE);
        boardFields[13][10] = new BoardField(13, 10, BonusType.NONE);
        boardFields[13][11] = new BoardField(13, 11, BonusType.NONE);
        boardFields[13][12] = new BoardField(13, 12, BonusType.NONE);
        boardFields[13][13] = new BoardField(13, 13, BonusType.DOUBLE_WORD_SCORE);
        boardFields[13][14] = new BoardField(13, 14, BonusType.NONE);

        boardFields[14][0] = new BoardField(14, 0, BonusType.TRIPLE_WORD_SCORE);
        boardFields[14][1] = new BoardField(14, 1, BonusType.NONE);
        boardFields[14][2] = new BoardField(14, 2, BonusType.NONE);
        boardFields[14][3] = new BoardField(14, 3, BonusType.DOUBLE_LETTER_SCORE);
        boardFields[14][4] = new BoardField(14, 4, BonusType.NONE);
        boardFields[14][5] = new BoardField(14, 5, BonusType.NONE);
        boardFields[14][6] = new BoardField(14, 6, BonusType.NONE);
        boardFields[14][7] = new BoardField(14, 7, BonusType.TRIPLE_WORD_SCORE);
        boardFields[14][8] = new BoardField(14, 8, BonusType.NONE);
        boardFields[14][9] = new BoardField(14, 9, BonusType.NONE);
        boardFields[14][10] = new BoardField(14, 10, BonusType.NONE);
        boardFields[14][11] = new BoardField(14, 11, BonusType.DOUBLE_LETTER_SCORE);
        boardFields[14][12] = new BoardField(14, 12, BonusType.NONE);
        boardFields[14][13] = new BoardField(14, 13, BonusType.NONE);
        boardFields[14][14] = new BoardField(14, 14, BonusType.TRIPLE_WORD_SCORE);


    }

    public BoardField[][] getBoardFields() {
        return this.boardFields;
    }

    public BoardField getBoardField(int x, int y) {
        return this.boardFields[x][y];
    }

    public boolean isBoardFieldAlone(BoardField boardField) {
        boolean topClear = boardField.getI1() == 0 ||
                boardFields[boardField.getI1() - 1][boardField.getI2()].getTileOnField() == null;

        boolean bottomClear = boardField.getI1() == 14 ||
                boardFields[boardField.getI1() + 1][boardField.getI2()].getTileOnField() == null;

        boolean leftClear = boardField.getI2() == 0 ||
                boardFields[boardField.getI1()][boardField.getI2() - 1].getTileOnField() == null;

        boolean rightClear = boardField.getI2() == 14 ||
                boardFields[boardField.getI1()][boardField.getI2() + 1].getTileOnField() == null;

        return topClear && bottomClear && leftClear && rightClear;
    }

    public List<Word> getWordsOnBoard(){
        List<Word> words = new ArrayList<>();

        List<BoardField> notNullFields = Stream.of(boardFields).flatMap(Stream::of).filter(bf -> bf.getTileOnField() != null).collect(Collectors.toList());


        for(BoardField notNullField : notNullFields){
            boolean topClear = notNullField.getI1() == 0 ||
                    boardFields[notNullField.getI1() - 1][notNullField.getI2()].getTileOnField() == null;

            boolean bottomClear = notNullField.getI1() == 14 ||
                    boardFields[notNullField.getI1() + 1][notNullField.getI2()].getTileOnField() == null;

            boolean leftClear = notNullField.getI2() == 0 ||
                    boardFields[notNullField.getI1()][notNullField.getI2() - 1].getTileOnField() == null;

            boolean rightClear = notNullField.getI2() == 14 ||
                    boardFields[notNullField.getI1()][notNullField.getI2() + 1].getTileOnField() == null;

            boolean wordDownward = topClear && !bottomClear;
            boolean wordRightward = leftClear && !rightClear;

            if(wordDownward) words.add(findWord(notNullField, true));
            if(wordRightward) words.add(findWord(notNullField, false));

        }

        return words;
    }

    public void saveWords(){
        savedWordsOnBoard = getWordsOnBoard();
    }

    public List<Word> getNewWords(){

        List<Word> newWords = new ArrayList<>();

        for(Word word : getWordsOnBoard()){
            boolean isAlready = savedWordsOnBoard.stream().anyMatch(w -> w.compare(word));
            if(!isAlready) newWords.add(word);
        }

        return newWords;
    }

    public boolean isStartOccupied(){
        return boardFields[7][7].isOccupied();
    }



    private Word findWord(BoardField boardField, boolean isDownWard){

        WordDirection wordDirection = isDownWard ? WordDirection.DOWNWARD : WordDirection.RIGHTWARD;
        Word word = new Word(wordDirection);

        int startI1 = boardField.getI1();
        int startI2 = boardField.getI2();

        switch(wordDirection){
            case DOWNWARD:

                for(int i = startI1; i<15; i++){
                    BoardField BF = boardFields[i][startI2];
                    if(BF.getTileOnField() != null) word.append(BF);
                    else break;
                }

                break;


            case RIGHTWARD:

                for(int i = startI2; i<15; i++){
                    BoardField BF = boardFields[startI1][i];
                    if(BF.getTileOnField() != null) word.append(BF);
                    else break;
                }
                break;
        }

        return word;

    }

}



