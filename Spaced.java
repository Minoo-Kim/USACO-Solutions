import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Spaced { 
	public static void main(String[] args) throws IOException {
	    BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter (new OutputStreamWriter(System.out)));
		int n = Integer.valueOf(f.readLine());
		int[][] grid = new int[n][n];
		for(int i=0;i<n;i++) {
			StringTokenizer in = new StringTokenizer(f.readLine());
			for(int j=0;j<n;j++) {
				grid[i][j] = Integer.valueOf(in.nextToken());
			}
		}
		// row alt
		long row = 0;
		for(int i=0;i<n;i++) {
			long[] sum = new long[2];
			for(int j=0;j<n;j++) {
				sum[j%2]+=grid[i][j];
			}
			row += Math.max(sum[0], sum[1]);
		}
		// col alt
		long col = 0;
		for(int i=0;i<n;i++) {
			long[] sum = new long[2];
			for(int j=0;j<n;j++) {
				sum[j%2]+=grid[j][i];
			}
			col += Math.max(sum[0], sum[1]);
		}
		System.out.println(Math.max(row, col));
	}	
}
