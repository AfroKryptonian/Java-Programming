import java.io.*;
import java.util.*;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 *
 * @author David Mawazo
 *
 *         Andrew ID: dmawazo
 *
 *         On my honor, as a Carnegie-Mellon Africa student, I have neither
 *         given nor received unauthorized assistance on this work.
 */

public class MadStory
{
	private LinkedList<String> story = new LinkedList<String>();
	private Stack<MadPrompt> prompts = new Stack<MadPrompt>();
	private boolean isReady = false;

	// Read a story from the file.

	// read a line of data
	// while input OK

	// Call your MadUtils.smartSplit() method
	// It should indicate that it got a blank link with null
	// This means it's a paragraph break - add the empty string to your
	// story, read a line, then continue.
	// not a paragraph, so add the words to the story
	// read a line of data

	public void readFromFile(String filename)
	{

		List<String> wordList;
		story.clear(); // Clear the LinkedList

		InputDatafile datafile = new InputDatafile(filename);

		datafile.open();

		if (!datafile.isOpen())
		{
			System.out.println("Cannot open " + datafile.getName() + " for reading. Program ending.");
			System.exit(0);
		}

		String inputName;
		inputName = datafile.readString();

		while ((inputName != null))
		{

			String[] words = MadUtils.smartSplit(inputName);

			if (words != null)
			{

				wordList = Arrays.asList(words);
				story.addAll(wordList); //Add items to LinkedList

			}

			else
			{
				story.add(" ");
			}

			inputName = datafile.readString();
		}

		datafile.close();
	}

	// Play the game

	public boolean play(BufferedReader keyboard) throws IOException
	{
		// ----------- You write the code -----------//
		// Process the MadPrompts stack - use the proper terms and method
		// for procesisng a Stack.

		// For each MadPrompt taken off the Stack, prompt the user (use
		// Utils.getIndefiniteArticle())
		// then use the entered value to replace the mad word in the story LinkedList.

		String str;
		MadPrompt p;

		if (!isReady)
			return false;

		// isReady = false;

		while (!prompts.isEmpty())
		{

			Utils.printStack(prompts);

			System.out.println("\nEntry " + (prompts.size() - 1));

			p = prompts.lastElement();
			StringBuffer stackWord = p.getDefinition();
			String wordToCheck = stackWord.toString();

			System.out.println("Please enter a word for " + Utils.getIndefiniteArticle(wordToCheck) + " " + stackWord);
			str = keyboard.readLine();

			String madWord = story.get(p.getNumWords() - 1);

			story.set(p.getNumWords() - 1, MadUtils.replaceMadWord(madWord, str));

			prompts.pop();

		}

		return true;
	}

	// Set up the game

	public boolean setupGame(BufferedReader keyboard, MadDictionary dictionary) throws IOException
	{
		// ----------- You write the code -----------//
		// Look up the definition in the dictionary, using your MadUtils.lookupWord()
		// method
		// create a MadPrompt using numWords and the definition
		// add it to the Stack (use the proper method for a Stack)
		
		MadPrompt p;
		StringBuffer madDef;
		String str;
		ObjectOutputStream out;

		int numWords = 0;

		// Iterate through the story

		for (String word : story)
		{
			numWords++;
			str = MadUtils.getMadWord(word);
			
			if (str != null)
			{
				
				madDef = MadUtils.lookupWord(str, dictionary, keyboard);
				
				if(madDef==null)
					return false;
				

				p = new MadPrompt(numWords, madDef);
				prompts.push(p);

			}
		}

		out = new ObjectOutputStream(new FileOutputStream("MadDictionary.dat"));
		out.writeObject(dictionary);
		out.close();

		isReady = true;
		return true;
	}


	// ----------- You write the code -----------//
	// Print the story to the screen
	// Be sure to show the paragraph markers.

	// Start by printing the MadWords, but update it to formate
	// format it into lines of n characters, with the MadWord replaces with
	// underscores
	// and the MadPrompt on the line below.

	public void print(int n)
	{

		String madDash = "";
		String def = "";
		Stack<MadPrompt> tempPrompts = new Stack<MadPrompt>();
		MadPrompt p = null;
		int pSize = prompts.size();

		for (int i = 0; i < pSize; i++)
		{
			p = prompts.pop();
			tempPrompts.push(p);
		}

		for (String listwords : story)
		{
			String madWord = MadUtils.getMadWord(listwords);

			if (madWord != null)
			{
				madDash = madDash + listwords.replaceAll("[A-Za-z0-9\\[\\]]", "_") + " ";

				if (!tempPrompts.isEmpty())
				{
					p = tempPrompts.pop();

					def = def + p.getDefinition() + " ";
				}
			}
			else
			{
				madDash = madDash + listwords + " ";
				def = def + listwords.replaceAll("[A-Za-z0-9 \\[\\,\\.\\'\\:\\?]", " ") + " ";
			}

			if (madDash.length() >= n)
			{
				System.out.println(madDash);
				System.out.println(def);
				System.out.println();
				madDash = "";
				def = "";
			}

		}
		System.out.println(madDash);
		System.out.println(def);
		System.out.println();

	}

	public void printPDF(int n)
	{
		String madDash = "";
		String def = "";
		Stack<MadPrompt> tempPrompts = new Stack<MadPrompt>();
		MadPrompt p = null;
		int pSize = prompts.size();

		for (int i = 0; i < pSize; i++)
		{
			// p =prompts.lastElement();
			p = prompts.pop();
			tempPrompts.push(p);
		}

		try
		{
			OutputStream file = new FileOutputStream(new File("example.pdf"));
			Document doc = new Document();
			PdfWriter.getInstance(doc, file);
			doc.open();

			for (String listwords : story)
			{
				String madWord = MadUtils.getMadWord(listwords);

				if (madWord != null)
				{
					madDash = madDash + listwords.replaceAll("[A-Za-z0-9\\[\\]]", "_") + " ";

					if (!tempPrompts.isEmpty())
					{
						p = tempPrompts.pop();

						def = def + p.getDefinition() + " ";
					}
				}
				else
				{
					madDash = madDash + listwords + " ";
					def = def + listwords.replaceAll("[A-Za-z0-9 \\[\\,\\.\\'\\:\\?]", " ") + " ";
				}

				if (madDash.length() >= n)
				{
					doc.add(new Paragraph(madDash));
					doc.add(new Paragraph(def));
					doc.add(new Paragraph());
					madDash = "";
					def = "";
				}

			}

			doc.add(new Paragraph(madDash));
			doc.add(new Paragraph(def));
			doc.add(new Paragraph());

			doc.close();
			file.close();
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
