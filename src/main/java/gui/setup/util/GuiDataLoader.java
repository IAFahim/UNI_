package gui.setup.util;


import java.awt.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class GuiDataLoader {

    public GuiDataLoader() {
        File file = new File("src/main/java/data/db/guiData.json");
        if (!_Win.load(file)) {
            firstLoad(file);
        }
    }

    public void firstLoad(File file) {
        Dimension dimension;
        dimension = getScreenWindowSize();
        _Win.setTitle("Anonymous");
        _Win.setWidth((int) dimension.getWidth());
        _Win.setHeight((int) dimension.getHeight());
        _Win.setIsFullScreen(true);
        _Win.setFont("Segoe UI");
        _Win.save(file);
    }

    public File getFile(String spec) {
        File file = null;
        try {
            URL url = new URL(spec);
            file = new File(url.getFile());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return file;
    }

    public Dimension getScreenWindowSize() {
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] graphicsDevices = graphicsEnvironment.getScreenDevices();
        Dimension d = new Dimension();
        Taskbar taskbar=Taskbar.getTaskbar();
        System.out.println(taskbar);
        for (GraphicsDevice graphicsDevice : graphicsDevices) {
            Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(graphicsDevice.getConfigurations()[0]);
            if (d.width < graphicsDevice.getDisplayMode().getWidth()) {
                d.width = graphicsDevice.getDisplayMode().getWidth() - (insets.left + insets.right);
                d.height = graphicsDevice.getDisplayMode().getHeight() - (insets.top + insets.bottom);
            }
        }

        return d;
    }
}
