package se.jensen.sofi_n.dice_game;//KLASS DICE
/*
 * throw()
 * */
//RANDOM SYNTAX
//Random random = new Random();//behöver bara skapas en gång
//int roll = random.nextInt(1,7); //anropas för varje tärningskast


import java.util.Random;

public class Dice{
    /// VARIABLES
    Random random = new Random();//initialises random

    /// INSTANCE METHODS
    /*
    public int roll() generates a number between 1 and 7
    */
    public  int roll(){
        return random.nextInt(1,7);
    }
}
