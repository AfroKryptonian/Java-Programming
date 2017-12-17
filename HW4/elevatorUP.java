/**
 *
 * @author David Mawazo
 *
 * Andrew ID: dmawazo
 *
 * On my honor, as a Carnegie-Mellon Africa student, 
 * I have neither given nor received unauthorized assistance on this work.
 */


public class elevatorUP
{

	public static int goUP(int enteredfloor, int currentfloor)
	{
		if (enteredfloor > 20) {
			System.out.println("Invalid Floor");
			return currentfloor;
		} else {
			System.out.println("Closing door");

			for (int i = currentfloor + 1; i < enteredfloor; i++) {
				System.out.println("Going up floor " + i);
			}

			System.out.println("Opening door at floor " + enteredfloor);

			System.out.println("\nThe elevator is on floor " + enteredfloor);
			return currentfloor = enteredfloor;
		}

	}

}