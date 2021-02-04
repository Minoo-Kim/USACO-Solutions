import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class hoofball {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new FileReader("hoofball.in"));
		int n = Integer.valueOf(f.readLine());
		ArrayList<Integer> dist = new ArrayList<Integer>(n);
		StringTokenizer input = new StringTokenizer(f.readLine());

		for(int i = 0; i<n; i++)
		{
			dist.add(Integer.valueOf(input.nextToken()));
		}
		Collections.sort(dist);
		ArrayList<Integer> gap = new ArrayList<Integer>(n-1);
		for(int i = 0; i<n-1; i++)
		{
			gap.add(Math.abs(dist.get(i) - dist.get(i+1)));
		}
		// count
		int count = 0;
		int status = 0; // 0 is nothing, 1 is increasing, 2 is decreasing
		for(int i = 0; i<n-2; i++)
		{
			if(gap.get(i) > gap.get(i+1) && status == 2) // getting smaller
			{
				continue;
			}
			else if((gap.get(i) <= gap.get(i+1)) && status == 1) // getting larger
			{
				continue;
			}
			else if((gap.get(i) > gap.get(i+1)) && status == 0) // first getting smaller
			{
				status = 2;
			}
			else if((gap.get(i) <= gap.get(i+1)) && status == 0) // first getting larger
			{
				status = 1;
			}
			else
			{
				status = 0;
				count += 1;
			}
		}
		PrintWriter out = new PrintWriter(new BufferedWriter (new FileWriter("hoofball.out")));
		System.out.println(count + 1);
		out.close();
		
	}

}
