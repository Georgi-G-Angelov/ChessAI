package game;

import pieces.Piece;

public class Square {
    private int x;
    private int y;
    private Color occupant;
    private Piece piece;

    public Square(int x, int y){
        this.x = x;
        this.y = y;
        occupant = Color.NONE;
    }

    public Square() {
        x = 0;
        y = 0;
        occupant = Color.NONE;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color occupiedBy() {
        return occupant;
    }

    public void setOccupier(Color color) {
        occupant = color;
    }

    public String getFile() {
        return "" + (char)('a'+ x);
    }

    public String getRank() {
        return "" + (8 - y);
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
