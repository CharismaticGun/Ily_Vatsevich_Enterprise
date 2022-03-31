package org.example.Test_3.dto;

import java.util.*;

public class VoteCountMus {

    private final Map<Musician,Integer> mapMusician;

    private List<Map.Entry<Musician,Integer>> entryListOfMusicians;

    private VoteCountMus(Map<Musician, Integer> mapMusician) {
        this.mapMusician = mapMusician;
    }

    public List<Map.Entry<Musician,Integer>> countMus(ListOfMusicians musicians,Musician mus) {
        int count;
        for (Musician musician : musicians.getMusicians()) {
            count = mapMusician.getOrDefault(musician,0);
            if (musician.equals(mus)) {
                mapMusician.put(musician,count+1);
            } else {
                mapMusician.put(musician,count);
            }
        }
        entryListOfMusicians = new ArrayList<>(mapMusician.entrySet());

        return entryListOfMusicians;
    }

    private static class VoteCountHolder{
        private final static VoteCountMus count = new VoteCountMus(new HashMap<>());
    }

    public static VoteCountMus getInstance() {
        return VoteCountHolder.count;
    }

    public List<Map.Entry<Musician, Integer>> getEntryListOfMusicians() {
        return entryListOfMusicians;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Musician, Integer> entryListOfMusician : entryListOfMusicians) {
            sb.append(entryListOfMusician.getKey()).
                    append(" голосов - ").
                    append(entryListOfMusician.getValue()).
                    append("\n");
        }
        return  sb.toString();
    }
}
