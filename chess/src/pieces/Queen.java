package pieces;

import game.Board;
import game.Move;
import game.Square;

import java.util.ArrayList;

public class Queen extends Piece {
    public Queen(Board board, Square square) {
        super(board, square);
    }

    @Override
    public ArrayList<Move> getAllValidMoves() {
        return null;
    }
}
