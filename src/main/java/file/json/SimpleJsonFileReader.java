package file.json;

import java.io.*;

public class SimpleJsonFileReader implements AutoCloseable {
    final private int BUFFER_SIZE = 1 << 16;
    private final DataInputStream din;
    private final byte[] buffer;
    private int bufferPointer, bytesRead;
    public boolean hasNext;

    public SimpleJsonFileReader(File file) throws IOException {
        hasNext = file.length() > 2;
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

    int c = -1;

    public String nextString() throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = (c != -1) ? c : read();
        c = -1;
        while (isWhiteSpace(n)) {
            n = read();
        }
        while (!isWhiteSpace(n)) {
            sb.append((char) n);
            n = read();
        }
        n = read();
        if (n == -1) {
            hasNext = false;
        } else {
            c = n;
        }
        int e = sb.length(), s = 0;
        if (e > 2) {
            if (sb.charAt(s) == '"') {
                s = 1;
            }
            if (sb.charAt(e - 1) == '"') {
                --e;
            }
        }
        return sb.substring(s, e);

    }

    private boolean isWhiteSpace(int n) {
        return n == ' ' || n == ':' || n == ',' || n == '\n' || n == '\r' || n == -1 || n == '\t' || n == '{' || n == '}';
    }

    public int nextInt() throws IOException {
        int ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');

        if (neg)
            return -ret;
        return ret;
    }

    public long nextLong() throws IOException {
        long ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');
        if (neg)
            return -ret;
        return ret;
    }

    public double nextDouble() throws IOException {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();

        do {
            ret = ret * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');

        if (c == '.') {
            while ((c = read()) >= '0' && c <= '9') {
                ret += (c - '0') / (div *= 10);
            }
        }

        if (neg)
            return -ret;
        return ret;
    }

    private void fillBuffer() throws IOException {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

    private byte read() throws IOException {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }

    @Override
    public void close() throws IOException {
        din.close();
    }
}