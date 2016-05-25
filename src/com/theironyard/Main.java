package com.theironyard;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static final String SAVE_FILE= "game.json";
    static Scanner scanner = new Scanner(System.in);
    static Player player;

    public static void main(String[] args) throws Exception {

        player = loadGame(SAVE_FILE);
        if (player == null) {
            player = new Player();
            System.out.println("Starting a new game.");
        } else {
            System.out.println("Found save file.");
            System.out.println("Start new game instead? [y/n]");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("y")) {
                player = new Player();
            }
        }

        System.out.println("Welcome traveller!");


        if (player.name == null) player.chooseName();
        if (player.weapon == null) player.chooseWeapon();
        if (player.location == null) player.chooseLocation();
        if (player.items.isEmpty()) {
            player.findItem("armor");
            player.findItem("potion");
        }


        Enemy ogre = new Enemy("Ogre", 10, 10);
        player.battle(ogre);

        System.out.println(player);
        System.out.println(ogre);

       // saveGame();



        /*System.out.println("Type a number...");

        String num = scanner.nextLine();
        int numInt = Integer.valueOf(num);

        if (numInt < 0) {
            System.out.println("That's a negative number!");
        } else {
            System.out.println("That's a positive number!");
        }*/

    }


    public static String nextLine() {
        String line = scanner.nextLine();
        while (line.startsWith("/")) {
            if (line.equals("/inv")) {
                for (String item : player.items) {
                    System.out.println(item);
                }
            }else if (line.equals("/save")) {
                saveGame(player, SAVE_FILE);
            } else {
                System.out.println("Command not found.");
            }
            line = scanner.nextLine();
        }
        return line;
    }

    public static void saveGame (Player player, String filename) {
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.include("*").serialize(player);

        File f = new File(filename);
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(json);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Player loadGame(String filename) {
        File f = new File(filename);
        try {
            Scanner scanner = new Scanner(f);
            scanner.useDelimiter("//Z");
            String contents = scanner.next();
            JsonParser parser = new JsonParser();
            return parser.parse(contents, Player.class);
        } catch (FileNotFoundException e) {
        }
        return null;
    }
}





