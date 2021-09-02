package gui.setup.util;

import data.Json;
import org.json.simple.JSONObject;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;


public final class _Win {
    private static int bound;

    private static String title;
    private static boolean isFullScreen;
    private static String font = "Segoe UI";
    private final static File file = new File("src/main/java/data/db/win.json");
    private static boolean shouldSave = false;
    private static final JSONObject map = new JSONObject(new LinkedHashMap<>());
    private static int x, y, height, width;

    public static boolean load() {
        if(!Json.load(file, map)){
            return false;
        }
        _Win.title = (String) map.get("title");
        _Win.x = (int)(long) map.get("x");
        _Win.y = (int)(long) map.get("y");
        _Win.width = (int)(long) map.get("width");
        _Win.height = (int)(long) map.get("height");
        _Win.isFullScreen = (boolean)map.get("isFullScreen");
        return true;
    }


    public static boolean save() {
        return Json.save(map, file);
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
        put("width", _Win.width = width);
    }

    public static void setHeight(int height) {
        put("height", _Win.height = height);
    }


    public static void setX(int x) {
        put("x", _Win.x = x);
    }

    public static void setY(int y) {
        put("y", _Win.y = y);
    }

    public static boolean isIsFullScreen() {
        return isFullScreen;
    }

    public static void setIsFullScreen(boolean isFullScreen) {
        put("isFullScreen", _Win.isFullScreen = isFullScreen);
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
        Object v=map.get(key);
        shouldSave |= ((v != null) && !v.equals(value));
        map.put(key, value);
    }
}
