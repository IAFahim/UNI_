package network.udp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

public class Client {
    static final public int DATA_RESERVE = 512, PACKAGE_RESERVE_SIZE=4 , SentSize = DATA_RESERVE;
    private final ByteBuffer byteBuffer;
    private DatagramSocket datagramSocket;
    public static String userID;
    private final int port;
    private ConnectionHistory connectionHistory;

    public Client(int port, String userID) {
        try {
            datagramSocket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        this.port = port;
        this.userID = userID;

        this.byteBuffer = ByteBuffer.allocateDirect(1 << 8).order(ByteOrder.BIG_ENDIAN);
        connectionHistory = new ConnectionHistory();
    }

    private void sendRequest(String clientId) {
        InetSocketAddress id = connectionHistory.getTransferInfo(clientId);
        if (id == null) {

        }
    }

    private void receiveRequest(String Data) {

    }

    void sendMessage(String text, String clientId) {

    }

    public void sendMessage(String str, InetSocketAddress inetSocketAddress) {

    }







































    void sendFile(File file, String id) {
        waitForSendPermission(file);

        FileChannel fileChannel = null;
        try {
            fileChannel = new FileInputStream(file).getChannel();
        } catch (IOException e) {
            e.printStackTrace();
        }

        fileClose(fileChannel);
    }

    private void fileClose(FileChannel fileChannel) {
        if (fileChannel != null && fileChannel.isOpen())
            try {
                fileChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    private void waitForSendPermission(File file) {
        byte[] info = fileInfo(file);
        try {
            datagramSocket.send(new DatagramPacket(info, info.length));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void addID(String id) {

    }

    private byte[] fileInfo(File file) {
        return (userID + " " + file.length() + " " + file.getName()).getBytes();
    }
}
