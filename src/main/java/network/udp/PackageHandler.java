package network.udp;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public final class PackageHandler {

    final ThreadLocal<ByteBuffer> bufferTL = ThreadLocal.withInitial(() -> ByteBuffer.allocate(1<<13).order(ByteOrder.BIG_ENDIAN));
    final ThreadLocal<DatagramSocket> socketTL;
    final ThreadLocal<DatagramPacket> packetTL;

    PackageHandler(int port, InetAddress address){
        socketTL = ThreadLocal.withInitial(() -> {
            try {
                return new DatagramSocket(port, address);
            } catch ( SocketException e) {
                throw new AssertionError(e);
            }
        });
        packetTL = ThreadLocal.withInitial(() -> new DatagramPacket(bufferTL.get().array(), 0, address, port));
    }

    //TODO
    private void send(String file) throws IOException {
        FileChannel fileChannel=fileInfo(file);

        if(fileChannel==null){
            return;
        }
        ByteBuffer buffer= bufferTL.get();
        while (fileChannel.read(buffer)>0){
            System.out.println(Arrays.toString(buffer.array()));
        }

    }

    private FileChannel fileInfo(String file) throws IOException{
        try {
            return new FileInputStream(file).getChannel();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
