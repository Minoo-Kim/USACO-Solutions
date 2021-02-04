import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class word {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new FileReader("word.in"));
		StringTokenizer input = new StringTokenizer(f.readLine());
		int n = Integer.valueOf(input.nextToken());
		int k = Integer.valueOf(input.nextToken());
		
		// array containing all the words
		String[] wordList = new String[n];
		StringTokenizer input2 = new StringTokenizer(f.readLine());
		for(int i = 0; i<n; i++)
		{
			wordList[i] = input2.nextToken();
		}
		PrintWriter out = new PrintWriter(new BufferedWriter (new FileWriter("word.out")));
		out.print(wordList[0]);
		int count = wordList[0].length();
		for (int i = 1; i<n; i++)
		{
			count += wordList[i].length();
			// if count is under or equal
			if(count <= k)
			{
				if(count == k)
				{
					out.print(" " + wordList[i]);
				}
				else
				{
					out.print(" " + wordList[i]);
				}		
			}
			// if count is over the limit
			else
			{
				out.print("\n");
				out.print(wordList[i]);
				count = wordList[i].length();
			}
		}
		out.close();
	}
	
}