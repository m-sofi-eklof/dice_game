package se.jensen.sofi_n.dice_game;

import java.util.Scanner;
import java.util.ArrayList;

///GAME CLASS
/*
* The following class contains the game logic for a simple console dice game.
* A match is set up for two players with two throws, but these can be altered through variables numberOfPlayers and
* turnsPerGame respectively.
* Game logic runs when the .init() function is called for any class object.
* */
public class Game {
    ///GAME VARIABLES
    boolean game = true;//game loop variable
    int numberOfPlayers=2;
    int turnsPerGame=2;
    Player[] players= new Player[numberOfPlayers]; //holds the created Player objects in each run

    ///GRAPHIC VARIABLES
    private String letsGO= (
                    "            .     *       .       ✧      *       .       \n"+
                    "██╗     ███████╗████████╗███████╗     ██████╗  ██████╗ ██╗\n"+
                    "██║     ██╔════╝╚══██╔══╝██╔════╝    ██╔════╝ ██╔═══██╗██║\n"+
                    "██║     █████╗     ██║   ███████╗    ██║  ███╗██║   ██║██║\n"+
                    "██║     ██╔══╝     ██║   ╚════██║    ██║   ██║██║   ██║╚═╝\n"+
                    "███████╗███████╗   ██║   ███████║    ╚██████╔╝╚██████╔╝██╗\n"+
                    "╚══════╝╚══════╝   ╚═╝   ╚══════╝     ╚═════╝  ╚═════╝ ╚═╝\n");

    private String youWon=(
            ".     *       .       ✧      *     .   *       .      ✧      *    .\n"+
                    "    ██╗   ██╗ ██████╗ ██╗   ██╗    ██╗    ██╗ ██████╗ ███╗   ██╗██╗\n"+
                    "    ╚██╗ ██╔╝██╔═══██╗██║   ██║    ██║    ██║██╔═══██╗████╗  ██║██║\n"+
                    "     ╚████╔╝ ██║   ██║██║   ██║    ██║ █╗ ██║██║   ██║██╔██╗ ██║██║\n"+
                    "      ╚██╔╝  ██║   ██║██║   ██║    ██║███╗██║██║   ██║██║╚██╗██║╚═╝\n"+
                    "       ██║   ╚██████╔╝╚██████╔╝    ╚███╔███╔╝╚██████╔╝██║ ╚████║██╗\n"+
                    "       ╚═╝    ╚═════╝  ╚═════╝      ╚══╝╚══╝  ╚═════╝ ╚═╝  ╚═══╝╚═╝\n");


    private String itsATie =(
             "              ██╗████████╗███████╗     █████╗     ████████╗██╗███████╗\n"+
             "▄ ██╗▄        ██║╚══██╔══╝██╔════╝    ██╔══██╗    ╚══██╔══╝██║██╔════╝      ▄ ██╗▄\n"+
             " ████╗  █████╗██║   ██║   ███████╗    ███████║       ██║   ██║█████╗█████╗   ████╗\n"+
             "▀╚██╔▀  ╚════╝██║   ██║   ╚════██║    ██╔══██║       ██║   ██║██╔══╝╚════╝  ▀╚██╔▀\n"+
             "  ╚═╝         ██║   ██║   ███████║    ██║  ██║       ██║   ██║███████╗        ╚═╝\n" +
             "              ╚═╝   ╚═╝   ╚══════╝    ╚═╝  ╚═╝       ╚═╝   ╚═╝╚══════╝\n");

    //String variables to visually represent the result of the .thow() method (see Dice class)
    private String dice1 =(
                    "+-------+\n" +
                    "|       |\n" +
                    "|   o   |\n" +
                    "|       |\n" +
                    "+-------+\n" +
                    "   One\n"
    );
    private String dice2 =(
                    "+-------+\n" +
                    "| o     |\n" +
                    "|       |\n" +
                    "|     o |\n" +
                    "+-------+\n" +
                    "   Two \n"
    );
    private  String dice3 =(
                    "+-------+\n" +
                    "| o     |\n" +
                    "|   o   |\n" +
                    "|     o |\n" +
                    "+-------+\n" +
                    "  Three \n"
    );
    private  String dice4= (
                    "+-------+\n" +
                    "| o   o |\n" +
                    "|       |\n" +
                    "| o   o |\n" +
                    "+-------+\n" +
                    "  Four \n"
    );
    private  String dice5= (
                    "+-------+\n" +
                    "| o   o |\n" +
                    "|   o   |\n" +
                    "| o   o |\n" +
                    "+-------+\n" +
                    "  Five \n"
    );
    private  String dice6= (
                    "+-------+\n" +
                    "| o   o |\n" +
                    "| o   o |\n" +
                    "| o   o |\n" +
                    "+-------+\n" +
                    "   Six \n"
    );

    /// STATIC METHODS
    /// printMenu()
    /*
    * The printMenu() method prints little ASCII grafics which relay the different options for the user at the base
    * of the game
    */
    private static void printMenu(){

        System.out.println("\n"+
                "██████╗ ██╗ ██████╗███████╗     ██████╗  █████╗ ███╗   ███╗███████╗\n" +
                "██╔══██╗██║██╔════╝██╔════╝    ██╔════╝ ██╔══██╗████╗ ████║██╔════╝\n"+
                "██║  ██║██║██║     █████╗      ██║  ███╗███████║██╔████╔██║█████╗\n"+
                "██║  ██║██║██║     ██╔══╝      ██║   ██║██╔══██║██║╚██╔╝██║██╔══╝\n"+
                "██████╔╝██║╚██████╗███████╗    ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗\n"+
                "╚═════╝ ╚═╝ ╚═════╝╚══════╝     ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝");
        System.out.println(
                        "            .     *       .       ✧      *       .       \n" +
                        "     +---------------------------------------------------+\n" +
                        "     |            WELCOME TO THE DICE GAME!              |\n" +
                        "     |                                                   |\n" +
                        "     |   Type 'Play' to roll the dice and start playing  |\n" +
                        "     |   Type 'Quit' to exit                             |\n" +
                        "     +---------------------------------------------------+\n" +
                        "            .     *       .       ✧      *       .       \n"
        );
    }

    /// INSTANCE METHODS
    /// .init()
    /*
    * The .init() method starts the game which uses console input and output to allow users to play a simple Dice Game.
    * Please note that when the user exits game using Quit input in the switch-case loop, the function closes the
    * whole program.
    */
    public void init() {
        Scanner scanner = new Scanner(System.in);//creates scanner object
        while (game) { //Start of game loop

            //MENU
            printMenu();
            String choice = scanner.nextLine();
            boolean switchCase=true;
            while(switchCase){
                switch (choice) {
                    case "Play":
                        game = true;
                        switchCase=false;
                        break;
                    case "Quit":
                        System.out.println("Good Bye!");
                        scanner.close();
                        System.exit(0);//exit program
                    default:
                        System.out.println("Invalid choice.");
                        printMenu(); //back to menu
                        choice = scanner.nextLine(); //new input
                }
            }

            //MAKE AND STORE PLAYERS
            for (int i = 0; i < numberOfPlayers; i++) {

                //create and store
                players[i] = new Player();

                //setting names
                boolean valid =false;
                System.out.println("PLAYER "+(i+1)+":");
                while(!valid){
                    System.out.println("Enter first name:");
                    String firstname = scanner.nextLine();
                    try{
                        players[i].setFirstName(firstname);
                        valid=true; //only reached if above doesn't throw exception(see Player class method .setFirstName())
                    }
                    catch(IllegalArgumentException e){
                        System.out.println(e.getMessage()); //see Player class method setFirstName()
                        System.out.println("Try again");
                    }
                }
                valid=false;
                while(!valid){
                    System.out.println("Enter last name:");
                    String lastname = scanner.nextLine();
                    try{
                        players[i].setLastName(lastname);//only reached if above doesn't throw exception(see Player class method .setLastName())
                        valid=true;
                    }
                    catch(IllegalArgumentException e){
                        System.out.println(e.getMessage());//see Player class method setFirstName()
                        System.out.println("Try again");
                    }
                }
            }

            //MAKING DICE
            Dice dice = new Dice();

            //MATCH
            System.out.println(letsGO);
            for (Player player : players) {
                while (player.getTurnCounter()<turnsPerGame){ //turnCounter starts off 0 (see Player class)
                    player.incrementTurnCounter();
                    System.out.println("It's "+player.getFirstName()+"s turn!");
                    System.out.println("Press enter to roll dice...");
                    scanner.nextLine();
                    int diceRoll = dice.roll(); //generates random int [1,6]
                    //printing visual representation of throw result
                    switch(diceRoll){
                        case 1:
                            System.out.println(dice1);
                            break;
                        case 2:
                            System.out.println(dice2);
                            break;
                        case 3:
                            System.out.println(dice3);
                            break;
                        case 4:
                            System.out.println(dice4);
                            break;
                        case 5:
                            System.out.println(dice5);
                            break;
                        case 6:
                            System.out.println(dice6);
                            break;

                    }
                    player.addToScore(diceRoll); //adding to player score (0 at first, see Player class)
                }
            }


            //CALCULATE AND ANNOUNCE WINNER/S
            ArrayList<Player> winners = new ArrayList<>();//arraylist in case of tie

            //calculate highest score
            int highestScore = 0;
            for (Player player : players) {
                if (player.getScore() > highestScore) {
                    highestScore = player.getScore();
                }
            }

            //find player/s with highest score and store in winners
            for (Player player : players) {
                if (player.getScore() == highestScore) {
                    winners.add(player);
                }
            }

            //announce winner
            if (winners.size() == 1) {
                System.out.println(youWon);
                System.out.println("Congratulations " + winners.get(0).getFullName()+"!");
            }

            //or announce tie
            else {
                System.out.println(itsATie);
                for (Player player : winners) {
                    System.out.println(player.getFullName());
                }
                System.out.println("Congratulations! You got a score of " + highestScore + "!");
            }

            //end of match outputs/inputs
            System.out.println("Press enter to go back to menu or enter Quit to quit");
            String quitOrNo = scanner.nextLine();
            if (quitOrNo.equals("Quit")) {
                game = false;
            }

        }//end of game loop

        scanner.close(); //close scanner
    }
}
