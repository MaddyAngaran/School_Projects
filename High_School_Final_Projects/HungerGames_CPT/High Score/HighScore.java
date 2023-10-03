/*
 * HighScore.java
 * This class is used to update the high scores of users.
 * Group 5: Maddy Angaran, Lynn John-Koshy, Erin Lee, 
 * Eugene Lee, and Stanley Liu
 * ICS 4U
 * November 9th, 2020
 */
import java.io.*;
import java.util.ArrayList;

/**
 * The HighScore class determines a score for the player based
 * on their performance throughout the game, taking into
 * account factors such as their game rank and stats with which
 * they ended and adds this to a file with past results, ordered
 * from highest to lowest score.
 */
public class HighScore {
  int score; // Calculated player score
  String thisResults; // Contains all of the info about the player in the current game

  File highScores; // File for the high scores list
  ArrayList<String> everyone; // Array to store the updated orders for all the players recorded in the high scores list

  String name;
  int gameRank;
  int kills;
  int dayNightPassed;
  int daysPassed;
  int nightsPassed;
  int hp;
  int hunger;
  int thirst;
  int sanity;

  /**
   * Constructor.
   * Pre: None.
   * Post: Sets score and current stat string, all .txt files,
   * name, kills days/nights passed, stats variables.
   */
  public HighScore(String n, int r, int ki, int dnp, int h, int hu, int th, int sa) {
    score = 0;
    thisResults = "";

    highScores = new File("High Score/highscores.txt");
    everyone = new ArrayList<String>();

    name = n;
    gameRank = r;
    kills = ki;
    dayNightPassed = dnp;
    daysPassed = (int)(dayNightPassed + 1)/2; // If dayNightPassed is odd, it takes half the value and rounds up
    nightsPassed = dayNightPassed/2; // Takes half the value of dayNightPassed and would round down if dayNightPassed was odd
    hp = h;
    hunger = hu;
    thirst = th;
    sanity = sa;
  }

  /**
   * Runs the other functions for processing/updating the high
   * score list and displays the contents.
   * Pre: None.
   * Post: Displays the updated high score list.
   */
  public void showHighScores() {
    determineScore(); // Calculates the score of the user
    compareOtherScores(); // Places the user's results on an array in order of scores
    writeToFile(); // Writes the entire array to the file

    /* Displays the list of each player on the high score list and their results */
    System.out.format("%-8s %-20s %8s %12s %8s %8s %8s %10s %10s %10s %10s", "RANK", "NAME", "SCORE", "GAME RANK", "KILLS", "DAYS", "NIGHTS", "HP", "HUNGER", "THIRST", "SANITY\n");
    try {
      FileReader in = new FileReader(highScores);
      BufferedReader readResults = new BufferedReader(in);
      String result; // Results for each line (each player)
      int rank = 0; // To display the rank of each player in relation to one another
      String[] currentResults; // Array used to hold all of the individual stats of each player (values reassigned for the next player down the list everytime a loop is repeated)
      String preScore = ""; // Compares the next score down the list to the previous, to be compared on whether or not they're equal
      while ((result = readResults.readLine()) != null) {
        currentResults = new String[] {"", "", "", "", "", "", "", "", "", ""};
        
        int infoNumber = 0; // Determines which element in the array is to be modified (each containing information about the current player and resetting after every player)
        int charPassed = 0; // Used to process every character in the result string, increments by 1 after every repeat of a loop
        while (infoNumber < currentResults.length) {
          /* Moves onto the next element in the array if the current character is a space, to divide different pieces of information pertaining to the player */
          if (result.charAt(charPassed) == ' ') {
            infoNumber++;
          } else {
            currentResults[infoNumber] += result.charAt(charPassed); // Adds the current character to the current element
          }
          charPassed++; // Increments to allow the next character to be processed
        }

        /* Only increments the rank to be displayed if the previously-read score is not same (above) as the current score */
        if (!currentResults[1].equals(preScore) && !currentResults[1].equals("")) {
          rank++;
        } 
        
        /* Adds a trophy beside the names of users who won their respective games and a skull beside users who didn't */
        if (currentResults[2].equals("1/13")) { 
          currentResults[0] = "🏆  " + currentResults[0];
        } else {
          currentResults[0] = "💀  " + currentResults[0];
        }

        /* Displays the information pertaining to the current player, formatted the same way as the headings to allow alignment */
        System.out.format("%-8s %-21s %8s %12s %8s %8s %8s %10s %10s %10s %10s", rank, currentResults[0], currentResults[1], currentResults[2], currentResults[3], currentResults[4], currentResults[5], currentResults[6], currentResults[7], currentResults[8], currentResults[9] + "\n");

        preScore = currentResults[1]; // Sets the previous score to the current score as the current score now becomes the "previous" score
      }
      readResults.close();
      in.close();
    } catch (FileNotFoundException e) {
      System.out.println("File does not exist or could not be found.");
      System.err.println("FileNotFoundException: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("Problem reading file.");
      System.err.println("IOException: " + e.getMessage());
    }
  }

  /**
   * Calculates the score of the user based on their
   * performance throughout the game and the stats they end with.
   * Also sets a String variable containing the current 
   * player's results.
   * Pre: None.
   * Post: Player's score calculated.
   */
  private void determineScore() {
    /* SCORE CALCULATION */
    // +1000 for every in-game rank above 12th (last)
    // +500 for every kill by the user
    // +10 for every HP point the user has left as of the end of the game
    // +20 for every hunger point remaining
    // +20 for every thirst point remaining
    // + 15 for every sanity point remaining
    score = (13 - gameRank) * 1000 + kills * 500 + hp * 10 + hunger * 20 + thirst * 20 + sanity * 15;
    /* +3000 bonus if the user wins */
    if (gameRank == 1) {
      score += 2000; // Additional points for winning the game (3000 in total from 2nd)
    }
    /* +200 bonus for every half day less than 10 (5 day/night cycles) experienced by the user */
    if (dayNightPassed < 10) {
      score += (10 - dayNightPassed) * 200; // Bonus points for finishing the game sooner if the user finished before 5 days and nights passed
    }

    /* Sets the score and the results to a string */
    thisResults = name + " " + Integer.toString(score) + " " + Integer.toString(gameRank) + "/13 " + Integer.toString(kills) + " " + Integer.toString(daysPassed) + " " + Integer.toString(nightsPassed) + " " + Integer.toString(hp) + "/100 " + Integer.toString(hunger) + "/10 " + Integer.toString(thirst) + "/3 " + Integer.toString(sanity) + "/10 ";
  }

  /**
   * Compares the current user's scores to past scores (in the
   * high scores list) and places it based on the order of all
   * the scores, greatest to least.
   * Pre: None.
   * Post: Places the user's score into the correct position in
   * an Arraylist.
   */
  private void compareOtherScores() {
    try {
      FileReader in = new FileReader(highScores);
      BufferedReader readResults = new BufferedReader(in);
      String result; // The String containing the results of every user on the high scores list (per line)
      boolean userAdded = false; // Boolean to determine whether or not the user's results have been added to the ArrayList
      while ((result = readResults.readLine()) != null) {
        /* While loop to process each character inside the line, sets a string equal to the first set of integers (the value of the score) */
        int i = 0; // Counter for every character in the String
        boolean numberDone = false; // Boolean indicating whether one set of integers has been recorded
        String otherScoreString = ""; // String containing the processed score
        int otherScore = 0; // Variable to hold the int value of the String containing the score
        boolean spaceEncountered = false; // The boolean is used to indicate whether the first set of non-space characters (being the name) has been fully read and recognized, as the next set of characters being numbers will be the score number
        while (i < result.length() && !numberDone) {
          /* Sets a boolean to true if a space has been encountered for the first time, as this incidicates that the current set of characters no longer belongs to the user's name but now to the user's score (in case the user put numbers in their name) */
          if (result.charAt(i) == ' ') {
            spaceEncountered = true;
          }

          /* Adds the current character to the String if it is a digit */
          if (Character.isDigit(result.charAt(i)) && spaceEncountered) {
            otherScoreString += result.charAt(i); // Adds the next digit to the String
          }

          /* If the String already has digits in it and the current character is not a digit, the loop ends. The current score integer has already been obtained */
          if (!Character.isDigit(result.charAt(i)) && otherScoreString.length() > 0) {
            numberDone = true;
          }

          i++;
        }
        otherScore = Integer.parseInt(otherScoreString); // Turns the score String into an integer

        /* If the user's score is higher than the currently-recorded score, they are placed into the array into their rightful position */
        if (score >= otherScore && !userAdded) {
          everyone.add(thisResults);
          userAdded = true; // To make sure the code inside this if statement is only processed once, adding the user's results only once
        }

        everyone.add(result);
      }

      /* Conditional to consider the possibility of the user having obtained a lower score than everyone else on the list */
      if (userAdded == false) {
        everyone.add(thisResults);
        userAdded = true;
      }

      readResults.close();
      in.close();
    } catch (FileNotFoundException e) {
      System.out.println("File does not exist or could not be found.");
      System.err.println("FileNotFoundException: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("Problem reading file.");
      System.err.println("IOException: " + e.getMessage());
    }
  }

  /**
   * Writes the elements of the ArrayList to the highscores file.
   * Pre: None.
   * Post: All users' results written to the highscores file in
   * their updated order.
   */
  private void writeToFile() {
    try {
      FileWriter out = new FileWriter(highScores);
      BufferedWriter writeResults =  new BufferedWriter(out);
      /* Writes the results of every user, one line at a time */
      for (int i = 0; i < everyone.size(); i++) {
        writeResults.write(everyone.get(i));
        writeResults.newLine();
      }
      writeResults.close();
      out.close();
    } catch (FileNotFoundException e) {
      System.out.println("File does not exist or could not be found.");
      System.err.println("FileNotFoundException: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("Problem writing to file.");
      System.err.println("IOException: " + e.getMessage());
    }
  }
}