import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class shell {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new FileReader("shell.in"));
		int swaps = Integer.valueOf(f.readLine());
		int[] shellSet = new int[]{1, 2, 3};
		//arrayList to store the results
		ArrayList<Integer> result = new ArrayList<Integer>(swaps);

		for(int i = 0; i<swaps; i++)
		{
			StringTokenizer input = new StringTokenizer(f.readLine());
			int index1 = Integer.valueOf(input.nextToken())-1;
			int index2 = Integer.valueOf(input.nextToken())-1;
			int guess = Integer.valueOf(input.nextToken())-1;
			swap(shellSet, index1, index2);
			//add the shell# (either 1, 2, or 3) based on the index
			result.add(shellSet[guess]);
		}
		f.close();

		int count1=Collections.frequency(result, 1);
		int count2=Collections.frequency(result, 2);
		int count3=Collections.frequency(result, 3);
		int ans = Math.max(count1, count2);
		ans = Math.max(ans, count3);
		
		PrintWriter out = new PrintWriter(new BufferedWriter (new FileWriter("shell.out")));
		out.println(ans);
		System.out.println(ans);
		out.close();
	}
	
	public static void swap(int a[], int i, int j)
	{
	  int temp = a[i];
	  a[i] = a[j];
	  a[j] = temp;
	}
}
