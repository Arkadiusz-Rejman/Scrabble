package amk.scrabble.model;

import amk.scrabble.enums.BonusType;

import java.util.ArrayList;

public class GameBoard {
    private BoardField[][] boardFields;

    public GameBoard() {

        boardFields = new BoardField[15][15];

        boardFields[0][0] = new BoardField(BonusType.TRIPLE_WORD_SCORE);
        boardFields[0][1] = new BoardField(BonusType.NONE);
        boardFields[0][2] = new BoardField(BonusType.NONE);
        boardFields[0][3] = new BoardField(BonusType.DOUBLE_LETTER_SCORE);
        boardFields[0][4] = new BoardField(BonusType.NONE);
        boardFields[0][5] = new BoardField(BonusType.NONE);
        boardFields[0][6] = new BoardField(BonusType.NONE);
        boardFields[0][7] = new BoardField(BonusType.TRIPLE_WORD_SCORE);
        boardFields[0][8] = new BoardField(BonusType.NONE);
        boardFields[0][9] = new BoardField(BonusType.NONE);
        boardFields[0][10] = new BoardField(BonusType.NONE);
        boardFields[0][11] = new BoardField(BonusType.DOUBLE_LETTER_SCORE);
        boardFields[0][12] = new BoardField(BonusType.NONE);
        boardFields[0][13] = new BoardField(BonusType.NONE);
        boardFields[0][14] = new BoardField(BonusType.TRIPLE_WORD_SCORE);

        boardFields[1][0] = new BoardField(BonusType.NONE);
        boardFields[1][1] = new BoardField(BonusType.DOUBLE_WORD_SCORE);
        boardFields[1][2] = new BoardField(BonusType.NONE);
        boardFields[1][3] = new BoardField(BonusType.NONE);
        boardFields[1][4] = new BoardField(BonusType.NONE);
        boardFields[1][5] = new BoardField(BonusType.TRIPLE_LETTER_SCORE);
        boardFields[1][6] = new BoardField(BonusType.NONE);
        boardFields[1][7] = new BoardField(BonusType.NONE);
        boardFields[1][8] = new BoardField(BonusType.NONE);
        boardFields[1][9] = new BoardField(BonusType.TRIPLE_LETTER_SCORE);
        boardFields[1][10] = new BoardField(BonusType.NONE);
        boardFields[1][11] = new BoardField(BonusType.NONE);
        boardFields[1][12] = new BoardField(BonusType.NONE);
        boardFields[1][13] = new BoardField(BonusType.DOUBLE_WORD_SCORE);
        boardFields[1][14] = new BoardField(BonusType.NONE);

        boardFields[2][0] = new BoardField(BonusType.NONE);
        boardFields[2][1] = new BoardField(BonusType.NONE);
        boardFields[2][2] = new BoardField(BonusType.DOUBLE_WORD_SCORE);
        boardFields[2][3] = new BoardField(BonusType.NONE);
        boardFields[2][4] = new BoardField(BonusType.NONE);
        boardFields[2][5] = new BoardField(BonusType.NONE);
        boardFields[2][6] = new BoardField(BonusType.DOUBLE_LETTER_SCORE);
        boardFields[2][7] = new BoardField(BonusType.NONE);
        boardFields[2][8] = new BoardField(BonusType.DOUBLE_LETTER_SCORE);
        boardFields[2][9] = new BoardField(BonusType.NONE);
        boardFields[2][10] = new BoardField(BonusType.NONE);
        boardFields[2][11] = new BoardField(BonusType.NONE);
        boardFields[2][12] = new BoardField(BonusType.DOUBLE_WORD_SCORE);
        boardFields[2][13] = new BoardField(BonusType.NONE);
        boardFields[2][14] = new BoardField(BonusType.NONE);

        boardFields[3][0] = new BoardField(BonusType.DOUBLE_LETTER_SCORE);
        boardFields[3][1] = new BoardField(BonusType.NONE);
        boardFields[3][2] = new BoardField(BonusType.NONE);
        boardFields[3][3] = new BoardField(BonusType.DOUBLE_WORD_SCORE);
        boardFields[3][4] = new BoardField(BonusType.NONE);
        boardFields[3][5] = new BoardField(BonusType.NONE);
        boardFields[3][6] = new BoardField(BonusType.NONE);
        boardFields[3][7] = new BoardField(BonusType.DOUBLE_LETTER_SCORE);
        boardFields[3][8] = new BoardField(BonusType.NONE);
        boardFields[3][9] = new BoardField(BonusType.NONE);
        boardFields[3][10] = new BoardField(BonusType.NONE);
        boardFields[3][11] = new BoardField(BonusType.DOUBLE_WORD_SCORE);
        boardFields[3][12] = new BoardField(BonusType.NONE);
        boardFields[3][13] = new BoardField(BonusType.NONE);
        boardFields[3][14] = new BoardField(BonusType.DOUBLE_LETTER_SCORE);

        boardFields[4][0] = new BoardField(BonusType.NONE);
        boardFields[4][1] = new BoardField(BonusType.NONE);
        boardFields[4][2] = new BoardField(BonusType.NONE);
        boardFields[4][3] = new BoardField(BonusType.NONE);
        boardFields[4][4] = new BoardField(BonusType.DOUBLE_WORD_SCORE);
        boardFields[4][5] = new BoardField(BonusType.NONE);
        boardFields[4][6] = new BoardField(BonusType.NONE);
        boardFields[4][7] = new BoardField(BonusType.NONE);
        boardFields[4][8] = new BoardField(BonusType.NONE);
        boardFields[4][9] = new BoardField(BonusType.NONE);
        boardFields[4][10] = new BoardField(BonusType.DOUBLE_WORD_SCORE);
        boardFields[4][11] = new BoardField(BonusType.NONE);
        boardFields[4][12] = new BoardField(BonusType.NONE);
        boardFields[4][13] = new BoardField(BonusType.NONE);
        boardFields[4][14] = new BoardField(BonusType.NONE);

        boardFields[5][0] = new BoardField(BonusType.NONE);
        boardFields[5][1] = new BoardField(BonusType.TRIPLE_LETTER_SCORE);
        boardFields[5][2] = new BoardField(BonusType.NONE);
        boardFields[5][3] = new BoardField(BonusType.NONE);
        boardFields[5][4] = new BoardField(BonusType.NONE);
        boardFields[5][5] = new BoardField(BonusType.TRIPLE_LETTER_SCORE);
        boardFields[5][6] = new BoardField(BonusType.NONE);
        boardFields[5][7] = new BoardField(BonusType.NONE);
        boardFields[5][8] = new BoardField(BonusType.NONE);
        boardFields[5][9] = new BoardField(BonusType.TRIPLE_LETTER_SCORE);
        boardFields[5][10] = new BoardField(BonusType.NONE);
        boardFields[5][11] = new BoardField(BonusType.NONE);
        boardFields[5][12] = new BoardField(BonusType.NONE);
        boardFields[5][13] = new BoardField(BonusType.TRIPLE_LETTER_SCORE);
        boardFields[5][14] = new BoardField(BonusType.NONE);

        boardFields[6][0] = new BoardField(BonusType.NONE);
        boardFields[6][1] = new BoardField(BonusType.NONE);
        boardFields[6][2] = new BoardField(BonusType.DOUBLE_LETTER_SCORE);
        boardFields[6][3] = new BoardField(BonusType.NONE);
        boardFields[6][4] = new BoardField(BonusType.NONE);
        boardFields[6][5] = new BoardField(BonusType.NONE);
        boardFields[6][6] = new BoardField(BonusType.DOUBLE_LETTER_SCORE);
        boardFields[6][7] = new BoardField(BonusType.NONE);
        boardFields[6][8] = new BoardField(BonusType.DOUBLE_LETTER_SCORE);
        boardFields[6][9] = new BoardField(BonusType.NONE);
        boardFields[6][10] = new BoardField(BonusType.NONE);
        boardFields[6][11] = new BoardField(BonusType.NONE);
        boardFields[6][12] = new BoardField(BonusType.DOUBLE_LETTER_SCORE);
        boardFields[6][13] = new BoardField(BonusType.NONE);
        boardFields[6][14] = new BoardField(BonusType.NONE);

//START
        boardFields[7][0] = new BoardField(BonusType.TRIPLE_WORD_SCORE);
        boardFields[7][1] = new BoardField(BonusType.NONE);
        boardFields[7][2] = new BoardField(BonusType.NONE);
        boardFields[7][3] = new BoardField(BonusType.DOUBLE_LETTER_SCORE);
        boardFields[7][4] = new BoardField(BonusType.NONE);
        boardFields[7][5] = new BoardField(BonusType.NONE);
        boardFields[7][6] = new BoardField(BonusType.NONE);
        boardFields[7][7] = new BoardField(BonusType.START);
        boardFields[7][8] = new BoardField(BonusType.NONE);
        boardFields[7][9] = new BoardField(BonusType.NONE);
        boardFields[7][10] = new BoardField(BonusType.NONE);
        boardFields[7][11] = new BoardField(BonusType.DOUBLE_LETTER_SCORE);
        boardFields[7][12] = new BoardField(BonusType.NONE);
        boardFields[7][13] = new BoardField(BonusType.NONE);
        boardFields[7][14] = new BoardField(BonusType.TRIPLE_WORD_SCORE);

        boardFields[8][0] = new BoardField(BonusType.NONE);
        boardFields[8][1] = new BoardField(BonusType.NONE);
        boardFields[8][2] = new BoardField(BonusType.DOUBLE_LETTER_SCORE);
        boardFields[8][3] = new BoardField(BonusType.NONE);
        boardFields[8][4] = new BoardField(BonusType.NONE);
        boardFields[8][5] = new BoardField(BonusType.NONE);
        boardFields[8][6] = new BoardField(BonusType.DOUBLE_LETTER_SCORE);
        boardFields[8][7] = new BoardField(BonusType.NONE);
        boardFields[8][8] = new BoardField(BonusType.DOUBLE_LETTER_SCORE);
        boardFields[8][9] = new BoardField(BonusType.NONE);
        boardFields[8][10] = new BoardField(BonusType.NONE);
        boardFields[8][11] = new BoardField(BonusType.NONE);
        boardFields[8][12] = new BoardField(BonusType.DOUBLE_LETTER_SCORE);
        boardFields[8][13] = new BoardField(BonusType.NONE);
        boardFields[8][14] = new BoardField(BonusType.NONE);

        boardFields[9][0] = new BoardField(BonusType.NONE);
        boardFields[9][1] = new BoardField(BonusType.TRIPLE_LETTER_SCORE);
        boardFields[9][2] = new BoardField(BonusType.NONE);
        boardFields[9][3] = new BoardField(BonusType.NONE);
        boardFields[9][4] = new BoardField(BonusType.NONE);
        boardFields[9][5] = new BoardField(BonusType.TRIPLE_LETTER_SCORE);
        boardFields[9][6] = new BoardField(BonusType.NONE);
        boardFields[9][7] = new BoardField(BonusType.NONE);
        boardFields[9][8] = new BoardField(BonusType.NONE);
        boardFields[9][9] = new BoardField(BonusType.TRIPLE_LETTER_SCORE);
        boardFields[9][10] = new BoardField(BonusType.NONE);
        boardFields[9][11] = new BoardField(BonusType.NONE);
        boardFields[9][12] = new BoardField(BonusType.NONE);
        boardFields[9][13] = new BoardField(BonusType.TRIPLE_LETTER_SCORE);
        boardFields[9][14] = new BoardField(BonusType.NONE);

        boardFields[10][0] = new BoardField(BonusType.NONE);
        boardFields[10][1] = new BoardField(BonusType.NONE);
        boardFields[10][2] = new BoardField(BonusType.NONE);
        boardFields[10][3] = new BoardField(BonusType.NONE);
        boardFields[10][4] = new BoardField(BonusType.DOUBLE_WORD_SCORE);
        boardFields[10][5] = new BoardField(BonusType.NONE);
        boardFields[10][6] = new BoardField(BonusType.NONE);
        boardFields[10][7] = new BoardField(BonusType.NONE);
        boardFields[10][8] = new BoardField(BonusType.NONE);
        boardFields[10][9] = new BoardField(BonusType.NONE);
        boardFields[10][10] = new BoardField(BonusType.DOUBLE_WORD_SCORE);
        boardFields[10][11] = new BoardField(BonusType.NONE);
        boardFields[10][12] = new BoardField(BonusType.NONE);
        boardFields[10][13] = new BoardField(BonusType.NONE);
        boardFields[10][14] = new BoardField(BonusType.NONE);

        boardFields[11][0] = new BoardField(BonusType.DOUBLE_LETTER_SCORE);
        boardFields[11][1] = new BoardField(BonusType.NONE);
        boardFields[11][2] = new BoardField(BonusType.NONE);
        boardFields[11][3] = new BoardField(BonusType.DOUBLE_WORD_SCORE);
        boardFields[11][4] = new BoardField(BonusType.NONE);
        boardFields[11][5] = new BoardField(BonusType.NONE);
        boardFields[11][6] = new BoardField(BonusType.NONE);
        boardFields[11][7] = new BoardField(BonusType.DOUBLE_LETTER_SCORE);
        boardFields[11][8] = new BoardField(BonusType.NONE);
        boardFields[11][9] = new BoardField(BonusType.NONE);
        boardFields[11][10] = new BoardField(BonusType.NONE);
        boardFields[11][11] = new BoardField(BonusType.DOUBLE_WORD_SCORE);
        boardFields[11][12] = new BoardField(BonusType.NONE);
        boardFields[11][13] = new BoardField(BonusType.NONE);
        boardFields[11][14] = new BoardField(BonusType.DOUBLE_LETTER_SCORE);

        boardFields[12][0] = new BoardField(BonusType.NONE);
        boardFields[12][1] = new BoardField(BonusType.NONE);
        boardFields[12][2] = new BoardField(BonusType.DOUBLE_WORD_SCORE);
        boardFields[12][3] = new BoardField(BonusType.NONE);
        boardFields[12][4] = new BoardField(BonusType.NONE);
        boardFields[12][5] = new BoardField(BonusType.NONE);
        boardFields[12][6] = new BoardField(BonusType.DOUBLE_LETTER_SCORE);
        boardFields[12][7] = new BoardField(BonusType.NONE);
        boardFields[12][8] = new BoardField(BonusType.DOUBLE_LETTER_SCORE);
        boardFields[12][9] = new BoardField(BonusType.NONE);
        boardFields[12][10] = new BoardField(BonusType.NONE);
        boardFields[12][11] = new BoardField(BonusType.NONE);
        boardFields[12][12] = new BoardField(BonusType.DOUBLE_WORD_SCORE);
        boardFields[12][13] = new BoardField(BonusType.NONE);
        boardFields[12][14] = new BoardField(BonusType.NONE);

        boardFields[13][0] = new BoardField(BonusType.NONE);
        boardFields[13][1] = new BoardField(BonusType.DOUBLE_WORD_SCORE);
        boardFields[13][2] = new BoardField(BonusType.NONE);
        boardFields[13][3] = new BoardField(BonusType.NONE);
        boardFields[13][4] = new BoardField(BonusType.NONE);
        boardFields[13][5] = new BoardField(BonusType.TRIPLE_LETTER_SCORE);
        boardFields[13][6] = new BoardField(BonusType.NONE);
        boardFields[13][7] = new BoardField(BonusType.NONE);
        boardFields[13][8] = new BoardField(BonusType.NONE);
        boardFields[13][9] = new BoardField(BonusType.TRIPLE_LETTER_SCORE);
        boardFields[13][10] = new BoardField(BonusType.NONE);
        boardFields[13][11] = new BoardField(BonusType.NONE);
        boardFields[13][12] = new BoardField(BonusType.NONE);
        boardFields[13][13] = new BoardField(BonusType.DOUBLE_WORD_SCORE);
        boardFields[13][14] = new BoardField(BonusType.NONE);

        boardFields[14][0] = new BoardField(BonusType.TRIPLE_WORD_SCORE);
        boardFields[14][1] = new BoardField(BonusType.NONE);
        boardFields[14][2] = new BoardField(BonusType.NONE);
        boardFields[14][3] = new BoardField(BonusType.DOUBLE_LETTER_SCORE);
        boardFields[14][4] = new BoardField(BonusType.NONE);
        boardFields[14][5] = new BoardField(BonusType.NONE);
        boardFields[14][6] = new BoardField(BonusType.NONE);
        boardFields[14][7] = new BoardField(BonusType.TRIPLE_WORD_SCORE);
        boardFields[14][8] = new BoardField(BonusType.NONE);
        boardFields[14][9] = new BoardField(BonusType.NONE);
        boardFields[14][10] = new BoardField(BonusType.NONE);
        boardFields[14][11] = new BoardField(BonusType.DOUBLE_LETTER_SCORE);
        boardFields[14][12] = new BoardField(BonusType.NONE);
        boardFields[14][13] = new BoardField(BonusType.NONE);
        boardFields[14][14] = new BoardField(BonusType.TRIPLE_WORD_SCORE);


    }

    public BoardField[][] getBoardFields() {
        return this.boardFields;
    }

    public BoardField getBoardField(int x, int y) {
        return this.boardFields[x][y];
    }
}
