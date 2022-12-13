package com.example.dat1_ice_drinkinggame;

import java.util.ArrayList;

public class Game {

    private static Game game_instance = null;

    public static Game getInstance() {
        if (game_instance == null) {
            game_instance = new Game();
        }
        return game_instance;
    }

    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Card> cards;

    private Game() {
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
}
