import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author David Mawazo
 *
 * Andrew ID: dmawazo
 *
 * On my honor, as a Carnegie-Mellon Africa student, 
 * I have neither given nor received unauthorized assistance on this work.
 */

/**
 * @author dmawazo
 *
 */
public class MadDictionary implements Serializable
{

	HashMap<String, StringBuffer> madWords = new HashMap<String, StringBuffer>();

	public StringBuffer addWord(String word, StringBuffer description)
	{
		if (getDescription(word) != null)
			return null; // indicates it is already in the list

		// write method to call the key(word) and value (descripion into the
		// HashMap(madWords)
		madWords.put(word, description);

		return description;

	}

	public StringBuffer getDescription(String word)
	{

		StringBuffer description =	null;
		
		// write the code to set description to the value in madWords for the key
		description = madWords.get(word);
		
		return description;

	}

	public void print()
	{

		for (String key : madWords.keySet())
		{
			// write the system out call to print the key and value in madWords

			System.out.println("The word " + key + " has a value of: " + madWords.get(key));
		}
	}

}
