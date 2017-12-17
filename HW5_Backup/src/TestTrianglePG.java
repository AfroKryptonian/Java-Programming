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
 * Andrew ID: dmawazo
 *
 * On my honor, as a Carnegie-Mellon Africa student, 
 * I have neither given nor received unauthorized assistance on this work.
 */

/**
 * @author dmawazo
 *
 */
public class TestTrianglePG
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

		TrianglePG triangle = new TrianglePG();
		

		frame.add(triangle);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setVisible(true);
		triangle.setSize(frame.getSize());
		triangle.setPreferredSize(frame.getSize());
		
		System.out.println(triangle);


		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the coordinates of the center as x,y: ");
		str = keyboard.readLine();

		while (!str.equals(""))
		{

			System.out.println("Enter the width and height of the rectangle as w , h: ");
			str2 = keyboard.readLine();
			
			coords = str.split(",");
			dimensions = str2.split(",");

			System.out.println("Enter the color of: ");
			str3 = keyboard.readLine();
			
			System.out.println("Choose the position of the triangle; U for Up or D for Down: ");
			str4 = keyboard.readLine();
			
			if(str4.equalsIgnoreCase("U"))
			{
				triangle.setPointUP();
				
			}
			else if (str4.equalsIgnoreCase("D"))
			{
				triangle.setPointDOWN();
			}

			

			int xCoord = Integer.parseInt(coords[0]);
			int yCoord = Integer.parseInt(coords[1]);

			int userWidth = Integer.parseInt(dimensions[0]);
			int userHeight = Integer.parseInt(dimensions[1]);

			Color triangleColor = ColorConverter.getColor(str3);

			triangle.setNewLocation(xCoord, yCoord, userWidth, userHeight);

			triangle.setTriangleSize(userWidth, userHeight);

			triangle.setTriColor(triangleColor);
			
			triangle.repaint();
			System.out.println(triangle);

			System.out.println("Enter the coordinates of the center as x,y: ");
			str = keyboard.readLine();
		}
	}

}
