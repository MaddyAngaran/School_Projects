/*
 * JumanjiJungle.java
 * This class is a subclass of the Habit class.
 * Group 5: Maddy Angaran, Lynn John-Koshy, Erin Lee, 
 * Eugene Lee, Stanley Liu
 * ICS 4U
 * November 9th, 2020
 */

import java.util.ArrayList;

/**
 * The JumanjiJungle Class allows users to face 
 * probablitly of whether or not they lose stats, health, 
 * etc. or gain it. 
 */
public class JumanjiJungle extends Habitat { 

  // Initializing variables.
  private int foodNum, hpLoss, waterNum, encounter;
  private String line;
  
  /**
   * Constructor.
   * Pre: None.
   * Post: Variables are initialized.
   */
  public JumanjiJungle() {
    ArrayList<String> food = new ArrayList<String>();
    food.add("Plants");
    food.add("Berries");
    food.add("Coconuts");
    food.add("Mangos");

    waterNum = 4; // 0-10 (0 being no water);
    encounter = 0;
    hpLoss = 0;
    line = "";
  }

  /**
   * Based on a random generator a random disadvantage or 
   * advantage is given.
   * Pre: Strength, hunger, and thirst must be greater 
   * than 0.
   * Post: Statements are printed, and variables are 
   * changed and returned. 
   */
  public void event(Player player, Inventory inv){
    Storyline text = new Storyline();
    encounter = random(1, 5);
    switch (encounter) {
      case 1:
        line = "\nA sponsor sent you medicine for your wound";
        text.textEffect(line);
        player.addHp(10); break;
      case 2:
        line = "\nYour inventory stash was raided... including your food!";
        text.textEffect(line);
        player.addHunger(-1); break;
      case 3:
        line = "\nOn your hunt for food, you found another players stash. As you were stuffing your face, you accidently swallowed it the wrong way... queue the cough attack.";
        text.textEffect(line); 
        player.addHp(-3); break;
      case 4:
        line = "\nWhile running away from another player, you fell down into a pond which infected your wound... yikes!";
        text.textEffect(line);
        player.addHp(-10); break;
      case 5:
        line = "\nAs you make your way through the jungle, you see something moving in the far distance... is that a ChIcKeN??? As you move closer to it and are arms reach from grabbing it, you realize two things... one, you are going insane and two, it's a rock... opps!";
        text.textEffect(line); break;
      default: break;
    }
  }
 } 