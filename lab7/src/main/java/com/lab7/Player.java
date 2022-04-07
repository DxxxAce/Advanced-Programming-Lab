package com.lab7;

import java.util.List;

public class Player implements Runnable {

    private String name;
    private Game game;
    private boolean running;

    public Player(String name) {

        this.name = name;
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

    public Game getGame() {

        return game;
    }

    private boolean submitWord() {
        List<Tile> extracted = game.getBag().extractTiles(7);
        if (extracted.isEmpty()) {
            return false;
        }
        //create a word with all the extracted tiles;
        String word = new String("");

        game.getBoard().addWord(this, word);
        //make the player sleep 50ms;
        return true;
    }

    @Override
    public void run() {

        System.out.println(getName() + " playing...");
    }
}
