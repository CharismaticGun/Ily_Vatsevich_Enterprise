package org.example.Test_3.dto;

import java.time.LocalDateTime;

public class VoteForBest {

    private final ListOfGenres genres = ListOfGenres.getInstance();

    private final ListOfMusicians musicians = ListOfMusicians.getInstance();

    private final InformationAboutMe me = InformationAboutMe.getInstance();

    private boolean checkMus = false;

    private boolean checkGen = false;

    private boolean checkMe = false;

    public boolean checkMusician(String musician) {

        for (Musician mus : musicians.getMusicians()) {
            if (musician.equals(mus.toString())) {
                VoteCountMus.getInstance().countMus(musicians,mus);
                checkMus = true;
                return true;
            }
        }
        return false;
    }

    public boolean checkGenre(String genre) {

        for (Genre gen : genres.getGenres()) {
            if (genre.equals(gen.toString())) {
                VoteCountGenre.getInstance().countGen(genres,gen);
                checkGen = true;
                return true;
            }
        }
        return false;
    }

    public String putInMe(String description) {
        me.setDescription(description);
        me.setDateTime(LocalDateTime.now());
        checkMe = true;
        return me.toString();
    }

    public boolean checkAll() {
        return checkMus&&checkGen&&checkMe;
    }

}
