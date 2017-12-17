/**
 *
 * @author David Mawazo
 *
 *         Andrew ID: dmawazo
 *
 *         On my honor, as a Carnegie-Mellon Africa student, I have neither
 *         given nor received unauthorized assistance on this work.
 */

public class MadPrompt
{
	private int numWords;
	private StringBuffer definition;
	

	public MadPrompt()
	{
		super();
		
	}
	
	
	public MadPrompt(int numWords, StringBuffer definition)
	{
		super();
		this.numWords = numWords;
		this.definition = definition;
	}


	public int getNumWords()
	{
		return numWords;
	}

	public void setNumWords(int numWords)
	{
		this.numWords = numWords;
	}

	public StringBuffer getDefinition()
	{
		return definition;
	}

	public void setDefinition(StringBuffer definition)
	{
		this.definition = definition;
	}


	public String toString()
	{
		return ("Position: " + numWords + " "+ "Definintion: " + definition);
	}
}
