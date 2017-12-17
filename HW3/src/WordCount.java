/**
 * *A program that prompts the user for a series of string input, up to a maximum of 10. 
 *Stores the input in an array and processes the splitting of the input into individual letters, words and sentences.
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
import java.util.regex.Pattern;

public class WordCount
{

	private static int count = 0;
	private static String input = "";
	private static String[] dataInput = new String[10];

	public static void main(String args[]) throws IOException
	{

		String sentinel = "";

		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

		// Request for user input and count the number of entries till they press Enter
		// to exit. The user input would be stored in an array.

		System.out.println("Please enter your lines of data : ");
		input = keyboard.readLine();
		int x = 0;

		for (x = 0; x < dataInput.length; x++)
		{
			if (!input.equals(sentinel))
			{
				dataInput[x] = input;
				System.out.println("Please enter your lines of data. Press Enter to exit:  ");
				input = keyboard.readLine();
				count++;
			}

			else
			{
				break;

			}

		}

		
		/*
		 * Display of the results of the user's entries, the sentences, words and
		 * letters split respectively. Calls the respective sentence, words and letters
		 * arrays for the input and split them up respectively.
		 */

		System.out.println("Thank you for entering " + count + " lines of data. Here are your results: ");

		for (int i = 0; i < count; i++)
		{
			input = dataInput[i];

			String[] sentences = splitSentences(input);
			String[] words = splitWords(input);
			Character[] letters = splitLetters(input);

			System.out.println("**Line " + (i + 1) + ": " + input);
			System.out.println("Counts (letters, words, sentences):  " + letters.length + " " + words.length + " "
					+ sentences.length);

			printArray("letter", letters);
			printArray("word", words);
			printArray("sentence", sentences);

			System.out.println();

		}
	}

	
	/* Array method splitLetters() used to split the user's entries to the
	*respective letters and stored in an array.
	*/
	
	public static Character[] splitLetters(String input)
	{
		int arraySize = input.length();
		Character[] letters = new Character[arraySize];

		for (int i = 0; i < arraySize; i++)
			letters[i] = input.charAt(i);

		return letters;
	}

	// Array method splitWords() used to split the user's entries to the respective
	// words and stored in an array.

	public static String[] splitWords(String input)
	{
		String userWords = input;
		String[] words = userWords.split(" ");
		return words;

	}

	// Array method splitSentences() used to split the user's entries to the
	// respective sentences and stored in an array.

	public static String[] splitSentences(String input)
	{
		String userSentences = input.replaceAll("[.?!]", "");
		Pattern toRemove = Pattern.compile(";");
		String[] sentences = toRemove.split(userSentences);
		return sentences;

	}

	// printArray method that is used to print the contents of the Letters, Words
	// and Sentences arrays.

	public static void printArray(String label, Object array[])
	{

		if (label.equals("letter"))
			for (int i = 0; i < splitLetters(input).length; i++)
			{
				System.out.println("Letter [ " + i + "] :" + array[i]);
			}

		if (label.equals("word"))
			for (int i = 0; i < splitWords(input).length; i++)
			{
				System.out.println("Word [ " + i + "] :" + array[i]);
			}

		if (label.equals("sentence"))
			for (int i = 0; i < splitSentences(input).length; i++)
			{
				System.out.println("Sentence [ " + i + "] :" + array[i]);
			}
	}
}
