import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class cowcode {
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("cowcode.in"));
		PrintWriter out = new PrintWriter(new FileWriter("cowcode.out"));
		StringTokenizer input = new StringTokenizer(f.readLine()); 
		String s = input.nextToken();
		long n = Long.valueOf(input.nextToken());
		out.println(output(s, n-1));
		out.close();
	}
	public static Character output(String word, long index) {
		if(word.length() > index) {
			return word.charAt((int)index);
		}
		else {
			long mid = word.length();
			while(mid*2 <= index) {
				mid = mid*2;
			}
			if(mid == index) { // start of the duplicate
				return output(word, index-1);
			}
			else {
				// regular pattern that's shifted
				return output(word, index-mid-1);
			}
		}
		
	}
}
