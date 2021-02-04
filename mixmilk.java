import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class mixmilk {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new FileReader("mixmilk.in"));
		int[] volume = new int[3];
		int[] amountMilk = new int[3];
		
		// fill in arrays
		for (int i = 0; i<3; i++)
		{
			StringTokenizer input = new StringTokenizer(f.readLine());
			int vol = Integer.valueOf(input.nextToken());
			int milk = Integer.valueOf(input.nextToken());
			volume[i] = vol;
			amountMilk[i] = milk;	
		}
		
		for(int i = 0; i<100; i++)
		{
			if(amountMilk[i%3] > volume[(i+1)%3]-amountMilk[(i+1)%3])
			{
				// fills up space left on jar b. Jar b will be full, the that amount will be subtracted from jar a
				amountMilk[i%3] = amountMilk[i%3] - (volume[(i+1)%3] - amountMilk[(i+1)%3]);
				amountMilk[(i+1)%3] = volume[(i+1)%3];
			}
			else if(amountMilk[i%3] < volume[(i+1)%3]-amountMilk[(i+1)%3])
			{
				// Jar A will be empty, adds amount taken away to Jar B
				amountMilk[(i+1)%3] += amountMilk[i%3];
				amountMilk[i%3] = 0;
			}
			else
			{
				amountMilk[(i+1)%3] = volume[(i+1)%3];
				amountMilk[i%3] = 0;
			}
		}
		PrintWriter out = new PrintWriter(new BufferedWriter (new FileWriter("mixmilk.out")));
		out.println(amountMilk[0]);
		out.println(amountMilk[1]);
		out.println(amountMilk[2]);
		out.close();
	}
}
