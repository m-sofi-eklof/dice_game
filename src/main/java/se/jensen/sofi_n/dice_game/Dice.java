package se.jensen.sofi_n.dice_game;
import java.util.Random;

/// CLASS DICE
public class Dice{
    //VARIABLE
    Random random = new Random();

    //INSTANCE METHOD
    /*
    public int roll() generates and returns a random int type number between 1 and 6
    */
    public  int roll(){
        return random.nextInt(1,7);
    }
}
