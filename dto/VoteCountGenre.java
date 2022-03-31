package org.example.Test_3.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VoteCountGenre {

    private final Map<Genre,Integer> mapGenres;

    private List<Map.Entry<Genre,Integer>> entryListOfGenres;

    private VoteCountGenre(Map<Genre, Integer> mapGenres) {
        this.mapGenres = mapGenres;
    }

    public List<Map.Entry<Genre,Integer>> countGen(ListOfGenres gener, Genre gen) {
        int count;
        for (Genre genres : gener.getGenres()) {
            count = mapGenres.getOrDefault(genres,0);
            if (genres.equals(gen)) {
                mapGenres.put(genres,count+1);
            } else {
                mapGenres.put(genres,count);
            }
        }
        entryListOfGenres = new ArrayList<>(mapGenres.entrySet());

        return entryListOfGenres;
    }

    private static class VoteCountHolder{
        private final static VoteCountGenre count = new VoteCountGenre(new HashMap<>());
    }

    public static VoteCountGenre getInstance() {
        return VoteCountHolder.count;
    }

    public List<Map.Entry<Genre, Integer>> getEntryListOfGenres() {
        return entryListOfGenres;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Genre, Integer> entryListOfMusician : entryListOfGenres) {
            sb.append(entryListOfMusician.getKey()).
                    append(" голосов - ").
                    append(entryListOfMusician.getValue()).
                    append("\n");
        }
        return  sb.toString();
    }
}
