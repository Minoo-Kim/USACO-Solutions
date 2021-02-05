import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class hps_silver {
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("hps.in"));
		int n = Integer.valueOf(f.readLine());
		int[] prefix = new int[n+1]; // rock
		int[] prefix2 = new int[n+1];//paper
		int[] prefix3 = new int[n+1];// scissor
		for(int i = 1; i<n+1; i++) {
			String let = f.readLine();
			prefix[i] += prefix[i-1];
			prefix2[i] += prefix2[i-1];
			prefix3[i] += prefix3[i-1];

			if(let.equals("H")) {
				prefix2[i] += 1;
			}
			else if(let.equals("P")) {
				prefix3[i] += 1;
			}
			else { // scissors
				prefix[i] +=1;
			}
		}
		int count = prefix[n];
		int count2 = prefix[n];
		int count3 = prefix2[n];
		int count4 = prefix2[n];
		int count5 = prefix3[n];
		int count6 = prefix3[n];
		// first is 0. 
		for(int i = 2; i<n+1; i++) {
			count = Math.max(prefix[i-1]+prefix2[n]-prefix2[i-1], count); // i + (i+1 to end) 
			count2 = Math.max(prefix[i-1]+prefix3[n]-prefix3[i-1], count2);
			count3 = Math.max(prefix2[i-1]+prefix[n]-prefix[i-1], count3);
			count4 = Math.max(prefix2[i-1]+prefix3[n]-prefix3[i-1], count4);
			count5 = Math.max(prefix3[i-1]+prefix[n]-prefix[i-1],count5);
			count6 = Math.max(prefix3[i-1]+prefix2[n]-prefix2[i-1], count6);
		}
		count = Math.max(count, count2);
		count = Math.max(count, count3);
		count = Math.max(count, count4);
		count = Math.max(count, count5);
		count = Math.max(count, count6);
		PrintWriter out = new PrintWriter(new FileWriter("hps.out"));
		out.println(count);
		out.close();
	}
}
