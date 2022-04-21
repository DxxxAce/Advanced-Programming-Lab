package com.lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bag {

    private final List<Tile> letters = new ArrayList<>();

    public Bag() {

        for (char c = 'a'; c <= 'z'; c++) {

            letters.add(new Tile(c, (new Random()).nextInt(10)));
        }
    }

    public synchronized List<Tile> extractTiles(int howMany) {

        List<Tile> extracted = new ArrayList<>();

        for (int i = 0; i < howMany; i++) {

            if (letters.isEmpty()) {

                break;
            }

            int randIndex = (new Random()).nextInt(letters.size());
            extracted.add(letters.get(randIndex));
        }

        return extracted;
    }
}
