package util;

public class Bomb extends Cell {
    public Bomb() {
        this.actualSymbol = "*";
    }

    @Override
    public void reveal(int row, int col) {
        super.reveal(row, col);
//        System.out.println("*****************");
//        System.out.println("Boom. Game Over!");
//        System.out.println("*****************");
//
//        System.exit(0);
    }
}
