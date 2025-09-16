package se.jensen.sofi_n.dice_game;
//KLASS PLAYER
/*
 * firstname
 * lastname
 * hasTurn
 * score - initially 0
 * addToScore(int score)
 * getFullname() - returnerar konkatering av firstname och lastname
 * setFirstName() - IllegalArgumentException vid tom sträng
 * setLastName() - IllegalArgumentException vid tom sträng
 * setHasTurn()
 * Programmet ska ge möjlighet att mata in igen om man matar in fel
 * */

public class Player {
    //ATTRIBUTES
    private String firstName;
    private String lastName;
    private int score = 0;
    private int turnCounter = 0;

    //SETTERS
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //GETTERS
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getScore() {
        return score;
    }
    public int getTurnCounter() {
        return turnCounter;
    }


    //INSTANSFUNKTIONER
    public void addToScore(int diceThrow) {
        score += diceThrow;
    }
    public void incrementTurnCounter(){
        turnCounter++;
    }
}
