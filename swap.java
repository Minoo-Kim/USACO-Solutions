import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class swap {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new FileReader("swap.in"));
		StringTokenizer input = new StringTokenizer(f.readLine());
		int n = Integer.valueOf(input.nextToken());
		int k = Integer.valueOf(input.nextToken());
		StringTokenizer input1 = new StringTokenizer(f.readLine());
		StringTokenizer input2 = new StringTokenizer(f.readLine());
		int a1 = Integer.valueOf(input1.nextToken());
		int a2 = Integer.valueOf(input1.nextToken());
		int b1 = Integer.valueOf(input2.nextToken());
		int b2 = Integer.valueOf(input2.nextToken());
		ArrayList<Integer> cows = new ArrayList<Integer>(n);
		ArrayList<Integer> original = new ArrayList<Integer>(n);
		for(int i = 1; i<=n; i++)
		{
			cows.add(i);
			original.add(i);
		}
		
		int counter = 0;
		for(int i = 0; i<k; i++)
		{
			swapper(a1, a2, cows);
			swapper(b1, b2, cows);
			counter += 1;
			if(cows.equals(original))
			{
				break;
			}
		}
		
		for(int i = 0; i<k%counter; i++)
		{
			swapper(a1, a2, cows);
			swapper(b1, b2, cows);
		}
		PrintWriter out = new PrintWriter(new BufferedWriter (new FileWriter("swap.out")));
		for(int i = 0; i<n; i++)
		{
			out.println(cows.get(i));
		}
		out.close();
	}
	
	// swap function
	public static void swapper(int num1, int num2, ArrayList<Integer> list)
	{
		if((num2 - num1)%2 == 0) // middle number stays the same
		{
			for(int i = 0; i<(num2 - num1)/2; i++)
			{
				Collections.swap(list, num1+i-1, num2-i-1);
			}
		}
		else // everything flips
		{
			for(int i = 0; i<(num2 - num1 + 1)/2; i++)
			{
				Collections.swap(list, num1+i-1, num2-i-1);
			}
		}
	}
	

}
