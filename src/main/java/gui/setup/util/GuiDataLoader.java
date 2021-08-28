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

    public void firstLoad(File file){
        Dimension dimension;
        dimension = getScreenWindowSize();
        _Win.set("Anonymous", (int) dimension.getWidth(), (int) dimension.getHeight(),true);
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
        for (GraphicsDevice graphicsDevice : graphicsDevices) {
            if (d.width < graphicsDevice.getDisplayMode().getWidth()) {
                d.width = graphicsDevice.getDisplayMode().getWidth();
                d.height = graphicsDevice.getDisplayMode().getHeight();
            }
        }
        return d;
    }
}
