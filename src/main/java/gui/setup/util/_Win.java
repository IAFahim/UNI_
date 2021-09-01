package gui.setup.util;

import data.Data;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Properties;


public final class _Win {
    private static int bound;

    private static String title;
    private static boolean isFullScreen;
    private static String font = "Segoe UI";
    private final static File file = new File("src/main/java/data/db/win.dat");
    private static boolean shouldSave = false;
    private static final Properties properties = new Properties();
    private static int x, y, height, width;

    public static boolean load() {
        boolean exist = file.exists();
        if (!exist) {
            return exist;
        }
        Data.load(properties,file);
        _Win.title = (String) properties.get("title");
        _Win.x = Integer.parseInt((String) properties.get("x"));
        _Win.y = Integer.parseInt((String)properties.get("y"));
        _Win.width = Integer.parseInt((String)properties.get("width"));
        _Win.height = Integer.parseInt((String)properties.get("height"));
        _Win.isFullScreen = Boolean.parseBoolean((String)properties.get("isFullScreen"));
        return exist;
    }


    public static void save() {
        Data.save(properties, file);
    }


    public static String getTitle() {
        return title;
    }

    public static void setTitle(String title) {
        put("title", _Win.title = title);
    }


    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }


    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }

    public static void setRectangle(int x, int y, int width, int height) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        if(shouldSave){
            save();
        }
        shouldSave=false;
    }

    public static void setWidth(int width) {
        put("width", String.valueOf(_Win.width = width));
    }

    public static void setHeight(int height) {
        put("height", String.valueOf(_Win.height = height));
    }


    public static void setX(int x) {
        put("x", String.valueOf(_Win.x = x));
    }

    public static void setY(int y) {
        put("y", String.valueOf(_Win.y = y));
    }

    public static boolean isIsFullScreen() {
        return isFullScreen;
    }

    public static void setIsFullScreen(boolean isFullScreen) {
        put("isFullScreen", String.valueOf(_Win.isFullScreen = isFullScreen));
    }

    public static File getFile() {
        return file;
    }

    public static String getFont() {
        return font;
    }

    public static void setFont(String font) {
        put("font", _Win.font = font);
    }


    public static int getBound() {
        return bound;
    }

    public static void setBound(int bound) {
        _Win.bound = bound;
    }

    public static boolean isShouldSave() {
        return shouldSave;
    }

    public static void setShouldSave(boolean shouldSave) {
        _Win.shouldSave = shouldSave;
    }

    private static void put(String key, Object value) {
        Object v = properties.get(key);
        shouldSave |= ((v != null) && !v.equals(value));
        properties.put(key, value);
    }
}
