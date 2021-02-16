import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class reststops {

	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("reststops.in"));
		PrintWriter out = new PrintWriter(new FileWriter("reststops.out"));
		StringTokenizer input = new StringTokenizer(f.readLine());
		int l = Integer.valueOf(input.nextToken());
		int n = Integer.valueOf(input.nextToken());
		int rF = Integer.valueOf(input.nextToken());
		int rB = Integer.valueOf(input.nextToken());
		Rest[] stops = new Rest[n];
		for(int i=0; i<n; i++) {
			StringTokenizer input2 = new StringTokenizer(f.readLine());
			stops[i] = new Rest(Integer.valueOf(input2.nextToken()), Integer.valueOf(input2.nextToken()));
		}
		Arrays.sort(stops);
		int curr = 0;
		long res = 0;		
		for(int i = 0; i<n; i++) {
			if(stops[i].index > curr) {
				long gap = stops[i].index - curr;
				res += (rF*gap - rB*gap)*stops[i].value;
				curr = stops[i].index;
			}
		}			
		out.println(res);
		out.close();
	}
	static class Rest implements Comparable<Rest> {
		 int index, value;
		 public Rest(int index, int value) {
			 this.index = index;
			 this.value = value;
		 }
		public int compareTo(Rest o) {
			// descending order
			if(this.value == o.value) {
				return this.index-o.index;
			}
			else{
				return -(this.value-o.value);
			}
		}	 
	}	
}