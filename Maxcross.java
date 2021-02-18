import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Maxcross {
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("maxcross.in"));
		PrintWriter out = new PrintWriter(new FileWriter("maxcross.out"));
		StringTokenizer in = new StringTokenizer(f.readLine());
		int n = Integer.valueOf(in.nextToken());
		int k = Integer.valueOf(in.nextToken());
		int b = Integer.valueOf(in.nextToken());
		int[] broken = new int[b];
		for(int i =0; i<b; i++) {
			broken[i] = Integer.valueOf(f.readLine());
		}
		Arrays.sort(broken);
		int ans = b;
		if(b ==1) {
			ans = 0;
		}
		for(int i =0; i<b; i++) {
			int min =0;
			// special case for the beginning
			if(i == 0) {
				for(int j =i; j<b; j++) {
					min += 1;
					if(j == b-1) { // last broken stop
						if(n >= k){
							ans = Math.min(ans, min);
							break;
						}	
					}
					else if(broken[j+1]-1 >= k) {
						ans = Math.min(ans, min);
						break;
					}
				}
			}
			// normal with special case for the last stop
			else {
				int start = broken[i-1]+1;
				for(int j =i; j<b; j++) {
					min += 1;
					if(j == b-1) { // last broken stop
						if(n-start+1 >= k){
							ans = Math.min(ans, min);
							break;
						}	
					}
					else if(broken[j+1]-start >= k) {
						ans = Math.min(ans, min);
						break;
					}
				}
			}
		}
		out.println(ans);
		out.close();
	} 
}