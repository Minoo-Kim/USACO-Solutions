import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class helpcross {
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("helpcross.in"));
		StringTokenizer input = new StringTokenizer(f.readLine());
		int c = Integer.valueOf(input.nextToken());
		int n = Integer.valueOf(input.nextToken());
		ArrayList<Long> chicken = new ArrayList<Long>(c);
		for(int i =0; i<c; i++)
		{
			chicken.add(Long.valueOf(f.readLine()));
		}
		Cow[] cow = new Cow[n];
		for(int i =0; i<n; i++)
		{
			StringTokenizer input2 = new StringTokenizer(f.readLine());
			cow[i] = new Cow(Long.valueOf(input2.nextToken()), Long.valueOf(input2.nextToken()));
		}
		Collections.sort(chicken);
		Arrays.sort(cow);
		int count = 0;

		for(int i =0; i<n; i++) // loop over every cow
		{
			long start = cow[i].getStart();
			long end = cow[i].getEnd();
			for(int j = 0; j<chicken.size(); j++)
			{
				if(start <= chicken.get(j) && end >= chicken.get(j)) 
				{
					chicken.remove(j);
					count +=1;
					break;
				}
			}	
		}
		PrintWriter out = new PrintWriter(new FileWriter("helpcross.out"));
		out.println(count);
		out.close();
	}
	static class Cow implements Comparable<Cow>{
	    long start; long end;
	    public Cow(long s, long e){
	    	start = s; end = e;
	    }
	    public long getStart()
	    {
	    	return start;
	    }
	    public long getEnd()
	    {
	    	return end;
	    }
	    public int compareTo(Cow e){
		    return Long.compare(this.end, e.end);
	    	
		} 
	}
}

