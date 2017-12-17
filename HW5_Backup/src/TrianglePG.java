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
 *         
 *         This class extends the PositionalGraphic class, inherits its method
 *         in order to draw the Triangle shape, with the coordinates of the
 *         bounding rectangle, and its width to set the size of the rectangle
 *         and sets it to new position.
 */
 

public class TrianglePG extends PositionalGraphic
{
	//Enumeration set to dictate the direction of the Triangle
	private enum TriangleDirection
	{
		UP, DOWN
	};

	private TriangleDirection type;
	private Color triColor;

	
	//Constructors for the Triangle
	public TrianglePG()
	{
		super();
		triColor = new Color(74, 152, 0);
	}
	
	public TrianglePG(boolean debugger)
	{
		super();
		setDebugger(false);
		triColor = Color.CYAN;
	}

	public void setTriColor(Color userColor)
	{
		triColor = userColor;
	}

	public Color getTriColor()
	{
		return triColor;

	}
	public void setTriColor(String triangleColor)
	{
		this.triColor = ColorConverter.getColor(triangleColor);
	}
	

	public void setTriangleSize(int userWidth, int userHeight)
	{

		super.setWidthHeight(userWidth, userHeight);
	}

	
	//Methods to set and get if the Triangle is pointing up or down
	public boolean isPointUP()
	{

		return type == TriangleDirection.UP;
	}

	public boolean isPointDOWN()
	{

		return type == TriangleDirection.DOWN;
	}

	public void setPointUP()
	{
		type = TriangleDirection.UP;
	}

	public void setPointDOWN()
	{
		type = TriangleDirection.DOWN;
	}

	//Paints the position of the triangle, with the default pointing down
	public void paint(Graphics g)

	{
		int xPoints[] = new int[3];
		int yPoints[] = new int[3];
		int nPoints = 3;

		if (super.isDebuggerOn() == true)
		{
			super.paint(g);

			xPoints[0] = super.getBottomMidPoint().x;
			xPoints[1] = super.getLeftTopPoint().x;
			xPoints[2] = super.getRightTopPoint().x;

			yPoints[0] = super.getBottomMidPoint().y;
			yPoints[1] = super.getLeftTopPoint().y;
			yPoints[2] = super.getRightTopPoint().y;
			nPoints = 3;

		}

		if (isPointUP())
		{
			xPoints[0] = super.getTopMidPoint().x;
			xPoints[1] = super.getLeftBottomPoint().x;
			xPoints[2] = super.getBottomRightPoint().x;

			yPoints[0] = super.getTopMidPoint().y;
			yPoints[1] = super.getLeftBottomPoint().y;
			yPoints[2] = super.getBottomRightPoint().y;
			nPoints = 3;
		}

		else if (isPointDOWN())
		{

			xPoints[0] = super.getBottomMidPoint().x;
			xPoints[1] = super.getLeftTopPoint().x;
			xPoints[2] = super.getRightTopPoint().x;

			yPoints[0] = super.getBottomMidPoint().y;
			yPoints[1] = super.getLeftTopPoint().y;
			yPoints[2] = super.getRightTopPoint().y;
			nPoints = 3;
		}

		g.setColor(getTriColor());
		g.fillPolygon(xPoints, yPoints, nPoints);

	}

	public String toString()
	{
		return "Triangle: " + super.toString() + "\nThe color of the Triangle is:" + getTriColor();
	}

}
