import game.Board;
import game.Color;
import game.Game;
import game.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
/*
        // Bugs all over the place
        // TO FIX
//        System.out.println("Az");
//
//        game.Square square = new game.Square(6,5);
//        System.out.println(square.getFile() + square.getRank());
//
//        game.Board board = new game.Board();
//        board.display();
//        square = board.getSquare(6,5);
//        square.setOccupier(game.Color.BLACK);
//        System.out.println(square.getFile() + square.getRank());
//        square = board.getSquare(0,0);
//        square.setOccupier(game.Color.WHITE);
//        System.out.println(square.getFile() + square.getRank());
//        square = new game.Square(0,0);
//        System.out.println(square.getFile() + square.getRank());
//        board.display();
//
//        game.Square a3 = board.getSquare(0,5);
//        game.Square c7 = board.getSquare(2, 1);
//        game.Move move = new game.Move(a3, c7, true,false);
//        System.out.println(move.getSAN());

        game.Board board = new game.Board('a', 'h');
        board.display();
        game.Square from = board.getSquare(1, 6);
        game.Square to = board.getSquare(1, 5);
        game.Move move = new game.Move(from, to, false, false);
        board.applyMove(move);
        System.out.println(move.getSAN());
        board.display();
        from = board.getSquare(1, 5);
        to = board.getSquare(1, 4);
        move = new game.Move(from, to, false, false);
        board.applyMove(move);
        System.out.println(move.getSAN());
        board.display();
        from = board.getSquare(1, 4);
        to = board.getSquare(1, 3);
        move = new game.Move(from, to, false, false);
        board.applyMove(move);
        System.out.println(move.getSAN());
        board.display();
        from = board.getSquare(1, 3);
        to = board.getSquare(1, 2);
        move = new game.Move(from, to, false, false);
        board.applyMove(move);
        System.out.println(move.getSAN());
        board.display();
        from = board.getSquare(2, 1);
        to = board.getSquare(1, 2);
        move = new game.Move(from, to, true, false);
        board.applyMove(move);
        System.out.println(move.getSAN());
        board.display();

//        from = board.getSquare(2,1);
//        to = board.getSquare(2, 2);
//        move = new game.Move(from, to, false, false);
//        board.applyMove(move);
//        board.display();
//        from = board.getSquare(1,3);
//        to = board.getSquare(2, 2);
//        move = new game.Move(from, to, true, false);
//        board.applyMove(move);
//        board.display();
//        board.unapplyMove(move);
//        board.display();
//        from = board.getSquare(2,2);
//        to = board.getSquare(1,3);
//        move = new game.Move(from, to, true, false);
//        board.applyMove(move);
//        board.display();
//        board.unapplyMove(move);
//        board.display();
        //board.unapplyMove(move);
        //board.unapplyLast();
        board.unapplyLast();
        board.display();
        board.unapplyLast();
        board.display();
        board.unapplyLast();
        board.display();
        board.unapplyLast();
        board.display();
        board.unapplyLast();
        board.display();
        board.unapplyLast();
        System.out.println(board.getSquare(8, 8));
        move = new game.Move(board.getSquare(7, 6), board.getSquare(0, 6), false, false);
        board.applyMove(move);
        board.display();
        for (int i = 0; i < 7; i++) {
            move = new game.Move(board.getSquare(i, 1), board.getSquare(i, 3), false, false);
            board.applyMove(move);
            move = new game.Move(board.getSquare(i, 6), board.getSquare(i, 4), false, false);
            board.applyMove(move);
        }
        for (int i = 1; i < 7; i += 2) {
            move = new game.Move(board.getSquare(i, 3), board.getSquare(i, 1), false, false);
            board.applyMove(move);
            move = new game.Move(board.getSquare(i, 4), board.getSquare(i, 2), false, false);
            board.applyMove(move);
        }
        board.display();
        System.out.println(board.isStalemate(game.Color.WHITE));
        move = new game.Move(board.getSquare(0,4 ), board.getSquare(1,4), false, false);
        board.applyMove(move);
        move = new game.Move(board.getSquare(2,4 ), board.getSquare(3,4), false, false);
        board.applyMove(move);
        board.display();
        game.Game game = new game.Game(board);
        if (game.parseMove("bxa5") != null) {
            System.out.println(game.parseMove("bxa5"));
            game.applyMove(game.parseMove("bxa5"));
        } else {
            System.out.println("null");
        }
        System.out.println(game.getCurrentPlayer());
        board.display();
        if (game.parseMove("exd4") != null) {
            System.out.println(game.parseMove("exd4"));
            game.applyMove(game.parseMove("exd4"));
        } else {
            System.out.println("null");
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("");
        }
        game.Board board1 = new game.Board('a', 'h');
        board1.display();
        game.Game game1 = new game.Game(board1);
        game1.applyMove(game1.parseMove("d4"));
        game1.applyMove(game1.parseMove("a5"));
        game1.applyMove(game1.parseMove("d5"));
        game1.applyMove(game1.parseMove("e5"));
        game1.applyMove(game1.parseMove("e6"));
        board1.display();
        */


        Board board = new Board();
        Game game = new Game(board);
        Player p1 = new Player(game, board, Color.WHITE, false);
        Player p2 = new Player(game, board, Color.BLACK, false);
        board.display();

        Scanner sc = new Scanner(System.in);
        System.out.println(p1.staticEvaluation(board));
        game.applyMove(game.parseMove("d4"));
        System.out.println(p1.staticEvaluation(board));
    }
}
