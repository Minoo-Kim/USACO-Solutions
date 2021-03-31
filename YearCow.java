import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class YearCow {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter (new OutputStreamWriter(System.out)));
		StringTokenizer in = new StringTokenizer(f.readLine());
		int n = Integer.valueOf(in.nextToken());
		int k = Integer.valueOf(in.nextToken());
		int[] contains = new int[1000000000/12];
		for(int i=0;i<n;i++) {
			int cycle = Integer.valueOf(f.readLine());
			contains[cycle/12]+=1;
		}
		// goes farthest back
		boolean curr = false;
		int index = 0;
		int total =0;
		int dist = 0;
		int jumpUsed = 0;
		for(int i=contains.length-1;i>=0;i--) {
			if(contains[i]!=0) {
				index = i;
				total+=1;
				jumpUsed +=1;
				curr = true;
				break;
			}
		}
		ArrayList<Integer> gaps=new ArrayList<Integer>();
		for(int i=index-1; i>=0;i--) {
			if(contains[i]==0) {
				curr=false;
				dist+=1;
				// back to present
				if(i==0) {
					jumpUsed+=1;
					gaps.add(dist);
				}
			}
			else {
				total+=1;
				// pretend Bessie jumped to here
				if(!curr) {
					jumpUsed +=1;
					gaps.add(dist);
					dist=0;
					curr=true;
				}
			}
		}
		Collections.sort(gaps);
		while(jumpUsed>k) {
			jumpUsed-=1;
			total+=gaps.get(0);
			gaps.remove(0);
		}
		System.out.println(total*12);
	}
}
