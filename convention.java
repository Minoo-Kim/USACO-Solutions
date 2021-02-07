import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class convention {
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("convention.in"));
		PrintWriter out = new PrintWriter(new FileWriter("convention.out"));
		StringTokenizer input = new StringTokenizer(f.readLine()); 
		int n = Integer.valueOf(input.nextToken()); 
		int m = Integer.valueOf(input.nextToken()); 
		int c = Integer.valueOf(input.nextToken()); 
		int[] times = new int[n];
		StringTokenizer input2 = new StringTokenizer(f.readLine()); 
		for(int i =0;i<n;i++) {
			times[i] = Integer.valueOf(input2.nextToken());
		}
		Arrays.sort(times);
		int min = 1;
		int max = 1000000000;
		int t = 0;
		while(min <= max) {
			int mid = (min+max)/2;
			if(check(times, c, m, mid)) {			
				max = mid -1;
			}
			else {
				t = mid;
				min = mid +1;
			}
		}
		out.println(t+1);
		out.close();
		
	}
	public static boolean check(int[] times, int c, int m, int t) {
		// given value t, can the bus depart with every cow, following
		// a) if t is not reached yet but C cows are on-board, bus leaves
		// b) if t is reached but C cows are not on-board, bus leaves
		int curr = 0;
		while(m>0) {
			m -=1;
			
			int first = times[curr]; // arrival of first cow
			int thresh = t+first; // bus must leave at this time
			int lastIndex = search(times,thresh); // greatest index <= t
			if((lastIndex-curr)+1 >= c) {
				curr += c;
			}
			else { 
				curr = lastIndex+1;
			}
			if(curr >= times.length) { // all cows have boarded
				return true;
			}
		}
			return false; // curr is less than the number of cows
	}
	// search for the max index below limit
		public static int search(int[] list, int limit) { 
			int min = 0;
			int max = list.length-1; // index
			int ans = 0;
			while(min <= max) {
				int mid = (max + min)/2;
				if(list[mid] <= limit) { // everything above is true
					min = mid + 1;
					ans = mid;
				}
				else { // everything below is false
					max = mid -1;
				}
			}
			return ans; // returns max index that satisfies list[index] <= limit. 
		}

}
