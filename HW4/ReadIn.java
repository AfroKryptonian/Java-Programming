/**
 *
 * @author David Mawazo
 *
 * Andrew ID: dmawazo
 *
 * On my honor, as a Carnegie-Mellon Africa student, 
 * I have neither given nor received unauthorized assistance on this work.
 */


public class ReadIn
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		InputDataFile datafile; 			// Declaration of datafile
											
		String filename;					// Declaration of file
		String names [] = new String[5];	// Declaration of the array names with a definite size of 5
		String inputName;
		int numNames = 0;

		int i =0;

		if(args.length == 0)
		{
			filename = "names.txt";
		}

		else
		{
			filename = args[0];
		}

		datafile = new InputDataFile(filename);	//Read in the data file and set it to open.
		datafile.open();
		
		//check if the file is not opened and exit the program. 
		if(!datafile.isOpen())
		{
			System.out.println("Cannot open " + datafile.getName() + " for reading. Program ending.");
			System.exit(1);
		}
		
		inputName = datafile.readString();
		
		//standard while loop that takes input.
		while(inputName != null)
		{
			if(numNames >=  names.length)
			{
				System.err.println("Sorry, the program can only store " + names.length + " names.");
				break;
			}
			
			names[i] = new String(inputName);
			i++;

			numNames++;
//			System.out.println("Trace message - processed " + inputName + " added it.");
			inputName = datafile.readString();
		}
		datafile.close();
		System.out.println();
		System.out.println("I read in " + numNames + "names from " + filename +".");
		
		
		// enhanced for loop
		i=1;

		for (String name : names)
		{
			System.out.println("Name " + i + ":" + name);
			i++;
		}
		
		for(int x=0; x <numNames; x++)
		{
			System.out.println("Name " + x + ":" + names[x]);
			
		}
	}

}
