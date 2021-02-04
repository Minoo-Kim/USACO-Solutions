import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class mowing {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new FileReader("mowing.in"));
		int n = Integer.valueOf(f.readLine());
		int time = 0;
		int[][] field = new int[10000][10000];
		int x = 1000;
		int y = 1000;
        ArrayList<Integer> res = new ArrayList<Integer>(n); 
        for(int i = 0; i<n; i++)
        {
        	res.add(1000000);
        }
		for(int i=0;i<n;i++)
		{
			StringTokenizer input = new StringTokenizer(f.readLine());
			String dir = input.nextToken();
			int steps = Integer.valueOf(input.nextToken());	
			for(int a = 0; a<steps; a++)
			{
				// always increase time
				time += 1;
				// only add if the field has been crossed before
				if(field[x][y] != 0)
				{
					res.add(time-field[x][y]);
				}
				// always set to current time
				field[x][y] = time;
				// change coordinates
				if(dir.equals("N"))
				{
					y+=1;
				}
				else if(dir.equals("S"))
				{
					y-=1;
				}
				else if(dir.equals("E"))
				{
					x+=1;
				}
				else // west
				{
					x-=1;
				}
			}
		}
		PrintWriter out = new PrintWriter(new FileWriter("mowing.out"));
		if(res.size() == n)
		{
			out.println(-1);
		}
		else
		{
			out.println(Collections.min(res));
		}
		out.close();
	}
}
