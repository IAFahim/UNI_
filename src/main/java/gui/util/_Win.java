package gui.util;

import data.Json;
import org.json.simple.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.io.File;


public final class _Win {
    private static int bound;

    private static String title;
    private static boolean isFullScreen;
    private static String font = "Segoe UI";
    private final static File file = new File("src/main/java/data/db/win.json");
    private static boolean shouldSave = false;
    private static JSONObject map;
    private static int x, y, height, width, deviceToShow = 0;

    public static Font extraSmallFont = new Font(font, Font.PLAIN, 13);
    public static Font smallFont = new Font(font, Font.PLAIN, 15);
    public static Font mediumFont = new Font(font, Font.PLAIN, 20);
    public static Font largeFont = new Font(font, Font.PLAIN, 22);
    public static int gapBetweenSmallLabel=5;

    public static Color selected_color_for_label = new Color(84,84,84);
    public static Color unSelected_color_for_label = new Color(152, 152, 152);
    public static Color light_mode_color_panel_backGround = new Color(245, 245, 245);
    public static Color light_mode_color_frame_backGround = new Color(228, 228, 228);
    public static Color selected_color_for_button = new Color(224, 240, 250);
    public static Color red_selected_color_for_button = new Color(254, 111, 97);

    public _Win() {
        map = new JSONObject();
        if (!load()) {
            firstLoad();
        }
    }

    public static GraphicsDevice graphicsDevicess;

    public static Dimension minimumSize;

    public static boolean load() {
        if (!Json.load(file, map)) {
            return false;
        }
        try {
            _Win.title = (String) map.get("title");
            _Win.x = (int) (long) map.get("x");
            _Win.y = (int) (long) map.get("y");
            _Win.width = (int) (long) map.get("width");
            _Win.height = (int) (long) map.get("height");
            _Win.isFullScreen = (boolean) map.get("isFullScreen");
            _Win.deviceToShow = (int) (long) map.get("deviceToShow");
        } catch (Exception e) {
            firstLoad();
            e.printStackTrace();
        }
        return true;
    }

    public static void firstLoad() {
        Dimension dimension;
        dimension = getScreenWindowSize();
        _Win.setTitle("Anonymous");
        _Win.setRectangle(dimension.width / 2, dimension.height / 2, dimension.width, dimension.height);
        _Win.setIsFullScreen(true);
        _Win.setFont("Segoe UI");
        _Win.setGraphicsDevice();
        save();
    }

    public static Dimension getScreenWindowSize() {
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] graphicsDevices = graphicsEnvironment.getScreenDevices();
        Dimension d = new Dimension();
        Taskbar taskbar = Taskbar.getTaskbar();
        System.out.println(taskbar);
        int x = 0;
        for (GraphicsDevice graphicsDevice : graphicsDevices) {
            Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(graphicsDevice.getConfigurations()[0]);
            if (d.width < graphicsDevice.getDisplayMode().getWidth()) {
                d.width = graphicsDevice.getDisplayMode().getWidth() - (insets.left + insets.right);
                d.height = graphicsDevice.getDisplayMode().getHeight() - (insets.top + insets.bottom);
                deviceToShow = x;
                graphicsDevicess = graphicsDevice;
            }
            x++;
        }

        return d;
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

    public static void setGraphicsDevice() {
        put("deviceToShow", deviceToShow);
    }

    public static GraphicsDevice getGraphicsDevice() {
        return GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[deviceToShow];
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
        if (shouldSave) {
            save();
        }
        shouldSave = false;
    }

    public static void checkToSave(JFrame jFrame) {
        new Thread(() -> {
            int t=0;
            while (true) {
                try {
                    if(t==0){
                        t++;
                        Thread.sleep(10000);
                    }
                    Dimension size = jFrame.getSize();
                    Point loc = jFrame.getLocation();
                    if ( Math.abs(loc.x - x) > 10 || Math.abs(loc.x - y) > 10) {
                        if(-9<loc.x && loc.x<0){
                            loc.x=0;
                            loc.y=0;
                        }else {
                            setX(loc.x);
                            setY(loc.y);
                        }
                        setWidth(size.width-16);
                        setHeight(size.height-8);
                        setIsFullScreen(jFrame.getExtendedState()==6);
                        if(shouldSave){
                            save();
                        }
                        shouldSave=false;
                    }
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
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
        Object v = map.get(key);
        shouldSave |= ((v != null) && !v.equals(value));
        map.put(key, value);
    }

//
//    static double xFix=1920;
//    static double yFix=1080;
//
//    public static Dimension init(double width, double height) {
//        return new Dimension(scaleX(width),scaleY(height));
//    }


//    public static int scaleX(double x) {
//        if (x != 0) {
//            return (int) ((_Win.width * (x / xFix)));
//        }
//        return 0;
//    }
//
//    public static int scaleY(double y) {
//        if (y != 0) {
//            return (int) ((_Win.height * (y / yFix)));
//        }
//        return 0;
//    }

    public static Dimension getMinimumSize() {
        if (minimumSize == null) {
            minimumSize = new Dimension(640, 520);
        }
        return minimumSize;

    }


}
