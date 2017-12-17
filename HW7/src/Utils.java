import java.util.*;

public class Utils
{

	// Return "a" or "an", which ever matches wordToCheck

	public static String getIndefiniteArticle(String wordToCheck)
	{
		if (wordToCheck.startsWith("a") || wordToCheck.startsWith("e") || wordToCheck.startsWith("i")
				|| wordToCheck.startsWith("o") || wordToCheck.startsWith("u"))
		{
			return "an";
		}

		return "a";
	}

	// This method will print a Stack as a Vector

	public static void printStack(Vector<? extends Object> stack)
	{
		int i = 0;
		for (Object e : stack)
		{
			System.out.println("\n\nEntry " + i + ": " + e);
			i++;
		}
	}

}
