package game;

import pieces.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {
    private Game game = new Game();
    private Board board = new Board();
    private Color color;
    private boolean isComputerPlayer;
    private Player opponent;
    private Move nextMove = new Move();

    public Player(Game game, Board board, Color color, boolean isComputerPlayer) {
        this.game = game;
        this.board = board;
        this.color = color;
        this.isComputerPlayer = isComputerPlayer;
    }

    public Player getOpponent() {
        return opponent;
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    public Color getColor() {
        return color;
    }

    public boolean isComputerPlayer() {
        return isComputerPlayer;
    }

    public ArrayList<Piece> getAllPieces() {
        ArrayList<Piece> pawns = new ArrayList<>();
        Square current = new Square();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                current = board.getSquare(i,j);
                if (current.occupiedBy() == color) {
                    pawns.add(current.getPiece());
                }
            }
        }
        return pawns;
    }


    public ArrayList<Move> getAllValidMoves() {
        ArrayList<Move> possibleMoves = new ArrayList<>();
        for (Piece piece : getAllPieces()) {
            possibleMoves.addAll(piece.getAllValidMoves());
        }
        return possibleMoves;
    }

    public boolean isPassedPawn(Square square) {
        if (square.occupiedBy() != color) {
            return false;
        }
        int x = square.getX();
        int y = square.getY();
        Square current = new Square();
        if (color == Color.WHITE) {
            for (int i = -1; i <= 1; i++) {
                for (int j = 0; j < y; j++) {
                    current = board.getSquare(square.getX() + i, j);
                    if (current != null) {
                        if (current.occupiedBy() == Color.BLACK) {
                            return false;
                        }
                    }
                }
            }
        }
        if (color == Color.BLACK) {
            for (int i = -1; i <= 1; i++) {
                for (int j = 7; j > y; j--) {
                    current = board.getSquare(square.getX() + i, j);
                    if (current != null) {
                        if (current.occupiedBy() == Color.WHITE) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public void makeMove() {
        Random rng = new Random();
        ArrayList<Move> possibleMoves = new ArrayList<>();
        possibleMoves = getAllValidMoves();
        for (Move move : possibleMoves) {
            System.out.println(move.getSAN());
        }
        int index = rng.nextInt(possibleMoves.size());
        game.applyMove(possibleMoves.get(index));
    }

    public void takeMove() {
        ArrayList<Move> possibleMoves = new ArrayList<>();
        possibleMoves = getAllValidMoves();
        Scanner sc = new Scanner(System.in);
        String moveSAN;
        Move nextMove = new Move();
        boolean isMoveFound = false;
        while (!isMoveFound) {
            System.out.println(this.color.toString() + " to move:");
            moveSAN = sc.next();
            for (Move move : possibleMoves) {
                if (move.getSAN().equals(moveSAN)) {
                    nextMove = move;
                    isMoveFound = true;
                    break;
                }
            }
        }
        game.applyMove(nextMove);
    }

    //TEST
    public void makeSmartMove() {
        boolean isMaximizingPlayer;
        if (color == Color.WHITE) {
            isMaximizingPlayer = true;
            //minimax(board, 4, Integer.MIN_VALUE, Integer.MAX_VALUE, isMaximizingPlayer);
        } else {
            isMaximizingPlayer = false;
            //minimax(board, 6, Integer.MIN_VALUE, Integer.MAX_VALUE, isMaximizingPlayer);
        }
        minimax(board, 5, Integer.MIN_VALUE, Integer.MAX_VALUE, isMaximizingPlayer);
        game.applyMove(nextMove);
    }


    //TO DO
    //Fix
    public int staticEvaluation(Board board) {
        int score = 0;
        for (Piece piece : getAllPieces()) {
            if (piece.getClass() == King.class) {
                score = score + 2000;
            }
            if (piece.getClass() == Queen.class) {
                score = score + 10;
            }
            if (piece.getClass() == Rook.class) {
                score = score + 5;
            }
            if (piece.getClass() == Bishop.class) {
                score = score + 3;
            }
            if (piece.getClass() == Knight.class) {
                score = score + 3;
            }
            if (piece.getClass() == Pawn.class) {
                score = score + 1;
            }
        }
        for (Piece piece : opponent.getAllPieces()) {
            if (piece.getClass() == King.class) {
                score = score - 2000;
            }
            if (piece.getClass() == Queen.class) {
                score = score - 10;
            }
            if (piece.getClass() == Rook.class) {
                score = score - 5;
            }
            if (piece.getClass() == Bishop.class) {
                score = score - 3;
            }
            if (piece.getClass() == Knight.class) {
                score = score - 3;
            }
            if (piece.getClass() == Pawn.class) {
                score = score - 1;
            }
        }
        if (game.hasWon(this)) {
            score = Integer.MAX_VALUE / 2;
        }

        if (color == Color.WHITE) {
            return score;
        } else {
            return -score;
        }

    }

    // BROKEN
    // extremely broken
    private int minimax(Board board, int depth, int alpha, int beta, boolean isMaximizingPlayer) {
        if (depth == 0 || game.isFinished()) {
            return staticEvaluation(board);
        }
        Move move = new Move();
        if (isMaximizingPlayer) {
            int maxEvaluation = Integer.MIN_VALUE;
            ArrayList<Move> moves = getAllValidMoves();
            for (int i = 0; i < moves.size(); i++) {
                Board newBoard = board.clone();
                move = moves.get(i);
                Square from = newBoard.getSquare(move.getFrom().getX(), move.getFrom().getY());
                Square to = newBoard.getSquare(move.getTo().getX(), move.getTo().getY());
                if (to.occupiedBy() == Color.BLACK) {
                    newBoard.applyMove(new Move(from, to, true, false));
                } else {
                    newBoard.applyMove(new Move(from, to, false, false));
                }
//                Board newerBoard = newBoard.clone();
//                newBoard.unapplyLast();
                int evaluation = minimax(newBoard, depth - 1, alpha, beta, false); // !!!!
                if (evaluation > alpha) {
                    nextMove = moves.get(i);
                }
                maxEvaluation = Math.max(maxEvaluation, evaluation);
                alpha = Math.max(alpha, evaluation);
                if (beta <= alpha) {
                    break;
                }
            }
            return maxEvaluation;
        } else {
            int minEvaluation = Integer.MAX_VALUE;
            ArrayList<Move> moves = getAllValidMoves();
            for (int i = 0; i < moves.size(); i++) {
                Board newBoard = board.clone();
                move = moves.get(i);
                Square from = newBoard.getSquare(move.getFrom().getX(), move.getFrom().getY());
                Square to = newBoard.getSquare(move.getTo().getX(), move.getTo().getY());
                if (to.occupiedBy() == Color.WHITE) {
                    newBoard.applyMove(new Move(from, to, true, false));
                } else {
                    newBoard.applyMove(new Move(from, to, false, false));

                }
//                Board newerBoard = newBoard.clone();
//                newBoard.unapplyLast();
                int evaluation = minimax(newBoard, depth - 1, alpha, beta, true); // !!!!
                if (evaluation < beta) {
                    nextMove = moves.get(i);
                }
                minEvaluation = Math.min(minEvaluation, evaluation);
                beta = Math.min(beta, evaluation);
                if (beta <= alpha) {
                    break;
                }
            }
            return minEvaluation;
        }
    }


}