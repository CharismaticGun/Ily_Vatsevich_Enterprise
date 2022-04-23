package org.example.JD2_Maven.home_work_1.web.service;

import org.example.JD2_Maven.home_work_1.dto.Message;
import org.example.JD2_Maven.home_work_1.dto.User;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


public class MessageControl {

    private final MessageStorage ms = MessageStorage.getInstance();

    private final UserStorage us = UserStorage.getInstance();

    private final StatisticStorage ss = StatisticStorage.getInstance();

    public boolean sendMessage(HttpServletRequest request, String login, String messageText) {

        User attribute = (User) request.getSession().getAttribute("user");

        if (!attribute.getLogin().equals(login)&& us.getUsers().stream().
                anyMatch(user -> user.getLogin().equals(login))) {
                    ms.getMessages().add(new Message(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS),
                    attribute.getLogin(),
                    login,
                    messageText));
                    ss.increaseCountSendMessages();
            return true;
        }
        return false;
    }

    public List<Message> getMessage(HttpServletRequest request) {

        User attribute = (User) request.getSession().getAttribute("user");

        List<Message> messages = new ArrayList<>();

        for (Message message : ms.getMessages()) {
            if (message.getToWho().equals(attribute.getLogin())) {
                messages.add(message);
            }
        }
        return messages;
    }

}
