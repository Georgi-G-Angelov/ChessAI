package game;

import game.Square;

public class Move {
    private Square from;
    private Square to;
    private boolean isCapture;
    private boolean isEnPassantCapture;

    public Move(Square from, Square to, boolean isCapture, boolean isEnPassantCapture) {
        this.from = from;
        this.to = to;
        this.isCapture = isCapture;
        this.isEnPassantCapture = isEnPassantCapture;
    }

    public Move() {

    }

    public Square getFrom() {
        return from;
    }

    public Square getTo() {
        return to;
    }

    public boolean isCapture() {
        return isCapture;
    }

    public boolean isEnPassantCapture() {
        return isEnPassantCapture;
    }

    public String getSAN() {
        if(isCapture || isEnPassantCapture) {
            return from.getFile() + "x" + to.getFile() + to.getRank();
        }
        return to.getFile() + to.getRank();
    }

    public String toString() {
        return from.getFile() + from.getRank() + " to " + to.getFile() + to.getRank();
    }

//    public boolean isTwoBlocks(Square square) {
//        return Math.abs(from.getY() - to.getY()) == 2 && square == to;
//    }
}
