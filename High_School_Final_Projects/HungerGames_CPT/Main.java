/* 
 * Main.java
 * This program is used to run the the functions of the 
 * various classes in order to run the game.
 * Group 5: Maddy Angaran, Lynn John-Koshy, Erin Lee, 
 * Eugene Lee, Stanley Liu
 * ICS 4U1
 * November 9th, 2020
 */

import java.util.Scanner;
import java.util.ArrayList;

/**
 * The Main Class is used access the other classes within 
 * this project. 
 */
class Main {
  public static void main(String[] args) {
    
    // Instantiating objects
    Scanner scan = new Scanner(System.in);
    HabitatMain hab = new HabitatMain();
    DesertedDesert desert = new DesertedDesert();
    FrostBite frost = new FrostBite();
    JumanjiJungle jungle = new JumanjiJungle();
    RisingWater ocean = new RisingWater();
    Battle battle = new Battle();
    AiBattle aiBattle = new AiBattle();
    Inventory inv = new Inventory();
    Storyline text = new Storyline();
    Graphics graphics = new Graphics();
    HighScore hs;

    // Initialzing variables.
    int type = 0;
    int choice = 0;
    boolean check = true;
    String answer, s1, s2, name, cont;

    //Intializing variables for the turn-based loop.
    boolean running = true;
    boolean endGame = false;
    boolean win = false;
    boolean day = true;
    int input = 0;
    int numHalfDays = 0;
    
    // Descriptions of location.
    text.platformRising();
    s1 = "\n\n" + graphics.group() + "\n\n";
    text.textEffect(s1);
    s2 = "\n\n" + graphics.title() + "\n\n";
    text.textEffect(s2);
    
    // Introduction to the game.
    text.intro();

    // Verfies that user whats to play the game.
    do {
      System.out.print("\nAnswer (YES or NO): ");
      answer = scan.nextLine();
    } while (!(answer.equalsIgnoreCase("yes")) && (!answer.equalsIgnoreCase("no")));

    // If user does not want to play, this text is displayed.
    if (answer.equalsIgnoreCase("no")) {
      text.isReady();
    } 

    // Cont. description.
    text.platformRising();
    text.platformRising();
    

    //Loops if the user has not actually entered any characters in their name
    do {
      text.prompting();
      name = scan.next();

      // Removes spaces in the name (A name should be one word)
      name = name.replaceAll(" ", ""); 

      // Conditional to let the user know to enter a valid name
      if (name.equals("")) { 
        System.out.println("Please enter a valid name.");
      }
    } while (name.equals(""));
    
    // Cont. description.
    //text.platformRising();
    text.prompting();
    
    // Verfies user input.
    do {
      do {
        try {
          check = true;
          type = scan.nextInt();
        } catch (Exception e) {
          System.out.print("Error - Please enter a valid option (1, 2, 3, 4): ");
          check = false;
          scan.nextLine(); // Prevents the catch code from looping if activated
        }
      } while (!check);

      if (type != 1 && type != 2 && type != 3 && type != 4) {
        System.out.print("Please enter a valid option (1, 2, 3, 4): ");
      }
    } while (type != 1 && type != 2 && type != 3 && type != 4);

    // Creating new player object.
    Player player = new Player(name, type);

    // Cont. description and countdown.
    text.platformRising();
    text.platformRising();
    text.countDown();

    // Prompts user for first option answer and verifies answer.
    text.begin();
    do {
      do {
        try {
          choice = scan.nextInt();
          check = true;
        } catch (Exception e) {
          System.out.print("Error - Please enter a valid option (1, 2): ");
          check = false;
          scan.nextLine();
        }
      } while (!check);

      if (choice != 1 && choice != 2) {
        System.out.print("Please enter a valid option (1, 2): ");
      }
    } while (choice != 1 && choice != 2);

    // Generates a random for the user to use.
    switch (choice) {
      case 1:
        inv.generateWeapon();
        String line = "\nYou rush to the center and grab the first weapon you see. You look down and realize you've grabbed a " + inv.getWeaponName(inv.getWeapon()) + ".\n";
        String line2 = "\nUnfortunately, there's no time to think. Another person is running towards you, ready for a fight. You draw your weapon and prepare yourself.\n";
        
        // Text will be displayed with an effect 
        text.textEffect(line);
        text.textEffect(line2);

        // Begins a battle between two players.
        int i = random(0, player.getAiList().size() - 1);
        battle.startBattle(player, player.getAiList().get(i), inv, player.getAiList(), text); 

        if(!player.checkAlive()){
          running = false;
          break; //break statement necessary for one-time use
        }
        
        // Prompts user of different habitats they can travel to.
        text.travel();

        // Verifies user input.
        do {
          do {
            try {
              choice = scan.nextInt();
              check = true;
            } catch (Exception e) {
              System.out.print("Error - Please enter a valid option (1, 2, 3, 4): ");
              check = false;
              scan.nextLine();
            }
          } while (check == false);

          if (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
            System.out.print("Please enter a valid option (1, 2, 3, 4): ");
          }
        } while (choice != 1 && choice != 2 && choice != 3 && choice != 4);
        player.setLocation(choice - 1);

        // Description of running towards a habitat.
        text.runToHabitat();

        // Displays each habitats graphics.
        // It is choice -1 to meet index values.
        switch (choice - 1) {
          case 0:
            System.out.print("\n\n" + graphics.divider() + "\n\n");
            System.out.print("\n" + graphics.desertTitle() + "\n\n");
            text.desertedDesert(graphics); break;
          case 1:
            System.out.print("\n\n" + graphics.divider() + "\n\n");
            System.out.print("\n" + graphics.frostTitle() + "\n\n");
            text.frostBite(graphics); break;
          case 2:
            System.out.print("\n\n" + graphics.divider() + "\n\n");
            System.out.print("\n" + graphics.jungleTitle() + "\n\n");
            text.jumanjiJungle(graphics); break;
          case 3:
            System.out.print("\n\n" + graphics.divider() + "\n\n");
            System.out.print("\n" + graphics.waterTitle() + "\n\n");
            text.risingWater(graphics); break;
          default: break;
        } 
        break;
        
      // Send player to habitat.
      case 2: 
        // Prompts user of different habitats they can travel to.
        text.travel();

        // Verifies user input.
        do {
          do {
            try {
              choice = scan.nextInt();
              check = true;
            } catch (Exception e) {
              System.out.print("Error - Please enter a valid option (1, 2, 3, 4): ");
              check = false;
              scan.nextLine();
            }
          } while (check == false);

          if (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
            System.out.print("Please enter a valid option (1, 2, 3, 4): ");
          }
        } while (choice != 1 && choice != 2 && choice != 3 && choice != 4);
          
        // Sets new location.
        player.setLocation(choice - 1);

        // Describes player running to a habitat.
        text.runToHabitat();


        // Displays each habitats graphics.
        // It is choice -1 to meet index values.
        switch (choice - 1) {
          case 0:
            System.out.print("\n\n" + graphics.divider() + "\n\n");
            System.out.print("\n" + graphics.desertTitle() + "\n\n");
            text.desertedDesert(graphics); break;
          case 1:
            System.out.print("\n\n" + graphics.divider() + "\n\n");
            System.out.print("\n" + graphics.frostTitle() + "\n\n");
            text.frostBite(graphics); break;
          case 2:
            System.out.print("\n\n" + graphics.divider() + "\n\n");
            System.out.print("\n" + graphics.jungleTitle() + "\n\n");
            text.jumanjiJungle(graphics); break;
          case 3:
            System.out.print("\n\n" + graphics.divider() + "\n\n");
            System.out.print("\n" + graphics.waterTitle() + "\n\n");
            text.risingWater(graphics); break;
            default: break;
        } 
          
        // Generates a weapon to use.
        inv.generateWeapon();
        String s = "\nAfter arriving at your location, you find a " + inv.getWeaponName(inv.getWeapon()) + " lying on the ground.\n";
        s2 = "You put it in your back pocket; it's sure to be handy in the near future.\n";

        // Text Effect.
        text.textEffect(s);
        text.textEffect(s2); break;

      default: break;
    }


    // Entire game (day by day).
    while (running) {
      //displaying daytime text
      if(numHalfDays != 0){
        text.day();
      }

      // Daytime turn.
      while (day && running) {
        //Displays player stats
        inv.viewStatsLine(player);

        // Displays options menu.
        dayTimeOptions(player, graphics);

        // Getting valid user input.
        if (player.getLocation() == 1) {
          System.out.print("Enter option (0-8): ");
        } else {
          System.out.print("Enter option (0-7): ");
        }
        do {
          do {
            try {
              input = scan.nextInt();
              check = true;
            } catch (Exception e) {
              if (player.getLocation() == 1) {
                System.out.print("Error - Please enter a valid option (0-8): ");
              } else {
                System.out.print("Error - Please enter a valid option (0-7): ");
              }
              check = false;
              scan.nextLine();
            }
          } while (!check);
          if (input < 0 || input > 8) {
            if (player.getLocation() == 1) {
              System.out.print("Please enter a valid option (0-8): ");
            } else {
              System.out.print("Please enter a valid option (0-7): ");
            }
          }
        } while (input < 0 || input > 8);
        player.checkHabitatPlayers();
        // Running the chances of encountering an enemy.
        if (battle.fightOccur(player)) {
          battle.setFights(player, inv, player.getAiList(), aiBattle, text, graphics); 
        } else { 
          // Executing requested action.
          switch (input) {
            case 0:
              day = false;
              // Exits condition.
              running = false; break; 
            case 1: //Hunting.
              player.hunt(inv, frost, desert, jungle, ocean, hab); break;
            case 2: // Getting water.
              player.dowsing(inv, frost, desert, jungle, ocean, hab); break;
            case 3: //Cooking/eating.
              if (player.getType() == 4) {
                inv.cook(player, player.getLocation());
              } else {
                inv.eat(player, player.getLocation());
              } break;
            case 4: // Drinking water.
              inv.drink(player, player.getLocation()); break;
            case 5: // Player travels to different location.
              player.changeLocation(getNewLocation(player.getLocation(), graphics, text), hab); 
              text.runToHabitat(); break;
            case 6: // Special "seeing" ability.
              if (player.getType() == 3) {
                player.checkHabitatPlayers();
                System.out.print("There are " + player.habitatPlayers() + " in your region. ");
              } else {
                System.out.print("You don't have access to that ability. ");
              } break;
            case 7: //Looking at player's inventory.
              inv.invSee(player); break;
            case 8: // Adds frost bitie inventory supplies.
              if (player.getLocation() == 1) {
                frost.findSupplies(inv); break;
              }
          }
        }

        // Updates the number of players in each habitat.
        player.checkHabitatPlayers();

        // Check time of day.
        day = hab.timeOfDay();
        
        // Check player status.
        // If player is not alive.
        if (!player.checkAlive()) { 
          win = false; //They lost.
          running = false; // Ends game.
        }

        if(player.getAiList().size() == 1){
          day = true; // Skips night time turns.
          endGame = true; // Sends player to end game.
          break; // Exits day time.
        }

        // Checks how many half days have passed.
        if (!day) {
          numHalfDays++;
        }
      }
      
      // Habitat event (happens at the end of each day).
      switch (player.getLocation()) {
        case 0:
          desert.event(player, inv); break;
        case 1:
          frost.event(player, inv); break;
        case 2:
          jungle.event(player, inv); break;
        case 3:
          ocean.event(player, inv);
        default: break;
      }

      //updates player stats (decreases approriate thingys)
      if (player.checkAlive()) {
        player.playerTurn();
      }
      
      // If player is not alive.x
      if (!player.checkAlive()) { 
        win = false; // They lost.
        running = false; // Ends game.
        day = true; // Skips night time.
      }

      if(player.getAiList().size() == 1){
        day = true; // Skips night time turns.
        endGame = true; // Sends player to end game.
      }
      
      if (running) {
        text.playerDeathNames(player, player.getDeadList(), graphics);
      }
      
      // Displays nighttime text.
      text.night();

      // Nighttime turn.
      while (!day && running) {
        //Displays player stats
        inv.viewStatsLine(player);
  
        // Displays nighttime options.
        nightTimeOptions(player, graphics);

        // Getting valid user input.
        System.out.print("Enter option (0-5): ");
        do {
          do {
            try {
              input = scan.nextInt();
              check = true;
            } catch (Exception e) {
              System.out.print("Error - Please enter a valid option (0-5): ");
              check = false;
              scan.nextLine();
            }
          } while (!check);
          if (input < 0 || input > 5) {
            System.out.print("Please enter a valid option (0-5): ");;
          }
        } while (input < 0 || input > 5);
        
        // Running the chances of player encountering an enemy.
        if (battle.fightOccur(player)) {
          // For visual orginization.
          graphics.dividerBattle(); 
          System.out.print("\n\n" + graphics.fight() + "\n\n");
          // Running a battle.
          battle.setFights(player, inv, player.getAiList(), aiBattle, text, graphics); 
        } else {
          // Execute requested action.
          switch (input) {
            case 0: 
              // Exit condition.  
              running = false; break; 
            case 1: //sleeping
              player.sleep(hab); 
              text.sleep(); 
              System.out.print("\n\n" + graphics.sleeping() + "\n\n"); break;
            case 2: // Getting water.
              player.dowsing(inv, frost, desert, jungle, ocean, hab); break;
            case 3: // Eating/cooking food.
              if (player.getType() == 4) {
                inv.cook(player, player.getLocation());
              } else {
                inv.eat(player, player.getLocation());
              } break;            
            case 4: // Drinking water.
              inv.drink(player, player.getLocation()); break;
            case 5: //looking at inventory
              inv.invSee(player); break;
          }
        }

        // Updates number of players in the habitats.
        player.checkHabitatPlayers();

        // Check time of day.
        day = hab.timeOfDay();

        // Check player status.
        if (!player.checkAlive()) { // If player is not alive.
          win = false;
          running = false; // Ends game.
        }

        if (player.getAiList().size() == 1) {
          day = true; // Ends night time turns.
          endGame = true;
        }

        // Calculates number of half days.
        if (day && player.getAiList().size() != 1) { // Does not count the current night as having passed if the user is sent to a death match
          numHalfDays++;
        }
      }

      // Gets total ai stats.
      for (int i = 0; i < player.getAiList().size(); i++) {
        player.getAiList().get(i).aiAction(player, player.getAiList());
        player.getAiList().get(i).hpLoss();
        player.getAiList().get(i).hpGain();
      }

      // At the end, they final players battle till death.
      if (endGame) {
        hab.deathMatch(player.getAiList(), player, battle, inv, text);
        // Check player status
        if (player.checkAlive()) { //If player is alive.
          win = true; // They win.
        } else {
          win = false; // If they are dead, they lose.
        }
        running = false; // End game.
      }
    }
  
    // Sisplaying appropriate game results (win or lose).
    if (win) {
      System.out.print("\n\n" + graphics.winner() + "\n\n");
      text.playerWin();
    } else {
      System.out.print("\n\n" + graphics.lose() + "\n\n");
      text.playerDeath();
    }

    // Text for score and divider.
    text.score();
    graphics.divider(); 

    // High Score list.
    System.out.print("\n\n" + graphics.highScores() + "\n");

    // Calculates High Scores. 
    hs = new HighScore(name, 13 - player.getDeadPeople(), player.getKillNum(), numHalfDays, player.getHp(), player.getHunger(), player.getThirst(), player.getSanity());
    
    // Displays high score.
    hs.showHighScores();

    // Divider and end credits.
    graphics.divider(); 
    text.endCredits();
    
    // End graphics.
    System.out.print("\n" + graphics.theEnd());
  }

  /**
   * Displays the options menu the player has during the 
   * day time.
   * Pre: None.
   * Post: Prints out options.
   */
  public static void dayTimeOptions(Player player, Graphics graphics) {
    
    // Instantiating object and Initializing variables.
    Storyline text = new Storyline();
    String line;

    // Adds a divider.
    graphics.divider();

    // Displays menu.
    line = "\nAction menu:\n\t0: EXIT GAME\n\t1: Hunt\n\t2: Dowsing\n";
    text.textEffect(line);

    // Dependant on what type of character you are.
    if (player.getType() == 4) {
      line = "\t3: Cook\n";
    } else {
      line = "\t3: Eat\n";
    }
    text.textEffect(line);

    // Cont. print menu.
    line = "\t4: Drink\n\t5: Change Location\n\t6: Sixth Sense Ability\n\t7: Check Player Stats/Inventory\n";
    text.textEffect(line);

    // If it is the location with supplies, this option is added. 
    if (player.getLocation() == 1){
      line = ("\t8: Search for supplies\n");
      text.textEffect(line);
    }
    
  }

  /**
   * Displays the options menu the player has during the 
   * night time.
   * Pre: None.
   * Post: Prints out options.
   */
  public static void nightTimeOptions(Player player, Graphics graphics) {

    // Instantiating object and Initializing variables.
    Storyline text = new Storyline();
    String line;
    
    // Adds a divider.
    graphics.divider();
    
    // Displays menu.
    line = "\nAction menu:\n\t0: EXIT GAME\n\t1: Sleep\n\t2: Dowsing\n";
    text.textEffect(line);

    if (player.getType() == 4) {
      line = "\t3: Cook\n";
    } else {
      line = "\t3: Eat\n";
    }
    text.textEffect(line);

    line = "\t4: Drink\n\t5: Check Player Stats/Inventory\n";
    text.textEffect(line);
    
  }

  /**
   * Finds the locations the player is near.
   * Pre: int currentLocation between 0-3 (inclusive)
   * Post: Displays the locations the player can travel 
   * to, returns the new location, and displays 
   * appropriate text/ascii art
   */
  public static int getNewLocation(int currentLocation, Graphics graphics, Storyline text) {

    // Instantiating scanner.
    Scanner scan = new Scanner(System.in);

    boolean check = true;
    // Changes location.
    int option1 = currentLocation + 1;
    int option2 = currentLocation - 1;
    int input = 0;

    if (option1 > 3) {
      option1 = 0;
    }
    if (option2 < 0) {
      option2 = 3;
    }


    //  Displays location.
    System.out.println("You are @ location: " + getHabitatName(currentLocation));
    System.out.println("You can travel to: \n" + option1 + ". " + getHabitatName(option1) + "\n" + option2 + ". " + getHabitatName(option2));
    
    System.out.print("Enter your new location choice: ");
    do {
      do {
        try {
          check = true;
          input = scan.nextInt();
        } catch (Exception e) {
          System.out.print("Error - Please enter a valid option (" + option1 + ", " + option2 + "): ");
          check = false;
          scan.nextLine();
        }
      } while (check == false);
      if (input != option1 && input != option2) {
        System.out.print("Please enter a valid option (" + option1 + ", " + option2 + "): ");
      }
    } while (input != option1 && input != option2);

    // Displays different habitats.
    switch (input) {
      case 0: 
        System.out.print("\n\n" + graphics.divider() + "\n\n");
        System.out.print(graphics.desertTitle() + "\n\n");
        text.desertedDesert(graphics); break;
      case 1: 
        System.out.print("\n\n" + graphics.divider() + "\n\n");
        System.out.print(graphics.frostTitle() + "\n\n");
        text.frostBite(graphics); break;
      case 2: 
        System.out.print("\n\n" + graphics.divider() + "\n\n");
        System.out.print(graphics.jungleTitle() + "\n\n");
        text.jumanjiJungle(graphics); break;
      case 3: 
        System.out.print("\n\n" + graphics.divider() + "\n\n");
        System.out.print(graphics.waterTitle() + "\n\n");
        text.risingWater(graphics);
    }

    return input;
  }
  
  public static String getHabitatName(int locate) {
    String s = "";
    switch (locate) {
      case 0:
        s = "DesertedDesert"; break;
      case 1:
        s = "FrostBite"; break;
      case 2:
        s = "JumanjiJungle"; break;
      case 3:
        s = "RisingWater"; break;
    }
    return s;
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