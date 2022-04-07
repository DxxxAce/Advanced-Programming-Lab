package com.lab7;

import java.util.Collection;
import java.util.HashSet;

public class Board {

    private final Collection<String> words;

    public Board() {

        this.words = new HashSet();
    }

    public synchronized void addWord(Player player, String word) {

        //add the word to the collection;
        words.add(word);
        System.out.println(player.getName() + ": " + word);
    }

    @Override
    public String toString() {

        return words.toString();
    }
}
