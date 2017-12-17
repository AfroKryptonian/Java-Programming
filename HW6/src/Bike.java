/**
 *
 * @author David Mawazo
 *
 *         Andrew ID: dmawazo
 *
 *         On my honor, as a Carnegie-Mellon Africa student, I have neither
 *         given nor received unauthorized assistance on this work.
 */

public class Bike implements CarbonFootprint
{

	// Declaration of the instance variables of the class

	private double averageYearlyDistance; // Distance is in Kilometers
	private double averageDistanceEnergy; // Energy is in calories
	private final String bikeType = "Mountain";

	// Default constructor of the Bike class
	public Bike()
	{
		averageYearlyDistance = 500;
		averageDistanceEnergy = 100;
	}

	// Constructor of the Bike class that takes in two attributes

	public Bike(double yearDistance, double calories)
	{
		super();
		this.averageYearlyDistance = yearDistance;
		this.averageDistanceEnergy = calories;
	}

	// Getters and setters to be used in the Bike class
	public double getAverageYearlyDistance()
	{
		return averageYearlyDistance;
	}

	public void setAverageYearlyDistance(double yearDistance)
	{
		this.averageYearlyDistance = yearDistance;
	}

	public double getAverageDistanceEnergy()
	{
		return averageDistanceEnergy;
	}

	public void setAverageDistanceEnergy(double calories)
	{
		this.averageDistanceEnergy = calories;
	}

	// Method to carry out the calculation of the Carbon Footprint
	public double getCarbonFootprint()
	{
		return ((getAverageYearlyDistance() * getAverageDistanceEnergy()));
	}

	// toString method to print the details

	public String toString()
	{
		return "\nBike: The Bike is a " + bikeType + "\nAverage distance cycled in a year = " + averageYearlyDistance
				+ ", \nAverage energy used per mile = " + averageDistanceEnergy
				+ "\nThe carbon footprint of the bike is: " + getCarbonFootprint();
	}

}
