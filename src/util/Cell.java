package util;

public abstract class Cell {
    protected String actualSymbol;
    protected String displaySymbol = "?";

    public String getSymbol() {
        return displaySymbol;
    }

    public void reveal(int row, int col) {
        displaySymbol = actualSymbol;
    }

    public boolean isRevealed() {
        return !displaySymbol.equals("?");
    }
}
