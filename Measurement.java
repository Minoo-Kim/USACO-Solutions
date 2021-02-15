import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;
import java.util.StringTokenizer;

public class Measurement {
	public static void main(String[] args) throws IOException
	{
		// I need to keep track of every cow's milk output every time there's a change
		// If a different cow becomes max --> add 1
		// If +/- # of cows at max --> add 1 
		
		BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
		PrintWriter out = new PrintWriter(new FileWriter("measurement.out"));
		StringTokenizer input = new StringTokenizer(f.readLine());
		int n = Integer.valueOf(input.nextToken());
		int g = Integer.valueOf(input.nextToken());
		Cow[] changes = new Cow[n];
		Hashtable<Integer, Integer> values = new Hashtable<>();
		for(int i=0; i<n; i++) {
			StringTokenizer input2 = new StringTokenizer(f.readLine());
			int day = Integer.valueOf(input2.nextToken());
			int id = Integer.valueOf(input2.nextToken());
			int change = Integer.valueOf(input2.nextToken());
			changes[i] = new Cow(day, id, change);
			values.put(id, 0);
		}
		Arrays.sort(changes);
		int count = 0;
		int max = 0; // max will never fall below 0.
		int maxNum = 0;
		ArrayList<Integer> maxId = new ArrayList<Integer>();
		for(int i =0; i<n; i++) {
			int id = changes[i].id;
			int orig = values.get(id);
			values.put(id, orig + changes[i].change);
			// Case 1: Change makes the max higher
			if(values.get(id) > max) {
				max = values.get(id);
				// Sub-case: Went from multiple to 1 max
				if(maxNum != 1) {
					count += 1;
				}
				// Sub-case: Only 1 previous max, but it's a diff cow
				// If it's not the same cow, don't count
				else if(!maxId.contains(id)) {
					count +=1;
				}
				maxId.clear();
				maxId.add(id);
				maxNum = 1;
			}
			// Case 2: Number of max cows increases
			else if(values.get(id) == max) {
				maxId.add(id);
				maxNum += 1;
				count += 1;
			}
			// Case 3: Number of max cows decreases
			else if(orig == max) {
				// Sub-case: A lower max needs to be calculated 
				if(maxNum == 1) {
					// find new max or a group of new maxes
					ArrayList<Integer> maxKeys= new ArrayList<Integer>();
					int maxValue = 0; 
					for(Map.Entry<Integer,Integer> entry : values.entrySet()) {
					     if(entry.getValue() > maxValue) {
					         maxKeys.clear(); /* New max remove all current keys */
					         maxKeys.add(entry.getKey());
					         maxValue = entry.getValue();
					     }
					     else if(entry.getValue() == maxValue)
					     {
					       maxKeys.add(entry.getKey());
					     }
					}
					maxNum = maxKeys.size();
					max = values.get(maxKeys.get(0));
					if(maxNum == 1 && id == maxKeys.get(0)) {
						// New (lower) max is the same cow as old max
					}
					else {
						count += 1;
					}
					maxId.clear();
					maxId = new ArrayList<>(maxKeys);			
				}
				// Sub-case: If multiple max cows, just decrease 
				else {
					maxNum -= 1;
					count += 1;
				}
			}
		}
		out.println(count);
		out.close();
	}
	public static class Cow implements Comparable<Cow> {
		int day, id , change;
		public Cow(int day, int id, int change) {
			this.day = day;
			this.id = id; 
			this.change = change;
		}
		public int compareTo(Cow o) {
			return this.day - o.day;
		}	
	}
}