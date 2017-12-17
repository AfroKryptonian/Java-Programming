import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFrame;

/**
 *
 * @author David Mawazo
 *
 *         Andrew ID: dmawazo
 *
 *         On my honor, as a Carnegie-Mellon Africa student, I have neither
 *         given nor received unauthorized assistance on this work.
 * 
 *         This is the application class used to draw the Circle graphic, prompt
 *         the user for attributes to change the position and color of the
 *         circle.
 */

public class TestCirclePG
{

	public static void main(String[] args) throws IOException
	{
		String str;
		String str2;
		String str3;
		String[] coords;

		JFrame frame = new JFrame();
		CirclePG circle = new CirclePG();
		frame.add(circle);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setVisible(true);
		circle.setSize(frame.getSize());
		circle.setPreferredSize(frame.getSize());

		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the coordinates of the center as x,y: ");
		str = keyboard.readLine();

		while (!str.equals(""))
		{

			System.out.println("Enter the diameter of the circle: ");
			str2 = keyboard.readLine();

			System.out.println("Enter the color of the circle: ");
			str3 = keyboard.readLine();

			coords = str.split(",");

			int xCoord = Integer.parseInt(coords[0]);
			int yCoord = Integer.parseInt(coords[0]);

			int circDiameter = Integer.parseInt(str2);

			Color circColor = ColorConverter.getColor(str3);

			circle.setNewLocation(xCoord, yCoord, circDiameter, circDiameter);

			circle.setNewSize(circDiameter);
			circle.setCirColor(circColor);

			circle.repaint();
			System.out.println(circle);

			System.out.println("Enter the coordinates of the center as x,y: ");
			str = keyboard.readLine();
		}
	}

}
