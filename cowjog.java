import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class cowjog {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("cowjog.in"));
		PrintWriter out = new PrintWriter(new FileWriter("cowjog.out"));
		StringTokenizer in = new StringTokenizer(f.readLine());
		int n = Integer.valueOf(in.nextToken());
		int t = Integer.valueOf(in.nextToken());
		ArrayList<Long> pos= new ArrayList<Long>();
		for(int i=0;i<n;i++) {
			StringTokenizer in2 = new StringTokenizer(f.readLine());
			pos.add((long) (Integer.valueOf(in2.nextToken())+Integer.valueOf(in2.nextToken())*t));
		}

		int groups = n;
		boolean merged = true;
		while(merged) {
			merged = false;
			for(int i=0;i<pos.size()-1;i++) {
				if(pos.get(i)>pos.get(i+1)) {
					pos.set(i, pos.get(i+1));
					groups-=1;
					merged=true;
				}
			}
		}
		Set<Long> res = new LinkedHashSet<Long>(pos);
		out.print(res.size());
		out.close();
	}
}