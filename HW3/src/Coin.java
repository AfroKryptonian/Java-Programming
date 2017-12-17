/**
 * This class creates the coin element and generates random numbers to represent the HEADS and TAILS of the Coin. 
 * It uses enumeration to set the HEADS and TAILS elements
 * 
 * @author David Mawazo
 *
 * Andrew ID: dmawazo
 *
 * On my honor, as a Carnegie-Mellon Africa student, 
 * I have neither given nor received unauthorized assistance on this work.
 */

import java.util.*;

public class Coin
{
	//enumeration declaration for CoinSide that sets defaults of Heads and Tails.
	
	private enum CoinSide
	{
		HEADS, TAILS
	};
	

	private static Random r = new Random();
	private CoinSide sideUp;
	private int coin1;

	//Coin constructor
	
	public Coin()
	{
			sideUp = CoinSide.HEADS;

	}

	//Method to check when the coin side is facing Heads.
	
	public boolean isHeads()
	{
		if(sideUp == CoinSide.HEADS )
		{
			return true;
		}
		
		else
			return false;
	}

	//Method to check when the coin side is facing Tails.
	
	public boolean isTails()
	{
		if(sideUp == CoinSide.TAILS)
		{
			return true;
		}
		
		else
			return false;
	}

	// Method to conduct the coin flip and set Heads to 0 and Tails to 1.
	
	public void flip()
	{
		// Generate a random number, either 0 or 1, and use it to set sideUp to HEADS or
		// TAILS

		coin1 = r.nextInt(2);


		if(coin1 == 0) 
		{
			sideUp = CoinSide.HEADS;

		}

		if(coin1 == 1)
		{
			sideUp = CoinSide.TAILS;
		}
	}

	//toString method to print out the side the coin is facing.
	public String toString()
	{
		return ("Coins side up is: " + sideUp);
	}
}