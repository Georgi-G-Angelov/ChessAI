package pieces;

import game.Board;
import game.Color;
import game.Move;
import game.Square;

import java.util.ArrayList;

public class Queen extends Piece {
    public Queen(Board board, Square square, Color color) {
        super(board, square, color, "queen");
    }

    @Override
    public ArrayList<Move> getAllValidMoves() {
        ArrayList<Move> possibleMoves = new ArrayList<>();
        Board board = getBoard();
        Rook asRook = new Rook(board, getSquare(), getColor());
        possibleMoves.addAll(asRook.getAllValidMoves());
        Bishop asBishop = new Bishop(board, getSquare(), getColor());
        possibleMoves.addAll(asBishop.getAllValidMoves());
        return possibleMoves;
    }

    @Override
    public Piece clone() {
        return new Queen(getBoard(), getSquare(), getColor());
    }
}
