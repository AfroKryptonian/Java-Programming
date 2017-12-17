/**
 *
 * @author David Mawazo
 *
 *         Andrew ID: dmawazo
 *
 *         On my honor, as a Carnegie-Mellon Africa student, I have neither
 *         given nor received unauthorized assistance on this work.
 */

public class Car implements CarbonFootprint
{

	// Declaration of the instance variables of the class

	private double averageYearlyDistance; // Distance is in Kilometers/year
	private double averageFuelConsumption; // Consumption is in Kilometers/Liter
	private final double averageCarbonEmission = 2.38; // Emissions is in Kilograms/litre

	// Default Constructor of the Car class

	public Car()
	{
		averageYearlyDistance = 5000;
		averageFuelConsumption = 23;
	}

	// Constructor of the Car class that takes in two attributes

	public Car(double distance, double consumption)
	{
		super();
		this.averageYearlyDistance = distance;
		this.averageFuelConsumption = consumption;
	}

	// Getters and setters to be used in the Car class

	public double getAverageYearlyDistance()
	{
		return averageYearlyDistance;
	}

	public void setAverageYearlyDistance(double distance)
	{
		this.averageYearlyDistance = distance;
	}

	public double getAverageFuelConsumption()
	{
		return averageFuelConsumption;
	}

	public void setAverageFuelConsumption(double consumption)
	{
		this.averageFuelConsumption = consumption;
	}

	// Method to carry out the calculation of the Carbon Footprint

	public double getCarbonFootprint()
	{
		return ((getAverageYearlyDistance() * getAverageFuelConsumption() * averageCarbonEmission));
	}

	// toString method to print the details

	public String toString()
	{
		return "Car: Average distance driven in a year = " + averageYearlyDistance
				+ ", \nAverage fuel consumption in a year = " + averageFuelConsumption
				+ ", \nAverage emissions in a year = " + averageCarbonEmission
				+ "\nThe carbon footprint of the car is: " + getCarbonFootprint();
	}

}
