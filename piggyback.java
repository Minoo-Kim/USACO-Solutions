import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;


public class piggyback {
	
	static ArrayList<Integer>[] adj;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("piggyback.in"));
		PrintWriter out = new PrintWriter(new FileWriter("piggyback.out"));
		StringTokenizer in = new StringTokenizer(f.readLine());
		int b = Integer.valueOf(in.nextToken());
		int e = Integer.valueOf(in.nextToken());
		int p = Integer.valueOf(in.nextToken());
		int n = Integer.valueOf(in.nextToken());
		int m = Integer.valueOf(in.nextToken());
		
		// adj list initialization 
		adj = new ArrayList[n];
		for(int i=0;i<n;i++) {
			adj[i] = new ArrayList<Integer>();
		}	
		for(int i=0;i<m;i++) {
			StringTokenizer in2 = new StringTokenizer(f.readLine());
			int q = Integer.valueOf(in2.nextToken())-1;
			int w = Integer.valueOf(in2.nextToken())-1;
			adj[q].add(w);
			adj[w].add(q);
		}
		
		// run BFS three times starting from 1, 2, and N 
		// traverse through every node and add up numbers --> find min index + 1
		int[] first = new int[n];
		bfs(0,first);
		int[] second = new int[n];
		bfs(1,second);
		int[] last = new int[n];
		bfs(n-1,last);
		ArrayList<Integer> count = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			count.add(first[i]*b+second[i]*e+last[i]*p);
		}
		out.print(Collections.min(count));	
		out.close();
	}
	
	static void bfs(int k, int[] dist){
		Arrays.fill(dist, -1); // fill distance array with -1's
		Queue<Integer> q = new LinkedList<Integer>();
		dist[k] = 0;
		q.add(k);
		while(!q.isEmpty()){
			int v = q.poll();
			for(int e : adj[v]){
				if(dist[e] == -1){
					dist[e] = dist[v] + 1;
					q.add(e);
				}
			}
		}
	}
}
