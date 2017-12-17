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
 *         This is the application class used to draw the Ice Cream Cone
 *         graphic, from the IceCreamConePG class. Prompt the user for
 *         attributes to change the number and color of the scoops.
 */

public class TestIceCreamConePG
{

	public static void main(String[] args) throws IOException
	{
		String str;
		String str2;
		String str3;
		String str4;

		JFrame frame = new JFrame();

		IceCreamConePG coneIce = new IceCreamConePG();

		frame.add(coneIce);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setVisible(true);
		coneIce.setSize(frame.getSize());
		coneIce.setPreferredSize(frame.getSize());

		System.out.println(coneIce);

		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter the number of scoops: ");
		str3 = keyboard.readLine();

		while (!str3.equals(""))
		{
			int scoopN = Integer.parseInt(str3);

			coneIce.clearScoop();

			for (int i = 0; i < scoopN; i++)
			{

				System.out.println("Enter the color of the scoop: ");
				str4 = keyboard.readLine();
				Color userColor = ColorConverter.getColor(str4);
				coneIce.addScoop(userColor);

			}

			coneIce.repaint();
			System.out.println(coneIce);

			System.out.println("Enter the number of scoops: ");
			str3 = keyboard.readLine();

		}

	}

}
