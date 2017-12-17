import java.util.ArrayList;

/**
 *
 * @author David Mawazo
 *
 *         Andrew ID: dmawazo
 *
 *         On my honor, as a Carnegie-Mellon Africa student, I have neither
 *         given nor received unauthorized assistance on this work.
 */

public class TestCarbonFootprint
{

	public static void main(String[] args)
	{
		// creates array of objects of type CarbonFootprint
		
		ArrayList<CarbonFootprint> collectionItems = new ArrayList<CarbonFootprint>();
																						
		Car saloonCar = new Car(5845, 20.5);
		Building bungalow = new Building(400, 45, 250.5);
		Bike bmx = new Bike(200.00, 185);

		collectionItems.add(saloonCar);
		collectionItems.add(bungalow);
		collectionItems.add(bmx);

		for (CarbonFootprint currentObject : collectionItems)
		{
			System.out.println(currentObject.toString());
		}
	}

}
