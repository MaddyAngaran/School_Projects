/*
 * DesertedDesert.java
 * This class is a subclass of the Habit class.
 * Group 5: Maddy Angaran, Lynn John-Koshy, Erin Lee,
 * Eugene Lee, Stanley Liu
 * ICS 4U
 * November 9th, 2020
 */
import java.util.ArrayList;

/**
 * The DesertedDesert Class makes users lose vitals 
 * quickly due to heat, therefore there are bodies of 
 * water that players can find but there is a higher risk 
 * of needing to fight. 
 */
public class DesertedDesert extends Habitat{ 

  // Initializing variables.
  private int playersNum;
  private int foodNum = 6;
  private int waterNum = 2;
  private String line;

  /**
   * Constructor.
   * Pre: None.
   * Post: Variables are initialized.
   */
  public DesertedDesert() {
    ArrayList<String> food = new ArrayList<String>();
    food.add("Cactus fruit");
    food.add("Corn");
    food.add("Pumpkin");
    food.add("Squash");
  }

  /**
   * Based on probabillity a disadvantage is played.
   * Pre: None.
   * Post: ArrayList is updated.
   */
  public void event(Player player, Inventory inv) {
    Storyline text = new Storyline();
    int encounter = random(0, 3);
    switch(encounter){
      case 0:
      line = "\nYou see a poisonous desert holly plant and notice how envious you are of the birds that are able to eat it.  Your stomach gurgles out of jealousy as your hunger grows.";
      text.textEffect(line);
      player.addHunger(-2); break;
      case 1:
      line = "\nThe warm desert sun has made you start sweating profusely.  You quickly realize how dry this has made your mouth and how thirsty you are.";
      text.textEffect(line);
      player.addThirst(-1); break;
      default:
      line = "\nWhile walking you feel a sting on your foot and notice a hole in the bottom of your shoe.  You look down and realize you burnt your foot!";
      text.textEffect(line);
      player.addHp(-5); break;
    }
  }
} 