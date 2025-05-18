package util;

public class Number extends Cell {
    private int bombCount;

    public Number(int count) {
        this.bombCount = count;
        this.actualSymbol = Integer.toString(count);
    }

    public int getBombCount() {
        return bombCount;
    }

    @Override
    public void reveal(int row, int col) {
        super.reveal(row, col);
    }
}
