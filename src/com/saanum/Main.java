package com.saanum;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //Runescape clone - text based
	    Melee warrior = new Melee("Warrior", 99);
	    Magic wizard = new Magic( "Wizard", 75);
	    Ranged hunter = new Ranged("Hunter", 85);

	    Boss agoroth = new Boss( "Agoroth", 300);

        double damage;
        //Start
	    while(agoroth.getHealth()>=0){
            damage = new Random().nextDouble() * 50;
            warrior.Attack(agoroth, damage);

            damage = new Random().nextDouble() * 50;
            wizard.Attack(agoroth, damage);

            damage = new Random().nextDouble() * 50;
            hunter.Attack(agoroth, damage);
        }

        //Done
        System.out.println(agoroth.getName() + " defeated");
        System.out.println(warrior.getName() + " has life left: " + Double.toString(Math.round(warrior.getHealth())));
        System.out.println(wizard.getName() + " has life left: " + Double.toString(Math.round(wizard.getHealth())));
        System.out.println(hunter.getName() + " has life left: " + Double.toString(Math.round(hunter.getHealth())));


    }


}
