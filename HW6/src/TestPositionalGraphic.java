import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
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
 */

/*
 * 
 * This is the application that is used to draw the positional graphic shape,
 * that would be the bounding rectangle of the child shapes
 * 
 */

public class TestPositionalGraphic
{

	public static void main(String[] args) throws IOException
	{

		String str;
		String str2;
		String str3;
		String[] coords;
		String[] dimensions;

		JFrame frame = new JFrame();

		PositionalGraphic pg = new PositionalGraphic();

		frame.add(pg);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);

		pg.setSize(frame.getSize());
		pg.setPreferredSize(frame.getSize());

		frame.setVisible(true);

		System.out.println(pg);

		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the coordinates of the center as x,y: ");
		str = keyboard.readLine();

		while (!str.equals(""))
		{

			System.out.println("Enter the width and height of the rectangle as w , h: ");
			str2 = keyboard.readLine();

			System.out.println("Enter the color of the Bounding Rectangle: ");
			str3 = keyboard.readLine();

			coords = str.split(",");
			dimensions = str2.split(",");

			int xCoord = Integer.parseInt(coords[0]);
			int yCoord = Integer.parseInt(coords[1]);

			int recWidth = Integer.parseInt(dimensions[0]);
			int recHeight = Integer.parseInt(dimensions[1]);

			// Call to ColorConverter class that converts a user's input color to the color
			// component.

			Color recColor = ColorConverter.getColor(str3);

			// Calls the setNewLocation method to calculate the new starting point for the
			// bounding rectangle, as well as set its width, height and color.
			
			pg.setNewLocation(xCoord, yCoord, recWidth, recHeight);
			pg.setWidthHeight(recWidth, recHeight);
			pg.setShapeColor(recColor);

			pg.repaint();
			System.out.println(pg);

			System.out.println("Enter the coordinates of the center as x,y: ");
			str = keyboard.readLine();

		}

	}
}
