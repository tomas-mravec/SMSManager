package org.example;

import org.example.connection.ConnectionEstablisher;
import org.example.factory.connection.ConnectionEstablisherFactory;
import org.example.factory.listener.SMSListenerFactory;
import org.example.listener.SMSListener;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter device IP address:");
//        String ipAddress = scanner.nextLine();
//        System.out.println("Enter device port:");
//        int port = scanner.nextInt();

         final String DEVICE_IP_ADDRESS = "192.168.1.150";
         final int DEVICE_PORT = 5038;

        final String USERNAME = "apiuser";
        final String SECRET = "apipass";
        final String DEVICE_TYPE = "Yeastar";

        ConnectionEstablisher connection = ConnectionEstablisherFactory.create(DEVICE_TYPE, DEVICE_IP_ADDRESS,
                DEVICE_PORT,
                USERNAME,
                SECRET);

        connection.logIn();

        if (connection.getSocket().isPresent()) {
            SMSListener listener = SMSListenerFactory.create(DEVICE_TYPE, connection.getSocket().get());
            listener.listenForSMSMessages();
        } else {
            throw new RuntimeException();
        }
        //listener.startListening();
    }
}