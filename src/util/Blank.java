package util;

public class Blank extends Cell {
    public Blank() {
        this.actualSymbol = " ";
    }

    @Override
    public void reveal(int row, int col) {
        super.reveal(row, col);
    }
}
