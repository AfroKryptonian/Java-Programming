import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

/**
 * 
 * @author David Chukwuma & David Mawazo Andrew ID: dchukwue, dmawazo On my
 *         honor, as a Carnegie-Mellon Rwanda student, I have neither given nor
 *         received unauthorized assistance on this work.
 * 
 */
public class TrafficLight extends JPanel
{

	private Point center;
	private int diameter;
	private LightState lights;
	private GraphicalCircle redCircle = new GraphicalCircle();
	private GraphicalCircle yellowCircle = new GraphicalCircle();
	private GraphicalCircle greenCircle = new GraphicalCircle();

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

	private void changeColor()

	{

		if (isRedOn())
		{
			redCircle.setColor(Color.RED);
			yellowCircle.setColor(new Color(187, 187, 0));
			greenCircle.setColor(new Color(0, 100, 0));

		}

		if (isYellowOn())
		{
			redCircle.setColor(new Color(187, 0, 0));
			yellowCircle.setColor(Color.YELLOW);
			greenCircle.setColor(new Color(0, 100, 0));
		}

		if (isGreenOn())
		{

			redCircle.setColor(new Color(187, 0, 0));
			yellowCircle.setColor(new Color(187, 187, 0));
			greenCircle.setColor(Color.GREEN);
		}

	}

	public void change()
	{

		if (isRedOn())
		{
			lights = LightState.GREENON;
			// System.out.println("red changed");
			changeColor();

		}

		else if (isYellowOn())
		{
			lights = LightState.REDON;
			// System.out.println("yellow changed");
			changeColor();

		}

		else if (isGreenOn())
		{
			lights = LightState.YELLOWON;
			// System.out.println("green changed");
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
		// add a to string, write Boolean isRedOn, isGreenOn, isYellowOn

		int startX = (int) center.getX();
		int startY = (int) center.getY();
		int width = diameter;
		int height = diameter;
		int windowWidth = getWidth();
		int windowHeight = getHeight();

		g.setColor(Color.DARK_GRAY); // Drawing the rectangle around the Lights.
		g.fillRect(startX - 25, startY - 20, width + 50 + (windowWidth / 50), height * 4 + (windowWidth / 50));

		redCircle.setCenter(new Point(startX, startY));
		redCircle.setDiameter(diameter + (windowWidth / 100));
		redCircle.paintComponent(g);

		yellowCircle.setCenter(new Point(startX, startY + 100));
		yellowCircle.setDiameter(diameter + (windowWidth / 100));
		yellowCircle.paintComponent(g);

		greenCircle.setCenter(new Point(startX, startY + 200));
		greenCircle.setDiameter(diameter + (windowWidth / 100));
		greenCircle.paintComponent(g);

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
