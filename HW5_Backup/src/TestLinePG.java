import java.awt.Color;
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
 *         This is the application class used to draw the Line graphic, prompt
 *         the user for attributes to change the position and color of the Line
 *         and whether Horizontal or Vertical.
 */

public class TestLinePG
{

	public static void main(String[] args) throws IOException
	{

		String str;
		String str2;
		String str3;
		String str4;
		String[] coords;
		String[] dimensions;

		JFrame frame = new JFrame();

		LinePG uLine = new LinePG();

		frame.add(uLine);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setVisible(true);
		uLine.setSize(frame.getSize());
		uLine.setPreferredSize(frame.getSize());

		System.out.println(uLine);

		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the coordinates of the center as x,y: ");
		str = keyboard.readLine();

		while (!str.equals(""))
		{

			System.out.println("Enter the width and height of the rectangle as w , h: ");
			str2 = keyboard.readLine();

			System.out.println("Enter the color of: ");
			str3 = keyboard.readLine();

			System.out.println("Choose the position of the line;  H for Horizontal or V for Vertical: ");
			str4 = keyboard.readLine();

			if (str4.equalsIgnoreCase("H"))
			{
				uLine.setHorizontal();

			}
			else if (str4.equalsIgnoreCase("V"))
			{
				uLine.setVertical();
			}

			coords = str.split(",");
			dimensions = str2.split(",");

			int xCoord = Integer.parseInt(coords[0]);
			int yCoord = Integer.parseInt(coords[1]);

			int userWidth = Integer.parseInt(dimensions[0]);
			int userHeight = Integer.parseInt(dimensions[1]);

			Color lineColor = ColorConverter.getColor(str3);

			uLine.setNewLocation(xCoord, yCoord, userWidth, userHeight);

			uLine.setWidthHeight(userWidth, userHeight);

			uLine.setLineColor(lineColor);

			uLine.repaint();
			System.out.println(uLine);

			System.out.println("Enter the coordinates of the center as x,y: ");
			str = keyboard.readLine();
		}
	}

}
