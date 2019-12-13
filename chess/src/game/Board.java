package game;

import pieces.*;

import java.util.Stack;


// TO DO

public class Board {
    private Square[][] board = new Square[8][8];
    private Stack<Move> moves = new Stack<>();
    private Piece lastTakenPiece = null;

    public Board() {
        fillBoard();
        fillPawns();
        fillPieces();
    }

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

    private void fillPawns() {
        for(int i = 0; i < 8; i++) {
            board[6][i].setPiece(new Pawn(this, board[6][i], Color.WHITE));
            board[1][i].setPiece(new Pawn(this, board[1][i], Color.BLACK));
        }
    }

    private void fillPieces() {
        fillPawns();
        Square square = new Square();
        //Fill kings and queens
        square = getSquare('e', 1);
        square.setPiece(new King(this, square, Color.WHITE));
        square = getSquare('d', 1);
        square.setPiece(new Queen(this, square, Color.WHITE));
        square = getSquare('e', 8);
        square.setPiece(new King(this, square, Color.BLACK));
        square = getSquare('d', 8);
        square.setPiece(new Queen(this, square, Color.BLACK));
        //Fill bishops
        square = getSquare('c', 1);
        square.setPiece(new Bishop(this, square, Color.WHITE));
        square = getSquare('f', 1);
        square.setPiece(new Bishop(this, square, Color.WHITE));
        square = getSquare('c', 8);
        square.setPiece(new Bishop(this, square, Color.BLACK));
        square = getSquare('f', 8);
        square.setPiece(new Bishop(this, square, Color.BLACK));
        //Fill knights
        square = getSquare('b', 1);
        square.setPiece(new Knight(this, square, Color.WHITE));
        square = getSquare('g', 1);
        square.setPiece(new Knight(this, square, Color.WHITE));
        square = getSquare('b', 8);
        square.setPiece(new Knight(this, square, Color.BLACK));
        square = getSquare('g', 8);
        square.setPiece(new Knight(this, square, Color.BLACK));
        //Fill rooks
        square = getSquare('a', 1);
        square.setPiece(new Rook(this, square, Color.WHITE));
        square = getSquare('h', 1);
        square.setPiece(new Rook(this, square, Color.WHITE));
        square = getSquare('a', 8);
        square.setPiece(new Rook(this, square, Color.BLACK));
        square = getSquare('h', 8);
        square.setPiece(new Rook(this, square, Color.BLACK));
    }

    public Square getSquare(int x, int y) {
        if(x < 8 && x >= 0 && y < 8 && y >=0) {
            return board[y][x];
        }
        return null;
    }

    public Square getSquare(char file, int rank) {
        return getSquare(file - 'a', 8 - rank);
    }

    public void applyMove(Move move) {
        //TO DO
        //Fix movement of pieces after applying a move
        Square from = move.getFrom();
        Square to = move.getTo();
        if (move.isCapture()) {
            lastTakenPiece = to.getPiece();
        }
        to.setOccupier(from.occupiedBy());
        to.setPiece(from.getPiece());
        from.setOccupier(Color.NONE);

        //possible fix
        from.getPiece().setSquare(to);

        if(move.isEnPassantCapture() && to.occupiedBy() == Color.WHITE) {
            this.getSquare(to.getX(), to.getY() + 1).setOccupier(Color.NONE);
        }
        if(move.isEnPassantCapture() && to.occupiedBy() == Color.BLACK) {
            this.getSquare(to.getX(), to.getY() - 1).setOccupier(Color.NONE);
        }
        moves.push(move);
    }

    //TO DO
    //Same as apply move
    public void unapplyMove(Move move) {
        Square from = move.getTo();
        Square to = move.getFrom();
        to.setOccupier(from.occupiedBy());
        from.setOccupier(Color.NONE);
        to.setPiece(from.getPiece());
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
            from.setPiece(lastTakenPiece);
            return;
        }
        if(move.isCapture() && to.occupiedBy() == Color.BLACK) {
            this.getSquare(from.getX(), from.getY()).setOccupier(Color.WHITE);
            from.setPiece(lastTakenPiece);
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
                    if (square.getPiece().getClass() == Pawn.class) {
                        System.out.print((char) 9817);
                    }
                    if (square.getPiece().getClass() == King.class) {
                        System.out.print((char) 9812);
                    }
                    if (square.getPiece().getClass() == Queen.class) {
                        System.out.print((char) 9813);
                    }
                    if (square.getPiece().getClass() == Bishop.class) {
                        System.out.print((char) 9815);
                    }
                    if (square.getPiece().getClass() == Knight.class) {
                        System.out.print((char) 9816);
                    }
                    if (square.getPiece().getClass() == Rook.class) {
                        System.out.print((char) 9814);
                    }
                }
                if (square.occupiedBy() == Color.WHITE) {
                    if (square.getPiece().getClass() == Pawn.class) {
                        System.out.print((char) 9823);
                    }
                    if (square.getPiece().getClass() == King.class) {
                        System.out.print((char) 9818);
                    }
                    if (square.getPiece().getClass() == Queen.class) {
                        System.out.print((char) 9819);
                    }
                    if (square.getPiece().getClass() == Bishop.class) {
                        System.out.print((char) 9821);
                    }
                    if (square.getPiece().getClass() == Knight.class) {
                        System.out.print((char) 9822);
                    }
                    if (square.getPiece().getClass() == Rook.class) {
                        System.out.print((char) 9820);
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
                board[i][j] = square;
                if (this.board[i][j].getPiece() != null) {
                    square.setPiece(this.board[i][j].getPiece().clone());
                }
            }
        }
        return new Board(board);
    }

    // TO DO
    public boolean isStalemate(Player currentPlayer) {
        return currentPlayer.getAllValidMoves().isEmpty();
    }
}
