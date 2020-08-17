package ChessUI;
import game.Board;
import game.Color;
import game.Game;
import game.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Chess {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(720, 750);
        window.setTitle("Chess");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        window.setMinimumSize(new Dimension(720, 749));
        window.setMaximumSize(new Dimension(721, 751));

        window.revalidate();

        Image image = null;
        try {
            image = ImageIO.read(new File("images/chess_board.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        window.setIconImage(image);
        window.setResizable(false);

        BoardDrawingComponent chessBoard = new BoardDrawingComponent();

        addAllPieces(chessBoard);

        window.add(chessBoard);
        window.setVisible(true);
        window.revalidate();


//
//        Scanner sc = new Scanner(System.in);
//        char n = sc.next().charAt(0);
//        ArrayList<PieceImage> pieces = chessBoard.getPieces();
//        for (int i = 0; i < pieces.size(); i++) {
//            if (pieces.get(i).getFile() == n) {
//                pieces.get(i).setRank(pieces.get(i).getRank() + 1);
//            }
//        }
//
//        chessBoard.repaint();

        Board board = new Board();
        Game game = new Game(board);
        Player p1 = new Player(game, board, Color.WHITE, true);
        Player p2 = new Player(game, board, Color.BLACK, true);
        game.setCurrentPlayer(p1);
        p1.setOpponent(p2);
        p2.setOpponent(p1);
        board.display();

        MouseComponent mouse = new MouseComponent(window, game, board, p1, p2, chessBoard);
        window.addMouseListener(mouse);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



//        while (!game.isFinished()) {
//            //p1.takeMove();
//
//            game.setCurrentPlayer(p2);
//            chessBoard.setPieces(game);
//            chessBoard.repaint();
//            board.display();
//            System.out.println("White eval : " + p1.staticEvaluation(board));
//            System.out.println("Black eval : " + p2.staticEvaluation(board));
//            if (game.isFinished()) {
//                break;
//            }
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            p2.takeMove();
//            game.setCurrentPlayer(p1);
//            chessBoard.setPieces(game);
//            chessBoard.repaint();
//            board.display();
//            System.out.println("White eval : " + p1.staticEvaluation(board));
//            System.out.println("Black eval : " + p2.staticEvaluation(board));
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

    }

    private static void addAllPieces(BoardDrawingComponent chessBoard) {
        //add pawns
        for (char i = 'A'; i <= 'H'; i++) {
            chessBoard.addPiece(new PieceImage(2, i, "images/white_pawn.png", 30, 50));
            chessBoard.addPiece(new PieceImage(7, i, "images/black_pawn.png", 30, 50));
        }

        //add rooks
        chessBoard.addPiece(new PieceImage(1, 'A', "images/white_rook.png", 30, 60));
        chessBoard.addPiece(new PieceImage(1, 'H', "images/white_rook.png", 30, 60));
        chessBoard.addPiece(new PieceImage(8, 'A', "images/black_rook.png", 30, 60));
        chessBoard.addPiece(new PieceImage(8, 'H', "images/black_rook.png", 30, 60));

        //add knights
        chessBoard.addPiece(new PieceImage(1, 'B', "images/white_knight.png", 30, 60));
        chessBoard.addPiece(new PieceImage(1, 'G', "images/white_knight.png", 30, 60));
        chessBoard.addPiece(new PieceImage(8, 'B', "images/black_knight.png", 30, 60));
        chessBoard.addPiece(new PieceImage(8, 'G', "images/black_knight.png", 30, 60));

        //add bishops
        chessBoard.addPiece(new PieceImage(1, 'C', "images/white_bishop.png", 30, 60));
        chessBoard.addPiece(new PieceImage(1, 'F', "images/white_bishop.png", 30, 60));
        chessBoard.addPiece(new PieceImage(8, 'C', "images/black_bishop.png", 30, 60));
        chessBoard.addPiece(new PieceImage(8, 'F', "images/black_bishop.png", 30, 60));

        //add queens
        chessBoard.addPiece(new PieceImage(1, 'D', "images/white_queen.png", 30, 60));
        chessBoard.addPiece(new PieceImage(8, 'D', "images/black_queen.png", 30, 60));

        //add kings
        chessBoard.addPiece(new PieceImage(1, 'E', "images/white_king.png", 30, 60));
        chessBoard.addPiece(new PieceImage(8, 'E', "images/black_king.png", 30, 60));

    }

    private void takeMove(Player player) {
        boolean isSelectingPiece = true;
        boolean isSelectingMove = false;

        while (true) {

        }
    }
}
