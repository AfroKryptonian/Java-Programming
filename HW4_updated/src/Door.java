
/**
 * 
 * @author David Chukwuma and David Mawazo
 * Andrew ID: dchukwue, dmawazo
*  On my honor, as a Carnegie-Mellon Rwanda student, I have neither
*  given nor received unauthorized assistance on this work.

 */
public class Door
{
    String doorStatus="open";

    public Door() 
    {
        
    }
    
    public Boolean isOpen()
    {
        return doorStatus.equals("open");
    }
    
    
    public void openDoor(int floor)
    {
        doorStatus="open";
        System.out.println("Opening door at floor "+floor);
        
    }

    public void closeDoor()
    {
        doorStatus="closed";
        System.out.println("Closing door.");
        
    }
    
    public String toString()
    {
        String str = "";
        if (isOpen()) 
        {
            str = "The door is open.";
        } else
        {
            str = "The door is closed.";
        }

        return str;
    }
}
