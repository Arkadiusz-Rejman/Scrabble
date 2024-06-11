package amk.scrabble.model;

import amk.scrabble.utils.IndexesHolder;

import java.util.ArrayList;
import java.util.List;

public class Turn {
    private Player playerTurn;
    private final List<Integer> tilesIndexesToRemove;
    private final List<IndexesHolder> boardIndexesToAdd;

    public Turn(Player playerTurn) {
        this.playerTurn = playerTurn;
        tilesIndexesToRemove = new ArrayList<>();
        boardIndexesToAdd = new ArrayList<>();
    }


    public Player getPlayerTurn() {
        return playerTurn;
    }

    public List<Integer> getTilesIndexesToRemove() {
        return tilesIndexesToRemove;
    }

    public List<IndexesHolder> getBoardIndexesToAdd() {
        return boardIndexesToAdd;
    }

    public void setPlayerTurn(Player playerTurn) {
        this.playerTurn = playerTurn;
    }

    public void calculateScore(){

        List<StringBuilder> foundWords = new ArrayList<>();


        for (IndexesHolder indexesHolder : boardIndexesToAdd) {
            if (indexesHolder != null) {
                boolean topClear = indexesHolder.getI1() == 0 ||
                        boardIndexesToAdd.stream().noneMatch(
                                indexesHolder1 -> indexesHolder1 != null &&
                                        indexesHolder1.getI1() == indexesHolder.getI1() - 1 &&
                                        indexesHolder1.getI2() == indexesHolder.getI2()
                        );

                boolean bottomClear = indexesHolder.getI1() == 14 ||
                        boardIndexesToAdd.stream().noneMatch(
                                indexesHolder1 -> indexesHolder1 != null &&
                                        indexesHolder1.getI1() == indexesHolder.getI1() + 1 &&
                                        indexesHolder1.getI2() == indexesHolder.getI2()
                        );

                boolean leftClear = indexesHolder.getI2() == 0 ||
                        boardIndexesToAdd.stream().noneMatch(
                                indexesHolder1 -> indexesHolder1 != null &&
                                        indexesHolder1.getI1() == indexesHolder.getI1() &&
                                        indexesHolder1.getI2() == indexesHolder.getI2() - 1
                        );

                boolean rightClear = indexesHolder.getI2() == 14 ||
                        boardIndexesToAdd.stream().noneMatch(
                                indexesHolder1 -> indexesHolder1 != null &&
                                        indexesHolder1.getI1() == indexesHolder.getI1() &&
                                        indexesHolder1.getI2() == indexesHolder.getI2() + 1
                        );


                boolean wordDownward = topClear && !bottomClear;
                boolean wordRightward = leftClear && !rightClear;

                if(wordDownward || wordRightward){
                    StringBuilder word = generateWord(wordRightward, indexesHolder, boardIndexesToAdd, playerTurn);
                    System.out.println(word);
                }





            } else {
                System.out.println("indexesHolder is null");
            }

        }




    }

    private StringBuilder generateWord(boolean isRightward, IndexesHolder indexesHolder, List<IndexesHolder> boardIndexesToAdd, Player playerTurn) {
        StringBuilder word = new StringBuilder();

        word.append(playerTurn.getDock()[indexesHolder.getStoredIndex()]);

        int startIdx = isRightward ? indexesHolder.getI2() + 1 : indexesHolder.getI1() + 1;
        int endIdx = 15; // Dla wersji pionowej nie ma potrzeby zmiany endIdx

        for (int idx = startIdx; idx < endIdx; idx++) {
            boolean foundNextLetter = false;

            for (IndexesHolder indexes : boardIndexesToAdd) {
                int i1 = isRightward ? indexesHolder.getI1() : idx;
                int i2 = isRightward ? idx : indexesHolder.getI2();

                if (indexes.getI1() == i1 && indexes.getI2() == i2) {
                    word.append(playerTurn.getDock()[indexes.getStoredIndex()]);
                    foundNextLetter = true;
                    break;
                }
            }

            if (!foundNextLetter) {
                break;
            }
        }

        return word;
    }



}
