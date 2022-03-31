package org.example.Test_3.dto;

import java.util.ArrayList;
import java.util.List;

public class ListOfMusicians {

    private final List<Musician> musicians;

    private ListOfMusicians(List<Musician> musicians) {
        this.musicians = musicians;
    }

    private List<Musician> addMusician() {

        if (musicians.isEmpty()) {
            for (int i = 0; i < 4; i++) {
                musicians.add(new Musician("Вася" + i));
            }
        }
        return musicians;
    }

    public List<Musician> getMusicians() {
        return addMusician();
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (Musician musician : addMusician()) {
            sb.append(musician).append("\n");
        }
        return sb.toString();
    }

    private static class ListOfMusiciansHolder {
        private final static ListOfMusicians list = new ListOfMusicians(new ArrayList<>());
    }

    public static ListOfMusicians getInstance() {
        return ListOfMusiciansHolder.list;
    }
}
