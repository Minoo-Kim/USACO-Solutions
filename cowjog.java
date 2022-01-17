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
		long n = Long.valueOf(in.nextToken());
		long t = Long.valueOf(in.nextToken());
		ArrayList<Long> pos= new ArrayList<Long>();
		for(int i=0;i<n;i++) {
			StringTokenizer in2 = new StringTokenizer(f.readLine());
			pos.add(Long.valueOf(in2.nextToken())+Long.valueOf(in2.nextToken())*t);
		}
		int groups=1;
		for(int i=pos.size()-1;i>0;i--) {
			if(pos.get(i)<=pos.get(i-1)) {
				pos.set(i-1, pos.get(i));
			}
			else {
				groups+=1;
			}
		}
		out.println(groups);
		out.close();
	}
}