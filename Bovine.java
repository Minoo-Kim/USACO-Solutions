import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Bovine {
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("shuffle.in"));
		PrintWriter out = new PrintWriter(new FileWriter("shuffle.out"));
		int n = Integer.valueOf(f.readLine());
		StringTokenizer input = new StringTokenizer(f.readLine());
		int[] move = new int[n];
		int[] feeder = new int[n];
		for(int i =0; i<n; i++) {
			move[i] = Integer.valueOf(input.nextToken())-1;
		}
		for(int i=0; i<n; i++) {
			feeder[move[i]] += 1;
		}
		int res = 0;
		LinkedList<Integer> q = new LinkedList<Integer>();
		for(int i =0; i<n; i++) {
			if(feeder[i] == 0) {
				q.add(move[i]); 
				// ex: if 4 supplies to 2
				// 4 is guaranteed to contain 0 cows, and so is 2 
				// if and only if 2 has 1 supplier
				// to simulate the chain effect, decrease feeder by 1 everytime such pos is found
				
				res+=1;
			}
		}
		while(!q.isEmpty()) {
			if(--feeder[q.getFirst()] == 0) {
				res+=1;
				q.add(move[q.getFirst()]);
			}
			q.removeFirst();
		}
		out.println(n-res);
		out.close();
	}
}