import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class haybales {
	public class angry {

	}

	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("haybales.in"));
		StringTokenizer input = new StringTokenizer(f.readLine()); 
		int n = Integer.valueOf(input.nextToken());
		int q = Integer.valueOf(input.nextToken());
		StringTokenizer input2 = new StringTokenizer(f.readLine()); 
		long[] list = new long[n];
		for(int i =0; i<n; i++) {
			list[i] = Long.valueOf(input2.nextToken());
		}
		Arrays.sort(list);
		PrintWriter out = new PrintWriter(new FileWriter("haybales.out"));
		for(int i =0; i<q; i++) {
			StringTokenizer input3 = new StringTokenizer(f.readLine()); 
			long a = Long.valueOf(input3.nextToken());
			long b = Long.valueOf(input3.nextToken());

			out.println(search(list, b)-search(list, a-1));
		}
		
		out.close();
	}
	
	public static int search(long[] list, long limit) { 
		if(list[0] >= limit) {
			return -1;
		}
		int min = 0; // index
		int max = list.length-1; // index
		int ans = 0;
		while(min <= max) {
			int mid = (max + min)/2;
			if(list[mid] <= limit) { // upper half
				min = mid + 1;
				ans = mid;
			}
			else { // lower half
				max = mid -1;
			}
		}
		return ans; // returns max index that satisfies list[index] <= limit. 
	}
}
