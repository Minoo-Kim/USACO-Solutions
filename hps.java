import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class hps {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new FileReader("hps.in"));
		int n = Integer.valueOf(f.readLine());
		int[] cow1 = new int[n];
		int[] cow2 = new int[n];

		for(int i = 0; i<n; i++)
		{
			StringTokenizer input = new StringTokenizer(f.readLine());
			cow1[i] = Integer.valueOf(input.nextToken());
			cow2[i] = Integer.valueOf(input.nextToken());
		}
		ArrayList<String> set1 = new ArrayList<String>(n);
		ArrayList<String> set2 = new ArrayList<String>(n);
		int maxCount = 0;
		for(int i = 0; i<n; i++)
		{
			if(cow1[i] == 1)
			{
				set1.add("Rock");
			}
			else if(cow1[i] == 2)
			{
				set1.add("Scissors");
			}
			else
			{
				set1.add("Paper");
			}
			// 2nd set
			if(cow2[i] == 1)
			{
				set2.add("Rock");
			}
			else if(cow2[i] == 2)
			{
				set2.add("Scissors");
			}
			else
			{
				set2.add("Paper");
			}
		}
		int count = 0;
		for(int i = 0; i<n; i++)
		{
			if(set1.get(i).contentEquals("Scissors") && set2.get(i).contentEquals("Paper"))
			{
				count += 1;
			}
			else if(set1.get(i).contentEquals("Paper") && set2.get(i).contentEquals("Rock"))
			{
				count += 1;
			}
			else if(set1.get(i).contentEquals("Rock") && set2.get(i).contentEquals("Scissors"))
			{
				count += 1;
			}
		}
		maxCount = Math.max(maxCount, count);
		//2nd
		for(int i = 0; i<n; i++)
		{
			if(cow1[i] == 1)
			{
				set1.set(i, "Rock");
			}
			else if(cow1[i] == 2)
			{
				set1.set(i, "Paper");
			}
			else
			{
				set1.set(i, "Scissors");
			}
			// 2nd set
			if(cow2[i] == 1)
			{
				set2.set(i, "Rock");
			}
			else if(cow2[i] == 2)
			{
				set2.set(i, "Paper");
			}
			else
			{
				set2.set(i, "Scissors");
			}
		}
		int count2 = 0;
		for(int i = 0; i<n; i++)
		{
			if(set1.get(i).contentEquals("Scissors") && set2.get(i).contentEquals("Paper"))
			{
				count2 += 1;
			}
			else if(set1.get(i).contentEquals("Paper") && set2.get(i).contentEquals("Rock"))
			{
				count2 += 1;
			}
			else if(set1.get(i).contentEquals("Rock") && set2.get(i).contentEquals("Scissors"))
			{
				count2 += 1;
			}
		}
		maxCount = Math.max(maxCount, count2);
		
		// 3rd
		for(int i = 0; i<n; i++)
		{
			if(cow1[i] == 1)
			{
				set1.set(i, "Paper");
			}
			else if(cow1[i] == 2)
			{
				set1.set(i, "Rock");
			}
			else
			{
				set1.set(i, "Scissors");
			}
			// 2nd set
			if(cow2[i] == 1)
			{
				set2.set(i, "Paper");
			}
			else if(cow2[i] == 2)
			{
				set2.set(i, "Rock");
			}
			else
			{
				set2.set(i, "Scissors");
			}
		}
		int count3 = 0;
		for(int i = 0; i<n; i++)
		{
			if(set1.get(i).contentEquals("Scissors") && set2.get(i).contentEquals("Paper"))
			{
				count3 += 1;
			}
			else if(set1.get(i).contentEquals("Paper") && set2.get(i).contentEquals("Rock"))
			{
				count3 += 1;
			}
			else if(set1.get(i).contentEquals("Rock") && set2.get(i).contentEquals("Scissors"))
			{
				count3 += 1;
			}
		}
		maxCount = Math.max(maxCount, count3);
		
		
		//4th
		for(int i = 0; i<n; i++)
		{
			if(cow1[i] == 1)
			{
				set1.set(i, "Paper");
			}
			else if(cow1[i] == 2)
			{
				set1.set(i, "Scissors");
			}
			else
			{
				set1.set(i, "Rock");
			}
			// 2nd set
			if(cow2[i] == 1)
			{
				set2.set(i, "Paper");
			}
			else if(cow2[i] == 2)
			{
				set2.set(i, "Scissors");
			}
			else
			{
				set2.set(i, "Rock");
			}
		}
		int count4 = 0;
		for(int i = 0; i<n; i++)
		{
			if(set1.get(i).contentEquals("Scissors") && set2.get(i).contentEquals("Paper"))
			{
				count4 += 1;
			}
			else if(set1.get(i).contentEquals("Paper") && set2.get(i).contentEquals("Rock"))
			{
				count4 += 1;
			}
			else if(set1.get(i).contentEquals("Rock") && set2.get(i).contentEquals("Scissors"))
			{
				count4 += 1;
			}
		}
		maxCount = Math.max(maxCount, count4);
		
		//5
		for(int i = 0; i<n; i++)
		{
			if(cow1[i] == 1)
			{
				set1.set(i, "Scissors");
			}
			else if(cow1[i] == 2)
			{
				set1.set(i, "Rock");
			}
			else
			{
				set1.set(i, "Paper");
			}
			// 2nd set
			if(cow2[i] == 1)
			{
				set2.set(i, "Scissors");
			}
			else if(cow2[i] == 2)
			{
				set2.set(i, "Rock");
			}
			else
			{
				set2.set(i, "Paper");
			}
		}
		int count5 = 0;
		for(int i = 0; i<n; i++)
		{
			if(set1.get(i).contentEquals("Scissors") && set2.get(i).contentEquals("Paper"))
			{
				count5 += 1;
			}
			else if(set1.get(i).contentEquals("Paper") && set2.get(i).contentEquals("Rock"))
			{
				count5 += 1;
			}
			else if(set1.get(i).contentEquals("Rock") && set2.get(i).contentEquals("Scissors"))
			{
				count5 += 1;
			}
		}
		maxCount = Math.max(maxCount, count5);
		
		//6
		for(int i = 0; i<n; i++)
		{
			if(cow1[i] == 1)
			{
				set1.set(i, "Scissors");
			}
			else if(cow1[i] == 2)
			{
				set1.set(i, "Paper");
			}
			else
			{
				set1.set(i, "Rock");
			}
			// 2nd set
			if(cow2[i] == 1)
			{
				set2.set(i, "Scissors");
			}
			else if(cow2[i] == 2)
			{
				set2.set(i, "Paper");
			}
			else
			{
				set2.set(i, "Rock");
			}
		}
		int count6 = 0;
		for(int i = 0; i<n; i++)
		{
			if(set1.get(i).contentEquals("Scissors") && set2.get(i).contentEquals("Paper"))
			{
				count6 += 1;
			}
			else if(set1.get(i).contentEquals("Paper") && set2.get(i).contentEquals("Rock"))
			{
				count6 += 1;
			}
			else if(set1.get(i).contentEquals("Rock") && set2.get(i).contentEquals("Scissors"))
			{
				count6 += 1;
			}
		}
		maxCount = Math.max(maxCount, count6);
	    PrintWriter out = new PrintWriter(new FileWriter("hps.out"));
		out.println(maxCount);
		out.close();
	}
}
