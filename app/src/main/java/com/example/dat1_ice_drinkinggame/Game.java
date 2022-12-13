package com.example.dat1_ice_drinkinggame;

import android.os.Build;
import java.util.ArrayList;
import java.util.Collections;

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

    public ArrayList<Player> sortPlayersForScoreBoard (ArrayList<Player> players) {
        Collections.sort(players);

        for (Player p: players) {
            System.out.println(p);
        }
        return players;
    }
}
