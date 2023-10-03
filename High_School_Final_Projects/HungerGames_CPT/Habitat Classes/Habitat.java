/*
 * Habitat.java
 * This class is the parent class of the habitats and 
 * therefore includes common elements amongst all 
 * habitats.
 * Group 5: Maddy Angaran, Lynn John-Koshy, Erin Lee, 
 * Eugene Lee, Stanley Liu
 * ICS 4U
 * November 9th, 2020
 */

import java.util.ArrayList;

/**
 * The Habitat Class is used to determine time, amount of 
 * players, and amount of resources found in each 
 * habitat. 
 */
public abstract class Habitat {

  // Initializing variables.
  private int totalTime, turn, water;
  private String line;
  private ArrayList<String> food = new ArrayList<String>();
  private String[] habitats = {"Deserted Desert", "Frost Bite", "Jumanji Jungle", "Rising Water", "Jumanji Jungle", "Rising Water"};
  
  /**
   * Constructor.
   * Pre: None.
   * Post: Variables are initialized.
   */
  public Habitat() {
    totalTime = 7; 
    turn = 0;
    line = "";
    water = 0;
    food.add("");
  }

  /**
   * Calculates the time remaining in the day.
   * Pre: Time must be less than 24.
   * Post: totalTime is calculated.
   */
  public void totalHours(int time) {
    totalTime += time;

    if (totalTime >= 24) {
      totalTime = totalTime-24; //24-hour clock
      turn(); // Goes to turn counter.
    }
  }

  /**
   * Returns totalTime.
   * Pre: Time must be less than 24.
   * Post: totalTime is returned.
   */
  public int getTime() {
    return totalTime;
  }

  /**
   * Sets totalTime.
   * Pre: Time must be less than 24.
   * Post: totalTime is set.
   */
  public void setTime(int time) {
    totalTime = time;
  }
  
  /**
   * Calculates the amount of days passed (turns).
   * Pre: None.
   * Post: A counter of turn adds one.
   */
  private void turn(){
    turn++;
  }

  /**
   * The amount of turns is returned.
   * Pre: None.
   * Post: turn is returned.
   */
  public int getTurn(){
    return(turn);
  }

  /**
   * Determines what time of day it is.
   * Pre: None.
   * Post: Boolean is set to true or false.
   */
  public boolean timeOfDay() {
    if (totalTime > 7 && totalTime < 19) {
      return true; 
    } else {
      return false;
    }
  }

  /**
   * Calculates how many food resources are available.
   * Pre: None.
   * Post: foodLeft is returned.
   */
  public int getFoodResources() {
    int foodLeft = food.size();
    return(foodLeft);
  }

  /**
   * Calculates how much water resources are available.
   * Pre: None.
   * Post: water is returned.
   */
  public int getWaterResources() {
    return(water);
  }

  /**
   * Remaining players are teleported to the center of 
   * the map to battle.
   * Pre: None.
   * Post: ArrayLists are updated.
   */
  public void deathMatch(ArrayList<Ai> aiList, Player player, Battle battle, Inventory inv, Storyline text) {
    battle.startBattle(player, aiList.get(0), inv, aiList, text);
  }

  /**
   * Abstract class for child classes.
   * Pre: None.
   * Post: A habitat specific event takes place.
   */
  abstract void event(Player player, Inventory inv);

  /**
   * Random number generator.
   * Pre: None.
   * Post: A random number is generated.
   */
  public int random(int min, int max) {
    int range = (max-min) + 1;
    return (int)((Math.random() * range) + min);
  }
} 