import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class sleepy {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new FileReader("sleepy.in"));
		int cowNum = Integer.valueOf(f.readLine());	
		int[] order = new int[cowNum];
		StringTokenizer input = new StringTokenizer(f.readLine());
		for (int i = 0; i<cowNum; i++)
		{
			order[i] = Integer.valueOf(input.nextToken());
		}
		int last = order.length-1;
		int count = 1;
		for(int i = 0; i<last; i++)
		{
			if (count == cowNum)
			{
				break;
			}
			if(order[last - i] > order[last-i-1])
			{
				count++;
			}
			else
			{
				break;
			}
		}
		
		if(order.length == 2)
		{
			count = 1;
		}
		
		PrintWriter out = new PrintWriter(new BufferedWriter (new FileWriter("sleepy.out")));
		out.println(cowNum-count);
		out.close();
	}
}
