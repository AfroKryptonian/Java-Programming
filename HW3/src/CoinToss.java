/**
 *A program used for a tossing a coin N times, where N is a value passed in through command-line arguments.
 *
 * @author David Mawazo
 *
 * Andrew ID: dmawazo
 *
 * On my honor, as a Carnegie-Mellon Africa student, 
 * I have neither given nor received unauthorized assistance on this work.
 */

import java.io.IOException;

public class CoinToss
{

	
	public static void main(String [] args) throws IOException
	{

		//Coin class call and declaration of the numHeads and numTails variables.
		
		Coin test = new Coin();
		int numHeads = 0;
		int numTails = 0;

	
		//integer declaration to take in command-line argument when passed in.
		
		int N = Integer.parseInt(args[0]);

		for (int i = 1; i <= N; i++)
		{
			test.flip();
			if (test.isHeads())
			{
				numHeads += 1;
			} else if (test.isTails())
			{
				numTails += 1;
			}
		}

		System.out.println("java Coin " + N + "\n" + "Tossed a coin " + N + " times.");
		System.out.println("Heads: " + numHeads + " Tails: " + numTails);

		System.out.println("Heads: " + formatPercent(numHeads, N) + "%" + " Tails: " + formatPercent(numTails, N) + "%");


	}

	//Method used to calculate the percentage of the Heads and Tails based on the total number of tosses.
	
	public static String formatPercent(int number, int total)
	{
		double percentage = ((double) number / total) * 100;

		return String.valueOf(percentage);
	}

}
