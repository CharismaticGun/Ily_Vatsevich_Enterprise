package org.example.JD2_Maven.dto;

public class Musician {

    private final String name;

    public Musician(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name ;
    }
}
