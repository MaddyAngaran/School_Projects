/*
 * Storyline.java
 * This class contains all storyline text needed in the 
 * game.
 * Group 5: Maddy Angaran, Lynn John-Koshy, Erin Lee, 
 * Eugene Lee, Stanley Liu.
 * ICS 4U
 * November 9th, 2020
 */

import java.util.Scanner;
import java.util.ArrayList;

/**
 * The Storyline Class includes all text needed to be 
 * displayed in the game (including a text effect). 
 */
 public class Storyline { // Start class definition.
 
  // Initializing variables.
  private String line, cont;
  private int counter; // Rising platform.
  private int counterP; // Prompting.
  private int counterD; // Desert.
  private int counterF; // FrostBite.
  private int counterJ; // Jungle.
  private int counterW; // Flood.
  private int counterN; // Night.
  private int counterAE; // Action of Eating
  private int counterAD; // Action of Drinking
  private int counterAH; // Action of Hunting
  private int counterADo; // Action of Dowsing
  private int counterUA; // Player attacks
  private int counterAIA; // AI attacks
  Scanner scan = new Scanner(System.in);

  /**
   * Constructor.
   * Pre: None.
   * Post: Variables are initialized.
   */
  public Storyline() {
    line = "";
    counter = 0;
    counterP = 0;
    counterD = 0;
    counterF = 0;
    counterJ = 0;
    counterW = 0;
    counterN = 0;
    counterAE = 0;
    counterAD = 0;
    counterAH = 0;
    counterADo = 0;
  }

  /**
   * Displays the text animation effect faster.
   * Pre: None.
   * Post: Affect is applied.
   */
  public void textEffect(String line) {
    for (int i = 0; i < line.length(); i++) {
      System.out.printf("%c", line.charAt(i));
      try {
        Thread.sleep(17);
      } catch(InterruptedException e) {
          Thread.currentThread().interrupt();
      }
    }
  }

  /**
   * Displays the text animation effect slower.
   * Pre: None.
   * Post: Affect is applied.
   */
  public void textEffect2(String line){
    for (int i = 0; i < line.length(); i++) {
      System.out.printf("%c", line.charAt(i));
      try {
        Thread.sleep(50);
      } catch(InterruptedException e) {
          Thread.currentThread().interrupt();
      }
    }
  }

  /**
   * Displays the text animation effect faster.
   * Pre: None.
   * Post: Affect is applied.
   */
  public void textEffect3(String line){
    for (int i = 0; i < line.length(); i++) {
      System.out.printf("%c", line.charAt(i));
      try {
        Thread.sleep(2);
      } catch(InterruptedException e) {
          Thread.currentThread().interrupt();
      }
    }
  }

  /**
   * Displays the text animation effect slower.
   * Pre: None.
   * Post: Affect is applied.
   */
  public void textEffect4(String line){
    for (int i = 0; i < line.length(); i++) {
      System.out.printf("%c", line.charAt(i));
      try {
        Thread.sleep(200);
      } catch(InterruptedException e) {
          Thread.currentThread().interrupt();
      }
    }
  }

  /**
   * Displays opening credits of the game.
   * Pre: None.
   * Post: Statements are printed.
   */
  public void intro() {
    line = "\nWelcome to the first annual Thirsty Games!";
    textEffect(line);
    scan.nextLine();

    line = "\nIt is a privilege and honour to have our first ever volunteer for such an occasion.";
    textEffect(line);
    scan.nextLine();

    line = "\nYou will test your limits, find your niche, and most importantly fight till death in our games. How you survive is all up to you.";
    textEffect(line);
    scan.nextLine();

    line = "\nThis is not a ripoff of the Hunger Games(tm), but rather the Thirsty Games(tm pending)!";
    textEffect(line);
    scan.nextLine();

    line = "\n\nThe rules are simple...\n\t1) Wait for the countdown.\n\t2) Choose to gather supplies or start your journey in a habitat.\n\t3) Find inventory and supplies.\n\t4) Be the last player standing.";
    textEffect(line);
    scan.nextLine();

    line = "\nYour journey will begin soon... are you ready? (Press ENTER)";
    textEffect(line);
  }

  /**
   * Displays that user must play.
   * Pre: None.
   * Post: Statements are printed.
   */
  public void isReady(){
    line = "\nAhhh so funny story.. looks like no one else volunteered, so I guess it's up to you, hehe. ";
    textEffect(line);
    scan.nextLine();
  }
  
  /**
   * Displays that the platform is rising.
   * Pre: None.
   * Post: Statements are printed.
   */
  public void platformRising() {
    switch(counter) { 
      case 0:
        line = "\nPlease enlarge/stretch the output stream to full size for best quality. Press ENTER when done. ";
        textEffect(line);
        scan.nextLine();

        line = "\nPlease note to press ENTER to continue at ALL times!";
        textEffect(line);
        scan.nextLine();

        counter++;
        break;
      case 1:
        line = "\n\nAn eerie silence hangs in the air. You've been walking down a dimly lit hallway for God only know's how long. You arrive at a small circular platform. Above it is a tunnel, stretching so far you can't see the end of it. The moment you step onto the platform, it starts to rise.";
        textEffect(line);
        scan.nextLine();
        counter++; break;
      case 2:
        line = "\nAs you ascend, an empty feeling in your stomach begins to grow. You try to recall your name, a word that holds everything you were and everything you will be.";
        textEffect(line);
        scan.nextLine();
        counter++; break;
      case 3:
        line = "\nAs the platform continues to rise, a bright white light begins creeping through the cracks of the walls... it's almost time.";
        textEffect(line);
        scan.nextLine();
        counter++; break;
      case 4:
        line = "\nLooking straight up, the light becomes brighter and brighter, bigger and bigger, until it envelopes you in its warm glow. You feel the platform come to a halt, and a cool breeze flows through the air. You've arrived.";
        textEffect(line);
        scan.nextLine();
        counter++; break;
      case 5:
        line = "\nYou suddenly feel naked, vulnerable. A loud voice booms from seemingly out of nowhere.";
        textEffect(line);
        scan.nextLine();
        counter++; break;
    }
  }


  /**
   * Prompts user for their name and character 
   * selection.
   * Pre: None.
   * Post: Statements are printed.
   */
  public void prompting() {
    switch(counterP) {
      case 0:
        line = "\nWhat is your name? (Please enter one word): ";
        textEffect(line);
        
        counterP++; break;
      case 1:
        //ability choices
        //After case 2 in platform rising
        line = "\nJust before you reach the bright light shining above you, you are given the choice of a unique ability to have throughout the game.";
        textEffect(line);
        scan.nextLine();

        line = "\nYour choices are...\n1) Resilience: You have a strength and dexterity advantage while also limiting the impact of outside influences on you. \n2) Concealing: You have the ability to blend in with any environment you may encounter throught the games. \n3) Sixth Sense: You have the ability to see the number of players in the area you are in. \n4) Cook: You have the ability to cook the animals you hunt, increasing the amount of hunger you replenish as well as replenishing a bit of your hp. ";
        textEffect(line);

        line = "\n\nWhat is your choice? (Please enter a number value (1-4)): ";
        textEffect(line);
        
        counterP++; break;
      case 2:
        line = "";
        textEffect(line);
        scan.nextLine(); break;
      default: break;
    }
  }

  /**
   * Displays a count down
   * Pre: None.
   * Post: Statements are printed.
   */
  public void countDown() {
    line = "\nThe Games begin in...";
    String s = "\n10\n9\n8\n7\n6\n5\n4\n3\n2\n1\n\n\nGO!";
    textEffect2(line);
    textEffect4(s);
  }
 
  /**
   * Prompts user to run to supplies or run to a 
   * habitat.
   * selection.
   * Pre: None.
   * Post: Statements are printed.
   */
  public void begin() {
    line = "\nIts time! Quickly! You must decide whether to gather supplies or not. ";
    textEffect(line);
    scan.nextLine();
    
    line = "\nYou see in the far distance a mountain filled with bags, weapons, food, and... other players. Everything you will need to hunt for is located in that pile. No need for sleepless nights hunting and stealing inventory!"; 
    textEffect(line);
    scan.nextLine();
    
    line = "\nBut... is it worth the bloody battle of fighting and attacks that await?\n\nWhere will you go? (Please select a number value (1-2))\n\t1. The Center Filled with Supplies\n\t2. Habitat\nEnter your choice: ";
    textEffect(line);
  }

  /**
   * Used when user is traveling to another 
   * habitat (displays choices).
   * Pre: None.
   * Post: Statements are printed.
   */
  public void travel() {
    line = "\nWhere would you like to go? (Please select a number value (1-4))\n\t1. DesertedDesert (Desert Biome)\n\t2. FrostBite (Tundra Biome)\n\t3. JumanjiJungle (Jungle Biome)\n\t4. RisingWater (Ocean Biome)\nHabitat Number (1-4):  ";
    textEffect(line);
  }

  /**
   * Displays that user is running to habitat.
   * Pre: None.
   * Post: Statements are printed.
   */
  public void runToHabitat() {
    Graphics graphics = new Graphics();
    
    line = "\n*Queue the adventure music*";
    textEffect(line);
    if (scan.hasNextLine()) {
      scan.nextLine();
    }
    
    line = "\nYou run as fast as you can to the next habitat. On your way, you feel a sense of adrenaline run through your veins as you see the habitat nearing...\n\n" + graphics.running() + "\n\nYou have arrived.";
    textEffect(line);
    if (scan.hasNextLine()) {
      scan.nextLine();
    }
  }

  /** 
   * Displays the actions for eating.
   * Pre: Habitat number must be a valid index (0-3).
   * Post: Statements are printed. 
   */
  public void actionEat(int habitat){ // the habitat variable in the main class will go here
    switch (habitat) {
      case 0: // Desert
        switch(counterAE){ 
          case 0:
            line = "\nWhen you finally rush out of sight from the others, you quickly reach into your bag for a snack.";
            textEffect(line);
            scan.nextLine();
            break;
          case 1:
            line = "\nYou look to your left and see some fruit growing on the nearby cactus. You rush over and grab some food to eat.";
            textEffect(line);
            scan.nextLine();
            break;
          case 2:
            line = "\nAs you walk around the desert, in the distance you notice something burried in the sand. It's a bag! You reach into it and find some food to eat.";
            textEffect(line);
            scan.nextLine();
            break;
        }
        break;
      case 1: // Frost Bite
        switch(counterAE){
          case 0:
            line = "\nAs you shift through your bag in search for food, your notice some canned beans roll out... yummy :|";
            textEffect(line);
            scan.nextLine();
            break;
          case 1:
            line = "\nAs you travel through the snow, you notice a light from the far distance. As you approach, you see that it's a fire. You quickly grab your hot chocolate mix and make it.";
            textEffect(line);
            scan.nextLine();
            break;
          case 2:
            line = "\nAs you were walking, you accidentally slipped on ice and hit something. When you get  up, you relize someone left behind some food, so without thinking, you eat it.";
            textEffect(line);
            scan.nextLine();
            break;
        }
        break;
      case 2: // Jungle
        switch(counterAE){
          case 0:
            line = "\nWhen walking through the jungle, out of nowhere, something hits your head. Suddenly, you realize it's a coconut, so you quickly eat it";
            textEffect(line);
            scan.nextLine();
            break;
          case 1:
            line = "\nAs you were walking, you notice some other players huddled around a bush. Once, they leave and you make your way there, you realize they were huddled around a berry bush. You quickly stuff your face, before they return.";
            textEffect(line);
            scan.nextLine();
            break;
          case 2:
            line = "\nAs you walk through the jungle, you notice a butterfly flying. As you try to catch up to it, it suddenly vanishes out of nowhere, only to realize it lead you to a mango tree! You quickly collect any mangos that have fallen and eat them quickly.";
            textEffect(line);
            scan.nextLine();
            break;
        }
        break;
      case 3: // Rising water
        switch(counterAE){
          case 0:
            line = "\nAs the water begins to flood, you remember that you have some fish from early, you quickly stuff your face before you begin to swim";
            textEffect(line);
            scan.nextLine();
            break;
          case 1:
            line = "\nAs the water continues to rise, you can't help but feel your stomach growl. You notice some seweed in the far corner, so you swim to get it. You stretch out your arms as wide as you can and grab as much as you can eat. Yum!";
            textEffect(line);
            scan.nextLine();
            break;
          case 2:
            line = "\nAs the water gets closer and closer to your mouth, you realize this is probably the last time you can eat once you escape. Therefore, as your swimming, you reach into your bag and grab the closest thing to eat.";
            textEffect(line);
            scan.nextLine();
            break;
        }
        break;
    }
    /* Sets the counter on a cycle of 3 options, goes back to the first after the third is displayed */
    if (counterAE >= 2) {
      counterAE = 0;
    } else {
      counterAE++;
    }
  }

  /** 
   * Displays the actions for drinking.
   * Pre: Habitat number must be a valid index (0-3).
   * Post: Statements are printed.
   */
  public void actionDrink(int habitat){ // the habitat variable in the main class will go here
    switch (habitat) {
      case 0: // Desert
        switch(counterAD){ 
          case 0:
            line = "\nAs your mouth becomes like sandpaper, you reach into your bag to get the final drops of water you have left.";
            textEffect(line);
            scan.nextLine();
            break;
          case 1:
            line = "\nYou notice behind the sand domes lies a bottle of water... and another player. You quickly reach into your bag and grab something to throw infront of the player as a distraction, and do so. It works! You quickly run and grab a sip of water.";
            textEffect(line);
            scan.nextLine();
            break;
          case 2:
            line = "\nAs your walking in the endless world of sand, you notice a body of water in the far distance. You quickly run to it and fill up your bottle with water. Then you drink as much as you can!";
            textEffect(line);
            scan.nextLine();
            break;
        }
        break;
      case 1: // Frost Bite
        switch(counterAD){
          case 0:
            line = "\nWith frozen water all around you, you grab an icicle of water, and using a fire you just built, you melt it to liquid water to drink.";
            textEffect(line);
            scan.nextLine();
            break;
          case 1:
            line = "\nAs your mouth quenches for water, your only choice is to grab a pile of snow, and place it into your mouth to melt into liquid to drink.";
            textEffect(line);
            scan.nextLine();
            break;
          case 2:
            line = "\nAs you approach the edge of the habitat, you notice the flowing water. You know it's salt water, but the feeling of thirst must be stopped, so you take a sip.";
            textEffect(line);
            scan.nextLine();
            break;
        }
        break;
      case 2: // Jungle
        switch(counterAD){
          case 0:
            line = "\nAs it begins to rain, you quickly grab your bottle of water and fill it up to drink.";
            textEffect(line);
            scan.nextLine();
            break;
          case 1:
            line = "\nAfter last nights rainstorm, you go to the closest trees and collect any water on their leaves to drink.";
            textEffect(line);
            scan.nextLine();
            break;
          case 2:
            line = "\nYou notice a palm tree on your left. You quickly run to it, an brend off a flowering stalk. As the water flows out, you drink it's water";
            textEffect(line);
            scan.nextLine();
            break;
        }
        break;
      case 3: // Rising water
        switch(counterAD){
          case 0:
            line = "\nAs water fills all around you, you take a sip to quench your thirst, only to realize that it's salt water... yuck!";
            textEffect(line);
            scan.nextLine();
            break;
          case 1:
            line = "\nKnowing you can't drink salt water to survive, you grab your bottle of water and take a sip.";
            textEffect(line);
            scan.nextLine();
            break;
          case 2:
            line = "\nAs the water continues to flood, just with your luck it begins to rain, speeding up the flooding. Then you realize something... you can drink rain water!! You quickly open your mouth and drink whatever falls into your mouth!";
            textEffect(line);
            scan.nextLine();
            break;
        }
        break;
    } 
    
    /* Sets the counter on a cycle of 3 options, goes back to the first after the third is displayed */
    if (counterAD >= 2) {
      counterAD = 0;
    } else {
      counterAD++;
    }
  }
 
  /** 
   * Displays the actions for hunting.
   * Pre: Habitat number must be a valid index (0-3).
   * Post: Statements are printed.
   */
  public void actionHunt(int habitat){ // the habitat variable in the main class will go here
    switch (habitat) {
      case 0: // Desert
        switch(counterAH){ 
          case 0:
            line = "\nAfter what feels like years of walking, you suddenly trip out of nowhere, only to continue rolling down a sand dome, into a cactus! Hey, atleast this cactus has prickly pears on it!";
            textEffect(line);
            scan.nextLine();
            break;
          case 1:
            line = "\nAs the desert heat begins seeping in, you stomach begins roaring... you need to find food! Just then, you notice a player running from another player. You quickly duck! When you pop your head over to take a look again, you notice they dropped their bag of food during the run, so you quickly run and grab it.";
            textEffect(line);
            scan.nextLine();
            break;
          case 2:
            line = "\nWhile you were walking, you notice something blinking in the far distance. As you approach, you notice it's a care package of food from a sponsor. You quickly stash it into your bag before anyone can see.";
            textEffect(line);
            scan.nextLine();
            break;
        }
        break;
      case 1: // Frost Bite
        switch(counterAH){
          case 0:
            line = "\nHow convenient! You find a hole in the ice in which there are fish swimming by. You snatch one of them with your bare hands to add to your collection of food.";
            textEffect(line);
            scan.nextLine();
            break;
          case 1:
            line = "\nDoe, a deer, a female deer. That is what you see just up ahead! You grab a rock nearby and throw it at its head, knocking it unconscious. You then go ahead and take all the meat you need.";
            textEffect(line);
            scan.nextLine();
            break;
          case 2:
            line = "\n You see a few bunnies in the distance. Arctic hares to be specific. After spending quite the effort, you sneak right behind them and slash them. Time to add some more to your stash of food.";
            textEffect(line);
            scan.nextLine();
            break;
        }
        break;
      case 2: // Jungle
        switch(counterAH){
          case 0:
            line = "\nBUZZ! BUZZ! What's yellow and black and has a stinger on its back? That's right! Bees! And what do you find? A beehive! You take a chunk from the hive and extract the honey out of it. You escape just in time not to be swarmed by the bees.";
            textEffect(line);
            scan.nextLine();
            break;
          case 1:
            line = "\nIn your run from the other players, you climb up a tree to hide. While your hiding, you notice you're in a mango tree! You quickly add some mangos into your bag.";
            textEffect(line);
            scan.nextLine();
            break;
          case 2:
            line = "\nWhile walking you notice a group of plants in the distance. From your thirsty games training you think they look familar, but you can't help but remember if they are poisonous or not. Ehhh, yolo! You grab the plants and suff them into your bag";
            textEffect(line);
            scan.nextLine();
            break;
        }
        break;
      case 3: // Rising water
        switch(counterAH){
          case 0:
            line = "\nTo nobody's surprise, you see a bunch of salmon jumping up. You snatch one of them in the air to add to your collection of food.";
            textEffect(line);
            scan.nextLine();
            break;
          case 1:
            line = "\nYou see a lot of ducks nearby. You quickly chase them and manage to catch one of them. Upon catching one, you snap its neck for an instant kill. Fresh meat!";
            textEffect(line);
            scan.nextLine();
            break;
          case 2:
            line = "\nThere is a huge frog right in front of you! You are instantly reminded of the time when you had to dissect one in high school (eww) which causes you to hesitate for a moment. But then you're reminded that food is scarce so you take that frog and put it inside your bag.";
            textEffect(line);
            scan.nextLine();
            break;
        }
        break;
    } 

    /* Sets the counter on a cycle of 3 options, goes back to the first after the third is displayed */
    if (counterAH >= 2) {
      counterAH = 0;
    } else {
      counterAH++;
    }
  }

  /** 
   * Displays the actions for dowsing.
   * Pre: Habitat number must be a valid index (0-3).
   * Post: Statements are printed.
   */
  public void actionDowsing(int habitat){ // the habitat variable in the main class will go here
    switch (habitat) {
      case 0: // Desert
        switch(counterADo){ 
          case 0:
            line = "\nWater in a desert? Seriously? Actually, to what may be your surprise, there is a whole pond! Knowing how deserts are, you rush there and fill up your canister like there's no tomorrow.";
            textEffect(line);
            scan.nextLine();
            break;
          case 1:
            line = "\nWell. You were fortunate enough to come across what seems to be a filled canister that another player happened to leave behind. You use that to fill up your own canister.";
            textEffect(line);
            scan.nextLine();
            break;
          case 2:
            line = "\nThe ground beneath you feels rather damp. To settle your curiosity, you dig up the sand with your bare hands and find a good amount of clean water underneath. You know what to do! Fill that canister!";
            textEffect(line);
            scan.nextLine();
            break;
        }
        break;
      case 1: // Frost Bite
        switch(counterADo){
          case 0:
            line = "\nYou find a huge clear icicle hanging from a tree. You take it and put it inside your canister.";
            textEffect(line);
            scan.nextLine();
            break;
          case 1:
            line = "\nYou somehow manage to find a hot kettle filled with steaming water. You know you're gonna need it so you pour all of it into your canister.";
            textEffect(line);
            scan.nextLine();
            break;
          case 2:
            line = "\nLooks like it's time to take from that pile of fresh, clean (hopefully), white snow and place it inside your canister.";
            textEffect(line);
            scan.nextLine();
            break;
        }
        break;
      case 2: // Jungle
        switch(counterADo){
          case 0:
            line = "\nYou tread through trees and thick leaves and branches in your way until you come across... a clear blue pond! You rush to the source and collect some water.";
            textEffect(line);
            scan.nextLine();
            break;
          case 1:
            line = "\nYou hear heavy splashes of water in the distance. You follow the sound and discover a waterfall! You immediately go to it and fill up your canister.";
            textEffect(line);
            scan.nextLine();
            break;
          case 2:
            line = "\nWas that an elephant trumpet you just heard? Yes it was! You see a crowd of elephants in a body of clear water. You go towards it to take some of the water.";
            textEffect(line);
            scan.nextLine();
            break;
        }
        break;
      case 3: // Rising water
        switch(counterADo){
          case 0:
            line = "\nIs it possible to find fresh water in a place filled with salt water? Apparently so. You find a bucket of seemingly clean water and taste it. To your surprise, it's not salty at all so you pour it all into your canister."; 
            textEffect(line);
            scan.nextLine();
            break;
          case 1:
            line = "\nAs the water continues rising, you notice a bottle of water bouncing through the flood, you quickly grab it and add it in your bag.";
            textEffect(line);
            scan.nextLine();
            break;
          case 2:
            line = "\nIt's raining! Heavily! So you quickly swim to shore and try to catch as much water as you can in your water bottle.";
            textEffect(line);
            scan.nextLine();
            break;
        }
        break;
    } 
    
    /* Sets the counter on a cycle of 3 options, goes back to the first after the third is displayed */
    if (counterADo >= 2) {
      counterADo = 0;
    } else {
      counterADo++;
    }
  }

  /**
   * Displays text for battles.
   * Pre: None.
   * Post: Statements are printed.
   */
  public void userAttacks(String victim, int weaponNum) {
    String weapon = "";
    switch (weaponNum) {
      case 1:
        weapon = "Rusty Sword";
        break;
      case 2:
        weapon = "Katana";
        break;
      case 3:
        weapon = "Bolo Knife";
        break;
      case 4:
        weapon = "Roman Gladius";
        break;
      case 5:
        weapon = "GunKnife";
        break;
    }

    switch(counterUA) { 
      case 0:
        line = "You charge at " + victim + " and use your " + weapon + " to slash their chest. OUCH!";
        textEffect(line);
        scan.nextLine();
        break;
      case 1:
        line = victim + " is right behind you! You quickly grab your " + weapon + " and head right towards them!";
        textEffect(line);
        scan.nextLine();
        break;
      case 2:
        line = victim + " is running away! But not for long! You show no mercy as you chase after them and slash your " + weapon + " on their back! Poor " + victim + " has teared up!";
        textEffect(line);
        scan.nextLine();
        break;
      case 3:
        line = "Just as you thought you escaped, you come face to face with " + victim + ", you give it all you got and attack them with a " + weapon;
        textEffect(line); 
        scan.nextLine(); 
        break;
      case 4:
        line = "You manage to punch " + victim + " and knock them down. You then proceed to inflict harm with your " + weapon + ".";
        textEffect(line);
        scan.nextLine();
        break;
      case 5:
        line = "Your " + weapon + " is held firm in your grip. As " + victim + " rushes towards you, you take your " + weapon + " out to stab them in the leg. Sucks for " + victim + "!";
        textEffect(line);
        scan.nextLine();
        break;
    }
    
    if (counterUA == 5) {
      counterUA = 0;
    } else {
      counterUA++;
    }
  }

  /**
   * Displays text for battles.
   * Pre: None.
   * Post: Statements are printed.
   */
  public void aiAttacks(String attacker, int weaponNum) {
    String weapon = "";
    switch (weaponNum) {
      case 1:
        weapon = "Rusty Sword";
        break;
      case 2:
        weapon = "Katana";
        break;
      case 3:
        weapon = "Bolo Knife";
        break;
      case 4:
        weapon = "Roman Gladius";
        break;
      case 5:
        weapon = "GunKnife";
        break;
    }

    switch(counterAIA) { 
      case 0:
        line = "Ohh no!! You dropped your weapon! As you bend down to grab it, " + attacker + " attacks you with a " + weapon + ".";
        textEffect(line);
        scan.nextLine();
        break;
      case 1:
        line = "As you're in your battle with " + attacker + ", out of nowhere they pull out a " + weapon + "... oh no!";
        textEffect(line);
        scan.nextLine();
        break;
      case 2:
        line = attacker + " comes out of nowhere and attacks you with a " + weapon + "! You try to run away, but you're out of luck.";
        textEffect(line);
        scan.nextLine();
        break;
      case 3:
        line = "Looks like " + attacker + " dropped their " + weapon + "! You quickly run to grab it, but they get to it first. Ohh great :(";
        textEffect(line);
        scan.nextLine();
        break;
      case 4:
        line = "As " + attacker + " charges at you, you drop your bag of inventory! You quickly try to grab it but you took too long... " + attacker + " attacks you with a " + weapon + "." ;
        textEffect(line);
        scan.nextLine();
        break;
      case 5:
        line = "While your running away, out of nowhere " + attacker + " trips you face first into the ground. They then proceed to use their " + weapon + " against you.";
        textEffect(line);
        scan.nextLine();
        break;
    }
    
    if (counterAIA >= 5) {
      counterAIA = 0;
    } else {
      counterAIA++;
    }
  }
  
  /**
   * Displays that it is night time.
   * Pre: None.
   * Post: Statements are printed.
   */
  public void night() {
    line = "\n\nAs the sun finishes to set, the darkness begins to creep in. It is now night time.";
    textEffect(line);
    scan.nextLine();
  }

  /**
   * Displays that it is day time.
   * Pre: None.
   * Post: Statements are printed.
   */
  public void day(){
    line = "\n\nAs the sun slowly inches its way up the sky, light seeps across the dark sky. It is now day time.";
    textEffect(line);
    scan.nextLine();
  }
  
  /**
   * Displays that the player is sleeping.
   * Pre: None.
   * Post: Statements are printed.
   */
  public void sleep(){
    switch(counterN) { 
      case 0:
        line = "\n\nAs the morning breath begins retreating, you sense the dreeded darkness begin to creep in. You find an isolated place to hide just over the hill and finally sit down. Finally you can relax.";
        textEffect(line);
        scan.nextLine();
        counterN++; break;
      case 1:
        line = "\nAs you rapidly search for some place to rest, you suddenly see a group of players following closely behind you. You quickly run up the closest tree and pray that they will leave. Just with your luck, they don't... I guess this is where you'll spend the night.";
        textEffect(line);
        scan.nextLine();
        counterN++; break;
      case 2:
        line = "\nWhen you finally find a place to spend the night, you scatter through your bag to find your lunch you never finished. As you silently try to unzip your bag, you hear footsteps approaching in the far distance. You entire body jolts knocking over your water bottle! You think to yourself, \"Did I just give myself away?\".";
        textEffect(line);
        scan.nextLine();
        counterN++; break;
      case 3:
        line = "\nYou notice from the far distance a group of players huddling together.\"They're probably skimming a plot to get you,\" you think to yourself. The agony of their unknown plans, haunts you the rest of the night, so you decide to stay up and watch what they're up to.";
        textEffect(line);
        scan.nextLine();
        counterN++; break;
      case 4:
        line = "\nAs you go to take rest inbetween two rocks, you notice the bushes moving in the far distance. You body tenses up, as you move closer to see what it is. Suddenly, you look straight into it's eyes. You think to yourself that this is the end. Suddenly you see it racing towards you! You shut your eyes to embrace what is about to come, only for silence. You look around, only to see a small bunny hoping around... it's going to be a long night.";
        textEffect(line);
        scan.nextLine();
        counterN++; break;
    }
  }

  /**
   * Displays the scenary of the desert.
   * Pre: None.
   * Post: Statements are printed.
   */
  public void desertedDesert(Graphics graphics) {
    counterD++;
    switch(counterD) {
      case 1:
      System.out.print(graphics.desert());
      System.out.print(graphics.divider());
      line = "\n\nAs you make your way through the desert, you can't help but feel at ease. The warm sand meets your feet with every step and the wind prances in your hair. Though, the moment is ruined as all of a sudden you hear footsteps approaching.. it's game time.";
      textEffect(line);
      if (scan.hasNextLine()) {
        scan.nextLine(); 
      } break;
     case 2:
      line = "\n\nThe once breathtaking desert habitat now looks nothing but empty. An unsteady feeling suddenly rushes through your body. It’s quite... too quite.";
      textEffect(line);
      if (scan.hasNextLine()) {
        scan.nextLine(); 
      } break;
     case 3: 
      line = "\n\nAs you make your way through the desert one final time. You can't help but notice the overwhelming colour of red which now covers the once golden sand.";
      textEffect(line);
      if (scan.hasNextLine()) {
        scan.nextLine(); 
      } break;
    }
  }

  /**
   * Displays the scenary of the frost bite lands.
   * Pre: None.
   * Post: Statements are printed.
   */
  public void frostBite(Graphics graphics) {
    counterF++;
    switch(counterF){
      case 1:
      System.out.print(graphics.frostBite());
      System.out.print(graphics.divider());
      line = "\n\nThe frost bite habitat is no place for any living thing. Your nose is bright red and your feet are uncontrollably shaking. You realize your body is practically numb as you let out a weak shiver. \"It's going to be a long day,\" you sigh.";
      textEffect(line);
      if (scan.hasNextLine()) {
        scan.nextLine(); 
      } break;
     case 2:
      line = "\n\nAs you approch the desert again, you mentally prepare yourself for the bitter road ahead. As you enter and the wind passes your hands,the uncontrollable shaking begins it's same routine.";
      textEffect(line);
      if (scan.hasNextLine()) {
        scan.nextLine(); 
      } break;
     case 3:
      line = "\n\nAs you walk through the habitat, your body goes numb, though not because of the cold weather, but because of what you see. The people you started this game with lie lifeless amoungst the crowds and you can no longer contain your emotions.";
      textEffect(line);
      if (scan.hasNextLine()) {
        scan.nextLine(); 
      } break;
    }
  }
  
  /**
   * Displays the scenary of the jungle.
   * Pre: None.
   * Post: Statements are printed.
   */
  public void jumanjiJungle(Graphics graphics){
    counterJ++;
    switch(counterJ){
      case 1:
      System.out.print(graphics.jungle());
      System.out.print(graphics.divider());
      line = "\n\nThe jungle habitat feels alive. You see animals prancing and the trees dancing. It reminds you of the good old times when you were safe at home.";
      textEffect(line);
      if (scan.hasNextLine()) {
        scan.nextLine(); 
      } break;
      case 2:
      line = "\n\nAs you make your way through the jungle, you notice the sense of feeling of alive, now has drifted away. The trees sniffle to the sound of rain and the animals are no longer in sight... the jungle is dead.";
      textEffect(line);
      if (scan.hasNextLine()) {
        scan.nextLine(); 
      } break;
      case 3:
      line = "\n\nSilence fills the mists as you approach the jungle one final time. The once vibrant and colourfull livelihood now lives in a world of darkness and vengance.";
      textEffect(line);
      if (scan.hasNextLine()) {
        scan.nextLine(); 
      } break;
    }
  }

  /**
   * Displays the scenary of rising water habitat.
   * Pre: None.
   * Post: Statements are printed.
   */
  public void risingWater(Graphics graphics){
    counterW++;
    switch(counterW){
      case 1:
        System.out.print(graphics.water1());
        System.out.print(graphics.divider());
        line = "\n\nThe water habitat is practically a death wish, you say under your breath as you enter. You see from the corner a large drain flooding the entire habitat with water... it’s just a matter of time until there’s no way to escape.";
        textEffect(line);
        if (scan.hasNextLine()) {
        scan.nextLine(); 
      } break;
      case 2:
        System.out.print(graphics.water2());
        System.out.print(graphics.divider());
        line = "\n\nThe water habitat has now flood up to chin level. You must now rely on your swimming abilities to save you.";
        textEffect(line);
        if (scan.hasNextLine()) {
          scan.nextLine(); 
        } break;
      case 3:
        System.out.print(graphics.water3());
        System.out.print(graphics.divider());
        line = "\n\nNow the habitat is simply a race to the finish. The water keeps rising and theres nothing you can do... you must escape!";
        textEffect(line);
        if (scan.hasNextLine()) {
          scan.nextLine(); 
        } break;
    }
  }

  /**
   * Displays that player dies.
   * Pre: None.
   * Post: Statements are printed.
   */
  public void playerDeath(){
    line = "\nAs the world around you starts to fade, the distanced fighting is silenced and the pain slowly but surely begins going numb.";
    textEffect(line);
    scan.nextLine();
    
    line = "You look to the sky and see the clouds begin to retreat and feel a small drizzle beginning to fall.";
    textEffect(line);
    scan.nextLine();
    
    line = "You think about how far you’ve come and your family. You picture their smiles one last time before you close your eyes one final time.";
    textEffect(line);
    scan.nextLine();
  }

  /**
   * Displays that all players who have died.
   * Pre: None.
   * Post: Statements are printed.
   */
  public void playerDeathNames(Player player, ArrayList<Ai> dead, Graphics graphics) {
    line = "\nAs the night falls, in the distance you hear a loud canon. You look to the skies and see the list of names of those who have passed...\n";
    textEffect(line);
    scan.nextLine();

    line = "\n\n" + graphics.deaths() + "\n\n";
    textEffect3(line);

    for (int i = 0; i < dead.size(); i++)  {
      line = dead.get(i).getName() + "\n";
      textEffect(line);
      
    }
    
    //to avoid concurrent modifications error
    ArrayList<Ai> totalDead = new ArrayList<Ai>();
    for (Ai ai : dead) {
      totalDead.add(ai);
      player.deadPeople();
    }

    dead.removeAll(totalDead);

    player.returnDead(dead);
    scan.nextLine();
  }

  /**
   * Displays that player has won the game.
   * Pre: None.
   * Post: Statements are printed.
   */
  public void playerWin(){
    line = "\nAs you look around you one last time, you finally feel a sense of relief... you survived. You are the first ever winner of THE THIRSTY GAMES!";
    textEffect(line);
    scan.nextLine();
  }

  /**
   * Displays end credits of the game.
   * Pre: None.
   * Post: Statements are printed.
   */
  public void endCredits(){
    line = "\n\nThank you for playing THE THIRSTY GAMES! Your name will go down in history as the first ever volunteer.\n\n\n" 
    + "BY: Stanley Liu\n" 
    + "    Erin Lee\n" 
    + "    Maddy Angaran\n" 
    + "    Eugene Lee\n" 
    + "    Lynn John-Koshy\n";
    textEffect(line);
  }

  /**
   * Displays score text.
   * Pre: None.
   * Post: Statements are printed.
   */
  public void score() {
    // For high score class.
    line = "\n\nAmazing work! Here is how you did compared to past participants:\n";
    textEffect(line);
  }
 } // End class definition. 