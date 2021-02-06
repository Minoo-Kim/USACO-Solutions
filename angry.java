import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class angry {
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("angry.in"));
		StringTokenizer input = new StringTokenizer(f.readLine()); 
		int n = Integer.valueOf(input.nextToken());
		int k = Integer.valueOf(input.nextToken());
		long[] hay = new long[n];
		for(int i =0; i<n; i++) {
			hay[i] = Long.valueOf(f.readLine());
		}
		Arrays.sort(hay);
		ArrayList<Long> intervals = new ArrayList<Long>(n-1);
		intervals.add(hay[1]-hay[0]);
		for(int i =1; i<n-1; i++) {
			intervals.add(Math.min(hay[i] - hay[i-1], hay[i+1] - hay[i]));
		}
		intervals.add(hay[n-1]-hay[n-2]);
		// minimum diameter of the blast
		long min = Collections.max(intervals);
		// maximum diameter of the blast
		long max = (hay[n-1] - hay[0])/k; 
		long r = 0;
		// bin search to find r 
		while(min<= max) {
			long mid = (min +max)/2;
			if(check(hay, k, mid)){
				r = mid;
				min = mid +1;
			}
			else {
				max = mid-1;
			}
		}
		if(r % 2 == 1) {
			r = (r+1)/2;
		}
		else {
			r = r/2;
		}
		PrintWriter out = new PrintWriter(new FileWriter("angry.out"));
		out.println(r); 
		out.close();
	}
	public static boolean check(long[] list, int k, long r) {
		long curr = list[0];
		for(int i =0; i<k; i++) {
			curr += r;
			if(curr > list[list.length-1]) {
				return false;
			}
			curr = search(list, curr);
		}
		return true;
	}
	
	
	// search for the minimum value in an array above limit
	public static long search(long[] list, long limit) { 
		int min = 0;
		int max = list.length-1; // index
		int ans = 0;
		while(min <= max) {
			int mid = (max + min)/2;
			if(list[mid] >= limit) { // everything above is true
				max = mid - 1;
				ans = mid;
			}
			else { // everything below is false
				min = mid +1;
			}
		}
		return list[ans];
	}

}
