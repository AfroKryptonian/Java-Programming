

import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * @author David Chukwuma & David Mawazo Andrew ID: dchukwue, dmawazo On my
 *         honor, as a Carnegie-Mellon Rwanda student, I have neither given nor
 *         received unauthorized assistance on this work.
 * 
 */
public class PhraseList
{

    /**
     * @param args
     */
    private static int numNames = 0; // number of phrases counted
    private static ArrayList<String> phraseArray = new ArrayList<String>();

    public void addToPhraselist(String str)
    {
        if (!isBlank(str))
        {
            phraseArray.add(str);
        } else
        {
            System.out.println("You can't enter a blank phrase");
        }

    }

    public void clearPhraselist()
    {
        phraseArray.clear();
    }

    public String toString()
    {
        return "There are " + numNames + " phrases in the phrase List";
    }

    public void printPhraseList()
    {
        int i = 0;
        for (String phrase : phraseArray)
        {
            System.out.println("Phrase " + i + ": " + phrase);
            i++;
        }

    }

    public String getRandomPhrase()
    {

        String filename;

        int i = 0; // counter

        filename = "phraselist.txt";

        InputDataFile datafile = new InputDataFile(filename);
        datafile.open();

        if (!datafile.isOpen())
        {
            System.out.println("Cannot open " + datafile.getName() + " for reading. Program ending.");
            System.exit(1);
        }

        String inputName;
        inputName = datafile.readString();

        while (inputName != null)
        {
            /*
             * if (numNames >= phraseArray.length) {
             * System.err.println("Sorry, this program can only accept up to "+
             * phraseArray.length +" names"); break; }
             */
            numNames++;
            phraseArray.add(inputName);
            // System.out.println("Trace message - processed " + inputName + " added it.");
            inputName = datafile.readString();

        }

        datafile.close();
        // System.out.println();
        // System.out.println("I read in " + numNames + " names from " + filename +
        // ".");

        Random r = new Random();
        int random = r.nextInt(phraseArray.size());
        String randomString = phraseArray.get(random);
        return randomString;

    }

    public static Boolean isBlank(String string)
    {
        if (string.trim().length() == 0)
            return true;
        else
            return false;
    }

}
