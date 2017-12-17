import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.ShutdownChannelGroupException;

/**
 * 
 * @author David Chukwuma & David Mawazo
 * Andrew ID: dchukwue, dmawazo 
*  On my honor, as a Carnegie-Mellon Rwanda student, I have neither
*  given nor received unauthorized assistance on this work.

 */
public class GuessWord
{

    
    private static String str = "";
    
    private static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException
    {
        
        
        System.out.println("***********************************************************");
        System.out.println("Welcome to David and David's fabulous word-guessing game!");
        System.out.println("***********************************************************\n");
        
        System.out.println("Would you like to play?");
        str= keyboard.readLine();
        
        while(isBlank(str)||isYes(str))
        {
            playGame();
            System.out.println("***********************************************************");
            System.out.println("\nWould you like to play again?");
            str= keyboard.readLine();
        }
           System.out.println("***************************************************************");
           System.out.println("Bye, Thanks for playing David and David's word-guessing game!"); 
           System.out.println("***************************************************************");
         
        
        
    }
    
    public static void playGame() throws IOException 
    {
        PhraseList trial = new PhraseList();
        SecretString guessString = new SecretString(trial.getRandomPhrase());
        int numOfTries = 1;
        
        System.out.println(guessString);
         
        
        while (!guessString.hasGameFinished()) 
        {
            
            numOfTries++;
            System.out.println("\nGuess the phrase:");
            str = keyboard.readLine().toLowerCase();
            
            if (!guessString.revealPhrase(str)) 
            {
              System.out.println("\nNo, that's not it.");
            }
            
            System.out.println(guessString);
            
            if (guessString.hasGameFinished())
            {
                break;
            }
            
            System.out.println("\nGuess a letter:");
            str = keyboard.readLine().toLowerCase();
                    
            guessString.revealLetters(str);//how the code stops
            System.out.println(guessString);
            
        }
        

        System.out.println("\n**Yes, that's it! You guessed it in "+numOfTries+" tries");
        

    }

    public static Boolean isBlank(String string)
    {
        if (string.trim().length() == 0)
            return true;
        else
            return false;
    }
    
    public static Boolean isYes(String string) 
    {
        if (string.equalsIgnoreCase("yes")||string.equalsIgnoreCase("yep")||string.equalsIgnoreCase("y"))
            return true;
        else
            return false;
        
        
    }
}
