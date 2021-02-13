import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class homework {
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("homework.in"));
		PrintWriter out = new PrintWriter(new FileWriter("homework.out"));
		int n = Integer.valueOf(f.readLine());
		int[] prefix = new int[n];
		int[] nums = new int[n];
		StringTokenizer input = new StringTokenizer(f.readLine());
		int start = Integer.valueOf(input.nextToken());
		prefix[0] = start;
		nums[0] = start;
		for(int i=1; i<n; i++) {
			int num = Integer.valueOf(input.nextToken());
			prefix[i] = prefix[i-1] + num;
			nums[i] = num;
		}
		// find min value down to the given index
		// for example, min[6] contains the min-value from index-end, inclusive  
		int[] min = new int[n];
		min[n-1] = nums[n-1];
		for(int i = n-2; i>=0; i--) {
			min[i] = Math.min(min[i+1], nums[i]);
		}
		ArrayList<Integer> data = new ArrayList<Integer>();
		double max = 0.0;
		for(int i = 0; i<n-2; i++) {
			// ex: if index = 0; k = 1;
			double num = (prefix[n-1]-prefix[i]-min[i+1])/(n-2.0-i); // avg w/ min subtracted
			if(num > max) {
				max = num;
				data = new ArrayList<Integer>();
				data.add(i+1);	
			}
			else if(num == max) {
				data.add(i+1);
			}
		}
		Collections.sort(data);
		for(int i =0; i<data.size(); i++) {
			out.println(data.get(i));	
		}
		out.close();
	}

}
