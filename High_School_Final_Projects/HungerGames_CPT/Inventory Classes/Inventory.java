/*
 * Inventory.java
 * This class is used to monitor a players inventory.
 * Group 5: Maddy Angaran, Lynn John-Koshy, Erin Lee, 
 * Eugene Lee, Stanley Liu
 * ICS 4U
 * November 9th, 2020
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The Inventory Class is used to keep track of all food, 
 * weapons, water, etc.. 
 */
public class Inventory {

  // Initializing variables.
  Scanner scan = new Scanner(System.in);
  private boolean check = true;
  private int weaponDMG;
  private int choice = 0;
  ArrayList<Integer> inventory = new ArrayList<Integer>();
  ArrayList<Integer> sword = new ArrayList<Integer>();

  public Storyline text = new Storyline();

  /**
   * Constructor.
   * Pre: None.
   * Post: Variables are initialized.
   */
  public Inventory () {
    inventory.add(0); //food
    inventory.add(0); //water
    inventory.add(0); //blanket
  }

  /**
   * Returns weapons.
   * Pre: None.
   * Post: Weapon is returned.
   */
  public int getWeapon() {
    return sword.get(0);
  }

  /**
   * Generates a random number for a weapon.
   * Pre: None.
   * Post: Function is called upon.
   */
  public void generateWeapon() {
    sword.add(random(1, 5));
  }

  /**
   * Sets weapon name.
   * Pre: Weapon must be a number from 1-5.
   * Post: Name is returned.
   */
  public String getWeaponName(int weapon) {
    String name = "";
    switch (weapon) {
      case 1:
        name = "Rusty Sword"; break;
      case 2:
        name = "Katana"; break;
      case 3:
        name = "Bolo Knife"; break;
      case 4:
        name = "Roman Gladius"; break;
      case 5:
        name = "GunKnife"; break;
      default: break;
    }
    return name;
  }

  /**
   * Sets weapon damage.
   * Pre: Weapon must be a number from 1-5.
   * Post: Weapon damage is returned.
   */
  public int getWeaponDamage(int weapon) {
    switch(weapon) {
      case 1:
        weaponDMG = 18; break;
      case 2:
        weaponDMG = 20; break;
      case 3:
        weaponDMG = 21; break;
      case 4:
        weaponDMG = 22; break;
      case 5:
        weaponDMG = 23; break;
      default: break;
    }
    return weaponDMG;
  }

  /**
   * Adds food to inventory array.
   * Pre: None.
   * Post: Food is added.
   */
  public void addFood() {
    int mid = inventory.get(0);
    inventory.set(0, mid + 1);
  }

  /**
   * Adds water to inventory array.
   * Pre: None.
   * Post: Water is added.
   */
  public void addWater() {
    int mid = inventory.get(1);
    inventory.set(1, mid + 1);
  }

  /**
   * Adds blanket to inventory array.
   * Pre: None.
   * Post: Blanket is added.
   */
  public void addBlanket() {
    inventory.set(2, 1);
  }

  /**
   * Checks to see if blanket is in inventory.
   * Pre: None.
   * Post: Boolean is set to true or false.
   */
  public boolean hasBlanket() {
    if (inventory.get(2) == 1) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Checks to see if food is avaliable in inventory. If 
   * yes, hunger is sufficed.
   * Pre: None.
   * Post: Hunger is sufficed or statement is printed.
   */
  public void eat(Player player, int location) {
    if (inventory.get(0) > 0) {
      int mid = inventory.get(0);
      inventory.set(0, mid - 1);
      player.addHunger(3);
      text.actionEat(location);
    } else {
      System.out.println("\nYou have no food!");
    }
  }

  /**
   * Checks to see if food is avaliable in inventory (to 
   * cook). If yes, hunger is sufficed.
   * Pre: None.
   * Post: Hunger is sufficed or statement is printed.
   */
  public void cook(Player player, int location) {
    if (inventory.get(0) > 0) {
      int mid = inventory.get(0);
      inventory.set(0, mid - 1);
      player.addHunger(6);
      player.addHp(15);
      text.actionEat(location);
    } else {
      System.out.println("\nYou have no food!");
    }
  }

  /**
   * Checks to see if water is avaliable in inventory. If 
   * yes, thirst is sufficed.
   * Pre: None.
   * Post: Thirst is sufficed or statement is printed.
   */
  public void drink(Player player, int location) {
    if (inventory.get(1) > 0) {
      int mid = inventory.get(1);
      inventory.set(1, mid - 1);
      player.addThirst(3);
      text.actionDrink(location);
    } else {
      System.out.println("\nYou have no water!");
    }
  }


  /**
   * Allows players to see their inventory (stats, 
   * weapons, etc.).
   * Pre: None.
   * Post: Inventory is displayed.
   */
  public void invSee(Player user) { // Object for the user's Player class
    
    // Instantiating object and initializing variable.
    Storyline text = new Storyline();
    String line;

    // Lists menu.
    line = "\n1: View stats\n2: View weapons\n3: View food/water/items\n0: Quit\nEnter an option: ";
    text.textEffect(line);

    // Verifies user input.
    do {
      do {
        try {
          choice = scan.nextInt();
          check = true;
        } catch (Exception e) {
          System.out.print("Error - Input was not a valid choice.");
          check = false;
          System.out.print("Please enter a valid option (1, 2, 3, 0): ");
        }
      } while (check = false);

      if (choice != 1 && choice != 2 && choice != 3 && choice != 0) {
        System.out.print("Please enter a valid option (1, 2, 3, 0): ");
      }
    } while (choice != 1 && choice != 2 && choice != 3 && choice != 0);

    // Leads to choice function.
    switch(choice) {
      case 1: viewStats(user); break;
      case 2: viewWeapons(user); break;
      case 3: viewInventory(); break;
      default: break;
    }
  }

  /**
   * Displays players stats (Ex. hp, hunger, etc.)
   * Pre: None.
   * Post: Stats are printed.
   */
  public void viewStats(Player user) {
    System.out.println("HP: " + user.getHp());
    System.out.println("Hunger: " + user.getHunger());
    System.out.println("Thirst: " + user.getThirst());
    System.out.println("Sanity: " + user.getSanity());
    System.out.println("Immunity: " + user.getImmunity());
    System.out.println("Strength: " + user.getStrength());
  }

  /**
   * Displays players stats (Ex. hp, hunger, etc.) 
   * Pre: None.
   * Post: Stats are printed. (different formatting)
   */
  public void viewStatsLine(Player user) {
    System.out.print("\nHP: " + user.getHp());
    System.out.print("\tHUNGER: " + user.getHunger());
    System.out.print("\tTHIRST: " + user.getThirst());
    System.out.print("\tSANITY: " + user.getSanity());
    System.out.print("\tIMMUNITY: " + user.getImmunity());
    System.out.print("\tSTRENGTH: " + user.getStrength());
  }


  /**
   * Allows player to access their weapon inventory and either see what weapons they have or eqip one.
   * Pre: None.
   * Post: displays weapon inventory/equips selected weapon.
   */
  public void viewWeapons(Player user) {
    
    // Instantiating object and initializing variable.
    Storyline text = new Storyline();
    String line;

    // Lists menu.
    line = "\n1: Display weapons\n2: Equip weapon\n0: Quit";
    text.textEffect(line);

    // Verifies user input.
    do {
      do {
        try {
          choice = scan.nextInt();
          check = true;
        } catch (Exception e) {
          System.out.print("Error - Input was not a valid choice.");
          check = false;
          System.out.print("Please enter a valid option (1, 2, 0): ");
        }
      } while (check = false);

      if (choice != 1 && choice != 2 && choice != 0) {
        System.out.print("Please enter a valid option (1, 2, 0): ");
      }
    } while (choice != 1 && choice != 2 && choice != 0);

    // Describes weapons.
    switch (choice) {
      case 1:
        System.out.print("Weapons Inventory\n-------------------------------------------------------------------------------------------------------");
        for (int num : sword) {
          System.out.print("\n-------------------------------------------------------------------------------------------------------\n");
          switch (num) {
            case 1:
              System.out.print("Rusty Sword\n\nA jagged blade that clearly has been left outside for too long. Although it doesn't look the cleanest, it feels sturdy and is definitely sharp enough to cut.\n\nAttack Damage: 18"); break;
            case 2:
              System.out.print("Katana\n\nA japanese, curved, single-edged blade. You've heard about it in film and media, but you've never really wielded one. Time to learn how.\n\nAttack Damage: 20"); 
              break;
            case 3:
              System.out.print("Bolo Knife\n\nQuick and agile, the Filipino weapon was a national pride during the Philippine Revolution and the Philippine-American War. You have no idea what it is though.\n\nAttack Damage: 21"); break;
            case 4:
              System.out.print("Roman Gladius\n\nIt sounds cool, looks cool, and also killed more people than any other weapon in human history before the invention of the gun. That being said, you feel like you're likely to harm yourself before someone else.\n\nAttack Damage: 22"); break;
            case 5:
              System.out.print("GunKnife\n\nIt looks like a gun, feels like a gun, shoots like a gun, but is a knife. I don't get it either.\n\nAttack Damage: 23"); 
              break;
            default: break;
          }
        }
        break;

      // Prompts user to select a weapon.
      case 2:
        System.out.print("Select the weapon you would like to equip:\n");
        for (int num : sword) {
          System.out.print("\n\t" + (num+1) + ". " + sword.get(num));
        }

        // Verifies user input.
        do {
          do {
            try {
              int choice = scan.nextInt();
              check = true;
            } catch (Exception e) {
              System.out.print("Error - Please enter an integer.");
              check = false;
            }
          } while (check == false);

          if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
            System.out.print("Please enter a valid option: ");
          }
        } while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5);

        // Displays weapon to be used.
        Collections.swap(sword, 0, choice);
        System.out.print("You equipped " + getWeaponName(sword.get(0)) + ".");
        
        break;
      default: break;
    }
  }

  /**
   * Displays food or water inventory.
   * Pre: None.
   * Post: Inventory is displayed.
   */
  public void viewInventory() {

    // Instantiating object and initializing variable.
    Storyline text = new Storyline();
    String line;

    // Display inventory
    line = "\n1: Amount of food\n2: Amount of water\n0: Quit\nEnter an option: ";
    text.textEffect(line);

    // Verifies user input.
    do {
      do {
        try {
          choice = scan.nextInt();
          check = true;
        } catch (Exception e) {
          System.out.print("Error - Input was not a valid choice.");
          check = false;
          System.out.print("Please enter a valid option (1, 2, 0): ");
        }
      } while (check = false);

      if (choice != 1 && choice != 2 && choice != 0) {
        System.out.print("Please enter a valid option (1, 2, 0): ");
      }
    } while (choice != 1 && choice != 2 && choice != 0);

    // Displays inventory amounts.
    if (choice == 1) {
      System.out.print("You have " + inventory.get(0) + " units of food.");
    } else if (choice == 2) {
      System.out.print("You have " + inventory.get(1) + " units of water.");
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