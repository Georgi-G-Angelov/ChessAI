package ChessUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.image.ImageObserver;
import java.awt.image.renderable.RenderableImage;
import java.io.File;
import java.io.IOException;

public class boardDrawingComponent extends JComponent {
    public void paintComponent (Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;

        Color boardWhite = new Color(255, 241, 215);
        Color boardBlack = new Color(117, 80, 16);

        graphics2D.setColor(boardWhite);
        graphics2D.fillRect(0, 0, 720, 750);

        graphics2D.setColor(Color.BLACK);
        graphics2D.drawRect(39, 39, 641, 641);

        Rectangle[][] board = new Rectangle[8][8];

        int x = 40, y = 40;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Rectangle(x, y, 80, 80);
                x = x + 80;
                if (i % 2 == j % 2) {
                    graphics2D.setColor(boardWhite);
                } else {
                    graphics2D.setColor(boardBlack);
                }
                graphics2D.fill(board[i][j]);
            }
            x = 40;
            y = y + 80;
        }


//        Ellipse2D.Double ellipse = new Ellipse2D.Double(100,100,50,50);
//        graphics2D.fill(ellipse);
//
//        Line2D.Double line = new Line2D.Double(150, 150, 100, 50);
//        graphics2D.draw(line);
//
//        Point2D.Double point1 = new Point2D.Double(200, 200);
//        Point2D.Double point2 = new Point2D.Double(500, 200);
//
//        Line2D.Double line2 = new Line2D.Double(point1, point2);
//        graphics2D.draw(line2);
//
//        graphics2D.setFont(new Font("serif", Font.BOLD + Font.ITALIC, 14));
//        graphics2D.drawString("String time", 400, 400);

        //Image image = Toolkit.getDefaultToolkit().getImage("black_pawn.png");
        //File file = new File("black_pawn.png");
        //System.out.println(file.getPath());

        //Print black pawns
        Image image = null;
        try {
            image = ImageIO.read(new File("images/black_pawn.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        x = 40 + 25;
        y = 120 + 15;
        for (int i = 0; i < 8; i++) {
            graphics2D.drawImage(image, x, y, 30, 50, this);
            x = x + 80;
        }

        //Print black queen
        try {
            image = ImageIO.read(new File("images/black_queen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        x = 280 + 25;
        y = 40 + 10;
        graphics2D.drawImage(image, x, y, 30, 60, this);

        //Print black king
        try {
            image = ImageIO.read(new File("images/black_king.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        x = 360 + 25;
        y = 40 + 10;
        graphics2D.drawImage(image, x, y, 30, 60, this);

        //Print black bishops
        try {
            image = ImageIO.read(new File("images/black_bishop.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        x = 440 + 25;
        y = 40 + 10;
        graphics2D.drawImage(image, x, y, 30, 60, this);

        x = 200 + 25;
        y = 40 + 10;
        graphics2D.drawImage(image, x, y, 30, 60, this);

        //Print black knights
        try {
            image = ImageIO.read(new File("images/black_knight.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        x = 520 + 25;
        y = 40 + 10;
        graphics2D.drawImage(image, x, y, 30, 60, this);

        x = 120 + 25;
        y = 40 + 10;
        graphics2D.drawImage(image, x, y, 30, 60, this);

        //Print black rooks
        try {
            image = ImageIO.read(new File("images/black_rook.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        x = 600 + 25;
        y = 40 + 10;
        graphics2D.drawImage(image, x, y, 30, 60, this);

        x = 40 + 25;
        y = 40 + 10;
        graphics2D.drawImage(image, x, y, 30, 60, this);

        //------------------------------------------------------------------//
        //Print black pawns
        try {
            image = ImageIO.read(new File("images/white_pawn.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        x = 40 + 25;
        y = 520 + 15;
        for (int i = 0; i < 8; i++) {
            graphics2D.drawImage(image, x, y, 30, 50, this);
            x = x + 80;
        }

        //Print white queen
        try {
            image = ImageIO.read(new File("images/white_queen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        x = 280 + 25;
        y = 600 + 10;
        graphics2D.drawImage(image, x, y, 30, 60, this);

        //Print white king
        try {
            image = ImageIO.read(new File("images/white_king.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        x = 360 + 25;
        y = 600 + 10;
        graphics2D.drawImage(image, x, y, 30, 60, this);

        //Print white bishops
        try {
            image = ImageIO.read(new File("images/white_bishop.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        x = 440 + 25;
        y = 600 + 10;
        graphics2D.drawImage(image, x, y, 30, 60, this);

        x = 200 + 25;
        y = 600 + 10;
        graphics2D.drawImage(image, x, y, 30, 60, this);

        //Print white knights
        try {
            image = ImageIO.read(new File("images/white_knight.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        x = 520 + 25;
        y = 600 + 10;
        graphics2D.drawImage(image, x, y, 30, 60, this);

        x = 120 + 25;
        y = 600 + 10;
        graphics2D.drawImage(image, x, y, 30, 60, this);

        //Print white rooks
        try {
            image = ImageIO.read(new File("images/white_rook.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        x = 600 + 25;
        y = 600 + 10;
        graphics2D.drawImage(image, x, y, 30, 60, this);

        x = 40 + 25;
        y = 600 + 10;
        graphics2D.drawImage(image, x, y, 30, 60, this);

        //Print files and ranks
        graphics2D.setColor(Color.BLACK);
        graphics2D.setFont(new Font("serif", Font.BOLD, 24));

        for (int i = 0; i < 8; i++) {
            graphics2D.drawString((char)('A' + i) + "", (i + 1) * 80 - 10, 30);
            graphics2D.drawString((char)('A' + i) + "", (i + 1) * 80 - 10, 705);
            graphics2D.drawString((8-i) + "", 10, (i+1) * 80 + 10);
            graphics2D.drawString((8-i) + "", 690, (i+1) * 80 + 10);

        }


    }
}
