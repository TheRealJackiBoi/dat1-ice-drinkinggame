package com.example.dat1_ice_drinkinggame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {


    public static ArrayList<Card> loadCards() {
        ArrayList<String> cardData = readFromFile(new File("sampledata/Dares.csv"));
        ArrayList<Card> cards = new ArrayList<Card>();

        for (String c :
                cardData) {
            String[] data = c.split(";");

            String dare = data[0];
            int sips = Integer.parseInt(data[1].trim());
            cards.add(new Card(dare, sips));
        }

        return cards;
    }

    private static ArrayList<String> readFromFile(File file) {

        ArrayList<String> arr = new ArrayList<>();

        try {
            Scanner scn = new Scanner(file);

            while(scn.hasNext()) {
                arr.add(scn.nextLine());
            }

        }
        catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }

        return arr;
    }

}
