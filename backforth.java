import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class backforth {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new FileReader("backforth.in"));
		int[] barn1 = new int[10];
		int[] barn2 = new int[10];

	
		StringTokenizer input = new StringTokenizer(f.readLine());
		for(int j = 0; j<10; j++)
		{
			barn1[j] = Integer.valueOf(input.nextToken());
		}
		StringTokenizer input2 = new StringTokenizer(f.readLine());
		for(int j = 0; j<10; j++)
		{
			barn2[j] = Integer.valueOf(input2.nextToken());
		}
		f.close();
		
		Set<Integer> result = new HashSet<Integer>();
		recursion(1000, barn1, barn2, 0, result);
		
		PrintWriter out = new PrintWriter(new BufferedWriter (new FileWriter("backforth.out")));
		out.println(result.size());
		out.close();
	}	
	public static void recursion(int milk, int[] bucket1, int[] bucket2, int times, Set<Integer> data)
	{
		if(times == 4)
		{
			data.add(milk);
		}
		else
		{
			//main loop that iterates through every possible case
			for (int i = 0; i<bucket1.length; i++)
			{
				//subtract bucket (by index) 
				int[] bucket1_copy = new int[bucket1.length-1];
				int j = 0;
				for(int k=0; k < bucket1.length; k++)
				{
					//if k == remove, skip the index
					if(k != i)
				    bucket1_copy[j++] = bucket1[k];
				}
				//add bucket
				int[] bucket2_copy = new int[bucket2.length+1];
				for (int a=0; a<bucket2.length; a++)
				{
					bucket2_copy[a] = bucket2[a];
				}
				bucket2_copy[bucket2.length] = bucket1[i];				
				recursion(milk + bucket1[i]*(times % 2 == 0 ? -1 : 1), bucket2_copy, bucket1_copy,times + 1, data);
			}			
		}
	}
	//function for finding index
	public static int findIndex(int arr[], int t) 
	{  
		int index = Arrays.binarySearch(arr, t); 
		return (index < 0) ? -1 : index; 
	} 	
}