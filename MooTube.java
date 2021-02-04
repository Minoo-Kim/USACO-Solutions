import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.StringTokenizer;

public class MooTube {
	static int n, m;
	static ArrayList<Edge>[] adj;
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("mootube.in"));
		StringTokenizer input = new StringTokenizer(f.readLine());  
		n = Integer.valueOf(input.nextToken());
		m = n-1;
		int q = Integer.valueOf(input.nextToken());

		// make tree graph
		adj = new ArrayList[n];
		for(int i = 0; i<n; i++) {
			adj[i] = new ArrayList<Edge>();
		}
		for(int i =0; i<m; i++) {
			StringTokenizer input2 = new StringTokenizer(f.readLine());  
		    int a = Integer.valueOf(input2.nextToken())-1;
		    int b = Integer.valueOf(input2.nextToken())-1;
		    long c = Long.valueOf(input2.nextToken());
		    adj[a].add(new Edge(b, c));
		    adj[b].add(new Edge(a, c));    
		}
		
		// DFS
		PrintWriter out = new PrintWriter(new FileWriter("mootube.out"));
		for(int i = 0; i<q; i++)
		{
			ArrayList<Integer> count = new ArrayList<Integer>();
			long cur = 1000000000;
			boolean[] visited = new boolean[n];
			StringTokenizer input3 = new StringTokenizer(f.readLine());  
			long k = Long.valueOf(input3.nextToken());
			int node = Integer.valueOf(input3.nextToken())-1;
			int ans = dfs(node, visited, count, cur, k);
			out.println(ans);
		}
		out.close();

	}
	static class Edge{
		int to;
		long edge;
		public Edge(int to, long edge) {
			this.to = to;
			this.edge = edge;
		}
		public int getTo() {
			return to;
		}
		public long getWeight() {
			return edge;
		}
	}
	
	public static int dfs(int node, boolean[] bool, ArrayList<Integer> count, long cur, long k) {
		bool[node] = true;
		for(Edge next : adj[node]) {
			if(!bool[next.getTo()]) {
				if(Math.min(next.getWeight(), cur) >=k){ // cur must always be bigger or equal to k
					count.add(10);
					dfs(next.getTo(), bool, count, Math.min(next.getWeight(), cur), k);
				}
			}
		}
		return count.size();
	}

}
