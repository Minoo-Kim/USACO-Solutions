import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class MooParticle {
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("moop.in"));
		int n = Integer.valueOf(f.readLine());
		// make graph
		ArrayList<Integer>[] moop = new ArrayList[n];
		for(int i = 0; i<n; i++) {
			moop[i] = new ArrayList<Integer>();
		}
		long[] a = new long[n];
		long[] b = new long[n];
		for(int i =0; i<n; i++){
			StringTokenizer input = new StringTokenizer(f.readLine()); 
			a[i] = Long.valueOf(input.nextToken());
			b[i] = Long.valueOf(input.nextToken());
		}
		for(int i =0; i<n; i++) {
			for(int j = i+1; j<n; j++) {
				if((a[i] >= a[j] && b[i] >= b[j]) || (a[i] <= a[j] && b[i] <= b[j])) {
					moop[i].add(j);
					moop[j].add(i);
				}
			}
		}
		//DFS
		Boolean[] visited = new Boolean[n];
		for(int i =0; i<n; i++){
			visited[i] = false;
		}
		// stops when every element is true
		ArrayList<Integer> res = new ArrayList<Integer>();
		int node = 0;
		int count = 0;
		while(Arrays.asList(visited).contains(false)){ 
			for(int i =node; i<n; i++)	{
				if(visited[i] == false) {
					node = i;
					break;
				}
			}
			ArrayList<Integer> count2 = new ArrayList<Integer>();
			count += (dfs(node, moop, visited, count2));
		}
		PrintWriter out = new PrintWriter(new FileWriter("moop.out"));
		// test
		out.println(n-count);
		out.close();
	}
	static int dfs(int node, ArrayList<Integer>[] moop, Boolean[] visited, ArrayList<Integer> count)
	{
		visited[node] = true;
		for(int next : moop[node]) {
			if(!visited[next]) {
				count.add(10);
				dfs(next, moop, visited, count);
			}
		}
		return count.size();
	}
}
