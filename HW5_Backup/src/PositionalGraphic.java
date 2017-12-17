import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JPanel;;

/**
 *
 * @author David Mawazo
 *
 *         Andrew ID: dmawazo
 *
 *         On my honor, as a Carnegie-Mellon Africa student, I have neither
 *         given nor received unauthorized assistance on this work.
 * 
 *         This class is the parent class, that sets the default attributes and
 *         methods used to draw various Positional Graphic objects. By default,
 *         it draws a Bounding Rectangle, which can be modified in terms of
 *         location and color on the Frame.
 */

public class PositionalGraphic extends Canvas
{

	private Rectangle boundingRectangle;
	private Color boundColor;
	private boolean debugger = true;

	// Constructors of the PositionalGraphic that sets default values and take in
	// different attributes
	public PositionalGraphic()
	{
		boundingRectangle = new Rectangle(150, 150, 150, 150);
		boundColor = Color.DARK_GRAY;
	}

	public PositionalGraphic(Rectangle userRec, Color userColor, boolean d)
	{

		boundingRectangle = userRec;
		boundColor = userColor;
		debugger = d;

	}

	public PositionalGraphic(Point userPoint, int width, int height, Color userColor, boolean debug)
	{
		boundingRectangle = new Rectangle(150, 150, 100, 100);
		boundColor = Color.black;
	}

	/*
	 * Getters and setter methods that are used to set the the shape of the bounding
	 * rectangle, its color, width, height and the starting point of the bounding
	 * rectangle
	 */

	public Rectangle getBoundingRectangle()
	{
		return boundingRectangle;
	}

	public void setRec1(Rectangle rec_1)
	{
		this.boundingRectangle = rec_1;
	}

	public Color getShapeColor()
	{
		return boundColor;
	}

	public void setShapeColor(Color rec_1Color)
	{
		this.boundColor = rec_1Color;
	}

	public void setShapeColor(String rec_1Color)
	{
		this.boundColor = ColorConverter.getColor(rec_1Color);
	}

	public boolean isDebuggerOn()
	{
		return debugger;
	}

	public void setDebugger(boolean debugger)
	{
		this.debugger = debugger;
	}

	public void setNewLocation(int userX, int userY, int userWidth, int userHeight)
	{
		int startX = (int) (userX - userWidth / 2);
		int startY = (int) (userY - userHeight / 2);

		boundingRectangle.setLocation(startX, startY);
	}
	
	

	public void setWidthHeight(int userWidth, int userHeight)
	{

		boundingRectangle.setSize(userWidth, userHeight);
	}

	public Dimension getWidthHeight()
	{
		return boundingRectangle.getSize();

	}

	public void setNewSize(int userDiameter)
	{

		boundingRectangle.setSize(userDiameter, userDiameter);
	}

	public void setWidth(int width)
	{
		this.boundingRectangle.width = width;
	}

	public int getWidth()
	{
		return boundingRectangle.width;
	}

	public void setHeight(int height)
	{
		this.boundingRectangle.height = height;
	}

	public int getHeight()
	{
		return boundingRectangle.height;
	}

	
	
	public Point getLeftTopPoint()
	{
		Point st = boundingRectangle.getLocation();
		return st;

	}

	public void setStartX(int userX)
	{
		this.boundingRectangle.x = userX;
	}

	public void setStartY(int userY)
	{
		this.boundingRectangle.y = userY;
	}
	
	public void setStartXStartY(int userX, int userY)
	{
		this.boundingRectangle.x = userX;
		this.boundingRectangle.y = userY;
	}

	public int getStartX()
	{
		return boundingRectangle.x;
	}

	public int getStartY()
	{
		return boundingRectangle.y;
	}
	
	public void setMyLocation(int x, int y)
	{
		boundingRectangle.setLocation(x ,y);
	}

	// getters to calculate the various points on the bounding rectangle to be used
	// by child shapes to be drawn; the corner points and the mid points.

	public Point getRightTopPoint()
	{

		Point st = boundingRectangle.getLocation();
		int trX = st.x + boundingRectangle.width;
		int trY = st.y;

		Point rightTop = new Point(trX, trY);
		return rightTop;
	}

	public Point getBottomRightPoint()
	{

		Point st = boundingRectangle.getLocation();
		int brX = st.x + boundingRectangle.width;
		int brY = st.y + boundingRectangle.height;

		Point rightBottom = new Point(brX, brY);
		return rightBottom;
	}

	public Point getLeftBottomPoint()
	{

		Point st = boundingRectangle.getLocation();
		int blX = st.x;
		int blY = st.y + boundingRectangle.height;

		Point leftBottom = new Point(blX, blY);
		return leftBottom;
	}

	public Point getTopMidPoint()
	{

		int centreTopX = (boundingRectangle.x + getRightTopPoint().x) / 2;
		int centreTopY = boundingRectangle.y;

		Point topCentre = new Point(centreTopX, centreTopY);
		return topCentre;
	}

	public Point getRightMidPoint()
	{

		int rightMidX = getRightTopPoint().x;
		int rightMidY = (getRightTopPoint().y + getBottomRightPoint().y) / 2;

		Point rightMid = new Point(rightMidX, rightMidY);
		return rightMid;
	}

	public Point getBottomMidPoint()
	{
		int bottomMidX = (getLeftBottomPoint().x + getBottomRightPoint().x) / 2;
		int botoomMidY = getLeftBottomPoint().y;

		Point bottomMid = new Point(bottomMidX, botoomMidY);
		return bottomMid;
	}

	public Point getLeftMidPoint()
	{

		int leftMidX = boundingRectangle.x;
		int leftMidY = (boundingRectangle.y + getLeftBottomPoint().y) / 2;

		Point leftMid = new Point(leftMidX, leftMidY);
		return leftMid;
	}

	// Paint method to get the shape on to the canvas and filled with its set color

	public void paint(Graphics g)

	{
		super.paint(g);

		g.setColor(boundColor);
		g.fillRect(boundingRectangle.x, boundingRectangle.y, boundingRectangle.width, boundingRectangle.height);
	}

	//toString method to display the details of the graphic

	public String toString()
	{
		return "The start point of the bounding rectangle is: " + boundingRectangle.getLocation()
				+ "\nThe width of the bounding rectangle is: " + boundingRectangle.getWidth()
				+ "\nThe height of the bounding rectangle is: " + boundingRectangle.getHeight()
				+ "\nThe color of the bounding rectangle is: " + boundColor + ".";
	}

}
