package se.jensen.sofi_n.dice_game;

///CLASS PLAYER
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
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
