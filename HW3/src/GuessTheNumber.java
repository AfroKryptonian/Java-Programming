
/**
 *This program prompts a user to guess a number that is randomly generated in a given range. 
 *The user is allowed to guess numerous times until they are correct and are given the number of attempts it took them.
 *
 * @author David Mawazo
 *
 * Andrew ID: dmawazo
 *
 * On my honor, as a Carnegie-Mellon Africa student, 
 * I have neither given nor received unauthorized assistance on this work.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class GuessTheNumber
{

	static Random r = new Random();
	static String str;
	static int maxRange;
	static int num;
	static int guessNum;

	static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

	// guess Method creation that accepts an integer value for the maximum range and
	// generates the random number to be guessed.
	// prompts the user to guess the random number

	public static int guess(int maxRange) throws IOException
	{
		int count = 0;

		num = 1 + r.nextInt(maxRange);

		// prompt action by the program to guess the number and gives an account of the
		// number of tries it has taken to be successful

		while (true)
		{
			System.out.println("I am thinking of a number between 1 and " + maxRange + " Can you guess it? ");
			str = keyboard.readLine();
			guessNum = Integer.parseInt(str);
			count++;

			if (guessNum == num)
			{
				System.out.println("CONGRATULATIONS!! You guessed the correct number!");
				System.out.println("You guessed it " + count + " times.");

				if (count <= log2(maxRange))
				{

					System.out.println("You either know the secret or you got lucky!");
				}

				else if (count > log2(maxRange))
					System.out.println("You should do better");

				break;
			}

			if (guessNum < num)
			{
				System.out.println("Sorry!! Your number was too low!");
			}

			else
			{
				System.out.println("Sorry!! Your number was too high!");
			}

			System.out.println("Please try again!");
			guessNum = Integer.parseInt(str);
		}

		return count;
	}

	// Method log2() that accepts an integer variable, to use to calculate the
	// number of tries it should take the user to be successful

	public static int log2(int log) throws IOException
	{

		int guessTries = (int) Math.round((Math.log10(log)) / Math.log10(2.));

		return guessTries;

	}

	// Method checkBlank accepts a String input to check for a blank when the user
	// is prompted to want to play again

	public static boolean checkBlank(String input)
	{
		String checkedString = input.replaceAll(" ", "");
		if (checkedString.length() == 0)
		{
			return true;
		}

		else
		{
			return false;
		}
	}

	// Method checkYes that checks for the user's input of "yes" to carry on playing
	// again. Cases are ignored.

	public static boolean checkYes(String input)
	{
		if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("yep"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static void main(String args[]) throws IOException
	{
		String response;

		// Initializing the maximum range for the random number to be generated and
		// calling the guess method to pass in the maximum range value.
		
		do
		{
			maxRange = 1 + r.nextInt(1000);

			guess(maxRange);

			System.out.println("Do you want to play again? Type 'Yes', 'Y' or 'Yep' to continue: ");
			response = keyboard.readLine();

		}

		while (checkBlank(response) == true || checkYes(response) == true);

	}

}
