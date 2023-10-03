/*
 * AiBattle.java
 * This class is used to monitor the Ai player's battles.
 * Group 5: Maddy Angaran, Lynn John-Koshy, Erin Lee, 
 * Eugene Lee, Stanley Liu
 * ICS 4U
 * November 9th, 2020
 */

import java.util.ArrayList;

/**
 * The AiBattle Class is used to keep track of Ai 
 * player's chances of a battle and surviving. 
 */
public class AiBattle {

  /**
   * Constructor.
   * Pre: None.
   * Post: Objects are instantiated.
   */
  public AiBattle() { 
  }

  /**
   * Based on a random chance, a battle occurs between 
   * the Ai, and one of them dies.
   * Pre: None.
   * Post: One player dies and their name is added to the 
   * dead player array list.
   */
  public void aiFight(Ai playerA, Ai playerB, ArrayList<Ai> ai, Player player) {
    int chance = random(1, 100);
    if (chance < 41) {
      int i = ai.indexOf(playerA);
      player.deadAi(ai, i);
    } else if (chance < 81) {
      int i = ai.indexOf(playerB);
      player.deadAi(ai, i);
    } //else they both live
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