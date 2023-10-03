/*
 * Player.java
 * This class is used to monitor the all the player's in 
 * the game (including the type of character/player you 
 * are, health, etc.) actions.
 * Group 5: Maddy Angaran, Lynn John-Koshy, Erin Lee, 
 * Eugene Lee, Stanley Liu
 * ICS 4U
 * November 9th, 2020
 */

import java.util.ArrayList;

/**
 * The Player Class is used to keep track of the player's 
 * battles, chances for a fight to occur, etc.. 
 */
public class Player {

  // Initializing variables.
  private String name;
  private int location, hp, type, killNum, deadPeople;
  private int hunger, thirst, sanity;
  private double strength, dexterity;
  private boolean immune, playerOrAi;
  ArrayList<Integer> numPlayerInHabitat = new ArrayList<Integer>();
  ArrayList<String> used = new ArrayList<String>();
  ArrayList<Ai> aiList = new ArrayList<Ai>();
  ArrayList<Ai> dead = new ArrayList<Ai>();

  private Storyline text = new Storyline();

  // Other classes must access this
  public String[] names = {"Markus", "Karen", "Hunter", "Chris", "Theo", "Nina", "Kasper", "Rose", "Andreas", "Kiana", "Vico", "Klaus", "Celeste", "Oskar", "Kenzo", "Elle", "Tomi", "Landon", "Ivana", "Carelton", "Harry", "Liam", "Isabella", "Amelie"};

  /**
   * Constructor.
   * Pre: None.
   * Post: Objects are instantiated.
   */
  public Player(String playerName, int typeEntered) {
    
    // Keeping track of number of players in each habitat.
    for (int i = 0; i < 4; i++) {
      numPlayerInHabitat.add(0);
    }

    for (int i = 0; i < 12; i++) {
      int j = 0;
      do {
        j = random(0, 23);
      } while (used.contains(names[j]) == true);

      aiList.add(new Ai(names[j]));
      used.add(names[j]);
    }

    name = playerName;
    type = typeEntered;
    location = 4;
    hp = 100;
    hunger = 10;
    thirst = 3;
    sanity = 10;

    if (type == 1) {
      strength = 1.25;
      dexterity = 1.25;
    } else {
      strength = 1;
      dexterity = 1;
    }

    immune = false;
    playerOrAi = true;
  }

  /**
   * Returns the array element.
   * Pre: None.
   * Post: Element is returned.
   */
  public String string() {
    int j = random(0, 23);
    String s = names[j];
    return s;
  }
  
  //ACCESSING PLAYER FEATURES

  /**
   * Returns the location of players.
   * Pre: None.
   * Post: Location is returned.
   */
  public int getLocation() {
    return location;
  }

  /**
   * Sets the new location using a parameter.
   * Pre: Location must be associated with habitat 
   * indexes.
   * Post: Location is set.
   */
  public void setLocation (int loca) {
    location = loca;
  }

  public void deadPeople() {
    deadPeople++;
  }

  public int getDeadPeople() {
    return deadPeople;
  }
  
  /**
   * Checks/sets number of players in habitat.
   * Pre: None.
   * Post: Sets location for players.
   */
  public void checkHabitatPlayers() {
    int mid = 0;
    for (int i = 0; i < 4; i ++) {
      for (int j = 0; j < aiList.size(); j++) {
        if (aiList.get(j).getLocation() == i) {
          mid++;
        }
      }
      numPlayerInHabitat.set(i, mid);
    }

    int midNum = numPlayerInHabitat.get(location);
    numPlayerInHabitat.set(location, midNum + 1);
  }

  /**
   * Returns the player's location.
   * Pre: None.
   * Post: Location is returned.
   */
  public int habitatPlayers() {
    return numPlayerInHabitat.get(location);
  }

  /**
   * Returns the number of players left.
   * Pre: None.
   * Post: Number of players left is returned.
   */
  public int numPlayers() {
    int playersLeft = 0;
    for (int i = 0; i < 4; i++) {
      playersLeft += numPlayerInHabitat.get(i);
    } 
    return playersLeft;
  }
  
  /**
   * Adds dead ai players to a dead array list and 
   * removes them from the current array list.
   * Pre: i must be a valid index value.
   * Post: Arraylists are updated.
   */
  public void deadAi(ArrayList<Ai> ai, int i){
    dead.add(ai.get(i));
  }

  /**
   * Transports remaining players to final location (in 
   * the center of the map).
   * Pre: None.
   * Post: Location is set to the fourth index value.
   */
  public void teleport() {
    location = 4;
  }

  /**
   * Returns the name of the player.
   * Pre: None.
   * Post: Name is returned.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the type.
   * Pre: None.
   * Post: Type is returned.
   */
  public int getType() {
    return type;
  }
 
  /**
   * Hp is updated and verfified it is within range.
   * Pre: None.
   * Post: New hp is set.
   */
  public void addHp(int amt) {
    hp += amt;
    hp = checkRange(hp, 100);
  }

  /**
   * Returns the value of hp.
   * Pre: None.
   * Post: Hp is returned.
   */
  public int getHp() {
    return hp;
  }

  /**
   * Hunger is updated and verified it is within range.
   * Pre: None.
   * Post: New value of hunger is set.
   */
  public void addHunger(int amt) {
    hunger += amt;
    hunger = checkRange(hunger, 10);
  }

  /**
   * Returns the value of hunger.
   * Pre: None.
   * Post: Hunger is returned.
   */
  public int getHunger() {
    return hunger;
  }

  /**
   * Thirst is updated and verified it is within range.
   * Pre: None.
   * Post: New value of thirst is set.
   */
  public void addThirst(int amt) {
    thirst += amt;
    thirst = checkRange(thirst, 3);
  }

  /**
   * Returns the value of thirst.
   * Pre: None.
   * Post: Thirst is returned.
   */
  public int getThirst() {
    return thirst;
  }

  /**
   * Sanity is updated and verified it is within range.
   * Pre: None.
   * Post: New value of sanity is set.
   */
  public void addSanity(int amt) {
    //-2 if turn results in no human interaction
    //resets to 10 otherwise
    sanity += amt;
    sanity = checkRange(sanity, 10);
  }

  /**
   * Sanity value is returned.
   * Pre: None.
   * Post: Returns sanity.
   */
  public int getSanity() {
    return sanity;
  }

  /**
   * Sets the immunity boolean.
   * Pre: None.
   * Post: Immunity boolean is set.
   */
  public void setImmunity(boolean var){
    immune = var;
  }

  /**
   * Immunity boolean is returned.
   * Pre: None.
   * Post: Returns immunity.
   */
  public boolean getImmunity(){
    return immune;
  }

  /**
   * Keeps the amount (for stats) within the mix/max 
   * range (0 to max inclusive).
   * Pre: None.
   * Post: Sets the amount to the maximum value if it 
   * goes above the maximum value.
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
   * Called every time before using a weapon (used in 
   * Battle class), determines the strength based on the 
   * weapon.
   * Pre: None.
   * Post: Sets the strength for the player based on 
   * their weapon and hunger.
   */
  public void setStrength() { 
    if (type == 1) {
      strength = hunger/8;
    } else {
      strength = hunger/10;
    }
  }
  
  /**
   * Strength value is returned.
   * Pre: None.
   * Post: Returns strength.
   */
  public double getStrength() {
    return strength;
  }

  /**
   * Dexterity value is set but dividing hunger by 10.
   * Pre: None.
   * Post: Dexterity is set.
   */
  public void setDexterity() {
    dexterity = hunger/10;
  }
  
  /**
   * Dexterity value is returned.
   * Pre: None.
   * Post: Returns dexterity.
   */
  public double getDexterity() {
    return dexterity;
  }

  /**
   * Adds to kills.
   * Pre: None.
   * Post: Counter adds one.
   */
  public void addKill(){
    killNum++;
  }

  /**
   * Returns kills.
   * Pre: None.
   * Post: Kills are returned.
   */
  public int getKillNum(){
    return(killNum);
  }

  /**
   * Returns aiList (names).
   * Pre: None.
   * Post: Returns aiList.
   */
  public ArrayList<Ai> getAiList(){
    return aiList;
  }

  /**
   * Returns dead ai (names).
   * Pre: None.
   * Post: Returns getDeadList.
   */
  public ArrayList<Ai> getDeadList() {
    return dead;
  }

  /**
   * Sets updated aiList (names).
   * Pre: None.
   * Post: ArrayList is updated.
   */
  public void returnArray(ArrayList<Ai> aiL) {
    aiList = aiL;
  } 

  /**
   * Determines which ai is dead.
   * Pre: None.
   * Post: Ai is set to dead.
   */
  public void returnDead(ArrayList<Ai> aiD) {
    dead = aiD;
  }

  /**
   * Runs default background processes (changes stats 
   * after every turn).
   * Pre: None.
   * Post: Stats are changed.
   */
  public void playerTurn() {
    addHunger(-2);
    addThirst(-1);
    addSanity(-2);
  }

  /**
   * Checks to see if player is still alive (based on 
   * stats).
   * Pre: None.
   * Post: Sets boolean to true (if alive) or false (if 
   * dead).
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
   * Checks to see if game should end.
   * Pre: Alive is set to true or false.
   * Post: If alive is set to false, the game ends.
   */
  public void endGame(boolean alive) {
    if (alive == false) {

    }
  }

  // ACTIONS

  /**
   * Based on resources available and number of players, 
   * food may or may not be added to inventory.
   * Pre: None.
   * Post: Inventory food may or may not be added, and 
   * total hours is updated.
   */
  public void hunt(Inventory inv, FrostBite frost, DesertedDesert desert, JumanjiJungle jungle, RisingWater waterH, HabitatMain habit) {
    //Depends on inventory
    //To "consume" inventory enter negative values
    //refers to methods from habitat class, check
    int food = 0;
    switch(location) {
      case 0:
        food = desert.getFoodResources();
      case 1:
        food = frost.getFoodResources();
      case 2:
        food = jungle.getFoodResources();
      case 3:
        food = waterH.getFoodResources();
      default: break;
    }
    
    // Based on number of players, food may be added.
    if (habitatPlayers() <= food) {
      inv.addFood();
      text.actionHunt(location);
    } else if (habitatPlayers() > food) {
      int chance = random(1, 100);
      if (chance < 75) {
        inv.addFood();
        text.actionHunt(location);
      } else {
        System.out.print("You come back to your campsite empty-handed.");
      }
    }
    habit.totalHours(3); 
  }

  /**
   * Based on resources available and number of players, 
   * water may or may not be added to inventory.
   * Pre: None.
   * Post: Inventory of water may or may not be added, 
   * and total hours is updated.
   */
  public void dowsing(Inventory inv, FrostBite frost, DesertedDesert desert, JumanjiJungle jungle, RisingWater waterH, HabitatMain habit) {
    int water = 0;
    switch(location) {
      case 0:
        water = desert.getWaterResources(); 
      case 1:
        water = frost.getWaterResources();
      case 2:
        water = jungle.getWaterResources();
      case 3:
        water = waterH.getWaterResources();
      default: break;
    }

    // Based on number of players, water may be added.
    if (habitatPlayers() <= water) {
      inv.addWater();
    } else {
      int chance = random(1, 100);
      if (chance < 75) {
        inv.addWater();
        text.actionDowsing(location);
      } else {
        System.out.print("Your quest for water was unsuccessful.");
      }
    }
    habit.totalHours(3);
  }

  /**
   * Location is changed.
   * Pre: None.
   * Post: New location is set and totalHours is updated.
   */
  public void changeLocation(int newLocation, HabitatMain habit){
    location = newLocation;
    habit.totalHours(5);
  }

  /**
   * Player "sleeps" and hp is gained.
   * Pre: None.
   * Post: Hp and totalHours is updated.
   */
  public void sleep(HabitatMain habit) {
    addHp(50);
    habit.setTime(8); //goes to morning time
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