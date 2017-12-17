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
 *         This is the application to test the drawing of the Hat Graphic,
 *         prompting the user for coordinates to get the startX and startY
 *         points, the color of the Hat
 * 
 */

public class TestHatPG
{

	public static void main(String[] args) throws IOException
	{

		String str;
		String str2;
		String str3;
		String[] coords;
		String[] dimensions;

		JFrame frame = new JFrame();

		HatPG hat = new HatPG();

		frame.add(hat);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setVisible(true);
		hat.setSize(frame.getSize());
		hat.setPreferredSize(frame.getSize());

		System.out.println(hat);

		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the coordinates of the center as x,y: ");
		str = keyboard.readLine();

		while (!str.equals(""))
		{

			System.out.println("Enter the width and height of the rectangle as w , h: ");
			str2 = keyboard.readLine();

			System.out.println("Enter color for the hat: ");
			str3 = keyboard.readLine();

			coords = str.split(",");
			dimensions = str2.split(",");

			int xCoord = Integer.parseInt(coords[0]);
			int yCoord = Integer.parseInt(coords[1]);

			int userWidth = Integer.parseInt(dimensions[0]);
			int userHeight = Integer.parseInt(dimensions[1]);

			Color userColor = ColorConverter.getColor(str3);

			hat.setNewLocation(xCoord, yCoord, userWidth, userHeight);

			hat.setWidthHeight(userWidth, userHeight);

//			hat.hCircle1.setHalfCirColor(userColor);
//			hat.line1.setLineColor(userColor);
			hat.setHatColor(userColor);
			hat.repaint();
			System.out.println(hat);

			System.out.println("Enter the coordinates of the center as x,y: ");
			str = keyboard.readLine();
		}
	}

}
