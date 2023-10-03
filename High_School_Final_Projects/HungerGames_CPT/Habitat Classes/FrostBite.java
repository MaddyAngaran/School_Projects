/*
 * FrostBite.java
 * This class is a subclass of the Habit class.
 * Group 5: Maddy Angaran, Lynn John-Koshy, Erin Lee, 
 * Eugene Lee, Stanley Liu
 * ICS 4U
 * November 9th, 2020
 */

import java.util.ArrayList;

/**
 * The FrostBite Class makes temperatures extremely cold 
 * making users loses HP quickly. Therefore to compensate 
 * they must find supplies. 
 */
public class FrostBite extends Habitat { 

  // Initializing variables.
  private int waterNum;
  private int temp;
  private String line, line2;
  ArrayList<String> items = new ArrayList<String>();
  ArrayList<String> food = new ArrayList<String>();

  /**
   * Constructor.
   * Pre: None.
   * Post: Variables are initialized.
   */
  public FrostBite() {
    food.add("Seafood");
    food.add("Meat");
    food.add("Canned Food");
    food.add("Hot Chocolate");
    
    items.add("Blanket");

    waterNum = 2; //most of it is frozen.

    temp = random(1, 4);
    line = "";
  }

  /**
   * With low temperatures hp is lost quicker. Temp is 
   * constant for one object.
   * Pre: HP must be greater than 0.
   * Post: HP is returned.
   */
  public void event(Player player, Inventory inv) {
    Storyline text = new Storyline();
    if (inv.hasBlanket() == false) {
      switch (temp) {
        case 1: 
          player.addHp(-1); break;
        case 2: 
          player.addHp(-3); break;
        case 3: 
          player.addHp(-5); break;
        case 4: 
          player.addHp(-7); break;
        default: break;
      }

      line = "\nBRRR! Goosebumps grow on your arms as you begin to feel the sudden decrease in temperature."; 
      text.textEffect(line);

      line = "\nThe extreme temperatures reduce your health. You are now at " + player.getHp() + " HP.";
      text.textEffect(line);

      line = "\nPerhaps you should search for some supplies to keep you warm.";
      text.textEffect(line);
    }
  }

  /**
   * User must find supplies (eg. blankets to maintain 
   * health).
   * Pre: None.
   * Post: Item is added to inventory and the associate 
   * statement is printed.
   */
  public void findSupplies(Inventory inv) {
    Storyline text = new Storyline();
    int luck = random(1, 100);
    if (luck < 61) {
      line = "\nYou didn't find anything :(";
      text.textEffect(line);
    } else {
      line2 = "\nYou found a blanket to keep you warm! You no longer lose HP due to the cold temperatures.";
      text.textEffect(line2);
      inv.addBlanket();
    }
  }
}