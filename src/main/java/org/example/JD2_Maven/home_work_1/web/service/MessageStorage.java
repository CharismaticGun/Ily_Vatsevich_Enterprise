package org.example.JD2_Maven.home_work_1.web.service;

import org.example.JD2_Maven.home_work_1.dto.Message;
import java.util.ArrayList;
import java.util.List;

public class MessageStorage {
    private final List<Message> messages;
    private MessageStorage(List<Message> messages) {
        this.messages = messages;
    }
    private static class MessageStorageHandler {
        private static final MessageStorage storage = new MessageStorage(new ArrayList<>());
    }

    public static MessageStorage getInstance() {
        return MessageStorageHandler.storage;
    }

    public List<Message> getMessages() {
        return messages;
    }
}
