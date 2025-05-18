package util;

public class Bomb extends Cell {
    public Bomb() {
        this.actualSymbol = "*";
    }

    @Override
    public void reveal(int row, int col) {
        super.reveal(row, col);
        System.out.println("Game Over!");
        System.exit(0);
    }
}
