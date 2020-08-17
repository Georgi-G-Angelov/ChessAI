package pieces;

import game.Board;
import game.Color;
import game.Move;
import game.Square;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    public Pawn(Board board, Square square, Color color) {
        super(board, square, color, "pawn");
    }

    @Override
    public ArrayList<Move> getAllValidMoves() {
        ArrayList<Move> possibleMoves = new ArrayList<>();
        Board board = getBoard();
        Square from = getSquare();
        int x = from.getX();
        int y = from.getY();
        Square to = new Square();
        Move move = new Move();
        switch (getColor()) {
            case WHITE:
                if (y == 6) {
                    to = board.getSquare(x, y - 2);
                    if (to != null) {
                        if (to.occupiedBy() == Color.NONE && board.getSquare(x, y - 1).occupiedBy() == Color.NONE) {
                            move = new Move(from, to, false,false);
                            possibleMoves.add(move);
                        }
                    }
                }
                to = board.getSquare(x - 1, y - 1);
                if (to != null) {
                    if (to.occupiedBy() == Color.BLACK) {
                        move = new Move(from, to, false,false);
                        possibleMoves.add(move);
                    }
                }
                to = board.getSquare(x + 1, y - 1);
                if (to != null) {
                    if (to.occupiedBy() == Color.BLACK) {
                        move = new Move(from, to, false,false);
                        possibleMoves.add(move);
                    }
                }
                to = board.getSquare(x, y - 1);
                if (to != null) {
                    if (to.occupiedBy() == Color.NONE) {
                        move = new Move(from, to, false,false);
                        possibleMoves.add(move);
                    }
                }
                break;
            case BLACK:
                if (y == 1) {
                    to = board.getSquare(x, y + 2);
                    if (to != null) {
                        if (to.occupiedBy() == Color.NONE && board.getSquare(x, y + 1).occupiedBy() == Color.NONE) {
                            move = new Move(from, to, false,false);
                            possibleMoves.add(move);
                        }
                    }
                }
                to = board.getSquare(x - 1, y + 1);
                if (to != null) {
                    if (to.occupiedBy() == Color.WHITE) {
                        move = new Move(from, to, false,false);
                        possibleMoves.add(move);
                    }
                }
                to = board.getSquare(x + 1, y + 1);
                if (to != null) {
                    if (to.occupiedBy() == Color.WHITE) {
                        move = new Move(from, to, false,false);
                        possibleMoves.add(move);
                    }
                }
                to = board.getSquare(x, y + 1);
                if (to != null) {
                    if (to.occupiedBy() == Color.NONE) {
                        move = new Move(from, to, false,false);
                        possibleMoves.add(move);
                    }
                }
        }
        return possibleMoves;
    }

    @Override
    public Piece clone() {
        return new Pawn(getBoard(), getSquare(), getColor());
    }
}
