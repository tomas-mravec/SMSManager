package org.example.factory.listener;

import org.example.listener.SMSListener;
import org.example.listener.SMSListenerYeastar;

import java.net.Socket;

public class SMSListenerFactory {
    public static SMSListener create(String type, Socket socket) {
        if (type.equals("Yeastar")) {
            return new SMSListenerYeastar(socket);
        }
        // Add other types of listeners here

        throw new IllegalArgumentException("Unsupported listener type: " + type);
    }
}
