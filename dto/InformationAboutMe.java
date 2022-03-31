package org.example.Test_3.dto;

import java.time.LocalDateTime;

public class InformationAboutMe {

    private String description;

    private  LocalDateTime dateTime;

    private InformationAboutMe() {

    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private static class InformationAboutMeHolder {
        private final static InformationAboutMe me = new InformationAboutMe();
    }
    public static InformationAboutMe getInstance() {
        return InformationAboutMeHolder.me;
    }

    @Override
    public String toString() {
        return description;
    }
}
