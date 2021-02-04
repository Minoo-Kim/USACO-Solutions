import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class daisy {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(f.readLine());
		StringTokenizer input = new StringTokenizer(f.readLine());
		int[] flowers = new int[n];
		for(int i = 0; i<n; i++)
		{
			flowers[i] = Integer.valueOf(input.nextToken());
		}
		int count = 0;
		// main loop. Every loop goes from i to the last flower.
		for(int i = 0; i<n; i++)
		{
			int size = 0;
			int[] temp = new int[n];
					
			// loop starts from flowers[i].
			// loop starts adding elements one by one and ends when there are no more elements to be added
			// each loop, an element is added
			// increment size at the start of each loop, if size is 3, only count temp[0] --> temp[2]
			for(int j = 0; j<n-i; j++)
			{
				size += 1;
				temp[j] = flowers[i+j];
				if(avgPetal(temp, size))
				{
					count += 1;
				}
			}
		}
		
		PrintWriter out = new PrintWriter(new BufferedWriter (new OutputStreamWriter(System.out)));
		System.out.println(count);

	}
	public static Boolean avgPetal(int[] arr, double length)
	{
		double total = 0;
		for(int i = 0; i<length; i++)
		{
			total += arr[i];
		}
		double value = total/length;
		for (int element : arr) 
		{
		    if (element == value) 
		    {
		        return true;
		    }
		}
		return false;
	}
}
