import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.nio.file.attribute.UserPrincipalLookupService;

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
 *         in order to draw the diamond shape, with the coordinates of the
 *         bounding rectangle and sets it to new position.
 */

public class DiamondPG extends PositionalGraphic
{

	private Color diaColor;

	// Constructors to draw the Diamond Graphic

	public DiamondPG()
	{
		super();
		diaColor = new Color(99, 15, 36);
	}

	public DiamondPG(Rectangle userRec, Color userColor, boolean d)
	{
		super(userRec, userColor, d);

	}

	public DiamondPG(Point startPoint, int width, int height, Color userColor, boolean d)
	{
		super(startPoint, width, height, userColor, d);
	}

	// Set methods used to set the color of the Diamond
	public void setDiaColor(Color userColor)
	{
		diaColor = userColor;
	}

	public void setDiaColor(String diamondColor)
	{
		this.diaColor = ColorConverter.getColor(diamondColor);
	}

	public Color getDiaColor()
	{
		return diaColor;

	}

	// Paint method used to draw the Diamond graphic, setting its position and color
	// with the inherited points from the parent class

	public void paint(Graphics g)

	{
		if (super.isDebuggerOn() == true)
		{
			super.paint(g);
		}

		int xPoints[] =
		{ super.getTopMidPoint().x, super.getLeftMidPoint().x, super.getBottomMidPoint().x,
				super.getRightMidPoint().x };
		int yPoints[] =
		{ super.getTopMidPoint().y, super.getLeftMidPoint().y, super.getBottomMidPoint().y,
				super.getRightMidPoint().y };
		int nPoints = 4;

		g.setColor(getDiaColor());
		g.fillPolygon(xPoints, yPoints, nPoints);

	}
	
	//toString method to display the details of the graphic

	public String toString()
	{
		return "Diamond: " + super.toString() + "\n The color of the diamond is:" + getDiaColor();
	}

}
