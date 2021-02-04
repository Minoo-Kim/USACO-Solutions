import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class hopscotch {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new FileReader("hopscotch.in"));
		StringTokenizer input = new StringTokenizer(f.readLine());
		int r = Integer.valueOf(input.nextToken());
		int c = Integer.valueOf(input.nextToken());
		char[][] grid = new char[r][c];
		for(int i = 0; i<r; i++)
		{
			String row = f.readLine();
			
			for(int j = 0; j<c; j++)
			{
				grid[i][j] = row.charAt(j);
			}
		}
		ArrayList<Integer> data = new ArrayList<Integer>(0);
		PrintWriter out = new PrintWriter(new BufferedWriter (new FileWriter("hopscotch.out")));
		out.println(counter(grid, r, c, grid[0][0], 1, 1, data));
		out.close();
	}
	public static int counter(char[][] grid, int r, int c, char color, int rPos, int cPos, ArrayList<Integer> data)
	{
		if(rPos == r && cPos == c)
		{
			data.add(10);
		}
		else
		{
			for(int i = rPos; i<r; i++)
			{
				for(int j = cPos; j<c; j++)
				{
					if(grid[i][j] != color && i>=rPos && j>=cPos)
					{	
						counter(grid, r, c, grid[i][j], i+1, j+1, data);		
					}
				}
				
			}
		}		
		return data.size();
	}

}
