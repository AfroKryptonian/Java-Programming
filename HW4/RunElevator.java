import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author David Mawazo
 *
 * Andrew ID: dmawazo
 *
 * On my honor, as a Carnegie-Mellon Africa student, 
 * I have neither given nor received unauthorized assistance on this work.
 */


public class RunElevator
{

	private static int enteredfloor;
	private static String str = "";
	private static int currentfloor = 1;

	public static void main(String[] args) throws IOException
	{

		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("The elevator is on floor" + currentfloor +"\n");
		System.out.println("Enter floor number");
		str = keyboard.readLine();
		

		while (!isBlank(str)) {

			enteredfloor = Integer.parseInt(str);

			if (enteredfloor < currentfloor) {

				currentfloor = elevatorDOWN.goDOWN(enteredfloor, currentfloor);
			}

			else if (enteredfloor > currentfloor) {

				currentfloor = elevatorUP.goUP(enteredfloor, currentfloor);

			}

			System.out.println("\nPlease enter the new floor number");
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
