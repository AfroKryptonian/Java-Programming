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
 *         in order to draw the Line shape, with the coordinates of the bounding
 *         rectangle and sets it to new position.
 */

public class LinePG extends PositionalGraphic
{

	private LineDirection type;
	private int thickness;
	private int length;
	private Color lineColor;

	// An enumeration to set the line to either have a Vertical or Horizontal
	// orientation
	private enum LineDirection
	{
		VERTICAL, HORIZONTAL
	};

	// Default constructor used to draw a default Line graphic object. 
	
	public LinePG()
	{
		super();
		lineColor = Color.CYAN;
		thickness = 10;
		length = getBoundingRectangle().width;
	}

	//Constructors that take in different attributes that can be used to draw the Line.
	public LinePG(boolean debug)
	{
		super();
		setDebugger(false);
		thickness = 10;
	}
	
	public LinePG(Rectangle userRec, Color userColor, boolean d)
	{
		super(userRec, userColor, d);
	}

	public LinePG(Point startPoint, int width, int height, Color userColor, boolean d)
	{
		super(startPoint, width, height, userColor, d);
	}

	//Set and Get methods used to set the Line color, Thickness and Length of the Line to be set
	
	public void setLineColor(Color userColor)
	{
		lineColor = userColor;
	}
	
	public void setLineColor(String userColor)
	{
		this.lineColor = ColorConverter.getColor(userColor);
	}

	public Color getLineColor()
	{
		return lineColor;

	}

	public int getThickness()
	{
		return thickness;
	}

	public void setThickness(int newThick)
	{
		this.thickness = newThick;
	}

	public int getLength()
	{
		return length;
	}

	public void setLength(int newLength)
	{
		this.length = newLength;
	}

	//Methods to check whether the Line is Horizontal or Vertical based on users choice
	
	public boolean isHorizontal()
	{
		return type == LineDirection.HORIZONTAL;
	}

	public boolean isVertical()
	{
		return type == LineDirection.VERTICAL;
	}

	// this are the setters for the enum variables.
	
	public void setHorizontal()
	{
		type = LineDirection.HORIZONTAL;
	}

	public void setVertical()
	{
		type = LineDirection.VERTICAL;
	}

	// Paint method used to draw the Line graphic, setting its position when the
	// user selects to have it whether Horizontal or Vertical and color.

	public void paint(Graphics g)
	{
		int startX;
		int startY;
		int width;
		int height;

		if (super.isDebuggerOn() == true)
		{
			super.paint(g);

			startX = super.getBoundingRectangle().x;
			startY = super.getBoundingRectangle().y;
			width = getBoundingRectangle().width;
			height = thickness;

		}

		if (isVertical())
		{

			startX = super.getTopMidPoint().x;
			startY = super.getTopMidPoint().y;
			width = thickness;
			height = getBoundingRectangle().height;
		}

		else
		{
			startX = super.getLeftMidPoint().x;
			startY = super.getLeftMidPoint().y;
			width = getBoundingRectangle().width;
			height = thickness;
		}

		g.setColor(getLineColor());
		g.fillRect(startX, startY, width, height);

	}

	public String toString()
	{
		return "Line: " + super.toString() + "\n The color of the Line is:" + getLineColor();
	}
}
