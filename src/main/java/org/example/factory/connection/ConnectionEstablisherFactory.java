package org.example.factory.connection;

import org.example.connection.ConnectionEstablisher;
import org.example.connection.ConnectionEstablisherYeastar;

public class ConnectionEstablisherFactory {

    public static ConnectionEstablisher create(String type, String ipAddress, int port, String username, String secret) {
        if (type.equals("Yeastar")) {
            return new ConnectionEstablisherYeastar(ipAddress, port, username, secret);
        }

        return null;
    }
}
