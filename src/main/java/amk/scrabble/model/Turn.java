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

        List<String> foundWords = new ArrayList<>();


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


                boolean wordDownward = leftClear && topClear && rightClear && !bottomClear;
                boolean wordRightward = leftClear && topClear && !rightClear && bottomClear;

                System.out.println("Word right " + wordRightward);
                System.out.println("Word down " + wordDownward);

                // Tu jest do dokończenia
                // Jest to pojedynczy znak jeżeli word Right oraz down jest na false

            } else {
                System.out.println("indexesHolder is null");
            }

        }




    }



}
