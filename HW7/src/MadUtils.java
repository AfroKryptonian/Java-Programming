import java.io.*;
import java.util.*;

/**
 *
 * @author David Mawazo & Cathy Bishop
 *
 *         Andrew ID: dmawazo
 *
 *         On my honor, as a Carnegie-Mellon Africa student, I have neither
 *         given nor received unauthorized assistance on this work.
 */
public class MadUtils
{


	/*
	 * This method will lookup the word in the MadDictionary d. If it does not
	 * exists, the method return null;
	 *
	 */

	public static StringBuffer lookupWord(String word, MadDictionary d) throws IOException
	{
		return lookupWord(word, d, null);
	}

	/*
	 * This method will lookup the word in the MadDictionary d. If it exists in the
	 * dictionary, it is returned. If it does not exist, and keyboard is not null,
	 * it will prompt for the MadDefinition, add it to the MadDictionary, and return
	 * it.
	 */

	
	public static StringBuffer lookupWord(String word, MadDictionary d, BufferedReader keyboard) throws IOException
	{
		String str;
		StringBuffer definition = null;

		definition = d.getDescription(word);
		
		if (definition != null)
			return definition;

		else if (keyboard != null)
		{
			System.out.println("Word: " + word + " not in MadDictionary. Please enter the description: ");
			definition = new StringBuffer(keyboard.readLine());
			d.addWord(word, definition);
			
			return definition;

		}
		
		else 
		{
			return definition = null;
		}
	}

	/*
	 * This method returns the MadWord, which is the text within [ and ]. The method
	 * return null if there is no MadWord (no [ ], empty string, null pointer, ...)
	 *
	 */

	public static String getMadWord(String str)
	{
		String str1 = null;

		if (str.contains("["))
		{
			 str = str.replaceAll("(\\p{Punct})", "");
			return str;
		}

		return str1;

		
	}

	// This method returns a String that has the text within [ and ] of madWord
	// replaced with newWord.

	public static String replaceMadWord(String madWord, String newWord)
	{
		String str = madWord;
		String nWord =	null;

		if (str.contains("["))
		{
			nWord = str.replaceAll("\\[.*?\\]", "");
			
		}
		
		String userWord = newWord +  nWord;
		
		return userWord;
	}

	public static String[] smartSplit(String inputName)
	{
		String [] words = null;
		
		if (inputName.length() < 1)
		{
			return words;
		}
		
		else
		{
		words = inputName.split("\\s+(?![^\\[]*\\])");
		}
		
		return words;

	}
}
