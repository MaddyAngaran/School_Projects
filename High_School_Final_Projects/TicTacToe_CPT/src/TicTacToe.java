/*
Madeline Angaran
Wednesday, June 10, 2020
This application runs the game TicTacToe
 */
package tictactoe;
import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
        
	static int A1, A2, A3, B1, B2, B3, C1, C2, C3;

	static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        int tie = 0;
        int win = 0;
        int lose = 0;
        int select = 1;
        int menu = 0;
        int games = 0;
        String play = "";
        int rnd = 0;
           
            
        Scanner input = new Scanner(System.in);
        
        mainLoop: // to cancel out alll function within multiple loops
        while(true){
            System.out.println();
            System.out.println("Menu: ");
            System.out.println("1 - play");
            System.out.println("2 - instructions");
            System.out.println("3 - credits");
            System.out.println("4 - exit");
            System.out.print("Enter choice: ");
            menu = input.nextInt();
            while (menu != 1 && select != 2){ // lets user access menu functions as many times as they would like
                switch(menu){
                    case 2:System.out.println("Welcome to tic tac toe!");
                        System.out.println("Position coices are as follows...");
                        System.out.println("A1 - top left corner");
                        System.out.println("A2 - top middle");
                        System.out.println("A3 - top right corner");
                        System.out.println("B1 - mid left corner");
                        System.out.println("B2 - mid middle");
                        System.out.println("B3 - mid right corner");
                        System.out.println("C1 - bottom left corner");
                        System.out.println("C2 - bottom middle");
                        System.out.println("C3 - bottom right corner");
                        
                        System.out.println("");
                        break;
                    case 3:
                        System.out.println("Games played: " + games);
                        System.out.println("Games won: "+ win);
                        System.out.println("Games lost: " + lose); 
                        System.out.println("Games tied: " + tie);
                        break;
                    default:
                        break mainLoop;

                    } 
                if (menu == 1){
                    break;
                }
                System.out.println();
                System.out.println("Enter 1 to return to menu");
                System.out.println("Enter 2 to exit");
                System.out.print("Enter choice: ");
                select = input.nextInt();  
                System.out.println();
                if (select != 1){
                    break mainLoop;
                }
                if (select == 1){
                    System.out.println("Menu: ");
                    System.out.println("1 - play");
                    System.out.println("2 - instructions");
                    System.out.println("3 - credits");
                    System.out.println("4 - exit");
                    System.out.print("Enter choice: ");

                    menu = input.nextInt();
                }

            }




            int p = 0;
            String prompt = "";
            String humanMove = "";
            String computerMove = "";
            boolean gameIsWon = false;

           
            while(menu == 1 && p == 0){ // only runs game for one full game then resets variables neede to play agin
                p = p+1;
                games = games+1;
                for (int i = 1; i <=9; i++){ //only 9 possible move so that is set as the max amount of times for the loop to run
                    // Human player
                    
                    if (i==1){ // only displays intial prompt for first move
                        prompt = "Welcome to Tic-Tac-Toe. Please enter your first move: ";
                         reset();
                    }
                    humanMove = getMove(prompt);
                    updateBoard(humanMove, 1);
                    displayBoard();
                    if (isGameWon()){
                            System.out.println("You beat me!");
                            gameIsWon = true;
                            win = win + 1;
                            break;
                    }

                    // Computer player
                    if (i < 9){
                            computerMove = getComputerMove(rnd, play);
                            System.out.println("I will play at " + computerMove);
                            updateBoard(computerMove, 2);
                            displayBoard();
                            if (isGameWon()){
                                    System.out.println("I beat you!");
                                    gameIsWon = true;
                                    lose = lose + 1;
                                    break;
                            }
                            prompt = "Please enter your next move: ";
                            i++;

                            }if (i == 9){
                                System.out.println("It's a draw!");
                                tie = tie +1;
                            }
                }
            }
        }
    }
    public static String getMove(String prompt){ // gets move from user 
        String play;
        System.out.print(prompt);
        do
        {
                play = sc.nextLine();
                if (!isValidPlay(play))// keeps collecting move until valid one is input
                {
                        System.out.println("That is not a valid play.");
                        System.out.print("Please enter valid play: ");
                }
        } while (!isValidPlay(play));
        return play;
    }

    public static boolean isValidPlay(String play){// checks if players move is valid
        if (play.equalsIgnoreCase("A1") & A1 == 0)
                return true;
        if (play.equalsIgnoreCase("A2") & A2 == 0)
                return true;
        if (play.equalsIgnoreCase("A3") & A3 == 0)
                return true;
        if (play.equalsIgnoreCase("B1") & B1 == 0)
                return true;
        if (play.equalsIgnoreCase("B2") & B2 == 0)
                return true;
        if (play.equalsIgnoreCase("B3") & B3 == 0)
                return true;
        if (play.equalsIgnoreCase("C1") & C1 == 0)
                return true;
        if (play.equalsIgnoreCase("C2") & C2 == 0)
                return true;
        if (play.equalsIgnoreCase("C3") & C3 == 0)
                return true;
        return false;
    }
    public static String valid(String play, int rnd){ // checks if computers move is valid
        if (A1 == 0 & rnd == 1)
            return "A1";
        if (A2 == 0 & rnd == 2)
            return "A2";
        if (A3 == 0 & rnd == 3)
            return "A3";
        if (B1 == 0 & rnd == 4)
            return "B1";
        if (B2 == 0 & rnd == 5)
            return "B2";
        if (B3 == 0 & rnd == 6)
            return "B3";
        if (C1 == 0 & rnd == 7)
            return "C1";
        if (C2 == 0 & rnd == 8)
            return "C2";
        if (C3 == 0 & rnd == 9)
            return "C3";
        return "";
    }

    public static void updateBoard(String play, int player){ // updates the board depending on player and computers move
        if (play.equalsIgnoreCase("A1"))
                A1 = player;
        if (play.equalsIgnoreCase("A2"))
                A2 = player;
        if (play.equalsIgnoreCase("A3"))
                A3 = player;
        if (play.equalsIgnoreCase("B1"))
                B1 = player;
        if (play.equalsIgnoreCase("B2"))
                B2 = player;
        if (play.equalsIgnoreCase("B3"))
                B3 = player;
        if (play.equalsIgnoreCase("C1"))
                C1 = player;
        if (play.equalsIgnoreCase("C2"))
                C2 = player;
        if (play.equalsIgnoreCase("C3"))
                C3 = player;
    }

    public static void displayBoard(){ // displays the board
        String line = "";
        System.out.println();
        line = " " + getXO(A1) + " | " + getXO(A2) + " | " + getXO(A3);
        System.out.println(line);
        System.out.println("-----------");
        line = " " + getXO(B1) + " | " + getXO(B2) + " | " + getXO(B3);
        System.out.println(line);
        System.out.println("-----------");
        line = " " + getXO(C1) + " | " + getXO(C2) + " | " + getXO(C3);
        System.out.println(line);
        System.out.println();
    }

    public static String getXO(int square){ // displays X for users choice and O for computers
        if (square == 1)
                return "X";
        if (square == 2)
                return "O";
        return " ";
    }

    public static String getComputerMove(int rnd, String play){ // gets computers move
        Random rand = new Random();
            do{
            rnd = rand.nextInt(9) + 1; // choses a random space 
            }while (valid(play, rnd) == ""); // loops until a valid space is chosen

        return valid(play,rnd);
    }



    public static boolean isGameWon(){ // checks if the game has been won based on different winning placements
        if (isRowWon(A1, A2, A3))
                return true;
        if (isRowWon(B1, B2, B3))
                return true;
        if (isRowWon(C1, C2, C3))
                return true;
        if (isRowWon(A1, B1, C1))
                return true;
        if (isRowWon(A2, B2, C2))
                return true;
        if (isRowWon(A3, B3, C3))
                return true;
        if (isRowWon(A1, B2, C3))
                return true;
        if (isRowWon(A3, B2, C1))
                return true;
        return false;
    }

    public static boolean isRowWon(int a, int b, int c){
        return ((a == b) & (a == c) & (a != 0));
    }
    public static void reset(){ //resets the board
        A1 = 0;
        A2 = 0;
        A3 = 0;
        B1 = 0;
        B2 = 0;
        B3 = 0;
        C1 = 0;
        C2 = 0;
        C3 = 0;
    }
}