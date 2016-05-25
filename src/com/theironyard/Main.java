package com.theironyard;

import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Player player = new Player();

    public static void main(String[] args) throws Exception {

        System.out.println("Welcome traveller!");


        player.chooseName();
        player.chooseWeapon();
        player.chooseLocation();
        player.findItem("armor");
        player.findItem("potion");

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
                saveGame();
            } else {
                System.out.println("Command not found.");
            }
            line = scanner.nextLine();
        }
        return line;
    }

    public static void saveGame () {
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.include("*").serialize(player);

        File f = new File("game.json");
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(json);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}





