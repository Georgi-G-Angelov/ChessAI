package ChessUI;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class PieceImage extends Image {
    private int rank;
    private char file;
    private String path;
    private int width;
    private int height;

    PieceImage (int rank, char file, String path, int width, int height) {
        this.rank = rank;
        this.file = file;
        this.path = path;
        this.width = width;
        this.height = height;
    }

    @Override
    public int getWidth(ImageObserver imageObserver) {
        return getWidth(imageObserver);
    }

    @Override
    public int getHeight(ImageObserver imageObserver) {
        return getHeight(imageObserver);
    }

    @Override
    public ImageProducer getSource() {
        return getSource();
    }

    @Override
    public Graphics getGraphics() {
        return getGraphics();
    }

    @Override
    public Object getProperty(String s, ImageObserver imageObserver) {
        return getProperty(s, imageObserver);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public char getFile() {
        return file;
    }

    public void setFile(char file) {
        this.file = file;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
