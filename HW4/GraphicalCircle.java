import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class GraphicalCircle extends JPanel
{

	private Color color;
	private Point center;
	private int diameter;

	public GraphicalCircle()
	{
		color = Color.RED;
		center = new Point(70, 70);
		diameter = 80;
	}

	public GraphicalCircle(Point ePoint, int eDiameter, Color eColor)
	{

		setCenter(ePoint);
		setDiameter(eDiameter);
		setColor(eColor);
	}

	public Color getColor()
	{
		return color;
	}

	public GraphicalCircle setColor(Color cirColor)
	{
		color = cirColor;
		return null;
	}

	public Point getCenter()
	{
		return center;
	}

	public void setCenter(Point cirCenter)
	{
		center = cirCenter;
	}

	public int getDiameter()
	{
		return diameter;
	}

	public void setDiameter(int circDiameter)
	{
		diameter = circDiameter;
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

}
