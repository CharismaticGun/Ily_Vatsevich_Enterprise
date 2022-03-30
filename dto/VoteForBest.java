package org.example.JD2_Maven.dto;

public class VoteForBest {

    private final ListOfGenres genres = ListOfGenres.getInstance();

    private final ListOfMusicians musicians = ListOfMusicians.getInstance();

    public boolean checkMusician(String musician) {
        for (Musician musicians : musicians.getMusicians()) {
            return musician.contains(musicians.toString());
        }
        return false;
    }

    public boolean checkGenre(String...genre) {
        for (Genre genres : genres.getGenres()) {
            return true;
        }
        return false;
    }
}
