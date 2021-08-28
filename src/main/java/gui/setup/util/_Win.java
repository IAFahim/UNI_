package gui.setup.util;

import file.json.Json;

import java.io.File;
import java.util.LinkedHashMap;

import static file.util.Cast.asBool;
import static file.util.Cast.asInt;

public final class _Win {
    private static int height;
    private static int width;
    private static String title;
    private static boolean isFullScreen;
    private static final LinkedHashMap<String, Object> map = new LinkedHashMap<>();
    private static String font="Segoe UI";

    private static File file;
    private static boolean shouldSave=false;

    public static void set(String title, int width, int height, boolean isFullScreen) {
        _Win.title = title;
        _Win.width = width;
        _Win.height = height;
        _Win.isFullScreen=isFullScreen;

        map.put("title", title);
        map.put("width", width);
        map.put("height", height);
        map.put("isFullScreen", isFullScreen);
    }

    public static void setSafe() {
        title = "SafeMode";
        width = 640;
        height = 480;
    }

    public static boolean load() {
        boolean exists=Json.jsonFileToMap(map, file);
        if(exists){
            _Win.title= (String)map.get("title");
            _Win.width= asInt(map.get("width"));
            _Win.height= asInt(map.get("height"));
            _Win.isFullScreen= asBool(map.get("isFullScreen"));
        }
        return exists;

    }

    public static boolean load(File file) {
        _Win.file = file;
        return load();
    }

    public static void save(File file) {
        Json.mapToJsonFile(map, file);
    }

    public static void save() {
        Json.mapToJsonFile(map, file);
    }


    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        _Win.height = height;
        put("height", height);
    }

    private static void put(String key, Object value) {
        Object v = map.get(key);
        shouldSave |= v != null && !v.equals(value);
        if (shouldSave) {
            map.put(key, height);
        }
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

    public static boolean isFullScreen() {
        return isFullScreen;
    }

    public static void setFullScreen(boolean fullScreen) {
        isFullScreen = fullScreen;
        put("isFullScreen", isFullScreen);
    }

    public static String getFont() {
        return font;
    }

    private static void setFont(String font) {
        _Win.font = font;
    }

    public static void setFile(File file) {
        _Win.file = file;
    }
}
