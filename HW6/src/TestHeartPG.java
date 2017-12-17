import java.awt.Color;
import java.awt.Rectangle;
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
 *         This is the application class used to draw the Heart graphic, from
 *         the HeartPG class. prompt the user for attributes to change the
 *         position and color of the Heart.
 */

public class TestHeartPG
{
	public static void main(String[] args) throws IOException
	{
		String str;
		String str2;
		String str3;
		String[] coords;
		String[] dimensions;

		JFrame frame = new JFrame();

		HeartPG heart = new HeartPG();

		frame.add(heart);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setVisible(true);
		heart.setSize(frame.getSize());
		heart.setPreferredSize(frame.getSize());

		System.out.println(heart);

		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the coordinates of the center as x,y: ");
		str = keyboard.readLine();

		while (!str.equals(""))
		{

			System.out.println("Enter the width and height: ");
			str2 = keyboard.readLine();

			System.out.println("Enter the color of the heart: ");
			str3 = keyboard.readLine();

			coords = str.split(",");
			dimensions = str2.split(",");

			int xCoord = Integer.parseInt(coords[0]);
			int yCoord = Integer.parseInt(coords[0]);

			int userWidth = Integer.parseInt(dimensions[0]);
			int userHeight = Integer.parseInt(dimensions[1]);

			Color shapeColor = ColorConverter.getColor(str3);

			heart.setNewLocation(xCoord, yCoord, userWidth, userHeight);

			heart.setWidthHeight(userWidth, userHeight);
//
//			heart.hCircle1.setHalfCirColor(shapeColor);
//			heart.hCircle2.setHalfCirColor(shapeColor);
//			heart.hTriangle.setTriColor(shapeColor);
			heart.setHeartColor(shapeColor);
			heart.repaint();
			System.out.println(heart);

			System.out.println("Enter the coordinates of the center as x,y: ");
			str = keyboard.readLine();
		}

	}

}
