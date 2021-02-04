import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class taming {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new FileReader("taming.in"));
		PrintWriter out = new PrintWriter(new FileWriter("taming.out"));
		int n = Integer.valueOf(f.readLine());
		StringTokenizer input = new StringTokenizer(f.readLine());  
		int[] nums = new int[n];
		for(int i = 0; i<n; i++)
		{
			nums[i] = Integer.valueOf(input.nextToken());
		}
		int count = 0;
		int extra = 0;
		Boolean error = false; 
		for(int i = n-1; i>=0; i--)
		{
			if(i == 0)
			{
				if(nums[0] != 0 && nums[0] != -1)
				{
					error = true;
				}
				else
				{
					count += 1;
					break;
				}
			}
			// real number
			if(nums[i] == 0)
			{
				count += 1;
			}
			else if(nums[i] != -1)
			{
				count +=1;
				int cur = nums[i];

				// loop ends when cur reaches 0 or -1 
				for(int j = 0; j<cur+1;j++)
				{
					// doens't fit pattern
					if((nums[i-j] != cur-j) && nums[i-j] != -1)
					{
						error = true;
					}
				}
				// skip i as much as was processed
				i = i - cur;

			}
			else // number is -1
			{
				extra +=1;
			}
		}
		if(error == true)
		{
			out.println(-1);
		}
		else
		{
			out.println(count + " " + (count + extra));		
		}
		out.close();
		
	}
}
