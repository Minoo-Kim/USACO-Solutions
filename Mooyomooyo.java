import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Mooyomooyo {
	static ArrayList<Character>[] grid;
	static int n;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("mooyomooyo.in"));
		PrintWriter out = new PrintWriter(new FileWriter("mooyomooyo.out"));
		StringTokenizer input = new StringTokenizer(f.readLine());
		n = Integer.valueOf(input.nextToken());
		int k = Integer.valueOf(input.nextToken());
		grid = new ArrayList[10];  // 10 = number of ArrayLists
		for(int i =0; i<10; i++) {
			grid[i] = new ArrayList<Character>(n);
			for(int j=0; j<n; j++) {
				grid[i].add('0');
			}
		}
		for(int i =n-1; i>=0; i--) {
			String line = f.readLine();
			for(int j=0; j<10; j++) {
				// first line elements go to the back of the arrayList
				grid[j].set(i, line.charAt(j));
			}
		}
		visited = new boolean[10][n];
		// list that contains all the removal sets 
		ArrayList<ArrayList<Integer> > needsRemove = new ArrayList<ArrayList<Integer>>(n);
		int[] coor = new int[2];
		coor = nextColor();
		while(coor[0] != -1) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			int x = coor[0];
			int y = coor[1];
			floodfill(x, y, grid[x].get(y), list);
			// satisfies the requirements 
			if(list.size() >= k*2) { 
				needsRemove.add(list);
			}
			coor = nextColor();
			
			// reset the board when a cycle is over
			if(coor[0] == -1) {
				// change matching ones to zero
				// number of sets needed for removal
				for(int i =0; i<needsRemove.size(); i++) {
					for(int j = 0; j<needsRemove.get(i).size(); j++) {
						int x1 = needsRemove.get(i).get(j);
						int y1 = needsRemove.get(i).get(j+1);
						grid[x1].set(y1, '0');
						j += 1; // skips the y coordinates
					}
				}
				if(needsRemove.size() == 0) {
					break;
				}
				// add in zeroes 
				else {
					for(int i =0; i<10; i++) {
						for(int j=0; j<n; j++) {
							// reminder: j = 0 is the bottom of column i
							int count = 0;
							while(grid[i].get(j) == '0' && count<=10){
								grid[i].remove(j);
								grid[i].add('0');
								count += 1;
							}
						}
					}
				}
				needsRemove.clear();
				visited = new boolean[10][n];
				coor = nextColor();
			}
		}
		for(int i = n-1; i>=0; i--) {
			for(int j =0; j<10; j++) {
				out.print(grid[j].get(i));
			}
			out.print("\n");
		}
		out.close();
		
	}
	static void floodfill(int r, int c, Character color, ArrayList<Integer> list){
		if( r < 0 || r >=10 || c < 0 || c >= n) return;
		if(grid[r].get(c) != color) return;
		if(visited[r][c]) return;
		visited[r][c] = true;
		list.add(r);
		list.add(c);
		floodfill(r, c+1, color, list);
		floodfill(r, c-1, color, list);
		floodfill(r-1, c, color, list);
		floodfill(r+1, c, color, list);
	}
	static int[] nextColor() {
		int[] res = new int[2];
		for(int i =0; i<10; i++) {
			for(int j =0; j<n; j++) {
				if(visited[i][j] == false && grid[i].get(j) != '0') {
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
