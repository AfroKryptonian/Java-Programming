
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author David Chukwuma and David Mawazo
 * Andrew ID: dchukwue, dmawazo
*  On my honor, as a Carnegie-Mellon Rwanda student, I have neither
*  given nor received unauthorized assistance on this work.

 */




public class RunElevator
{
    private static int destinationfloor;
    private static String str = "";
    
    
    

    public static void main(String[] args) throws IOException
    {
        Elevator box= new Elevator(); 
        
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("\nThe elevator is on Floor "+box.getCurrentFloor());
        
        System.out.println("\nPlease enter the new floor (Enter to quit)");
        str = keyboard.readLine();
        

        while (!isBlank(str))
            {

            destinationfloor = Integer.parseInt(str);
            
            if (!box.move(destinationfloor)) 
            {
               System.out.println("Invalid Floor!");
            }
            
            
            System.out.println("\nThe elevator is on Floor "+box.getCurrentFloor());


            System.out.println("\nPlease enter the new floor (Enter to quit)");
            str = keyboard.readLine();

        }

        System.out.println("Bye!");

    }

    public static Boolean isBlank(String string)
    {
        if (string.replaceAll("(\\s)", "").length() == 0)
            return true;
        else
            return false;
    }

}
