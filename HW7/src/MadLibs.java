import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;

/**
 *
 * @author David Mawazo
 *
 *         Andrew ID: dmawazo
 *
 *         On my honor, as a Carnegie-Mellon Africa student, I have neither
 *         given nor received unauthorized assistance on this work.
 */

public class MadLibs
{

	private static String str = "";
	private static String strFile = "";
	static ObjectInputStream in;

	private static MadStory story = new MadStory();
	private static MadDictionary dictionary = new MadDictionary();
	private static String dictionaryFileName = "MadDictionary.dat";
	private static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
	private static int playNum;

	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		File tempFile = new File("MadDictionary.dat");
		boolean exists = tempFile.exists();

		if (exists)
		{
			in = new ObjectInputStream(new FileInputStream(dictionaryFileName));
			dictionary = (MadDictionary) in.readObject();

		}
		
		System.out.println("\n***********************************************************");
		System.out.println("Welcome to Mawazo's MadLib Game!");
		System.out.println("***********************************************************\n");
		
		
		System.out.println(
				"Would you like to be a Player or Administrator? \nPress 1 for Player. \nPress 2 for Adminsitrator ");
		str = keyboard.readLine();

		if (str.equals("1"))
		{
			isPlayer();
			

		}

		else if (str.equals("2"))
		{
			isAdmin();
		}

	
	}

	public static void isPlayer() throws IOException
	{
		Boolean setupCheck;

		System.out.println("\nEnter the file name for your story: ");

		strFile = keyboard.readLine();

		while (strFile != null)
		{

			story.readFromFile(strFile);

			setupCheck = story.setupGame(null, dictionary);

			if (setupCheck != true)
			{
				System.out.println("\nSorry! The MadLib you selected cannot be played until the Admin sets it.");
			}

			else
			{
				System.out.println("\nThe MadLib is well set up to be played. Enjoy!");

				printMadLib();

			}

			System.out.println("\nEnter the file name for your story: ");
			strFile = keyboard.readLine();
		}

	}

	public static void isAdmin() throws IOException
	{
		System.out.println("\nEnter the file name for your story: ");

		strFile = keyboard.readLine();

		while (strFile != null)
		{
			story.readFromFile(strFile);
			story.setupGame(keyboard, dictionary);

			printMadLib();

			System.out.println("\nEnter the file name for your story: ");

			strFile = keyboard.readLine();
		}

	}

	public static void printMadLib() throws IOException
	{
		System.out.println("\nPrint or Play MadLib! \nEnter 1 to print MadLib to screen. "
				+ "Enter 2 to print MadLib to PDF. Enter 3 to play MadLib on screen: ");

		playNum = Integer.parseInt(keyboard.readLine());

		if (playNum == 1)
		{
			story.print(80);
		}

		else if (playNum == 2)
		{
			story.printPDF(80);
		}

		else if (playNum == 3)
		{
			// story.print(80);
			story.play(keyboard);
			story.print(80);
		}

		else
		{
			System.out.println("\nPlay mode ending.");

		}

	}

}
