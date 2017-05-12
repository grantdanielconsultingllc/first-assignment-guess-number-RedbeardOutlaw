package com.company;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

//TODO BRONZE
//TODO Announce the range of numbers at start of game
//TODO If the guess is off by 11 or more tell the user they are cold
//TODO If the guess is off by less than 11 tell the user they are warm
//TODO If the guess is off by less than 5 tell the user they are on fire

//TODO SILVER
//TODO Allow the player to decide to play again.
//TODO Every time they win continue show how many guesses they took but also show the total number of games played
//TODO and the average number of guesses across all the games they have played.

//TODO GOLD
//TODO Only allow the player five guesses to win. If they still have not won on the fifth guess tell them they lost.
//TODO Count the number of losses and do not include them in the average guesses to win calculation.


public class Main
{

    public static void main(String[] args)
    {
        //Create a variable to store ther player name.  It will be empty at this point.
        String name;

        //Get a String from the keyboard input and assign it to the variable name
        //The text in quotes is the text the user will see
        name = getStringFromUser("What is your name? ");
        //Now we have the player's name stored in name

        //Created and assign some variables to hold the low and high range values to use when
        //generating a random number
        //The word 'final' means that the variables will not change after they are assigned
        //Variables like this are called constants
        //their initial value
        //By convention final variables have all uppercase names separated by underscore
        final int LOWEST_NUMBER = 1;
        final int HIGHEST_NUMBER = 100;

        //Call a method that returns a random number
        //Save the random number in the variable 'randomNumber'
        //We have to pass it a lower and upper value
        //The first number is the lowest this method will return
        //The second number is one higher than the highest number this method will return
        int randomNumber = ThreadLocalRandom.current().nextInt(LOWEST_NUMBER, HIGHEST_NUMBER + 1);

        //Create a variable to hold the player's guess.
        int guess;

        //Create a variable to hold the number of times the player has guessed
        int guessCount = 0;

        //This is the loop of games that allows the user to guess multiple times
        //The code between the brackets will be repeated until the condition in
        //the while clause is true
        //The while clause is after the closing bracket of the do loop
        do
        {
            //Since our counter starts at 0 we can increment it each time through the loop
            guessCount++;

            //Save off the number the users guess into the 'guess' variable
            guess = getIntFromUser("Guess my secret number: ");

            //If guess is less than the random number we saved off tell the user they are too low
            if (guess < randomNumber)
            {
                System.out.println("Too low!");
            }
            else if (guess > randomNumber)
            {
                System.out.println("Too high!");
            }

        } while (guess != randomNumber);

        System.out.println("Awesome " + name + ", you got it in only " + guessCount + " guesses!");
    }

    private static String getStringFromUser(String prompt)
    {
        System.out.print(prompt);
        String userInput = getUserInput();
        return userInput;
    }

    private static int getIntFromUser(String prompt)
    {
        Integer userInt = null;

        do
        {
            System.out.print(prompt);
            String userInput = getUserInput();

            try
            {
                userInt = Integer.parseInt(userInput);
            }
            catch(Exception e)
            {
                System.out.println("I'm sorry. I can't accept that as an integer. Try again.");
            }

        } while (userInt == null);

        return userInt;
    }

    private static String getUserInput()
    {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        return input;
    }
}
