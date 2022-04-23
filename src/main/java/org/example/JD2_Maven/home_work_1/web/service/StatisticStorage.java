package org.example.JD2_Maven.home_work_1.web.service;

import java.util.concurrent.atomic.AtomicInteger;

public class StatisticStorage {

    private StatisticStorage() {}

    private static class StatisticStorageHolder{
        private static final StatisticStorage ss = new StatisticStorage();
    }

    public static StatisticStorage getInstance() {
        return StatisticStorageHolder.ss;
    }

    private long countActiveSessions;

    private long countSendMessages;

    public void increaseCountActiveSessions() {
        countActiveSessions++;
    }

    public void increaseCountSendMessages() {
        countSendMessages++;
    }

    public void decreaseCountActiveSessions() {
        countActiveSessions--;
    }

    public long getCountActiveSessions() {
        return countActiveSessions;
    }

    public long getCountSendMessages() {
        return countSendMessages;
    }
}
