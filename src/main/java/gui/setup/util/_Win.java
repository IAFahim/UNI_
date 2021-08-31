package gui.setup.util;

import file.json.Json;

import java.io.File;
import java.util.LinkedHashMap;


public final class _Win {
    private static int height;
    private static int width;



    private static int bound;

    private static String title;
    private static boolean isFullScreen;
    private static final LinkedHashMap<String, Object> map = new LinkedHashMap<>();
    private static String font = "Segoe UI";


    private static File file;
    private static boolean shouldSave = false;

    private static void getFromMap() {
        _Win.title = (String) map.get("title");
        _Win.width = (int) map.get("width");
        _Win.height = (int) map.get("height");
        _Win.isFullScreen = (boolean) map.get("isFullScreen");
    }

    public static boolean load() {
        boolean exists = Json.loadJson(file, map);
        if (exists) {
            getFromMap();
        }
        return exists;
    }

    public static boolean load(File file) {
        _Win.file = file;
        return load();
    }

    public static void save(File file) {
        Json.saveJson(map, file);
    }

    public static void save() {
        Json.saveJson(map, file);
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        _Win.height = height;
        put("height", height);
    }

    public static int getWidth() {
        return width;
    }

    public static void setWidth(int width) {
        _Win.width = width;
        put("width", width);
    }

    public static String getTitle() {
        return title;
    }

    public static void setTitle(String title) {
        _Win.title = title;
        put("title", title);
    }

    public static boolean isIsFullScreen() {
        return isFullScreen;
    }

    public static void setIsFullScreen(boolean isFullScreen) {
        _Win.isFullScreen = isFullScreen;
        put("isFullScreen", isFullScreen);
    }

    public static File getFile() {
        return file;
    }

    public static String getFont() {
        return font;
    }

    public static void setFont(String font) {
        _Win.font = font;
        put("font",font);
    }

    public static void setFile(File file) {
        _Win.file = file;
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
        Object v = map.get(key);
        shouldSave |= ((v != null) && !v.equals(value));
        map.put(key, value);
    }

    public static void setSafe() {
        title = "SafeMode";
        width = 640;
        height = 480;
    }
}
