package network.udp;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public final class PackageHandler {

    final ThreadLocal<ByteBuffer> byteBufferThreadLocal = ThreadLocal.withInitial(() -> ByteBuffer.allocateDirect(1<<13).order(ByteOrder.BIG_ENDIAN));
    final ThreadLocal<DatagramSocket> datagramSocketThreadLocal;
    final ThreadLocal<DatagramPacket> datagramPacketThreadLocal;

    PackageHandler(int port, InetAddress address){
        datagramSocketThreadLocal = ThreadLocal.withInitial(() -> {
            try {
                return new DatagramSocket(port, address);
            } catch ( SocketException e) {
                throw new AssertionError(e);
            }
        });
        datagramPacketThreadLocal = ThreadLocal.withInitial(() -> new DatagramPacket(byteBufferThreadLocal.get().array(), 0, address, port));
    }

    //TODO
    private void send(String file) throws IOException {
        FileChannel fileChannel=fileInfo(file);

        if(fileChannel==null){
            return;
        }
        ByteBuffer buffer= byteBufferThreadLocal.get();
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
