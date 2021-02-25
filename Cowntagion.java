import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Cowntagion {
	static ArrayList<Integer>[] farms;
	static boolean[] visited;
	static int[] processed;
	static int res;
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter (new OutputStreamWriter(System.out)));
		int n = Integer.valueOf(f.readLine());
		farms = new ArrayList[n];
		for(int i=0;i<n;i++) {
			farms[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<n-1;i++) {
			StringTokenizer in = new StringTokenizer(f.readLine());
			int a=Integer.valueOf(in.nextToken())-1;
			int b=Integer.valueOf(in.nextToken())-1;
			farms[a].add(b);
			farms[b].add(a);
		}
		// dfs
		visited = new boolean[n];
		processed = new int[n];
		res=0;
		dfs(0);
		System.out.println(res);
	}
	public static void dfs(int node) {
		visited[node]=true;
		int size = farms[node].size()-processed[node];
		res += calc(size+1)+size;
		for(int next : farms[node]) {
			if(!visited[next]) {
				processed[next]+=1;
				dfs(next);
			}
		}
	}
	public static int calc(int n) 
    { 
		if(n==0) {
			return -1;
		}
		double result = (Math.log(n) / Math.log(2)); 
		if(result == (int)result){
			return (int)result;
		}
		else {
			return (int)result+1;
		}
	} 
}
