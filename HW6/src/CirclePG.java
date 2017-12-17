import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * 
 * @author David Mawazo
 *
 *         Andrew ID: dmawazo
 *
 *         On my honor, as a Carnegie-Mellon Africa student, I have neither
 *         given nor received unauthorized assistance on this work.
 * 
 *         This class extends the PositionalGraphic class, inherits its method
 *         in order to draw the Circle shape, with the coordinates of the
 *         bounding rectangle, and its diameter to set the size of the rectangle
 *         and sets it to new position.
 */

public class CirclePG extends PositionalGraphic
{

	private Color cirColor;

	// Set up the classes constructors that take in different attributes to draw the
	// Circle.

	public CirclePG()
	{
		super();
		cirColor = Color.MAGENTA;
//		super.setNewLocation(650, 500, 200, 200);
	}

	public CirclePG(Point startPoint, int circleDiameter, Color circleColor, boolean debug)
	{
		super(startPoint, circleDiameter, circleDiameter, circleColor, debug);
		debug = true;

	}

	public CirclePG(Color circColor)
	{
		super();
		setShapeColor(circColor);
	}

	// CirclePG set and get methods to set different attributes of the Circle, such
	// as the diameter and the color

	public void setCirColor(Color userColor)
	{
		cirColor = userColor;
	}

	public Color getCirColor()
	{
		return cirColor;

	}

	public void setCirColor(String circleColor)
	{
		this.cirColor = ColorConverter.getColor(circleColor);
	}

	public void setDiameter(int userDiameter)
	{

		super.setNewSize(userDiameter);
	}

	// Paint method used to draw the Circle graphic, setting its position and color.

	public void paint(Graphics g)

	{
		if (super.isDebuggerOn() == true)
		{
			super.paint(g);

		}

		int startX = super.getBoundingRectangle().x;
		int startY = super.getBoundingRectangle().y;
		int width = super.getBoundingRectangle().width;
		int height = super.getBoundingRectangle().height;
		g.setColor(getCirColor());
		g.fillOval(startX, startY, width, height);

	}
	//toString method to display the details of the graphic

	public String toString()
	{
		return "Circle: " + super.toString() + "\n The color of the Circle is:" + getCirColor();
	}
}
