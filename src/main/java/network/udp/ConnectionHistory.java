package network.udp;

import java.net.*;
import java.util.HashMap;
import java.util.HashSet;

public class ConnectionHistory {
    private final HashMap<String, InetSocketAddress> connectionHistory;
    private HashSet<String> connectionsRequested;

    public ConnectionHistory() {
        connectionHistory = new HashMap<>();
    }

    public InetSocketAddress getTransferInfo(String id) {
        InetSocketAddress thisId = connectionHistory.get(id);
        if (thisId != null) {
            if (connectionsRequested == null) {
                connectionsRequested = new HashSet<>();
            }
            connectionsRequested.add(id);
        }
        return thisId;
    }

    public void addConnection(String id, InetAddress inetAddress, short port) {
        connectionHistory.put(id, new InetSocketAddress(inetAddress, port));
    }
}