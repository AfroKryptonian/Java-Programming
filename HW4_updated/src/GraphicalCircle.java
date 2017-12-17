
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
public class GraphicalCircle extends JPanel
{

	private Point center;
	private int diameter;
	private Color color;

	public GraphicalCircle()
	{
		center = new Point(70, 70);
		diameter = 80;
		color = Color.RED;
	}

	public GraphicalCircle(Point ePoint, int eDiameter, Color eColor)
	{

		setCenter(ePoint);
		setDiameter(eDiameter);
		setColor(eColor);
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

	public Color getColor()
	{
		return color;
	}

	public void setColor(Color color_)
	{
		color = color_;
	}

	public void paintComponent(Graphics g)

	{

		int startX = (int) center.getX();
		int startY = (int) center.getY();
		int width = diameter;
		int height = diameter;

		g.setColor(color);
		g.fillOval(startX, startY, width, height);

	}

	public String toString()
	{
		return "The start X value is: " + center.getX() + ". " + "The start Y value is: " + center.getY() + ". "
				+ "The width of the circle is: " + diameter + ". " + " The height of the circle is: " + diameter;
	}

}
