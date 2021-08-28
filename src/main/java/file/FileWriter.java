package file;

import java.awt.*;
import java.io.*;

public class FileWriter implements AutoCloseable {
    private final OutputStream out;

    public FileWriter(File file) throws FileNotFoundException {
        this.out = new FileOutputStream(file);
    }

    public void print(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            out.write(str.charAt(i));
        }
    }

    public void println(int x) throws IOException {
        print("" + x);
        nl();
    }

    public void println(double d) throws IOException {
        print("" + d);
        nl();
    }

    public void nl() throws IOException {
        out.write('\n');
    }


    public void println(String str) throws IOException {
        print(str);
        nl();
    }

    public void close() throws IOException {
        out.close();
    }
}