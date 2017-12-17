import java.awt.Color;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author David Mawazo
 *
 *         Andrew ID: dmawazo
 *
 *         On my honor, as a Carnegie-Mellon Africa student, I have neither
 *         given nor received unauthorized assistance on this work.
 * 
 *         This is the application class used to draw the HalfCircle graphic, prompt
 *         the user for attributes to change the position and color of the
 *         Half circle.
 */

public class TestHalfCirclePG
{
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		String str;
		String str2;
		String str3;
		String[] coords;
		String[] dimensions;

		JFrame frame = new JFrame();

		HalfCirclePG hCircle = new HalfCirclePG();

		frame.add(hCircle);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setVisible(true);
		hCircle.setSize(frame.getSize());
		hCircle.setPreferredSize(frame.getSize());

		System.out.println(hCircle);

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
			// dimensions = str2.split(",");

			int xCoord = Integer.parseInt(coords[0]);
			int yCoord = Integer.parseInt(coords[0]);

			int circDiameter = Integer.parseInt(str2);

			Color circColor = ColorConverter.getColor(str3);

			hCircle.setNewLocation(xCoord, yCoord, circDiameter, circDiameter);

			hCircle.setDiameter(circDiameter);

			hCircle.setHalfCirColor(circColor);

			hCircle.repaint();
			System.out.println(hCircle);

			System.out.println("Enter the coordinates of the center as x,y: ");
			str = keyboard.readLine();
		}

	}

}
