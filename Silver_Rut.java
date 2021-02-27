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



public class Silver_Rut {
	static ArrayList<Integer>[] transE;
	static ArrayList<Integer>[] transN;
	public static void main(String[] args) throws IOException 
	{
	    BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter (new OutputStreamWriter(System.out)));
		int n = Integer.valueOf(f.readLine());
		ArrayList<Point> north = new ArrayList<Point>();
		ArrayList<Point2> east = new ArrayList<Point2>();
		ArrayList<Pos> order = new ArrayList<Pos>();
		for(int i=0;i<n;i++) {
			StringTokenizer in = new StringTokenizer(f.readLine());
			String let = in.nextToken();
			int x = Integer.valueOf(in.nextToken());
			int y = Integer.valueOf(in.nextToken());
			order.add(new Pos(x, let));
			if(let.equals("E")) {
				east.add(new Point2(x, y));
			}
			else {
				north.add(new Point(x, y));
			}
		}
		Collections.sort(east);
		Collections.sort(north);
		transE = new ArrayList[east.size()];
		transN = new ArrayList[north.size()];
		for(int i=0;i<east.size();i++) {
			transE[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<north.size();i++) {
			transN[i] = new ArrayList<Integer>();
		}
		boolean[] eastOut = new boolean[east.size()];
		boolean[] northOut = new boolean[north.size()];
		int[] eastCount = new int[east.size()];
		int[] northCount = new int[north.size()];
		// calc east 
		for(int i=0;i<east.size();i++) {
			for(int j=0;j<north.size();j++) {
				if(east.get(i).x > north.get(j).x || east.get(i).y<north.get(j).y || northOut[j]) {
					// continue, they never intersect
				}
				else if(east.get(i).y-north.get(j).y > north.get(j).x-east.get(i).x) {
					eastCount[i] += 1;
					northOut[j] = true;
					transE[i].add(j);
				}
				else if(east.get(i).y-north.get(j).y == north.get(j).x-east.get(i).x) {
					// cows meet; do nothing
				}
				else {
					break;
				}
			}
		}
		// calc north
		for(int i=0;i<north.size();i++) {
			for(int j=0;j<east.size();j++) {
				if(east.get(j).x > north.get(i).x || east.get(j).y<north.get(i).y || eastOut[j]) {
					// continue, they never intersect
				}
				else if(east.get(j).y-north.get(i).y < north.get(i).x-east.get(j).x) {
					northCount[i] += 1;
					eastOut[j] = true;
					transN[i].add(j);
				}
				else if(east.get(j).y-north.get(i).y == north.get(i).x-east.get(j).x) {
					// cows meet; do nothing
				}
				else {
					break;
				}
			}
		}
		// calc transitive
		int[] eCount = new int[east.size()];
		int[] nCount = new int[north.size()];
		for(int i=0;i<east.size();i++) {
			dfs(i, i, eCount, eastCount, northCount, transE, transN, 1);
		}
		for(int i=0;i<north.size();i++) {
			dfs(i, i, nCount, northCount, eastCount, transN, transE, 1);
		}
		for(int i=0; i<n; i++) {
			int index=-1;
			if(order.get(i).dir.equals("E")) {
				for(int j=0;j<east.size();j++){
					if(order.get(i).x==east.get(j).x) {
						index = j;
					}
				}
				System.out.println(eCount[index]);
			}
			else {
				for(int j=0;j<north.size();j++){
					if(order.get(i).x==north.get(j).x) {
						index = j;
					}
				}
				System.out.println(nCount[index]);
			}
		}
	}
	static void dfs(int node, int index, int[] res, int[] count, int[] count2, ArrayList<Integer>[] list,ArrayList<Integer>[] list2, int status) {
		if(status ==1) {
			res[index] += count[node];
			for(int next : list[node]) {
				dfs(next, index, res, count, count2, list, list2, status*-1);
			}
		}
		else {
			res[index] += count2[node];
			for(int next : list2[node]) {
				dfs(next, index, res, count, count2, list, list2, status*-1);
			}
		}
		
	}
	// for north points, sorts by X
	static class Point implements Comparable<Point> {
		int x, y;
		public Point(int x, int y) {
			this.x=x;
			this.y=y;
		}
		public int compareTo(Point o) {
			return this.x-o.x;
		}
	}
	// for east points, sorts by Y
	static class Point2 implements Comparable<Point2> {
		int x, y;
		public Point2(int x, int y) {
			this.x=x;
			this.y=y;
		}
		public int compareTo(Point2 o) {
			return this.y-o.y;
		}
	}
	static class Pos {
		int x;
		String dir;
		public Pos(int x, String dir) {
			this.x=x;
			this.dir=dir;
		}
	}
}
