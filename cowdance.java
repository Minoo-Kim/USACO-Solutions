import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class cowdance {
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("cowdance.in"));
		PrintWriter out = new PrintWriter(new FileWriter("cowdance.out"));

		StringTokenizer input = new StringTokenizer(f.readLine()); 
		int n = Integer.valueOf(input.nextToken()); 
		int t = Integer.valueOf(input.nextToken()); 
		int[] time = new int[n];
		for(int i=0;i<n;i++) {
			time[i] = Integer.valueOf(f.readLine());
		}
		int min = 1;
		int max = n;
		int k = 0;
		
		while(min<=max) {
			int mid = (min+max)/2;
			if(check(time, t, mid)){ // For all k above mid works.
				max = mid - 1;
			}
			else {
				min = mid +1;
				k = mid;
			}
		}
		out.println(k+1);
		out.close();
		
	}
	public static boolean check(int[] time, int t, int k) {
		ArrayList<Integer> used = new ArrayList<Integer>(k);
		for(int i=0; i<k; i++) {
			used.add(0);
		}
		for(int i =0; i<time.length;i++) {	
			int index = used.indexOf(Collections.min(used));
			used.set(index, used.get(index)+time[i]);
		}
		if(Collections.max(used) > t) {
			return false;
		}
		else {
			return true;
		}
	}
		
}

