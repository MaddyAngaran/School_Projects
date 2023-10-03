/*
 * Ai.java
 * This class is used to monitor the Ai players.
 * Group 5: Maddy Angaran, Lynn John-Koshy, Erin Lee, 
 * Eugene Lee, Stanley Liu
 * ICS 4U
 * November 9th, 2020
 */

import java.util.ArrayList;

/**
 * The Ai Class is used to keep track of Ai player's 
 * actions, weapons, stats, etc. 
 */
public class Ai {

  // Initialzing variables.
  public boolean playerOrAi;
  private String name;
  public int location, hp, type, aiWeapon;
  public int hunger, thirst, sanity;
  private double strength, dexterity;

  /**
   * Constructor.
   * Pre: None.
   * Post: Variables are initialized.
   */
  public Ai(String aiName) {
    name = aiName;
    location = random(0, 3);
    hp = 100;
    hunger = 10;
    thirst = 10;
    sanity = 10;
    strength = 1;
    dexterity = 1;
    playerOrAi = false;
    aiWeapon = random(1, 5);
  }
  
  /**
   * Moves Ai player's location.
   * Pre: None.
   * Post: New location is declared.
   */
  public void aiAction(Player player, ArrayList<Ai> aiList) {
    int chance = random(1, 100);
    if (chance < 41 && aiList.size() > 3) {
      setLocation();
    } else if (chance < 41 && aiList.size() <= 3) {
      location = player.getLocation();
    }
  }

  /**
   * Returns weapon.
   * Pre: None.
   * Post: Weapon is returned.
   */
  public int getAiWeapon() {
    return aiWeapon;
  }

  /**
   * Returns location.
   * Pre: None.
   * Post: Location is returned.
   */
  public int getLocation() {
    return location;
  }

  /**
   * Changes location value to 4.
   * Pre: None.
   * Post: Location is changed.
   */
  public void teleport() {
    location = 4;
  }

  /**
   * Changes location value.
   * Pre: None.
   * Post: Location is changed.
   */
  public void setLocation() {
    int chance = random(0, 3);
    location = chance;
  }

  /**
   * Returns the name of the Ai player.
   * Pre: None.
   * Post: Name is returned.
   */
  public String getName() {
    return name;
  }

  /**
   * Adds to hp (postive or negaive value) and checks if 
   * hp is within a set range.
   * Pre: None.
   * Post: Hp is set and checked if it is valid.
   */
  public void addHp(int amt) {
    hp += amt;
    hp = checkRange(hp, 100);
  }

  /**
   * Returns hp.
   * Pre: None.
   * Post: Hp is returned.
   */
  public int getHp() {
    return hp;
  }

  /**
   * Returns the dexterity of the Ai player.
   * Pre: None.
   * Post: Dexterity is returned.
   */
  public double getDexterity() {
    return dexterity;
  }

  /**
   * Returns the strength of the Ai player.
   * Pre: None.
   * Post: Strength is returned.
   */
  public double getStrength() {
    return strength;
  }

  /**
   * Checks to see if the stats are within a valid range.
   * Pre: None.
   * Post: The value is returned.
   */
  public int checkRange(int amt, int max){
    if (amt < 0) {
      amt = 0;
    } else if (amt > max) {
      amt = max;
    }
    return(amt);
  }

  /**
   * Checks to see if the Ai player is still alive based 
   * on stats.
   * Pre: None.
   * Post: The boolean is set to true or false.
   */
  public boolean checkAlive() {
    if (hp == 0) {
      return(false);
    } else if (sanity == 0) {
      return(false);
    } else if (hunger == 0) { 
      return(false);
    } else if (thirst == 0) {
      return(false);
    } else {
      return(true);
    }
  }

  /**
   * Hp that ai loses at the end of each turn (random 
   * number is subtracted from hp).
   * Pre: None.
   * Post: New hp value is set.
   */
  public void hpLoss() {
    int chance = random(1, 100);
    if (chance < 31) {
      addHp(random(1, 10));
    } else if (chance < 41) {
      addHp(random(11, 20));
    }
  }

  /**
   * Hp that ai gains at the end of each turn (random 
   * number is added to hp).
   * Pre: None.
   * Post: New hp value is set.
   */
  public void hpGain() {
    int chance = random(1, 100);
    if (chance < 61) {
      hp += 0;
    } else if (chance < 81) {
      addHp(random(1, 10));
    } else {
      addHp(20);
    }
  }

  /**
   * Random number generator.
   * Pre: None.
   * Post: A random number is generated.
   */
  public static int random(int min, int max) {
    int range = (max-min) + 1;
    return (int)((Math.random() * range) + min);
  }
}