package gui.core.util;

import gui.setup.util._Win;

import java.awt.*;

public abstract class GData {
    protected int x, y, width, height;
    protected Color color = null;
    static double xFix=1920;
    static double yFix=1080;

    public void init(double x, double y, double width, double height) {
        this.x=scaleX(x);
        this.y=scaleY(y);
        this.width=scaleX(width);
        this.height=scaleY(height);
    }

    protected int scaleX(double x) {
        if (x != 0) {
            return (int) ((_Win.getWidth() * (x / xFix)));
        }
        return 0;
    }

    public static int scaleY(double y) {
        if (y != 0) {
            return (int) ((_Win.getHeight() * (y / yFix)));
        }
        return 0;
    }
}