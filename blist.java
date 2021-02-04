import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;

public class blist {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new FileReader("blist.in"));
		int cowsNum = Integer.valueOf(f.readLine());
		int[] start = new int[1001];
		int[] end = new int[1001];
		int[] buckets = new int[101];
		
		//initialize arrays 
		// these arrays: index are the elements, the inputs are the actual times
		for (int i = 1; i<cowsNum+1; i++)
		{
			StringTokenizer input = new StringTokenizer(f.readLine());
			start[Integer.valueOf(input.nextToken())] = i;
			end[Integer.valueOf(input.nextToken())] = i;
			buckets[i] = Integer.valueOf(input.nextToken());
		}
		
		int temp = 0;
		int max = 0;
		for(int i = 1; i<1000; i++)
		{
			if(start[i] != 0)
			{
				// add the amount of buckets from cow# (which is the index) resulted from the start array
				temp += buckets[start[i]];
			}
			if(end[i] != 0)
			{
				// subtract the amount of buckets from cow# (which is the index) resulted from the start array
				temp -= buckets[end[i]];
			} 
			if(temp > max)
			{
				max = temp;
			}
		}
		
		PrintWriter out = new PrintWriter(new BufferedWriter (new FileWriter("blist.out")));
		out.print(max);
		out.close();
	}
}
	
	
	
	
	
	
	
	