/*
 * Battle.java
 * This class is used to monitor the player's battles and 
 * actions.
 * Group 5: Maddy Angaran, Lynn John-Koshy, Erin Lee, 
 * Eugene Lee, Stanley Liu
 * ICS 4U
 * November 9th, 2020
 */

import java.util.*;

/**
 * The Battle Class is used to keep track of the player's 
 * battles, chances for a fight to occur, etc.. 
 */
public class Battle {

  // Initializing variables.
  Scanner scan = new Scanner(System.in);
  public Storyline text = new Storyline();
  private boolean running;
  private boolean notAttack;
  private boolean check;
  private String line;

  /**
   * Constructor.
   * Pre: None.
   * Post: Objects are instantiated.
   */
  public Battle() {
    running = true;
    check = true;
    line = "";
  }

  /**
   * Based on a random number and the amount of players 
   * in the habitat, a fight can occur.
   * Pre: None.
   * Post: If a fight occurs the boolean is set to true, 
   * else if the player is immune it is set to false.
   */
  public boolean fightOccur(Player player) { 
    boolean occur = false;
    int chance = random(1, 100);
    if (player.habitatPlayers() == 2) {
      if (chance < 31) {
        occur = true;
      }
    } else if (player.habitatPlayers() == 3) {
      if (chance < 46) {
        occur = true;
      }
    } else if (player.habitatPlayers() > 3){
      if (chance < 61) {
        occur = true;
      }
    }
    //checking if player is immune to battle
    if (player.getImmunity()) {
      occur = false;
      player.setImmunity(false);
    }
    return occur;
  }

  /**
   * If players are in the same location, a battle will 
   * occur.
   * Pre: Occur must be true.
   * Post: Players battle (both ai and player).
   */
  public void setFights(Player player, Inventory inv, ArrayList<Ai> aiList, AiBattle aiBattle, Storyline text, Graphics graphics) {
    boolean checking = true;
    boolean fight = false;
    ArrayList<Ai> used = new ArrayList<Ai>();
    for (Ai usedAi : used) { //used arraylist reset each time
      used.remove(usedAi);
    }

    player.checkHabitatPlayers(); //updates players in each habitat

    //as long as there is 1 other ai
    if (player.habitatPlayers() != 1) {
      for (int i = 0; i < aiList.size(); i++) {
        if (fight == false) { //while no fight has been started yet
          if (player.getLocation() == aiList.get(i).getLocation()) { //first ai that has same location as player
            // For visual orginization.
            text.textEffect3(graphics.dividerBattle()); 
            System.out.print("\n\n" + graphics.fight() + "\n\n");
            // Running a battle.
            System.out.print("\n\nOH NO! As you were trying to perform your action another player saw you and initiated a fight.\n");
            fight = true;
            used.add(aiList.get(i));
            startBattle(player, aiList.get(i), inv, aiList, text); //starts fight
          } 
        }
      }
    }

    //loops through aiList
    for (Ai ai : aiList) {
      boolean aiFight = false;
      //loops through aiList again
      for (int i = 0; i < aiList.size(); i++) {
        //while no fight has occurred yet
        if (aiFight == false) {
          if (used.contains(ai) == false && used.contains(aiList.get(i))) { //if neither is in a fight
            used.add(ai);
            used.add(aiList.get(i));
            aiBattle.aiFight(ai, aiList.get(i), aiList, player);
            aiFight = true;
          }
        }
      }
    }

    //dead Ai's must be removed outside of for loop to prevent ConcurrentModification Exception error
    for (Ai aiTemp : player.getDeadList()) {
      aiList.remove(aiTemp);
    }
  } 

  /**
   * Prompts user in battle asking what they would like 
   * to do (eg. hide, etc.) and ai player's attack.
   * Pre: None.
   * Post: Associate action is administered.  Returns the 
   * results of the battle
   */
  public void startBattle(Player playerA, Ai playerB, Inventory inv, ArrayList<Ai> ai, Storyline text) {
    boolean running = true;
    notAttack = true;
    int userResponse = 0;

    do {
      //PLAYER TURN
      // Only displays first option.
      if (notAttack == false) { 
        line = "\nEnter 1 to attack: ";
      // Displays all options.
      } else if (notAttack) {
        line = "\nWhat would you like to do?\n\t1: Attack\n\t2: Run\n\t3: Hide/Camoflauge\n\nEnter option: ";
      }
      text.textEffect(line);
      // Verifies user input.
      do {
        do {
          try {
            check = true;
            userResponse = scan.nextInt();
            System.out.print("\n");
            // Associated options.
            switch(userResponse) {
            //player attacking
              case 1: attack(playerA, playerB, inv, text); 
                String line = playerB.getName() + " has " + playerB.getHp() + " HP left.\n\n";
                text.textEffect(line);
                scan.nextLine(); break;
            //player running
              case 2: 
                running = run(); 
                if (running) {
                  attack(playerA, playerB, inv, text);
                } break;
            //player hiding
              case 3: 
                running = hide(playerA); break;
              }
          } catch (Exception e) {
            System.out.print("Error - Please enter a valid option (1, 2, 3): ");
            check = false;
            scan.nextLine();
          }
        } while (check == false);
        
        if (userResponse != 1 && userResponse != 2 && userResponse != 3) {
          System.out.print("Please enter a valid option (1, 2, 3): ");
        }
      } while (userResponse != 1 && userResponse != 2 && userResponse != 3);
      
      notAttack = false;

      //check if AI was killed
      if(!playerB.checkAlive()){
        //int mid = ai.indexOf(playerB.getName());
        ///playerA.deadAi(ai, mid); //kills the ai
        ///ai.remove(playerB); //removes ai from list
        playerA.deadAi(ai, ai.indexOf(playerB));
        playerA.addKill(); //adds to kill counter
        running = false; //unoffically end the fight
        line = "You won the fight!";
        text.textEffect(line);
        break; //to skip AI TURN + offically end the fight
      }

      //AI TURN (attack)
      if(!dodge(playerA, running) && running){
        playerA.addHp(-(int)(inv.getWeaponDamage(playerB.getAiWeapon())*playerB.getStrength()));
        //displaying events + player status
        text.aiAttacks(playerB.getName(), playerB.getAiWeapon());
        String line = "You have " + playerA.getHp() + " HP left.";
        text.textEffect(line);
        scan.nextLine();
      }

      //check if player was killed
      if(!playerA.checkAlive()) { 
        running = false; //end the fight
      }

    } while(running); 
    playerA.returnArray(ai);
  }

  /**
   * Players attack one another.
   * Pre: None.
   * Post: Stats are updated.
   */
  public void attack(Player player1, Ai player2, Inventory inv, Storyline text) {
    if(!dodge(player2)){
      player2.addHp(-(int)(inv.getWeaponDamage(inv.getWeapon())*player1.getStrength()));
      player1.addSanity(10); //resets when interacting
      text.userAttacks(player2.getName(), inv.getWeapon());
    } 
  }

  /**
   * Based on probability a player can dodge an attack.
   * Pre: None.
   * Post: They either dodge the attack or don't 
   * (boolean is set).
   */
  public boolean dodge(Player player1, boolean running){
    int chance = random(1, 100);
    if(chance < (int)65*player1.getDexterity()){
      if (!running) {
        //empty for text purposes
      } else {
        System.out.println("\nYou dodged the attack!");
      }
      return true;
    } else {
      return false;
    }
  }

  /**
   * Based on probability an ai player can dodge an 
   * attack.
   * Pre: None.
   * Post: They either dodge the attack or don't 
   * (boolean is set).
   */
  public boolean dodge(Ai ai){
    int chance = random(1, 100);
    if(chance < (int)20*ai.getDexterity()){
      System.out.println("\n" + ai.getName() + " dodged the attack!");
      return true;
    } else {
      return false;
    }    
  }

  /**
   * Based on probability a player can hide.
   * Pre: None.
   * Post: They either hide, or don't. If not, stats are 
   * changed (eg. boolean is set).
   */
  public boolean hide(Player player1) {
    int chance = random(1, 100);
    if (chance < 41) {
      System.out.println("You were found! Your hiding was unsuccessful...");
      return true;
    } else {
      System.out.println("You have sucessfully hid!");
      player1.setImmunity(true);
      player1.addSanity(-3);
      return false;
    }
    //returns if the user hides sucessfully or not 
  } 
  
  /**
   * Based on probability a player can camoflauge.
   * Pre: None.
   * Post: They either camoflauge, or don't. If not, 
   * stats are changed (eg. boolean is set).
   */
  public boolean camoflauge(Player player1) {
    int chance = random(1, 100);
    if (chance < 21) {
      System.out.println("You failed to hide!");
      return false;
    } else {
      player1.setImmunity(true);
      player1.addSanity(-3);
      System.out.println("You hid successfully!");
      return true;
    }
  }

  /**
   * Based on probability a player can run.
   * Pre: None.
   * Post: They either run or don't (boolean is set).
   */
  public boolean run() {
    int chance = random(1,100);
    if(chance < 61) {
      System.out.println("You failed to run away!");
      return true;
    } else {
      System.out.println("You escaped successfully!");
      return false;
    }
    //returns if the user escapes that fight
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