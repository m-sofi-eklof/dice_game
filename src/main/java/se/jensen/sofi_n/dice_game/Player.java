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
        if (firstName == null || firstName.trim().isEmpty()) { //throws exception for null, "" or "   " etc
            throw new IllegalArgumentException("First name cannot be empty");
        }
        this.firstName = firstName;//or set firstName
    }
    public void setLastName(String lastName) {
        if   (lastName == null || lastName.trim().isEmpty()) { //throws exception for null, "" or "   " etc
            throw new IllegalArgumentException("Last name cannot be empty");
        }
        this.lastName = lastName;//or set lastName
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


    //OBJECT METHODS
    /*
     * addToScore() takes an int (for example the return value of the Dice objects .throw() method) and adds it to
     * sets value of the Player objects int score variable to the sum of it's value at function call and the
     * value of the integer argument.
     */
    public void addToScore(int diceThrow) {
        score += diceThrow;
    }

    /*
    * incrementTurnCounter() increases the value of the Player objects turnCounter variable by 1
    */
    public void incrementTurnCounter(){
        turnCounter++;
    }

    /*
    * getFullName() returns a String consisting of the Player objects String firstName value and its String lastName
    * value with a space between the two
    * */
    public String getFullName() {
        return firstName + " " + lastName;
    }
}
