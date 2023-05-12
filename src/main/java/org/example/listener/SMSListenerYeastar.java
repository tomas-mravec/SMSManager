package org.example.listener;

import org.example.SmsMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SMSListenerYeastar implements SMSListener{

    private final Socket SOCKET;
    private PrintWriter out;
    private BufferedReader in;
    public SMSListenerYeastar(Socket socket) {
        this.SOCKET = socket;
        setUpResources();
    }

    private void setUpResources() {
        try {
            out = new PrintWriter(SOCKET.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(SOCKET.getInputStream()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void listenForSMSMessages() {


        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            String response;
            List<String> messages = new ArrayList<>();
            try {
                while ((response = in.readLine()) != null) {
                    System.out.println(response);
                    messages.add(response);
                    SmsMessage sms = SmsMessage.fromString(response);
                    System.out.println("Sprava od " + sms.getSender() + " content " + sms.getContent());
                }
            } catch (Exception e) {
                throw new RuntimeException();
            }
        });
    }
}
