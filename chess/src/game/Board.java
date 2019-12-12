package game;

import pieces.Pawn;
import pieces.Piece;

import java.util.Stack;


// TO DO

public class Board {
    private Square[][] board = new Square[8][8];
    Stack<Move> moves = new Stack<>();

    //TO DO
    public Board() {
        fillBoard();
    }


//    public Board(char whiteGap, char blackGap) {
//        fillBoard();
//        fillPawns();
//        board[6][whiteGap - 'a'].setOccupier(Color.NONE);
//        board[1][blackGap - 'a'].setOccupier(Color.NONE);
//    }

    public Board(Square[][] board) {
        this.board = board;
    }

    private void fillBoard() {
        for(int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[j][i] = new Square(i,j);
            }
        }
    }

//    private void fillPawns() {
//        for(int i = 0; i < 8; i++) {
//            board[6][i].setOccupier(Color.WHITE);
//            board[1][i].setOccupier(Color.BLACK);
//        }
//    }

    //TO DO
    private void fillPieces() {

    }

    public Square getSquare(int x, int y) {
        if(x < 8 && x >= 0 && y < 8 && y >=0) {
            return board[y][x];
        }
        return null;
    }

    public void applyMove(Move move) {
        Square from = move.getFrom();
        Square to = move.getTo();
        to.setOccupier(from.occupiedBy());
        from.setOccupier(Color.NONE);
        if(move.isEnPassantCapture() && to.occupiedBy() == Color.WHITE) {
            this.getSquare(to.getX(), to.getY() + 1).setOccupier(Color.NONE);
        }
        if(move.isEnPassantCapture() && to.occupiedBy() == Color.BLACK) {
            this.getSquare(to.getX(), to.getY() - 1).setOccupier(Color.NONE);
        }
        moves.push(move);
    }

    public void unapplyMove(Move move) {
        Square from = move.getTo();
        Square to = move.getFrom();
        to.setOccupier(from.occupiedBy());
        from.setOccupier(Color.NONE);
        if(move.isEnPassantCapture() && to.occupiedBy() == Color.WHITE) {
            this.getSquare(from.getX(), from.getY() + 1).setOccupier(Color.BLACK);
            return;
        }
        if(move.isEnPassantCapture() && to.occupiedBy() == Color.BLACK) {
            this.getSquare(from.getX(), from.getY() - 1).setOccupier(Color.WHITE);
            return;
        }
        if(move.isCapture() && to.occupiedBy() == Color.WHITE) {
            this.getSquare(from.getX(), from.getY()).setOccupier(Color.BLACK);
            return;
        }
        if(move.isCapture() && to.occupiedBy() == Color.BLACK) {
            this.getSquare(from.getX(), from.getY()).setOccupier(Color.WHITE);
        }
    }

    public void unapplyLast() {
        if(!moves.empty()) {
            unapplyMove(moves.peek());
            moves.pop();
        } else {
            System.out.println("There are no previous moves.");
        }
    }

    public Move getLastMove() {
        if(!moves.empty()) {
            return moves.peek();
        }
        return null;
    }

    //TO DO
    public void display() {
        System.out.println("   A B C D E F G H");
        int counter = 8;
        for (Square[] row : board) {
            System.out.print(counter + "  ");
            for (Square square : row) {
                if (square.occupiedBy() == Color.NONE) {
                    System.out.print(".");
                }
                if (square.occupiedBy() == Color.BLACK) {
                    System.out.print((char) 9817);
                }
                if (square.occupiedBy() == Color.WHITE) {
                    if (square.getPiece().getClass() == Pawn.class) {
                        System.out.print((char) 9823);
                    }
                }
                System.out.print(' ');
            }
            System.out.println("  " + counter);
            counter--;
        }
        System.out.println("   A B C D E F G H");
    }

    // TO DO
    public Board clone() {
        Square[][] board = new Square[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Square square = new Square(this.board[i][j].getX(), this.board[i][j].getX());
                square.setOccupier(this.board[i][j].occupiedBy());
                //Piece piece = (Piece) square.getPiece().clone();
                board[i][j] = square;
            }
        }
        return new Board(board);
    }

    // TO DO
    public boolean isStalemate(Color currentPlayer) {
        for (int i = 0; i < 8; i++) {
            for (int j = 1; j < 7; j++) {
                if (getSquare(i,j).occupiedBy() == currentPlayer) {
                    if (currentPlayer == Color.BLACK) {
                        if(getSquare(i, j + 1).occupiedBy() == Color.NONE) {
                            return false;
                        }
                        if(getSquare(i - 1, j + 1) != null) {
                            if(getSquare(i - 1, j + 1).occupiedBy() == Color.WHITE) {
                                return false;
                            }
                        }
                        if(getSquare(i + 1, j + 1) != null) {
                            if(getSquare(i + 1, j + 1).occupiedBy() == Color.WHITE) {
                                return false;
                            }
                        }
                    }
                    if (currentPlayer == Color.WHITE) {
                        if(getSquare(i, j - 1).occupiedBy() == Color.NONE) {
                            return false;
                        }
                        if(getSquare(i - 1, j - 1) != null) {
                            if(getSquare(i - 1, j - 1).occupiedBy() == Color.BLACK) {
                                return false;
                            }
                        }
                        if(getSquare(i + 1, j - 1) != null) {
                            if(getSquare(i + 1, j - 1).occupiedBy() == Color.BLACK) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
