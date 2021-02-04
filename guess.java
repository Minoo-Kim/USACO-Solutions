import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class guess {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new FileReader("guess.in"));
		int animalCount = Integer.valueOf(f.readLine());
		
		// list of charcteristics without duplicates
		ArrayList<String> characteristics = new ArrayList<String>();
		
		// Construct arraylist of arrays with all the characteristics of the animals
		ArrayList<String>[] animals = new ArrayList[animalCount];
		for(int i = 0; i<animalCount; i++)
		{
			StringTokenizer input = new StringTokenizer(f.readLine());
			//discard animal name
			String temp = input.nextToken();
			
			//create arraylist containing characteristics of the given animal
			int num = Integer.valueOf(input.nextToken());
			ArrayList<String> charas = new ArrayList<String>(num);
			for (int j = 0; j<num; j++)
			{
				String tempChara = input.nextToken();
				characteristics.add(tempChara);
				charas.add(tempChara);
			}
			animals[i] = charas;
		}
		// boolean set
		Boolean[] table = new Boolean[animalCount];
		for(int k = 0; k<animalCount; k++)
		{
			table[k] = true;
		}
		//testing
		System.out.println(characteristics);
		
		for(int b = 0; b<animalCount; b++)
		{
			System.out.println(animals[0]);
		}
		
		
		//data set
		ArrayList<Integer> dataSet = new ArrayList<Integer>();
		recursion(animals, characteristics, table, 0, dataSet);
		int ans = Collections.max(dataSet);
		
		//testing
		System.out.println(dataSet);

		
		PrintWriter out = new PrintWriter(new BufferedWriter (new FileWriter("guess.out")));
		out.println(ans);
		out.close();
	}
	
	public static void recursion(ArrayList<String>[] mainArray, ArrayList<String> characteristics, Boolean[] status, int count, ArrayList<Integer> data)
	{
		//if only one animal is left, add accumulated count to data set. Count starts at 1. Boolean is initilized as all true.
		if(numTrues(status) == 1)
		{
			data.add(count);
		}
		else
		{
			for(int n = 0; n<status.length; n++)
			{
				System.out.println(status[n]);
			}
			for(int i = 0; i<characteristics.size(); i++)
			{
				for(int j = 0; j<mainArray.length; j++)
				{
					// corresponding index of status is true/false depending on if characteristic is present
					// if the characteristic is present AND the animal is not already "falsed", remain true, everything else goes false
					if (mainArray[j].contains(characteristics.get(i)) && status[j] != false)
					{
						status[j] = true;
					}
					else
					{
						status[j] = false;
					}
				}
				
				ArrayList<String> copy = new ArrayList<String>();
				copy.addAll(characteristics);
				copy.remove(characteristics.get(i));
				
				Boolean[] copyBool = new Boolean[status.length];
				for(int a = 0; a<status.length; a++)
				{
					copyBool[a] = status[a];
				}
				
				if(numTrues(status) == 0)
				{
					data.add(count);
					return;
				}
				else
				{
					recursion(mainArray, copy, copyBool, count + 1, data);
				}
			}
		}
	}
	
	public static int numTrues(Boolean[] array)
	{
		int count = 0;
		for(int i = 0; i<array.length; i++)
		{
			if(array[i] == true)
			{
				count++;
			}
		}
		return count;
	}
}
