import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class perimeter {
	static boolean[][] grid;
	static boolean[][] visited;
	static int area, peri, n;
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("perimeter.in"));
		PrintWriter out = new PrintWriter(new FileWriter("perimeter.out"));
		StringTokenizer input = new StringTokenizer(f.readLine());
		n = Integer.valueOf(input.nextToken());
		grid = new boolean[n][n]; // init to false
		visited = new boolean[n][n];
		for(int i =0; i<n; i++) {
			String line = f.readLine();
			for(int j=0; j<n;j++) {
				if(line.charAt(j) == '#') { 
					grid[i][j] = true;
				}
				else {
					visited[i][j] = true; // never visit the dots
				}
			}
		}
		area = 0;
		peri = 0;		
		int r =0;
		int c =0;
		while(r != 27) {
			ArrayList<Integer> a = new ArrayList<Integer>();
			ArrayList<Integer> p = new ArrayList<Integer>();
			int[] arr = avail(visited);
			r = arr[0];
			c = arr[1];
			floodfill(r, c, a, p);
			if(area == a.size()) {
				peri = Math.min(peri, p.size());
			}
			else if(a.size() > area) {
				area = a.size();
				peri = p.size();
			}
			// else, don't change
		}
		out.println(area+" "+peri);
		out.close();
	}
	
	public static void floodfill(int r, int c, ArrayList<Integer> area, ArrayList<Integer> peri) {
		if(r<0||r>=n||c<0||c>=n) {
			// ran into edges
			peri.add(2); // add perimeter
			return;
		}
		if(grid[r][c] == false) {
			// ran into a dot
			peri.add(2);
			return;
		}
		if(visited[r][c]) {
			return;
		}
		visited[r][c] = true;
		area.add(1); // add size
		floodfill(r, c+1, area, peri);
		floodfill(r, c-1, area, peri);
		floodfill(r-1, c, area, peri);
		floodfill(r+1, c, area, peri);	
	}
	// find the indexes of the next false value 
	public static int[] avail(boolean[][] array) {
		int[] arr = new int[2];
		for(int i =0; i<n; i++) {
			for(int j =0; j<n; j++) {
				if(array[i][j] == false) {
					arr[0] = i;
					arr[1] = j;
					return arr ;
				}
			}
		}
		arr[0] = 27; // random number to know when there are no more falses left
		return arr;
	}

}
