import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class countcross {
	static ArrayList<String>[][] road;
	static boolean[][] pos;
	static boolean[][] visited;
	static int n;
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("countcross.in"));
		PrintWriter out = new PrintWriter(new FileWriter("countcross.out"));
		StringTokenizer in = new StringTokenizer(f.readLine());
		n = Integer.valueOf(in.nextToken());
		int k = Integer.valueOf(in.nextToken());
		int r = Integer.valueOf(in.nextToken());
		road = new ArrayList[n][n];
		for(int i =0; i<n; i++) {
			for(int j =0; j<n; j++) {
				road[i][j] = new ArrayList<String>();
			}
		}
		for(int i = 0; i<r; i++) {
			StringTokenizer in2 = new StringTokenizer(f.readLine());
			int x1 = Integer.valueOf(in2.nextToken())-1;
			int y1 = Integer.valueOf(in2.nextToken())-1;
			int x2 = Integer.valueOf(in2.nextToken())-1;
			int y2 = Integer.valueOf(in2.nextToken())-1;
			road[x1][y1].add(String.valueOf(x2) + String.valueOf(y2));
			road[x2][y2].add(String.valueOf(x1) + String.valueOf(y1));		
		}
		pos = new boolean[n][n];
		for(int i =0; i<k; i++) {
			StringTokenizer in3 = new StringTokenizer(f.readLine());
			pos[Integer.valueOf(in3.nextToken())-1][Integer.valueOf(in3.nextToken())-1] = true;
		}
		
		int total = 0;
		visited = new boolean[n][n];
		int[] coor = next();
		int x = coor[0];
		int y = coor[1];
		while(x != -1) {
			ArrayList<Integer> count = new ArrayList<Integer>();
			floodfill(x, y, count);
			total += (k-count.size())*count.size();
			coor = next();
			x = coor[0];
			y = coor[1];
		}
		out.println(total/2);
		out.close();
	}
	static void floodfill(int r, int c, ArrayList<Integer> count) {
		if(r<0||r>=n||c<0||c>=n) return;
		if(visited[r][c]) return;
		if(pos[r][c]) {
			count.add(1); // found a cow, includes itself
		}
		visited[r][c] = true;
		// if doesn't contain road block, proceed
		if(!road[r][c].contains(String.valueOf(r)+String.valueOf(c+1))) {
			floodfill(r, c+1, count);
		}
		if(!road[r][c].contains(String.valueOf(r)+String.valueOf(c-1))) {
			floodfill(r, c-1, count);
		}
		if(!road[r][c].contains(String.valueOf(r+1)+String.valueOf(c))) {
			floodfill(r+1, c, count);
		}
		if(!road[r][c].contains(String.valueOf(r-1)+String.valueOf(c))) {
			floodfill(r-1, c, count);
		}
	}
	static int[] next() {
		int[] res = new int[2];
		for(int i =0; i<n; i++) {
			for(int j =0; j<n; j++) {
				if(visited[i][j]==false&&pos[i][j]) {
					res[0] = i;
					res[1] = j;
					return res;
				}
			}
		}
		res[0] = -1;
		return res;
	}
}