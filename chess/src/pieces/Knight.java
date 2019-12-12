package pieces;

import game.Board;
import game.Color;
import game.Move;
import game.Square;

import java.util.ArrayList;

public class Knight extends Piece {
    public Knight(Board board, Square square, Color color) {
        super(board, square, color);
    }

    @Override
    public ArrayList<Move> getAllValidMoves() {
        return null;
    }
}
