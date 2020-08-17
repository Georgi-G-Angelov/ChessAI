package pieces;

import game.Board;
import game.Color;
import game.Move;
import game.Square;

import java.util.ArrayList;

public class Knight extends Piece {
    public Knight(Board board, Square square, Color color) {
        super(board, square, color, "knight");
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
        int[] deltaX = {-2, -2, -1, -1,  1,  1,  2,  2};
        int[] deltaY = {-1,  1, -2,  2, -2,  2, -1,  1};
        for (int i = 0; i < deltaX.length; i++) {
            to = board.getSquare(x + deltaX[i], y + deltaY[i]);
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
        return possibleMoves;
    }

    @Override
    public Piece clone() {
        return new Knight(getBoard(), getSquare(), getColor());
    }
}
