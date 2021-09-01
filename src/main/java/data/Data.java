package data;

import java.io.*;
import java.util.Properties;

public final class Data {
    private BufferedWriter out;
    public static void save(Properties properties, File file){
        try (OutputStream outputStream=new FileOutputStream(file)) {
            properties.store(outputStream,"UNI_"+System.currentTimeMillis());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void load(Properties properties, File file) {
        try (InputStream outputStream=new FileInputStream(file)) {
            properties.load(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
