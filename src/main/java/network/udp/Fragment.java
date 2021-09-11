package network.udp;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public final class Fragment {
    public static void format(ByteBuffer buffer, String... str) {
        if (str != null && str.length > 0) {
            int n=str.length - 1;
            for (int i = 0; i < n; i++) {
                buffer.put((byte) str[i].length()).put(str[i].getBytes(StandardCharsets.UTF_8));
            }
            buffer.put((byte) str[n].length()).put(str[n].getBytes(StandardCharsets.UTF_8));
        }
    }
}
