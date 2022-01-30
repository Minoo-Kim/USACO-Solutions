import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class barns {
	static boolean[] visited;
	static ArrayList<Integer>[] adj;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter (new OutputStreamWriter(System.out)));
		int t = Integer.valueOf(f.readLine());
		for(int i=0;i<t;i++) {
			StringTokenizer in = new StringTokenizer(f.readLine());
			int n = Integer.valueOf(in.nextToken());
			int m = Integer.valueOf(in.nextToken());
			visited = new boolean[n];
			adj=new ArrayList[n];
			for(int j=0;j<n;j++) {
				adj[j]=new ArrayList<Integer>();
			}

			for(int j=0;j<m;j++) {
				StringTokenizer in2 = new StringTokenizer(f.readLine());
				int a=Integer.valueOf(in2.nextToken())-1;
				int b=Integer.valueOf(in2.nextToken())-1;
				adj[a].add(b);
				adj[b].add(a);
			}
			// best starting pos
			ArrayList<Integer> l1 = new ArrayList<Integer>();
			dfs(0,l1);
			int begin = Collections.max(l1);
			
			// best ending pos
			ArrayList<Integer> l2 = new ArrayList<Integer>();
			dfs(n-1,l2);
			int end =Collections.min(l2);
			
			long ans=Long.MAX_VALUE;
			for(int j=1;j<n-1;j++) {
				if(!visited[j]) {
					ArrayList<Integer> l3 = new ArrayList<Integer>();
					dfs(j, l3);
					int low=Collections.min(l3);
					int high=Collections.max(l3);
					long val = (low-begin)*(low-begin)+(high-end)*(high-end);
					ans = Math.min(ans, val);
				}
			}
			if(ans==Long.MAX_VALUE) {
				System.out.println(1);
			}
			else {
				System.out.println(ans);
			}
		}
	}
	static void dfs(int node, ArrayList<Integer> l) {
		l.add(node);
		visited[node] = true;
		for(int next : adj[node]) {
			if(!visited[next]) {
				dfs(next,l);
			}
		}
	}
	static class Data{
		int l;
		int h;
		public Data(int l,int h) {
			this.l=l;
			this.h=h;
		}
	}
}
