package org.example.JD2_Maven.home_work_1.web.listeners;

import org.example.JD2_Maven.home_work_1.dto.User;
import org.example.JD2_Maven.home_work_1.web.service.StatisticStorage;

import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebListener
public class ListenerUsersSessions implements HttpSessionListener, HttpSessionAttributeListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {

        User user = ((User) sbe.getSession().getAttribute("user"));

        if (null!=user) {
            StatisticStorage.getInstance().increaseCountActiveSessions();
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        StatisticStorage.getInstance().decreaseCountActiveSessions();
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {

    }
}
