package org.example.JD2_Maven.home_work_1.dto;

import java.time.LocalDateTime;

public class Message {

    private LocalDateTime timeOfSend;

    private String fromWho;

    private String toWho;

    private String textOfMessage;

    public Message() {}

    public Message(LocalDateTime timeOfSend, String fromWho, String toWho, String textOfMessage) {
        this.timeOfSend = timeOfSend;
        this.fromWho = fromWho;
        this.toWho = toWho;
        this.textOfMessage = textOfMessage;
    }

    public LocalDateTime getTimeOfSend() {
        return timeOfSend;
    }

    public void setTimeOfSend(LocalDateTime timeOfSend) {
        this.timeOfSend = timeOfSend;
    }

    public String getFromWho() {
        return fromWho;
    }

    public void setFromWho(String fromWho) {
        this.fromWho = fromWho;
    }

    public String getToWho() {
        return toWho;
    }

    public void setToWho(String toWho) {
        this.toWho = toWho;
    }

    public String getTextOfMessage() {
        return textOfMessage;
    }

    public void setTextOfMessage(String textOfMessage) {
        this.textOfMessage = textOfMessage;
    }

    @Override
    public String toString() {
        return "Message{" +
                "timeOfSend=" + timeOfSend +
                ", fromWho='" + fromWho + '\'' +
                ", textOfMessage='" + textOfMessage + '\'' +
                '}';
    }
}
