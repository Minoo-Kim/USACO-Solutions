import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class silver_herding {
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("herding.in"));
		PrintWriter out = new PrintWriter(new FileWriter("herding.out"));
		int n = Integer.valueOf(f.readLine());
		int[] cows = new int[n];
		for(int i =0; i<n; i++) {
			cows[i] = Integer.valueOf(f.readLine());
		}
		Arrays.sort(cows);
		// find min
		int min = 0;
		if(cows[n-2]-cows[0] == n-2 && cows[n-1]-cows[n-2]>2) {
			min = 2;
		}
		else if(cows[n-1]-cows[1] == n-2 && cows[1]-cows[0]>2) {
			min = 2;
		}
		else {
			int best =0;
			for(int i =0; i<n; i++) {
				int j =0;
				// loop stops when there are enough spaces for at least n cows
				while(j<n-1 && cows[j+1]-cows[i]<=n-1) {
					j+=1;
					best = Math.max(best, j-i+1); // record total amount of cows CURRENTLY in the range
				}
			}
			min = n-best; 
			// total - max amount of cows within space for n cows. 
			// the empty spaces within the n range can be filled up optimally
		}
		out.println(min);
		
		//find max
		int total = 0;
		for(int i = 0; i<n-1; i++) {
			total += cows[i+1]-cows[i]-1;
		}
		int outside = Math.min(cows[1]-cows[0]-1, cows[n-1]-cows[n-2]-1);
		out.println(total-outside);
		out.close();
	}
}
