import game.*;

import java.util.Scanner;

public class ChessGame {
    public static void main(String[] args) {


        Board board = new Board();
        Game game = new Game(board);
        Player p1 = new Player(game, board, Color.WHITE, true);
        Player p2 = new Player(game, board, Color.BLACK, true);
        game.setCurrentPlayer(p1);
        p1.setOpponent(p2);
        p2.setOpponent(p1);
        while (!game.isFinished()) {
            p1.makeMove();
            game.setCurrentPlayer(p2);
            board.display();
            System.out.println("White eval : " + p1.staticEvaluation(board));
            System.out.println("Black eval : " + p2.staticEvaluation(board));
            if (game.isFinished()) {
                break;
            }
            p2.makeSmartMove();
            game.setCurrentPlayer(p1);
            board.display();
            System.out.println("White eval : " + p1.staticEvaluation(board));
            System.out.println("Black eval : " + p2.staticEvaluation(board));
        }
        Scanner sc = new Scanner(System.in);
//        p1.makeMove();
//        p1.makeMove();
//        p1.makeMove();
//        p1.makeMove();
//        p1.makeMove();
//        p1.makeMove();
//        board.display();
//        p1.getAllValidMoves().forEach(move -> System.out.println(move));


        //p1.getAllPieces().forEach(piece -> System.out.println(piece.getSquare().getX() + " " + piece.getSquare().getY()));
//        while(!game.isFinished()) {
//
//            //p1.getAllPawns().forEach(pawn -> System.out.println(p1.isPassedPawn(pawn) + " " + pawn.getFile() + pawn.getRank()));
//
//            if (p1.isComputerPlayer()) {
//                //p1.makeMove1();
//                p1.makeSmartMove();
//                //p1.makeSmartMove1();
//            } else {
//                System.out.println("game.Player one enter a move: ");
//                String san = sc.nextLine();
//                while(game.parseMove(san) == null) {
//                    // undo
//                    if (san.equals("undo")) {
//                        game.unapplyMove();
//                        game.unapplyMove();
//                        board.display();
//                        System.out.println("game.Player one enter a move: ");
//                    } else {
//                        System.out.println("Invalid move. Enter new move:");
//                    }
//                    san = sc.nextLine();
//                }
//                game.applyMove(game.parseMove(san));
//            }
//            board.display();
//            //System.out.println("static eval White: " + p1.staticEvaluation(board));
//            //System.out.println("static eval Black: " + p2.staticEvaluation(board));
//            if (game.isFinished()) {
//                break;
//            }
//            //board.display();
//            //p2.getAllValidMoves().forEach(move -> System.out.print(move.getSAN() + " "));
//            System.out.println();
//            if (p2.isComputerPlayer()) {
//                //p2.makeMove1();
//                p2.makeSmartMove();
//                //p2.makeSmartMove();
//            } else {
//                System.out.println("game.Player two enter a move: ");
//                String san = sc.nextLine();
//                while(game.parseMove(san) == null) {
//                    if (san.equals("undo")) {
//                        game.unapplyMove();
//                        game.unapplyMove();
//                        board.display();
//                        System.out.println("game.Player one enter a move: ");
//                    } else {
//                        System.out.println("Invalid move. Enter new move:");
//                    }
//                    san = sc.nextLine();
//                }
//                game.applyMove(game.parseMove(san));
//            }
//            board.display();
//            System.out.println("static eval White: " + p1.staticEvaluation(board));
//            System.out.println("static eval Black: " + p2.staticEvaluation(board));
//        }
//        try {
//            System.out.println(game.getGameResult().toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
