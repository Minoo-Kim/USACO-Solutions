import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class balancing {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new FileReader("balancing.in"));
		StringTokenizer input = new StringTokenizer(f.readLine());
		int n = Integer.valueOf(input.nextToken());
		int[] x = new int[n];
		int[] y = new int[n];
		for(int i = 0; i<n; i++)
		{
			StringTokenizer input2 = new StringTokenizer(f.readLine());
			x[i] = Integer.valueOf(input2.nextToken());
			y[i] = Integer.valueOf(input2.nextToken());
		}
		
		// add every x line possible without duplicates
        ArrayList<Integer> xLine = new ArrayList<Integer>(n); 
		for(int i = 0; i<n; i++)
		{
			xLine.add(x[i]+1);
		}
		// find minimum with y line
        ArrayList<Integer> res = new ArrayList<Integer>(n*n); 
        for(int i = 0; i<n; i++)
        {
        	int line = y[i] + 1;
        	
        	// every possible x line
        	for(int a = 0; a<xLine.size(); a++)
        	{	 	
        		int count = 0;
            	int count2 = 0;
            	int count3 = 0;
            	int count4 = 0;
        		// lowest count for every possible y line 
        		for(int j = 0; j<n; j++)
        		{
        			if(y[j] < line && x[j] < xLine.get(a)) // bottom left
        			{
        				count += 1;
        			}
        			else if(y[j] < line && x[j] > xLine.get(a)) // bottom right
        			{
        				count2 += 1;
        			}
        			else if(y[j] > line && x[j] < xLine.get(a)) // top left
        			{
        				count3 += 1;
        			}
        			else // top right
        			{
        				count4 +=1;
        			}
        		}
        		count = Math.max(count, count2);
        		count = Math.max(count, count3);
        		count = Math.max(count, count4);
        		res.add(count);
        	}
        }
        PrintWriter out = new PrintWriter(new FileWriter("balancing.out"));
		out.println(Collections.min(res));
		out.close();
	}
}
