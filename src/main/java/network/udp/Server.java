package network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashSet;

public class Server implements Runnable {
    DatagramSocket datagramSocket;
    static final public int PACKAGE_RESERVE_FOR_SIZE = 4, FROM_ID_SIZE = 4, TO_ID_SIZE = 4, DATA_RESERVE = 512, RECEIVED_SIZE = DATA_RESERVE + PACKAGE_RESERVE_FOR_SIZE + FROM_ID_SIZE + TO_ID_SIZE;
    static final public int SMALL_SIZE=100;

    public Server(int port) {
        try {
            datagramSocket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            byte[] bytes=new byte[SMALL_SIZE];
            DatagramPacket datagramPacket = new DatagramPacket(bytes,SMALL_SIZE);
            try {
                datagramSocket.receive(datagramPacket);
                if(acceptMessageWithComplicatedLogic(bytes))
                new Process(datagramPacket,PACKAGE_RESERVE_FOR_SIZE).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean acceptMessageWithComplicatedLogic(byte[] bytes){
        return true;
    }

}
