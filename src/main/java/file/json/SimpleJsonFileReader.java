package file.json;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SimpleJsonFileReader implements AutoCloseable {
    final private int BUFFER_SIZE = 1 << 16;
    private final DataInputStream din;
    private final byte[] buffer;
    private int bufferPointer, bytesRead;
    public boolean hasNext;
    protected long size = 0;
    private ArrayList<String> arrayList;
    private boolean isInt;

    public SimpleJsonFileReader(File file) throws IOException {
        size = file.length();
        hasNext = size > 2;
        din = new DataInputStream(new FileInputStream(file.getPath()));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public String readLine() throws IOException {
        byte[] buf = new byte[512];
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n')
                break;
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt);
    }

    public Object nextObject() throws IOException {
        StringBuilder sb = next();
        int n = sb.length();

        boolean isNull = n < 1;
        if (isNull) {
            return null;
        }

        int c = sb.charAt(0);
        boolean isString = false;
        isString = (c == '"');
        if (isString) {
            return sb.substring(1, n - 1);
        }

        boolean isBoolean = (c == 't' || c == 'f');
        if (isBoolean) {
            return c == 't';
        }

        boolean isArray = (c == '[');
        if (isArray) {
            arrayList = new ArrayList<String>();
            arrayList.add(sb.substring(2, n - 1));
            StringBuilder get = next();
            while (get.charAt(get.length() - 1) != ']') {
                arrayList.add(get.substring(1, get.length() - 1));
                get = next();
            }
            arrayList.add(get.substring(1, get.length() - 2));
            return arrayList;
        }

        double x = nextDouble(sb);
        if (isInt) {
            isInt = false;
            if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
                return (long) x;
            } else {
                return (int) x;
            }
        }

        return x;
    }

    private StringBuilder next() throws IOException {
        int n = read();
        StringBuilder sb = new StringBuilder();
        while (isWhiteSpace(n)) {
            n = read();
        }
        while (!isWhiteSpace(n)) {
            sb.append((char) n);
            n = read();
        }
        hasNext = (size > 2);
        return sb;
    }

    public String nextString() throws IOException {
        int n = read();
        StringBuilder sb = new StringBuilder();
        while (isWhiteSpace(n)) {
            n = read();
        }
        while (!isWhiteSpace(n)) {
            sb.append((char) n);
            n = read();
        }
        hasNext = (size > 1);
        return sb.substring(1, sb.length() - 1);
    }

    public double nextDouble(StringBuilder sb) throws IOException {
        double ret = 0, div = 1;
        int i = 0, n = sb.length();
        char c = sb.charAt(i);
        boolean neg = (c == '-');
        if (neg)
            c = sb.charAt(++i);
        do {
            ret = ret * 10 + c - '0';
        }
        while (++i < n && (c = sb.charAt(i)) >= '0' && c <= '9');
        isInt = !(c == '.');
        if (!isInt) {
            while (++i < n && (c = sb.charAt(i)) >= '0' && c <= '9') {
                ret += (c - '0') / (div *= 10);
            }
        }
        if (neg)
            return -ret;
        return ret;
    }

    private boolean isWhiteSpace(int n) {
        return n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == '{' || n == '}' || n == ',' || n == ':';
    }

    private void fillBuffer() throws IOException {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

    private byte read() throws IOException {
        size--;
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }

    @Override
    public void close() throws IOException {
        if (din == null)
            return;
        din.close();
    }
}