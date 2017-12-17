import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

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
 *         in order to draw the Ice Cream Cone shape from instances of a
 *         TrianglePG and an arrayList of CirclePG objects with the coordinates
 *         of the bounding rectangle and sets it to new position.
 */

public class IceCreamConePG extends PositionalGraphic
{

	TrianglePG hTriangle = new TrianglePG();
	ArrayList<CirclePG> scoops = new ArrayList<CirclePG>();
	private Color scoopColor;
	private Color coneColor;

	// Default constructor to set up the default position of the Ice cream cone

	public IceCreamConePG()
	{
		super();
		
	}

	public void setNewLocation(int userX, int userY, int userWidth, int userHeight)
	{
		super.setNewLocation(userX, userY, userWidth, userHeight);
		setup();
	}

	public void setup()
	{

		hTriangle.setWidth(getWidth());
		hTriangle.setHeight(getHeight() / 2);
		hTriangle.setStartX(getStartX());
		hTriangle.setStartY(getStartY() + getHeight() / 2);
		hTriangle.setTriColor("yellow");

		int i = 0;
		int arraySize = scoops.size();

		for (i = 0; i < arraySize; i++)
		{
			int scoopX = (getBoundingRectangle().x + getBoundingRectangle().width / 4);
			int scoopY = (getBoundingRectangle().y + getHeight() / 2 - (scoops.get(i).getHeight() * (i + 1)));

			scoops.get(i).setWidth(getWidth() / 2);
			scoops.get(i).setHeight(getWidth());
			scoops.get(i).setStartX(scoopX);
			scoops.get(i).setStartY(scoopY);
			scoops.get(i).setNewSize(getHeight() / 2 / arraySize);

		}

	}

	// Method adds ice cream scoops to the cone
	public void addScoop(String scoopColor)
	{
		Color colorScoop = ColorConverter.getColor(scoopColor);
		CirclePG scoop = new CirclePG();
		scoop.setCirColor(colorScoop);
		scoops.add(scoop);
		setup();
	}

	public void addScoop(Color scoopColor)
	{
		CirclePG scoop = new CirclePG();
		scoop.setCirColor(scoopColor);
		scoops.add(scoop);
		setup();
	}

	// clears the ice cream scoops from the drawing
	public void clearScoop()
	{
		scoops.clear();
	}

	public void setScoopColor(Color userColor)
	{
		scoops.get(0).setCirColor(userColor);
	}

	public Color getScoopColor()
	{
		return scoopColor;

	}

	public void setScoopColor(String userColor)
	{

		scoops.get(0).setCirColor(userColor);

	}

	public void setConeColor(String userColor1)
	{

		hTriangle.setTriColor(userColor1);
	}

	public void setConeColor(Color userColor)
	{
		hTriangle.setTriColor(userColor);
	}

	public Color getHeartColor()
	{
		return coneColor;

	}

	public void paint(Graphics g)

	{
		setup();
		super.paint(g);

		for (CirclePG scoop : scoops)
		{
			scoop.paint(g);

		}

		hTriangle.paint(g);

	}

	public String toString()
	{
		return "Ice Cream Cone: " + super.toString() + "\nThe number of scoops are:" + scoops.size();
	}

}
