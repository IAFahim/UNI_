package network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Server implements Runnable {
    DatagramSocket datagramSocket;
    static final public int PACKAGE_RESERVE_FOR_SIZE = 4, FROM_ID_SIZE = 4, TO_ID_SIZE = 4, DATA_RESERVE = 512, RECEIVED_SIZE = DATA_RESERVE + PACKAGE_RESERVE_FOR_SIZE + FROM_ID_SIZE + TO_ID_SIZE;
    ByteBuffer receivedBuffer;
    ByteBuffer sendBuffer;

    public Server(int port) {
        receivedBuffer = ByteBuffer.allocateDirect(RECEIVED_SIZE).order(ByteOrder.BIG_ENDIAN);
        sendBuffer = ByteBuffer.allocateDirect(RECEIVED_SIZE).order(ByteOrder.BIG_ENDIAN);
        try {
            datagramSocket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            DatagramPacket datagramPacket = new DatagramPacket(receivedBuffer.array(),RECEIVED_SIZE);
            try {
                datagramSocket.receive(datagramPacket);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
