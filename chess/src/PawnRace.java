import game.Board;
import game.Color;
import game.Game;
import game.Player;

import java.util.Scanner;

public class PawnRace {
    public static void main(String[] args) {


        Board board = new Board();
        Game game = new Game(board);
        Player p1 = new Player(game, board, Color.WHITE, true);
        Player p2 = new Player(game, board, Color.BLACK, true);
        p1.setOpponent(p2);
        p2.setOpponent(p1);
        board.display();

        Scanner sc = new Scanner(System.in);

        while(!game.isFinished()) {

            //p1.getAllPawns().forEach(pawn -> System.out.println(p1.isPassedPawn(pawn) + " " + pawn.getFile() + pawn.getRank()));

            if (p1.isComputerPlayer()) {
                //p1.makeMove1();
                p1.makeSmartMove();
                //p1.makeSmartMove1();
            } else {
                System.out.println("game.Player one enter a move: ");
                String san = sc.nextLine();
                while(game.parseMove(san) == null) {
                    // undo
                    if (san.equals("undo")) {
                        game.unapplyMove();
                        game.unapplyMove();
                        board.display();
                        System.out.println("game.Player one enter a move: ");
                    } else {
                        System.out.println("Invalid move. Enter new move:");
                    }
                    san = sc.nextLine();
                }
                game.applyMove(game.parseMove(san));
            }
            board.display();
            //System.out.println("static eval White: " + p1.staticEvaluation(board));
            //System.out.println("static eval Black: " + p2.staticEvaluation(board));
            if (game.isFinished()) {
                break;
            }
            //board.display();
            //p2.getAllValidMoves().forEach(move -> System.out.print(move.getSAN() + " "));
            System.out.println();
            if (p2.isComputerPlayer()) {
                //p2.makeMove1();
                p2.makeSmartMove();
                //p2.makeSmartMove();
            } else {
                System.out.println("game.Player two enter a move: ");
                String san = sc.nextLine();
                while(game.parseMove(san) == null) {
                    if (san.equals("undo")) {
                        game.unapplyMove();
                        game.unapplyMove();
                        board.display();
                        System.out.println("game.Player one enter a move: ");
                    } else {
                        System.out.println("Invalid move. Enter new move:");
                    }
                    san = sc.nextLine();
                }
                game.applyMove(game.parseMove(san));
            }
            board.display();
            System.out.println("static eval White: " + p1.staticEvaluation(board));
            System.out.println("static eval Black: " + p2.staticEvaluation(board));
        }
        try {
            System.out.println(game.getGameResult().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
