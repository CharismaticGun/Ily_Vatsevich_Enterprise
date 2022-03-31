package org.example.Test_3.dto;

public class Genre {

    private final String genreName;

    public Genre(String name) {
        this.genreName = name;
    }

    @Override
    public String toString() {
        return genreName ;
    }
}
