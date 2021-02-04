import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Uddered {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		String order = f.readLine();
		String word = f.readLine();
		int count = 1;
		Character let = 'a';
		int curr = -1;
		for(int i = 0; i<word.length(); i++)
		{
			let = word.charAt(i);
			// requested character happens before the current, so one more cycle is needed
			if(order.indexOf(let) <= curr) 
			{
				count += 1;
			}
			curr = order.indexOf(let);
		}
		PrintWriter out = new PrintWriter(new BufferedWriter (new OutputStreamWriter(System.out)));
		System.out.println(count);
	}

}
