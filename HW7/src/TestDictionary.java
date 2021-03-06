import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
public class TestDictionary
{
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		MadDictionary dictionary = new MadDictionary();
		ObjectOutputStream out;
		ObjectInputStream in;

		String str;
		StringBuffer madDef;
		String dictionaryFileName = "MadDictionary.dat";

		File tempFile = new File("MadDictionary.dat");
		boolean exists = tempFile.exists();

		if (exists)
		{
			in = new ObjectInputStream(new FileInputStream(dictionaryFileName));
			dictionary = (MadDictionary) in.readObject();
		}

		System.out.println("Enter a word and I will look it up or add it to the Mad Dictionary:");

		str = keyboard.readLine();
		while (!str.equals(""))
		{
			madDef = lookupWord(str, dictionary, keyboard);
			System.out.println("The MadDefinition for " + str + " is: " + madDef);
			System.out.println();
			System.out.print("Enter another word: ");
			str = keyboard.readLine();
		}

		dictionary.print();

		out = new ObjectOutputStream(new FileOutputStream(dictionaryFileName));
		out.writeObject(dictionary);
		out.close();
	}

	public static StringBuffer lookupWord(String word, MadDictionary d, BufferedReader keyboard) throws IOException
	{
		String str;
		StringBuffer definition;

		definition = d.getDescription(word);
		if (definition != null)
			return definition;

		System.out.println("Word: " + word + " not in MadDictionary. Please enter the description: ");
		definition = new StringBuffer(keyboard.readLine());
		d.addWord(word, definition);

		return definition;
	}

}
