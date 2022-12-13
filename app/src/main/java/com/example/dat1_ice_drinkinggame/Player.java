package com.example.dat1_ice_drinkinggame;

import java.util.ArrayList;
import java.util.Comparator;

public class Player implements Comparable{
    private final String name;
    private int sips;

    public Player(String name, int sips) {
        this.name = name;
        this.sips = sips;
    }

    public Player(String name) {
        this.name = name;
        sips = 0;
    }

    public void addSips(int sips) {
        this.sips += sips;
    }

    public String getName() {
        return name;
    }

    public int getSips() {
        return sips;
    }

    @Override
    public boolean equals(Object checkName) {
        boolean retVal = false;

        if (checkName instanceof String) {
            String s = (String) checkName;
            retVal = this.name.equals(s);
        } else if (checkName instanceof Player) {
            String s = ((Player) checkName).name;
            retVal = this.name.equals(s);
        }

        return retVal;
    }

    @Override
    public int compareTo(Object o) {
        int comparesips = ((Player)o).getSips();
        return this.getSips() - comparesips;
    }

    public String toString() {
        return "PLAYER: " +name+ " has had " +sips+ " sips!";
    }
}
