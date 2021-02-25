import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class clocktree {
	static ArrayList<Integer>[] rooms;
	static int[] clock;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{	
		BufferedReader f = new BufferedReader(new FileReader("clocktree.in"));
		PrintWriter out = new PrintWriter(new FileWriter("clocktree.out"));
		Integer n = Integer.valueOf(f.readLine());
		StringTokenizer in = new StringTokenizer(f.readLine());
		rooms = new ArrayList[n];
		int[] clockStore = new int[n];
		for(int i=0;i<n;i++) {
			rooms[i] = new ArrayList<Integer>();
			clockStore[i] = Integer.valueOf(in.nextToken());
		}
		for(int i=0;i<n-1;i++) {
			StringTokenizer in2 = new StringTokenizer(f.readLine());
			int a = Integer.valueOf(in2.nextToken())-1;
			int b = Integer.valueOf(in2.nextToken())-1;
			rooms[a].add(b);
			rooms[b].add(a);
		}
		// try every starting place
		int count = 0;
		for(int i=0;i<n;i++) {
			visited = new boolean[n];
			clock = clockStore.clone();
			if(dfs(i)) {
				count+=1;
			}
		}
		out.println(count);
		out.close();
	}
	public static boolean dfs(int node) {
		for(int child : rooms[node]) {
			if(!visited[child]) {
				visited[node]=true;
				clock[child]+=1;
				clock[child]=(clock[child]-1)%12+1;
				dfs(child);
				int increment = 12-clock[child];
				clock[node]+=increment+1;
				if(clock[node]>12) {
					clock[node]%=12;
				}
			}
		}
		if(clock[node]==12 || clock[node]==1) {
			return true;
		}
		else {
			return false;
		}
	}
}
