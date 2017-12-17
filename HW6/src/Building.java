/**
 *
 * @author David Mawazo
 *
 *         Andrew ID: dmawazo
 *
 *         On my honor, as a Carnegie-Mellon Africa student, I have neither
 *         given nor received unauthorized assistance on this work.
 */

public class Building implements CarbonFootprint
{

	// Declaration of the instance variables of the class

	private double averageMonthlyElectricity; // Electricity in kWh
	private double averageDailyWater; // Water in litres
	private double averageYearlyGas; // Fuel in litres
	private final double elecEmissionFactor = 1.7;
	private final double gasEmissionFactor = 12.7;

	// Default Constructor of the Car class

	public Building()
	{

		averageMonthlyElectricity = 600;
		averageDailyWater = 20;
		averageYearlyGas = 30;

	}

	// Constructor of the Building class that takes in three attributes

	public Building(double monthElectricity, double dayWater, double yearGas)
	{
		super();
		this.averageMonthlyElectricity = monthElectricity;
		this.averageDailyWater = dayWater;
		this.averageYearlyGas = yearGas;
	}

	// Getters and setters to be used in the class

	public double getAverageMonthlyElectricity()
	{
		return averageMonthlyElectricity;
	}

	public void setAverageMonthlyElectricity(double monthElectricity)
	{
		this.averageMonthlyElectricity = monthElectricity;
	}

	public double getAverageDailyWater()
	{
		return averageDailyWater;
	}

	public void setAverageDailyWater(double dayWater)
	{
		this.averageDailyWater = dayWater;
	}

	public double getAverageYearlyGas()
	{
		return averageYearlyGas;
	}

	public void setAverageYearlyGas(double yearFuel)
	{
		this.averageYearlyGas = yearFuel;
	}

	// Method to carry out the calculation of the Carbon Footprint

	public double getCarbonFootprint()
	{
		return (((getAverageMonthlyElectricity() * 12 * elecEmissionFactor) + (getAverageDailyWater() * 365)
				+ (getAverageYearlyGas() * gasEmissionFactor)));
	}

	// toString method to print the details
	public String toString()
	{
		return "\nBuilding: Average Monthly Electricity used = " + averageMonthlyElectricity
				+ ", \nAverage amount of water used in a day = " + averageDailyWater
				+ ", \nAverage Fuel used in a year = " + averageYearlyGas
				+ "\nThe carbon footprint of the Building is: " + getCarbonFootprint();
	}
}
