import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Rectangles {
	public static void main(String[] args) throws IOException 
	{
	//	BufferedReader f = new BufferedReader(new FileReader("rectangles.in"));
	    BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter (new OutputStreamWriter(System.out)));
		int n = Integer.valueOf(f.readLine());
		Point[] points = new Point[n];
		for(int i=0;i<n;i++) {
			StringTokenizer in = new StringTokenizer(f.readLine());
			int x=Integer.valueOf(in.nextToken());
			int y=Integer.valueOf(in.nextToken());
			points[i] = new Point(x, y);
		}
		Arrays.sort(points);
		long count = n+1; // count 0 subset and 1 subsets
		for(int i =0; i<n-1;i++) {
			int index = 0;
			ArrayList<Integer> yCoor = new ArrayList<Integer>();
			yCoor.add(points[i].y);
			for(int j=i+1;j<n;j++) {
				if(points[j].y > yCoor.get(yCoor.size()-1)) {
					yCoor.add(points[j].y);
					count+=index+1;
				}
				else if(points[j].y < yCoor.get(0)) {
					yCoor.add(0,points[j].y);
					index += 1;
					count+= yCoor.size()-index;
				}
				else {
					int curr = find(points[j].y, yCoor);
					yCoor.add(curr, points[j].y);
					if(curr > index) {
						// +1 to size because coordinate hasn't been added 
						count+=(index+1)*(yCoor.size()-curr);
					}
					else {
						index += 1;
						count+=(curr+1)*(yCoor.size()-index);
					}
				}
			}
		}
		System.out.println(count);
	}
	static int find(int y, ArrayList<Integer> list) {
		int min=0; 
		int max=list.size()-1;
		int index = -1;
		while(min<=max) {
			int mid = (min+max)/2;
			if(y>list.get(mid)) {
				index = mid;
				min = mid+1;
			}
			else {
				max = mid-1;
			}
		}
		return index+1;
	}
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
}