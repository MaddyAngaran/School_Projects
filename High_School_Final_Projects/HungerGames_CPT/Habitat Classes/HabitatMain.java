/*
 * HabitatMain.java
 * This class is used to run attributes of the Habitat 
 * class (abstract) other than throught using objects.
 * Group 5: Maddy Angaran, Lynn John-Koshy, Erin Lee, 
 * Eugene Lee, Stanley Liu
 * ICS 4U
 * November 9th, 2020
 */

import java.util.ArrayList;

/**
 * The HabitatMain Class is used to run habitat class 
 * funtions without a specific habitat (eg. FrostBite, 
 * etc.) object. 
 */
public class HabitatMain extends Habitat {

  // Constructor.
  public HabitatMain() {
    super();
  }

  // Since it is a subclass of the abstract class, it needs the abstract method.
  public void event(Player player, Inventory inv) {
  }
}