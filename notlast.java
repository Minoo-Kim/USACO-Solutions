import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class notlast {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new FileReader("notlast.in"));
		int n = Integer.valueOf(f.readLine());
		ArrayList<String> names = new ArrayList<String>(7);
		ArrayList<Integer> milk = new ArrayList<Integer>(7);
		milk.add(0);
		milk.add(0);
		milk.add(0);
		milk.add(0);
		milk.add(0);
		milk.add(0);
		milk.add(0);


		names.add("Bessie");
		names.add("Elsie");
		names.add("Daisy");
		names.add("Gertie");
		names.add("Annabelle");
		names.add("Maggie");
		names.add("Henrietta");
		for(int i = 0; i<n; i++)
		{
			StringTokenizer input = new StringTokenizer(f.readLine());
			int index = names.indexOf(input.nextToken());
			milk.set(index, (milk.get(index)+ Integer.valueOf(input.nextToken())));
		}
		int min = Collections.min(milk);
		int max = Collections.max(milk);
		int minCounter = 0;
		String res = new String();
		for(int i = 0; i<7; i++)
		{
			if(milk.get(i) == min)
			{
				minCounter += 1;
			}
			else if(milk.get(i) < max)
			{
				max = milk.get(i);
				res = names.get(i);
			}
		}
		int count = 0;
		for(int i = 0; i<7; i++)
		{
			if(milk.get(i) == max)
			{
				count += 1;
			}
		}
		PrintWriter out = new PrintWriter(new FileWriter("notlast.out"));
		if(minCounter == 7 || count > 1)
		{
			out.println("Tie");
		}
		else
		{
			out.println(res);

		}
		out.close();
	}
}
