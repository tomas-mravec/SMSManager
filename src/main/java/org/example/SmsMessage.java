package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SmsMessage {
    private String event;
    private String privilege;
    private String id;
    private int gsmSpan;
    private String sender;
    private LocalDateTime recvTime;
    private int index;
    private int total;
    private String smsc;
    private String content;

    // constructor, getters, and setters omitted for brevity

    public static SmsMessage fromString(String smsString) {
        SmsMessage sms = new SmsMessage();
        String[] lines = smsString.split("\n");
        for (String line : lines) {
            String[] parts = line.split(": ");
            String key = parts[0].trim();
            String value = parts[1].trim();
            switch (key) {
                case "Event":
                    sms.setEvent(value);
                    break;
                case "Privilege":
                    sms.setPrivilege(value);
                    break;
                case "ID":
                    sms.setId(value);
                    break;
                case "GsmSpan":
                    sms.setGsmSpan(Integer.parseInt(value));
                    break;
                case "Sender":
                    sms.setSender(value);
                    break;
                case "Recvtime":
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    sms.setRecvTime(LocalDateTime.parse(value, formatter));
                    break;
                case "Index":
                    sms.setIndex(Integer.parseInt(value));
                    break;
                case "Total":
                    sms.setTotal(Integer.parseInt(value));
                    break;
                case "Smsc":
                    sms.setSmsc(value);
                    break;
                case "Content":
                    sms.setContent(value);
                    break;
                default:
                    // ignore unknown keys
                    break;
            }
        }
        return sms;
    }

    private void setPrivilege(String value) {
    }

    private void setId(String value) {

    }

    private void setGsmSpan(int parseInt) {

    }

    private void setSender(String value) {
        this.sender = sender;
    }

    private void setIndex(int parseInt) {

    }

    private void setTotal(int parseInt) {

    }

    private void setContent(String content) {
        this.content = content;
    }

    private void setSmsc(String value) {

    }

    private void setRecvTime(LocalDateTime parse) {

    }

    private void setEvent(String event) {
        this.event = event;
    }

    public String getEvent() {
        return event;
    }

    public String getPrivilege() {
        return privilege;
    }

    public String getId() {
        return id;
    }

    public int getGsmSpan() {
        return gsmSpan;
    }

    public String getSender() {
        return sender;
    }

    public LocalDateTime getRecvTime() {
        return recvTime;
    }

    public int getIndex() {
        return index;
    }

    public int getTotal() {
        return total;
    }

    public String getSmsc() {
        return smsc;
    }

    public String getContent() {
        return content;
    }
}

