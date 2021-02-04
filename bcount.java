import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class bcount {
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("bcount.in"));
		StringTokenizer input = new StringTokenizer(f.readLine()); 
		int n = Integer.valueOf(input.nextToken());
		int q = Integer.valueOf(input.nextToken());
		int[] prefix = new int[n];
		prefix[0] = 0;
		int[] prefix2 = new int[n];
		prefix2[0] = 0;
		int[] prefix3 = new int[n];
		prefix3[0] = 0;
		for(int i =1; i<n+1; i++){
			int num = Integer.valueOf(f.readLine());
			if(num == 1) {
				prefix[i] += prefix[i-1] +1;
				prefix2[i] = prefix2[i-1];
				prefix3[i] = prefix2[i-1];
			}
			else if(num ==2) {
				prefix[i] += prefix[i-1];
				prefix2[i] = prefix2[i-1] +1;
				prefix3[i] = prefix2[i-1];
			}
			else {
				prefix[i] += prefix[i-1];
				prefix2[i] = prefix2[i-1];
				prefix3[i] = prefix2[i-1]+1;
			}
		}
		for(int i =0; i<q; i++) {
			StringTokenizer input2 = new StringTokenizer(f.readLine()); 
			int a = Integer.valueOf(input2.nextToken());
			int b = Integer.valueOf(input2.nextToken());
			PrintWriter out = new PrintWriter(new FileWriter("bcount.out"));
			System.out.println((prefix[b]-prefix[a-1]) + " " + (prefix2[b]-prefix2[a-1]) + " " + (prefix3[b]-prefix3[a-1]));
			out.close();
		}
	}
}
