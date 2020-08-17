package pieces;

import game.Board;
import game.Color;
import game.Move;
import game.Square;

import java.util.ArrayList;

public class Rook extends Piece {
    public Rook(Board board, Square square, Color color) {
        super(board, square, color, "rook");
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
        //Move left
        while(true) {
           x = x - 1;
           if (board.getSquare(x, y) != null) {
               to = board.getSquare(x, y);
               if (to.occupiedBy() == Color.NONE) {
                   move = new Move(from, to, false, false);
                   possibleMoves.add(move);
               }
               if (to.occupiedBy() == getOppositeColor()) {
                   move = new Move(from, to, true, false);
                   possibleMoves.add(move);
                   break;
               }
               if (to.occupiedBy() == getColor()) {
                   break;
               }
           } else {
               break;
           }
        }

        //Move right
        x = from.getX();
        y = from.getY();
        while(true) {
            x = x + 1;
            if (board.getSquare(x, y) != null) {
                to = board.getSquare(x, y);
                if (to.occupiedBy() == Color.NONE) {
                    move = new Move(from, to, false, false);
                    possibleMoves.add(move);
                }
                if (to.occupiedBy() == getOppositeColor()) {
                    move = new Move(from, to, true, false);
                    possibleMoves.add(move);
                    break;
                }
                if (to.occupiedBy() == getColor()) {
                    break;
                }
            } else {
                break;
            }
        }

        //Move up
        x = from.getX();
        y = from.getY();
        while(true) {
            y = y - 1;
            if (board.getSquare(x, y) != null) {
                to = board.getSquare(x, y);
                if (to.occupiedBy() == Color.NONE) {
                    move = new Move(from, to, false, false);
                    possibleMoves.add(move);
                }
                if (to.occupiedBy() == getOppositeColor()) {
                    move = new Move(from, to, true, false);
                    possibleMoves.add(move);
                    break;
                }
                if (to.occupiedBy() == getColor()) {
                    break;
                }
            } else {
                break;
            }
        }

        //Move down
        x = from.getX();
        y = from.getY();
        while(true) {
            y = y + 1;
            if (board.getSquare(x, y) != null) {
                to = board.getSquare(x, y);
                if (to.occupiedBy() == Color.NONE) {
                    move = new Move(from, to, false, false);
                    possibleMoves.add(move);
                }
                if (to.occupiedBy() == getOppositeColor()) {
                    move = new Move(from, to, true, false);
                    possibleMoves.add(move);
                    break;
                }
                if (to.occupiedBy() == getColor()) {
                    break;
                }
            } else {
                break;
            }
        }
        return possibleMoves;
    }

    @Override
    public Piece clone() {
        return new Rook(getBoard(), getSquare(), getColor());
    }
}
