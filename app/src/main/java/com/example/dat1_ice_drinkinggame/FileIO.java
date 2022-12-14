package com.example.dat1_ice_drinkinggame;

import android.app.Activity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileIO {


    public static ArrayList<Card> loadCards(Activity activity) {
        System.out.println(activity.getApplicationInfo().dataDir + File.separatorChar + "dares.csv");
        ArrayList<String> cardData = readFromFile(activity.getResources().openRawResource(R.raw.dares));
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

    private static ArrayList<String> readFromFile(InputStream is) {

        ArrayList<String> arr = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(is, StandardCharsets.UTF_8)
            );
            String line = "";
            while ((line = reader.readLine()) != null) {
                arr.add(line);
            }

        }
        catch (InputMismatchException | IOException fnfe) {
            fnfe.printStackTrace();
        }

        return arr;
    }

}
