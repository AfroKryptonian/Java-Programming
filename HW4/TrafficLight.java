import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

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

public class TrafficLight extends JPanel
{

	private Point center;
	private int diameter;
	private LightState lights;
	private GraphicalCircle redState = new GraphicalCircle();// Color.RED;
	private GraphicalCircle yellowState = new GraphicalCircle(); // Color.YELLOW;
	private GraphicalCircle greenState = new GraphicalCircle(); // = Color.GREEN;

	private enum LightState
	{
		REDON, YELLOWON, GREENON
	}

	public TrafficLight()
	{
		Point p = new Point(70, 70);
		diameter = 80;

		setCenter(p);

		setDiameter(diameter);

		lights = LightState.REDON;

		changeColor();

	}

	public Point getCenter()
	{
		return center;
	}

	public void setCenter(Point center_)
	{
		center = center_;
	}

	public int getDiameter()
	{
		return diameter;
	}

	public void setDiameter(int diameter_)
	{
		diameter = diameter_;
	}

	public void changeColor()

	{

		if (isRedOn())
		{
			redState.setColor(Color.RED);
			yellowState.setColor(new Color(187, 187, 0));
			greenState.setColor(new Color(0, 100, 0));

		}

		if (isYellowOn())
		{
			redState.setColor(new Color(187, 0, 0));
			yellowState.setColor(Color.YELLOW);
			greenState.setColor(new Color(0, 100, 0));
		}

		if (isGreenOn())
		{
			redState.setColor(new Color(187, 0, 0));
			yellowState.setColor(new Color(187, 187, 0));
			greenState.setColor(Color.GREEN);
		}

	}

	public void change()
	{

		if (isRedOn())
		{
			lights = LightState.GREENON;
			System.out.println("Red changed");
			changeColor();
		}

		else if (isYellowOn())
		{
			lights = LightState.REDON;
			System.out.println("Green changed");
			changeColor();
		}

		else if (isGreenOn())
		{
			lights = LightState.YELLOWON;
			System.out.println("Yellow changed");
			changeColor();

		}

	}

	public Boolean isRedOn()
	{

		return lights.equals(LightState.REDON);

	}

	public Boolean isYellowOn()
	{

		return lights.equals(LightState.YELLOWON);

	}

	public Boolean isGreenOn()
	{
		return lights.equals(LightState.GREENON);

	}

	public void paintComponent(Graphics g)

	{

		int startX = (int) center.getX();
		int startY = (int) center.getY();
		int width = diameter;
		int height = diameter;

		g.setColor(Color.DARK_GRAY); // Drawing the rectangle around the Lights.
		g.fillRect(startX - 25, startY - 20, width + 50, height * 4);

		redState.setCenter(new Point(startX, startY));
		redState.setDiameter(diameter);
		redState.paintComponent(g);

		yellowState.setCenter(new Point(startX, startY + 100));
		yellowState.setDiameter(diameter);
		yellowState.paintComponent(g);

		greenState.setCenter(new Point(startX, startY + 200));
		greenState.setDiameter(diameter);
		greenState.paintComponent(g);
	}

	public String toString()
	{

		String Message = "";

		if (isRedOn())
		{

			Message = ("The Red light is on");

		}

		else if (isYellowOn())
		{
			Message = ("The Yellow light is on");

		}

		else if (isGreenOn())
		{
			Message = ("The Green light is on");

		}
		return Message;

	}

}
