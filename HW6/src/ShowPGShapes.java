import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class ShowPGShapes
{

	public static void main(String argv[]) throws IOException
	{
		JFrame frame = new JFrame();
		ShowShapes shapes;
		shapes = new ShowShapes();

		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		String str;
		int n;
				
		System.out.println("Enter the number of scoops: ");
		str = keyboard.readLine();
		n = Integer.parseInt(str);

	
		for (int i = 0; i < n; i++)
		{
			System.out.println("Enter the color of the scoop: ");
			String color = keyboard.readLine();
			shapes.addScoop(color);

		}

		// ------------ You write the code ----------------

		// Prompt for the number of scoops then prompt for each color and call
		// shapes.addScoop(). You will write addScoop() - it should take one argument
		// that is the color to use. The argument can be a String or a Color, whichever
		// you prefer. Note: see ShowShapes.java for more comments.

	
		frame.setSize(1000, 850);
		shapes.setSize(frame.getSize());
		shapes.setPreferredSize(frame.getSize());
		frame.add(shapes);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
