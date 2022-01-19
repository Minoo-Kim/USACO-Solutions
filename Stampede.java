import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;

public class Stampede {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("stampede.in"));
		PrintWriter out = new PrintWriter(new FileWriter("stampede.out"));
		int n = Integer.valueOf(f.readLine());
		Cow[] cows = new Cow[n];
		for(int i=0;i<n;i++) {
			StringTokenizer in = new StringTokenizer(f.readLine());
			int x=Integer.valueOf(in.nextToken());
			int y=Integer.valueOf(in.nextToken());
			int speed=Integer.valueOf(in.nextToken());
			cows[i] = new Cow(x,y,speed,(-1-x)*speed, (-1-x)*speed+speed);
		}
		ArrayList<Data> data = new ArrayList<Data>();
		Arrays.sort(cows);
		for(Cow cow : cows) {
			for(Cow cow2 : cows) {
				if()
			}
		}
		
		out.println(n-data.size());
		out.close();
		
		
		// start at leftmost
		// store y coor and end point in arraylist
		// go through arraylist and if y coor is lower and end point is before own end point --> subtract 1 
		
	}
	
	static class Data{
		private int end;
		private int y;
		public Data(int end, int y) {
			this.end=end;
			this.y=y;
		}
	}
	
	static class Cow implements Comparable<Cow>{
		private int start;
		private int end;
		private int x;
		private int y;
		private int speed;
		
		public Cow(int x, int y, int speed, int start, int end) {
			this.x=x;
			this.y=y;
			this.speed=speed;
			this.start = start;
			this.end = end;
		}
		public int compareTo(Cow o) {
			return this.start - o.start;
		}
	}
}
