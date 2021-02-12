import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// Note: in hindsight, my code doesn't work for test cast #11, which is a set of m conditions that's impossible to achieve. 
// Tweaking this code include "S" or "D" as edges and checking if every case is actually possible will solve the problem.
public class revegetate {
	static ArrayList<Integer>[] adj;
	static Boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("revegetate.in"));
		PrintWriter out = new PrintWriter(new FileWriter("revegetate.out"));
		StringTokenizer input = new StringTokenizer(f.readLine());
		int n = Integer.valueOf(input.nextToken());
		int m = Integer.valueOf(input.nextToken());
		adj = new ArrayList[n];
		for(int i =0; i<n; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		visited = new Boolean[n];
		for(int i=0;i<n;i++) {
			visited[i] = true;
		}
		for(int i =0; i<m; i++) {
			StringTokenizer input2 = new StringTokenizer(f.readLine());
			String irrelevant = input2.nextToken(); // disregard
			int a = Integer.valueOf(input2.nextToken())-1; // shift one index since each index represents a pasture
			int b = Integer.valueOf(input2.nextToken())-1;
			adj[a].add(b);
			adj[b].add(a);
			visited[a] = false;
			visited[b] = false;
		}
		int count = 0;
		for(int i=0;i<n;i++) {
			if(visited[i] == true) {
				count += 1;
			}
		}
		while(Arrays.asList(visited).contains(false)) {
			dfs(nextFalse(visited));
			count +=1;
		}
		
		// print as binary
		out.print("1");
		for(int i=0; i<count; i++) {
				out.print("0");
		}
		out.close();

	}
	public static void dfs(int node) {
		visited[node] = true;
		for(int next : adj[node]) {
			if(!visited[next]) {
				dfs(next);
			}
		}
	}
	public static int nextFalse(Boolean[] array) {
		int index = 0;
		for(int i=0; i<array.length; i++) {
			if(array[i] == false) {
				index = i;
				break;
			}
		}
		return index;
	}
}
