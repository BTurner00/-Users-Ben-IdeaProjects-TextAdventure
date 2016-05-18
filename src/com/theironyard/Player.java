package com.theironyard;

/**
 * Created by Ben on 5/18/16.
 */
public class Player {
    String name;
    String weapon;
    String location;

    public void chooseName() {
        System.out.println("What is your name?");



        String name = Main.scanner.nextLine();
        System.out.println("Welcome, " + name);
    }

    public void chooseWeapon() throws Exception {
        System.out.println("Choose your weapon [sword/mace]");

        String weapon = Main.scanner.nextLine();
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

        String location = Main.scanner.nextLine();

        if (location.equalsIgnoreCase("forest")) {
            System.out.println("Entering forest...");
        } else if (location.equalsIgnoreCase("tunnel")) {
            System.out.println("Entering tunnel...");
        } else {
            throw new Exception("Invalid location");
        }
    }
}
