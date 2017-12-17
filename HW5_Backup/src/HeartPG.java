import java.awt.Color;
import java.awt.Graphics;

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
 *         in order to draw the Heart shape from instances of half circles and a
 *         triangle, with the coordinates of the bounding rectangle and sets it
 *         to new position.
 */

public class HeartPG extends PositionalGraphic
{
	HalfCirclePG hCircle1 = new HalfCirclePG(false);
	HalfCirclePG hCircle2 = new HalfCirclePG(false);
	TrianglePG hTriangle = new TrianglePG();
	private Color heartColor;

	// Default constructor to draw a default Heart with a bounding rectangle
	public HeartPG()
	{
		super();
	}

	// An overriding setNewLocation method that is used to set the new position of
	// the graphic object after drawing it

	public void setNewLocation(int userX, int userY, int userWidth, int userHeight)
	{
		super.setNewLocation(userX, userY, userWidth, userHeight);
		setup();
	}

	public void setWidthHeight(int userWidth, int userHeight)
	{

		super.setWidthHeight(userWidth, userHeight);
	}

	public void setHeartColor(String userColor1)
	{

		hCircle1.setHalfCircleColor(userColor1);
		hCircle2.setHalfCircleColor(userColor1);
		hTriangle.setTriColor(userColor1);
	}

	public void setHeartColor(Color userColor)
	{
		hCircle1.setHalfCirColor(userColor);
		hCircle2.setHalfCirColor(userColor);
		hTriangle.setTriColor(userColor);
	}

	public Color getHeartColor()
	{
		return heartColor;

	}

	// A method used to set up the position of the shapes used to form the Heart and
	// align them appropriately.
	public void setup()
	{

		hCircle1.setWidth(getWidth() / 2);
		hCircle1.setHeight(getHeight() / 2);

		hCircle2.setWidth(getWidth() / 2);
		hCircle2.setHeight(getHeight() / 2);

		hTriangle.setWidth(getWidth());
		hTriangle.setHeight(getHeight() * 3 / 4);

		hCircle1.setStartX(getStartX());
		hCircle1.setStartY(getStartY());
		hCircle2.setStartX(getStartX() + getWidth() / 2);
		hCircle2.setStartY(getStartY());

		hTriangle.setStartX(getStartX());
		hTriangle.setStartY(getStartY() + getHeight() / 4);
	}

	// Paint method is used to draw the objects to form the Heart.
	public void paint(Graphics g)

	{
		setup();
		super.paint(g);

		hCircle1.paint(g);
		hCircle2.paint(g);
		hTriangle.paint(g);

	}

	public String toString()
	{
		return "Heart: " + super.toString() + "\nThe color of the Heart is:" + hCircle1.getHalfCirColor();
	}

}
