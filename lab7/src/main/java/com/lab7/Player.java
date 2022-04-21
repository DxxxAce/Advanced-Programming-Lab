package com.lab7;

import java.util.List;

import static java.lang.Thread.sleep;

public class Player implements Runnable {

    private String name;
    private String word;
    private Game game;
    private boolean running;
    private List<Tile> extracted;

    public Player(String name) {

        this.name = name;
        this.word = "";
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setGame(Game game) {

        this.game = game;
    }

    public void setRunning(boolean running) {

        this.running = running;
    }

    public String getName() {

        return name;
    }

    private boolean submitWord() {

        this.extracted = game.getBag().extractTiles(7);

        if (extracted.isEmpty()) {

            return false;
        }

        for (Tile tile : extracted) {

            word = word.concat(Character.toString(tile.getLetter()));
        }

        //create a word with all the extracted tiles;
        game.getBoard().addWord(this, word);

        //make the player sleep 50ms;
        try {

            sleep(50);
        }
        catch (InterruptedException e) {

            e.printStackTrace();
        }

        return true;
    }

    @Override
    public void run() {

        submitWord();
    }
}
