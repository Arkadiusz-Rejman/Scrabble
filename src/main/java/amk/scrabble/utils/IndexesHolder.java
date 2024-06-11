package amk.scrabble.utils;

public class IndexesHolder {
    private int i1, i2, storedIndex;

    public IndexesHolder(int i1, int i2, int storedIndex) {
        this.i1 = i1;
        this.i2 = i2;
        this.storedIndex = storedIndex;
    }

    public IndexesHolder(int i1, int i2) {
        this.i1 = i1;
        this.i2 = i2;
    }

    public int getStoredIndex() {
        return storedIndex;
    }

    public int getI1() {
        return i1;
    }

    public int getI2() {
        return i2;
    }

    @Override
    public String toString() {
        return "IndexesHolder{" +
                "i1=" + i1 +
                ", i2=" + i2 +
                ", storedIndex=" + storedIndex +
                '}';
    }
}
