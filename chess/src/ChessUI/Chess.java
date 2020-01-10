package ChessUI;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
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

        BoardDrawingComponent component = new BoardDrawingComponent();

        addAllPieces(component);

        window.add(component);

        window.setVisible(true);

        window.revalidate();
    }

    private static void addAllPieces(BoardDrawingComponent component) {
        //add pawns
        for (char i = 'A'; i <= 'H'; i++) {
            component.addPiece(new PieceImage(2, i, "images/white_pawn.png", 30, 50));
            component.addPiece(new PieceImage(7, i, "images/black_pawn.png", 30, 50));
        }

        //add rooks
        component.addPiece(new PieceImage(1, 'A', "images/white_rook.png", 30, 60));
        component.addPiece(new PieceImage(1, 'H', "images/white_rook.png", 30, 60));
        component.addPiece(new PieceImage(8, 'A', "images/black_rook.png", 30, 60));
        component.addPiece(new PieceImage(8, 'H', "images/black_rook.png", 30, 60));

        //add knights
        component.addPiece(new PieceImage(1, 'B', "images/white_knight.png", 30, 60));
        component.addPiece(new PieceImage(1, 'G', "images/white_knight.png", 30, 60));
        component.addPiece(new PieceImage(8, 'B', "images/black_knight.png", 30, 60));
        component.addPiece(new PieceImage(8, 'G', "images/black_knight.png", 30, 60));

        //add bishops
        component.addPiece(new PieceImage(1, 'C', "images/white_bishop.png", 30, 60));
        component.addPiece(new PieceImage(1, 'F', "images/white_bishop.png", 30, 60));
        component.addPiece(new PieceImage(8, 'C', "images/black_bishop.png", 30, 60));
        component.addPiece(new PieceImage(8, 'F', "images/black_bishop.png", 30, 60));

        //add queens
        component.addPiece(new PieceImage(1, 'D', "images/white_queen.png", 30, 60));
        component.addPiece(new PieceImage(8, 'D', "images/black_queen.png", 30, 60));

        //add kings
        component.addPiece(new PieceImage(1, 'E', "images/white_king.png", 30, 60));
        component.addPiece(new PieceImage(8, 'E', "images/black_king.png", 30, 60));

    }
}
