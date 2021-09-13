package network.udp;

import javax.mail.MessagingException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.ByteBuffer;

public class Process extends Thread {
    private DatagramSocket clientSocket;
    private DatagramPacket inPacket;
    private DatagramPacket outPacket;
    private byte[] customBuffer;
    private ByteBuffer inBuffers;
    private int packetSize;
    private int service;


    public Process(DatagramPacket datagramPacket, int packetSize) {
        this.packetSize = packetSize;
        inPacket = datagramPacket;
        customBuffer = datagramPacket.getData();
        try {
            clientSocket=new DatagramSocket(datagramPacket.getPort(),datagramPacket.getAddress());
        } catch (SocketException e) {
            e.printStackTrace();
            return;
        }
        if (customBuffer.length == 0) return;
        service = (customBuffer[0] & 0xff);
    }

    @Override
    public void run(){
        switch (service) {
            case 10 -> sendMail();
            case 5 -> singleTextTo();
            default -> notFount();
        }
        waitForPackets();
    }

    private void notFount() {

    }

    private void waitForPackets() {

    }


    private void singleTextTo() {

    }

    private void sendMail() {
        try {
            new NewUserLoginData().send(customBuffer);
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
            badRequest();
        }
        created();
    }

    private void badRequest() {

    }

    private void created() {

    }

    private void successfulResponses() {

    }

}
