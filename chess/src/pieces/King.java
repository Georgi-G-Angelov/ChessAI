package pieces;

import game.Board;
import game.Color;
import game.Move;
import game.Square;

import java.util.ArrayList;

public class King extends Piece {
    public King(Board board, Square square, Color color) {
        super(board, square, color);
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
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                to = board.getSquare(x + i, y + j);
                if (to != null) {
                    if (to.occupiedBy() == Color.NONE) {
                        move = new Move(from, to, false, false);
                        possibleMoves.add(move);
                    }
                    if (to.occupiedBy() == getOppositeColor()) {
                        move = new Move(from, to, true, false);
                        possibleMoves.add(move);
                    }
                }
            }
        }
        return possibleMoves;
    }

    @Override
    public Piece clone() {
        return new King(getBoard(), getSquare(), getColor());
    }
}
