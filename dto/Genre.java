package org.example.JD2_Maven.dto;

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
