/**
 * A program that creates an array of 1001 items and sets all prime number slots
 * to true and prints out the prime values.
 *
 * @author David Mawazo
 *
 * Andrew ID: dmawazo
 *
 * On my honor, as a Carnegie-Mellon Africa student, I have neither
 * given nor received unauthorized assistance on this work.
 */

public class Primes
{

	public static void main(String[] args)
	{
		int n = 1000;
		Primes getPrimes = new Primes();

		getPrimes.prime(n);

	}

	public void prime(int n)
	{
		// create array for the integers and carry out the checks for the prime values
		// based on the Seive of Eratosthenes algorithm

		boolean[] numbers = new boolean[n + 1];
		for (int i = 1; i < numbers.length; i++)
		{
			numbers[i] = true;

		}

		int num = 2;
		while (true)
		{
			for (int x = 2;; x++)
			{

				int multiple = num * x;
				if (multiple > n)
				{
					break;
				}
				else
				{
					numbers[multiple] = false;
				}
			}

			boolean nextNumFound = false;

			for (int i = num + 1; i < n + 1; i++)
			{
				if (numbers[i])
				{
					num = i;
					nextNumFound = true;
					break;
				}
			}

			if (!nextNumFound)
			{
				break;
			}
		}

		// count prime numbers from 1-1000 and print out the values

		for (int i = 0; i < numbers.length; i++)
		{
			if (numbers[i])
			{
				System.out.println(i);
			}
		}
	}

}
