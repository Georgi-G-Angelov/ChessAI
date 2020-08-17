package pieces;

import game.Board;
import game.Color;
import game.Move;
import game.Square;
import javafx.scene.effect.Blend;

import java.util.ArrayList;

public abstract class Piece {
    private Square square = new Square();
    private Color color;
    private Board board;
    private int x;
    private int y;
    private String name;

    public Piece(Board board, Square square, Color color, String name) {
        this.square = square;
        x = square.getX();
        y = square.getY();
        this.board = board;
        this.color = color;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public abstract ArrayList<Move> getAllValidMoves();

    public abstract Piece clone();

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

    public Color getOppositeColor() {
        if (color == Color.BLACK) return Color.WHITE;
        if (color == Color.WHITE) return Color.BLACK;
        throw new AssertionError("Colour can only be black or white");
    }
}
