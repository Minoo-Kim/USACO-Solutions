import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class cowsignal {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new FileReader("cowsignal.in"));
		StringTokenizer input = new StringTokenizer(f.readLine());
		int m = Integer.valueOf(input.nextToken());
		int n = Integer.valueOf(input.nextToken());
		int k = Integer.valueOf(input.nextToken());
		PrintWriter out = new PrintWriter(new FileWriter("cowsignal.out"));
		// big loop that determines number of lines printed
		for(int i = 0; i<m; i++)
		{
			StringTokenizer line = new StringTokenizer(f.readLine());
			String word = line.nextToken();
			// store the line in character array
			Character[] chars = new Character[n];
			for(int d = 0; d<n; d++)
			{
				chars[d] = word.charAt(d);
			}
			// duplicate line k times (rows) 
			for(int a = 0; a<k; a++)
			{
				// number of characters per line
				for(int b = 0; b<n; b++)
				{
					// write each character twice consecutively 
					for(int c = 0; c<k; c++) 
					{
						out.print(chars[b]);
					}
				}
				out.print("\n");
			}
		}
		out.close();
	}

}
