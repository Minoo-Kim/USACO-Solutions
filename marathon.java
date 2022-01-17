
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.*;

public class marathon {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("marathon.in"));
		PrintWriter out = new PrintWriter(new FileWriter("marathon.out"));
		StringTokenizer in = new StringTokenizer(f.readLine());
		int n = Integer.valueOf(in.nextToken());
		int k = Integer.valueOf(in.nextToken());
		ArrayList<Coordinate> loc = new ArrayList<Coordinate>();
		for(int i=0;i<n;i++) {
			StringTokenizer in2 = new StringTokenizer(f.readLine());
			loc.add(new Coordinate(Integer.valueOf(in2.nextToken()),Integer.valueOf(in2.nextToken())));
		}
		
		for(int a=0;a<k;a++) {
			ArrayList<Integer> distances = new ArrayList<Integer>();
			// starts with the liability of the first checkpoint (index 1 loc) 
			int skip=1;
			for(int i=0;i<loc.size()-1;i++) {
				int total=0;
				for(int j=0;j<loc.size()-1;j++) {
					
				}
				distances.add(dist(loc.get(i), loc.get(i+1)) + dist(loc.get(i+1),loc.get(i+2)) - dist(loc.get(i),loc.get(i+2)));
			}
			
			// remove max liability from loc 
			int index = distances.indexOf(Collections.max(distances));
			loc.remove(index+1);
		}
	
		int total=0;
		for(int i=0;i<loc.size()-1;i++) {
			total+=dist(loc.get(i),loc.get(i+1));
		}
		out.print(total);
		out.close();

	}
	
	static int dist(Coordinate first, Coordinate second) {
		return Math.abs(first.x-second.x)+Math.abs(first.y-second.y);
	}
	

	static class Coordinate {
		  private int x;
		  private int y;
	
		  public Coordinate(int x, int y) {
		    this.x = x;
		    this.y = y;
		  }	
	}
}
