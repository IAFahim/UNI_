package network.udp;

import java.net.DatagramPacket;
import java.nio.ByteBuffer;

public class Process implements Runnable {

    public Process(DatagramPacket datagramPacket, ByteBuffer buffer) {
        int x = (buffer.get() & 0xff);
        switch (x) {
            case 10 -> sendMail();
        }
    }

    private void sendMail() {
    }

    @Override
    public void run() {

    }
}
