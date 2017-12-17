
public class elevatorDOWN
{

	public static int goDOWN(int enteredfloor, int currentfloor)
	{
		if (enteredfloor < 1) {
			System.out.println("Invalid Floor");
			return currentfloor;
		} else {
			System.out.println("Closing door");

			for (int i = currentfloor - 1; i > enteredfloor; i--) {
				System.out.println("Going down floor " + i);
			}

			System.out.println("Opening door at floor " + enteredfloor);

			System.out.println("\nThe elevator is on floor " + enteredfloor);
			return currentfloor = enteredfloor;
		}

	}
}
