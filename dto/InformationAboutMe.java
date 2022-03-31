package org.example.Test_3.dto;

public class InformationAboutMe {

    private String description;

    private InformationAboutMe() {
    }

    public String getDescription() {
        return description;
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
