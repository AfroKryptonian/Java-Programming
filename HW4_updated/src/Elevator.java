/**
 * 
 * @author David Chukwuma and David Mawazo
 * Andrew ID: dchukwue, dmawazo
*  On my honor, as a Carnegie-Mellon Rwanda student, I have neither
*  given nor received unauthorized assistance on this work.

 */
public class Elevator
{

    private int topFloor, bottomFloor, currentFloor, destinationFloor;
    private Door door = new Door();

    public Elevator()
    {
        setTopFloor(20);
        setBottomFloor(1);
        setCurrentFloor(1);
    }

    public int getTopFloor()
    {
        return topFloor;
    }

    public void setTopFloor(int topFloor_)
    {
        // return false if the bottom floor is > topfloor
        // return false if currentfloor is less than top floor
        // return true;
        topFloor = topFloor_;
    }

    public int getBottomFloor()
    {
        return bottomFloor;
    }

    public void setBottomFloor(int bottomFloor_)
    {
        bottomFloor = bottomFloor_;
    }

    public int getCurrentFloor()
    {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor_)
    {
        currentFloor = currentFloor_;
    }

    public int getDestinationFloor()
    {
        return destinationFloor;
    }

    public void setDestinationFloor(int destinationFloor_)
    {
        destinationFloor = destinationFloor_;
    }

    public Boolean move(int destinationFloor_)
    {

        if (destinationFloor_ < bottomFloor || destinationFloor_ > topFloor)
        {
            return false;
        }

        else
        {
            door.closeDoor();
            while (destinationFloor_ != currentFloor)
            {

                if (destinationFloor_ < currentFloor)
                {

                    currentFloor--;

                    if (destinationFloor_ != currentFloor)
                        System.out.println("Going down to floor " + currentFloor);
                    else
                        break;
                }

                if (destinationFloor_ > currentFloor)
                {

                    currentFloor++;
                    if (destinationFloor_ != currentFloor)
                        System.out.println("Going up to floor " + currentFloor);
                    else
                        break;
                }

            }
            door.openDoor(currentFloor);
        }
        return true;
    }

    public String toString()
    {
        String message = "";

        message = ("The top floor is: " + topFloor + ". " + "The bottom floor is: " + bottomFloor + ". "
                + "The current floor is: " + currentFloor + ".");

        return message;
    }

}
