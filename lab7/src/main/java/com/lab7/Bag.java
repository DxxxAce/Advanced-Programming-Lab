package com.lab7;

import java.util.*;

public class Bag {

    private final Collection<Tile> letters;

    public Bag() {

        this.letters = new HashSet();

        Random rand = new Random();

        for (char c = 'a'; c < 'z'; c++) {

            letters.add(new Tile(c, rand.nextInt(10)));
        }
    }
    public synchronized List<Tile> extractTiles(int howMany) {

        List<Tile> extracted = new ArrayList<>();

        for (int i = 0; i < howMany; i++) {

            if (letters.isEmpty()) {

                break;
            }

            //extracted.add(poll one tile from the collection);
        }

        return extracted;
    }
}
