package gui.core.util;

import gui.main.util._Win;

import java.awt.*;

public abstract class GData {
    protected int x, y, width, height;
    protected Color color = null;

    public void init(double x, double y, double width, double height) {
        this.x=scaleX(x);
        this.y=scaleY(y);
        this.width=scaleX(width);
        this.height=scaleY(height);
    }

    protected int scaleX(double x) {
        if (x != 0) {
            return (int) ((_Win.getWidth() * (x / 1920)));
        }
        return 0;
    }

    public static int scaleY(double y) {
        if (y != 0) {
            return (int) ((_Win.getHeight() * (y / 1080)));
        }
        return 0;
    }
}