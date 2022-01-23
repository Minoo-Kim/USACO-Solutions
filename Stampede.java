import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Stampede {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("stampede.in"));
		PrintWriter out = new PrintWriter(new FileWriter("stampede.out"));
		int n = Integer.valueOf(f.readLine());
		ArrayList<Event> events = new ArrayList<Event>();
		for(int i=0;i<n;i++) {
			StringTokenizer in = new StringTokenizer(f.readLine());
			int x=Integer.valueOf(in.nextToken());
			int y=Integer.valueOf(in.nextToken());
			int speed=Integer.valueOf(in.nextToken());
			events.add(new Event(-x*speed-speed,y));
			events.add(new Event(-x*speed,-y));
		}
		// sort events by time to perform line sweep 
		Collections.sort(events);
        PriorityQueue<Integer> active = new PriorityQueue<>();
	    Set<Integer> seen = new HashSet<Integer>();
		for(int i=0;i<events.size();i++) {
			int counter=-1;
			// add or remove everything at the time interval 
			for(int j=i;j<events.size()&&events.get(i).t==events.get(j).t;j++) {
				counter+=1;
				if(events.get(j).y>0) {
					active.add(events.get(j).y);
				}
				else {
					active.remove(-events.get(j).y);
				}
			}
			if(!active.isEmpty()) {
				seen.add(active.peek());
			}
			i+=counter;
		}
			
		out.println(seen.size());
		out.close();	
	}
	
	static class Event implements Comparable<Event>{
		int t;
		int y;
		public Event(int t, int y) {
			this.t=t;
		this.y=y;
		}
		public int compareTo(Event o) {
			if(this.t==o.t) {
				return this.y-o.y;
			}
			else {
				return this.t-o.t;
			}
		}		
	}
}