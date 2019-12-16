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

        boardDrawingComponent component = new boardDrawingComponent();
        window.add(component);

        window.setVisible(true);

        //window.revalidate();
    }
}
