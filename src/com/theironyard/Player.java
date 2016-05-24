package com.theironyard;

import java.util.ArrayList;

/**
 * Created by Ben on 5/18/16.
 */
public class Player extends Character{

    String weapon;
    String location;

    ArrayList<String>  items = new ArrayList<>();

    public Player() {
        this.health = 20;
        this.damage = 20;
    }

    public void chooseName() {
        System.out.println("What is your name?");
        name = Main.nextLine();
        System.out.printf("Welcome, %s\n", name);

    }

    public void chooseWeapon() throws Exception {
        System.out.println("Choose your weapon [sword/mace]");

        weapon = Main.nextLine();
        if (weapon.equalsIgnoreCase("sword")){
            System.out.println("A sword is a fine choice!");
        } else if(weapon.equalsIgnoreCase("mace")){
            System.out.println("A mace is a fine choice!");
        } else {
            throw new Exception("Invalid weapon!");
        }
    }

    public void chooseLocation() throws Exception {
        System.out.println("Choose your location [forest/tunnel]");

        location = Main.nextLine();

        if (location.equalsIgnoreCase("forest")) {
            System.out.println("Entering forest...");
        } else if (location.equalsIgnoreCase("tunnel")) {
            System.out.println("Entering tunnel...");
        } else {
            throw new Exception("Invalid location");
        }
    }

    public void findItem(String item) {
        System.out.printf("You found %s! Pick it up? [y/n]\n", item);
        String answer = Main.nextLine();

        if (answer.equalsIgnoreCase("y")) {
            items.add("armor");
            System.out.printf("You now have %s items in your inventory\n", items.size());
        }
    }
}
