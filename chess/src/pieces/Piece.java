package pieces;

import game.Board;
import game.Color;
import game.Move;
import game.Square;

import java.util.ArrayList;

public abstract class Piece {
    private Square square = new Square();
    private Color color;
    private Board board = new Board();
    private int x;
    private int y;

    public Piece(Board board, Square square) {
        this.square = square;
        x = square.getX();
        y = square.getY();
        this.board = board;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public abstract ArrayList<Move> getAllValidMoves();

    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

}
