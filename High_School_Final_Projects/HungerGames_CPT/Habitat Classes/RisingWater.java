/*
 * RisingWater.java
 * `s class is a subclass of the Habit class.
 * Group 5: Maddy Angaran, Lynn John-Koshy, Erin Lee, 
 * Eugene Lee, Stanley Liu
 * ICS 4U
 * November 9th, 2020
 */

import java.util.ArrayList;

/**
 * The RisingWater Class gives the user an amount of time 
 * to escape before the area is flooded and they die. 
 */
public class RisingWater extends Habitat{ 
  Storyline text = new Storyline();

  // Initializing variables.
  private int playersNum, encounter, turn;
  private int foodNum = 5;
  private int waterNum = 10;
  private String line;
  private int turnsRW = 0;
  
  /**
   * Constructor.
   * Pre: None.
   * Post: Variables are initialized.
   */
  public RisingWater() {
    ArrayList<String> food = new ArrayList<String>();
    food.add("Fish");
    food.add("Seaweed");
    food.add("Wild Rice");
    food.add("Aronia Berries");
  }

  /**
   * Probability of the habitat randomly flooding.
   * Pre: None.
   * Post: Calls upon chanceLeave function.
   */
  public void event(Player player, Inventory inv){
    Storyline text = new Storyline();
    encounter = random(0, 100);
    if (encounter < 30) {
      chanceLeave(turnsRW, player);
    }
  }

  /**
   * Habitat's water levels rise based on the amount of 
   * time the player has been in the habitat (number of 
   * turns)
   * Pre: None.
   * Post: HP is decreased.
   */
  public void chanceLeave(int turnsRW, Player player){
    turnsRW++;
    switch(turnsRW){
      case 1:
        line = "\nThe water is up to your knees now and is continuing to rise.";
        text.textEffect(line);
        break;
      case 2:
        line = "\nThe water is up to your chest now and is rising at an accelerated rate.  It’s only a matter of time before it covers your head.";
        text.textEffect(line);
        break;
      case 3:
      line = "\nThe water is now over your head and you are suffocating.";
      text.textEffect(line);
      player.addHp(-100);
      break;
    }
  }
} 