package org.example.Test_3.dto;

public class VoteForBest {

    private final ListOfGenres genres = ListOfGenres.getInstance();

    private final ListOfMusicians musicians = ListOfMusicians.getInstance();

    private final InformationAboutMe me = InformationAboutMe.getInstance();

    private final VoteCountMus count = VoteCountMus.getInstance();

    private boolean checkMus = false;

    private boolean checkGen = false;

    private boolean checkMe = false;

    public boolean checkMusician(String musician) {

        for (Musician mus : musicians.getMusicians()) {
            if (musician.equals(mus.toString())) {
                count.countMus(musicians,mus);
                checkMus = true;
                return true;
            }
        }
        return false;
    }

    public boolean checkGenre(String genre) {

        for (Genre genres : genres.getGenres()) {
            if (genre.equals(genres.toString())) {
                checkGen = true;
                return true;
            }
        }
        return false;
    }

    public String putInMe(String description) {
        me.setDescription(description);
        checkMe = true;
        return me.toString();
    }

    public boolean checkAll() {
        return checkMus&&checkGen&&checkMe;
    }

}
