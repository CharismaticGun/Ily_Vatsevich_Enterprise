package org.example.JD2_Maven.dto;

import java.util.ArrayList;
import java.util.List;

public class ListOfGenres {

    private final List<Genre> genres;

    private ListOfGenres(List<Genre> genres) {
        this.genres = genres;
    }

    private List<Genre> addGenre() {
        if (genres.isEmpty()) {
            for (int i = 0; i < 10; i++) {
                genres.add(new Genre("Поп" + i));
            }
        }
        return genres;
    }

    public List<Genre> getGenres() {
        return addGenre();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Genre genre : addGenre()) {
            sb.append(genre).append("\n");
        }
        return sb.toString();
    }

    private static class ListOfGenreHolder {
        private final static ListOfGenres list = new ListOfGenres(new ArrayList<>());
    }

    public static ListOfGenres getInstance() {
        return ListOfGenreHolder.list;
    }
}
