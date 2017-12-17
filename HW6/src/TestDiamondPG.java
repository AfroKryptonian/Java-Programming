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
 *         This is the application class used to draw the Diamond graphic, prompt
 *         the user for attributes to change the position and color of the
 *         Diamond.
 */

public class TestDiamondPG
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

		DiamondPG diamond = new DiamondPG();

		frame.add(diamond);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setVisible(true);
		diamond.setSize(frame.getSize());
		diamond.setPreferredSize(frame.getSize());

		System.out.println(diamond);

		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the coordinates of the center as x,y: ");
		str = keyboard.readLine();

		while (!str.equals(""))
		{

			System.out.println("Enter the width and height of the rectangle as w , h: ");
			str2 = keyboard.readLine();

			System.out.println("Enter the color of the diamond: ");
			str3 = keyboard.readLine();

			coords = str.split(",");
			dimensions = str2.split(",");

			int xCoord = Integer.parseInt(coords[0]);
			int yCoord = Integer.parseInt(coords[1]);

			int userWidth = Integer.parseInt(dimensions[0]);
			int userHeight = Integer.parseInt(dimensions[1]);

			Color diaColor = ColorConverter.getColor(str3);

			diamond.setNewLocation(xCoord, yCoord, userWidth, userHeight);

			diamond.setWidthHeight(userWidth, userHeight);

			diamond.setDiaColor(diaColor);

			diamond.repaint();
			System.out.println(diamond);

			System.out.println("Enter the coordinates of the center as x,y: ");
			str = keyboard.readLine();
		}
	}

}
