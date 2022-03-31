package org.example.Test_3.dto;

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
