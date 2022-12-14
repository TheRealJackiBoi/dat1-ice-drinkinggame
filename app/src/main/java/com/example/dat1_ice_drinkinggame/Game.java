package com.example.dat1_ice_drinkinggame;

import android.app.Activity;
import android.os.Build;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Game {

    //Singleton varible to have the same values for players and cards "Globaly"
    private static Game game_instance = null;

    //Create new instance if there isn't one
    public static Game getInstance() {
        if (game_instance == null) {
            game_instance = new Game();
        }
        return game_instance;
    }

    public static Game getInstance(Activity activity) {
        if (game_instance == null) {
            game_instance = new Game(activity);
        }
        return game_instance;
    }



    private final ArrayList<Player> players;
    private ArrayList<Card> cards;
    private Player currentPlayer;
    private Card currentCard;
    private boolean isGameEnded = false;

    //private... should only be used in .getInstance()
    private Game(Activity activity) {
        players = new ArrayList<>();
        cards = FileIO.loadCards(activity);
    }
    private Game() {
        players = new ArrayList<>();
        cards = new ArrayList<>();
    }

    public boolean playerExists(String playerName) {
        for (Player p :
                players) {
            //compares player names
            if (p.equals(playerName)) {
                return true;
            }
        }
        return false;
    }
    public ArrayList<Player> getPlayers() {
        return players;
    }

    //addPlayer for NewGameFragment
    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public Player getNewPlayer() {
        Random rnd = new Random();
        currentPlayer = players.get(rnd.nextInt(players.size()));
        return currentPlayer;
    }

    public Card getNewCard() {
        Random rnd = new Random();
        currentCard = cards.get(rnd.nextInt(cards.size()));
        return currentCard;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    //Sorting players for visible output on ScoreFragment
    public ArrayList<Player> sortPlayersForScoreBoard () {
        Collections.sort(players, new SortBySips());
        return players;
    }




    public boolean isGameEnded() {
        return isGameEnded;
    }

    public void setGameEnded(boolean gameEnded) {
        isGameEnded = gameEnded;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

}

//comparator for sortPlayersForScoreBoard
class SortBySips implements Comparator<Player>
{
        public int compare(Player a, Player b) {
            return a.getSips() - b.getSips();
        }
}