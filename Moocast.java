import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Moocast {
	static ArrayList<Integer>[] tree;
	static boolean[] visited;
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("moocast.in"));
		PrintWriter out = new PrintWriter(new FileWriter("moocast.out"));
		int n = Integer.valueOf(f.readLine());
		int[] x = new int[n];
		int[] y = new int[n];
		int[] r = new int[n];
		tree = new ArrayList[n];
		for(int i =0; i<n; i++) {
			tree[i] = new ArrayList<Integer>();
			StringTokenizer in = new StringTokenizer(f.readLine());
			x[i] = Integer.valueOf(in.nextToken());
			y[i] = Integer.valueOf(in.nextToken());
			r[i] = Integer.valueOf(in.nextToken());
		}
		for(int i =0; i<n; i++) {
			for(int j =0; j<n; j++) {
				if(range(x[i], y[i], x[j], y[j], r[i]) && i!=j) {
					tree[i].add(j);
				}
			}
		}
		int max =0;
		for(int i =0; i<n; i++) {
			ArrayList<Integer> data = new ArrayList<Integer>();
			visited = new boolean[n];
			dfs(i, data);
			max = Math.max(max, data.size());
		}
		out.println(max+1);
		out.close();
	}
	public static void dfs(int node, ArrayList<Integer> data) {
		visited[node] = true;
		for(int next: tree[node]) {
			if(!visited[next]) {
				data.add(1);
				dfs(next, data);
			}
		}
		
	}
	public static boolean range(int x1, int y1, int x2, int y2, int r) {
		// decimals
		double num = Math.sqrt(Math.pow((double)(x1-x2), 2)+Math.pow((double)(y1-y2), 2));
		if(r >= num) {
			return true;
		}
		else {
			return false;
		}
	}

}
