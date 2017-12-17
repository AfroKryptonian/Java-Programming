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
 *         in order to draw the Hat shape from instances of half circle and a
 *         line, with the coordinates of the bounding rectangle and sets it to
 *         new position and color.
 */

public class HatPG extends PositionalGraphic
{

	HalfCirclePG hCircle1 = new HalfCirclePG(false);
	LinePG line1 = new LinePG(false);
	private Color hatColor;

	// Default constructor to draw a default Hat object with a bounding rectangle
	// from the parent class.
	public HatPG()
	{
		super();
	}

	public void setHatColor(Color userColor)
	{
		hCircle1.setHalfCirColor(userColor);
		line1.setLineColor(userColor);
	}

	public Color getHatColor()
	{
		return hatColor;

	}

	public void setHatColor(String userColor)
	{

		hCircle1.setHalfCircleColor(userColor);
		line1.setLineColor(userColor);
	}

	public void setup()
	{
		hCircle1.setWidth(getWidth() - 20);
		hCircle1.setHeight(getHeight() - 10);

		hCircle1.setStartX(getStartX() + 10);
		hCircle1.setStartY(getStartY() + 5);

		line1.setWidth(getWidth());
		line1.setHeight(getHeight());

		line1.setStartX(getStartX());
		line1.setStartY(getStartY());

	}

	public void paint(Graphics g)

	{
		setup();
		super.paint(g);

		hCircle1.paint(g);
		line1.paint(g);

	}

	public String toString()
	{
		return "Hat: " + super.toString() + "\nThe color of the Hat is:" + hCircle1.getHalfCirColor();
	}

}
