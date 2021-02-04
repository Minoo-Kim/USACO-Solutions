import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class rut {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(f.readLine());
		
		int[] count = new int[n];
		String[] dir = new String[n];
		int[] xCoor = new int[n];
		int[] yCoor = new int[n];
		// change coordinates here
		int[][] grid = new int[101][101];
		for (int i = 0; i<n; i++)
		{
			StringTokenizer input = new StringTokenizer(f.readLine());
			dir[i] = input.nextToken();
			xCoor[i] = Integer.valueOf(input.nextToken());
			yCoor[i] = Integer.valueOf(input.nextToken());
		}
		// change i<100 here
		for (int i = 0; i<54; i++) {
			for(int j = 0; j<n; j++)
			{
				// if grass isn't eaten, eat grass and move
				if(grid[xCoor[j]][yCoor[j]] == 0 || grid[xCoor[j]][yCoor[j]] == j)
				{
					grid[xCoor[j]][yCoor[j]] = j;
					count[j] += 1;
					// move
					if(dir[j].equals("N"))
					{
						yCoor[j] += 1;
					}
					else {
						xCoor[j] += 1;
					}
				}
			}
		}
	
		PrintWriter out = new PrintWriter(new BufferedWriter (new OutputStreamWriter(System.out)));
		for (int i = 0; i<n; i++)
		{
			if(grid[xCoor[i]][yCoor[i]] == 0)
			{
				System.out.println("Infinity");
			}
			else {
				System.out.println(count[i]);
			}
		}
	}
}