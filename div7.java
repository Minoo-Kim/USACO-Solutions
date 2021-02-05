import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class div7 {
	public static void main(String[] args) throws IOException
	{
		// note: timed out on the 10th case
		BufferedReader f = new BufferedReader(new FileReader("div7.in"));
		int n = Integer.valueOf(f.readLine());
		// find prefix array
		long[] prefix = new long[n+1];
		prefix[0] = 0;
		for(int i =1; i<n+1; i++) {
			long num = Long.valueOf(f.readLine());
			prefix[i] = num + prefix[i-1];
		}
		// loop through all sub-arrays
		int result = 0;
		int a = 0;
		for(int i =2; i<n+1; i++) {
			a = Math.max(i, a);
			for(int j = a; j<n+1; j++) {
				if((prefix[j]-prefix[i-1])%7 == 0) {
					if(j-i+1>result){
						result = j-i+1;
						a = j+1; // new j restriction. Doesn't get changed until next biggest
						// j. Every loop starts from here now.
					}
				}
			}
		}
		PrintWriter out = new PrintWriter(new FileWriter("div7.out"));
		out.println(result);
		out.close();
		
	}
	

}
