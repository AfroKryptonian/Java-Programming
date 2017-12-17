import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author David Mawazo
 *
 *         Andrew ID: dmawazo
 *
 *         On my honor, as a Carnegie-Mellon Africa student, I have neither
 *         given nor received unauthorized assistance on this work.
 *
 *         This class extends the PositionalGraphic class, inherits its method
 *         in order to draw the HalfCircle shape, with the coordinates of the
 *         bounding rectangle and sets it to new position.
 */

public class HalfCirclePG extends PositionalGraphic
{

	private Color halfCircleColor;

	// Default and general constructors of the Half circle that would take in
	// different attributes

	public HalfCirclePG()
	{
		super();
		halfCircleColor = Color.MAGENTA;
	}

	public HalfCirclePG(Color circColor)
	{
		super();
		setShapeColor(circColor);
	}
	public HalfCirclePG(boolean debugger)
	{
		super();
		setDebugger(false);
		halfCircleColor = new Color(74, 152, 0);
	}

	public HalfCirclePG(Point startPoint, int width, int height, Color userColor, boolean debug)
	{
		super(startPoint, width, height, userColor, debug);
	}

	// Half Circle child methods to set the diameter and color of the half circle

	public void setDiameter(int userDiameter)
	{

		super.setNewSize(userDiameter);
	}

	public void setHalfCirColor(Color userColor)
	{
		halfCircleColor = userColor;
	}

	public Color getHalfCirColor()
	{
		return halfCircleColor;

	}

	public void setHalfCircleColor(String halfCirColor)
	{
		this.halfCircleColor = ColorConverter.getColor(halfCirColor);
	}

	// Paint method used to draw the Half circle graphic, setting its position and
	// color.

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
		g.setColor(getHalfCirColor());
		g.fillArc(startX, startY, width, height, 0, 180);

	}

	public String toString()
	{
		return "HalfCircle: " + super.toString() + "\nThe color of the Half Circle is:" + getHalfCirColor();
	}

}
