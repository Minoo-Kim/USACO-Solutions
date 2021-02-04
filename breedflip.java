import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class breedflip {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new FileReader("breedflip.in"));
		int n = Integer.valueOf(f.readLine());
		String a = f.readLine();
		String b = f.readLine();
		Boolean status = false;
		int count = 0;
		for (int i = 0; i<n; i++)
		{
			Boolean temp = a.charAt(i) == b.charAt(i);
			if(temp)
			{
				status = false;
			}
			else
			{
				if(status == false)
				{
					status = true;
					count = count + 1;
				}
				else
				{
					continue;
				}
			}
		}
		PrintWriter out = new PrintWriter(new BufferedWriter (new FileWriter("breedflip.out")));
		out.println(count);
		out.close();
	}
}
