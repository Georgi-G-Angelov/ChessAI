package ChessUI;

import game.*;
import pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseComponent extends JComponent implements MouseListener {
    private JFrame window;
    private Game game;
    private Board board;
    private Player p1;
    private Player p2;
    private BoardDrawingComponent drawer;
    private int x = 0;
    private int y = 0;

    MouseComponent(JFrame window, Game game, Board board, Player p1, Player p2, BoardDrawingComponent drawer) {
        this.window = window;
        this.game = game;
        this.board = board;
        this.p1 = p1;
        this.p2 = p2;
        this.drawer = drawer;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        x = mouseEvent.getX();
        y = mouseEvent.getY() - this.window.getInsets().top;
        System.out.println(mouseEvent.getX() + " " + (mouseEvent.getY() - this.window.getInsets().top));
        if (x > 39 && x < 681 && y > 39 && y < 681) { // click is inside the boundaries of the board
            char file = (char) ('a' + ((x - 40) / 80));
            int rank = 8 - ((y - 40) / 80);
            System.out.println(file + "" + rank);
            Piece piece = board.getSquare(file, rank).getPiece();
            if (piece != null) {
                if (piece.getColor() == game.getCurrentPlayer().getColor()) {
                    for (Move move : piece.getAllValidMoves()) {
                        Square square = move.getTo();
                        int x = 40 + square.getX() * 80;
                        int y = 40 + square.getY() * 80;
                        Rectangle rectangle = new Rectangle(x, y, 80 ,80);
                        drawer.paintRectangle(rectangle);
                    }
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
