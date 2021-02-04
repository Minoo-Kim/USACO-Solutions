import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Photos {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(f.readLine());
		int even = 0;
		int odd = 0;
		StringTokenizer input = new StringTokenizer(f.readLine());
		for(int i = 0; i<n; i++)
		{		
			if(Integer.valueOf(input.nextToken()) % 2 == 0)
			{
				even += 1;
			}
			else
			{
				odd +=1;
			}
		}
		
		// main function
		int res = 0;
		if(odd == even)
		{
			res = odd *2;
		}
		else if(even > odd)
		{
			res = odd*2 + 1;
		}
		else
		{
			res = even * 2 + calc(odd-even);
		}
		PrintWriter out = new PrintWriter(new BufferedWriter (new OutputStreamWriter(System.out)));
		System.out.println(res);

	}
	public static int calc(int num)
	{		
		int count = 0;
		int numLeft = num;
		String status = "even"; // the next requirement of cows
		if(num == 1)
		{
			count = -1;
		}
		else
		{
			//loop will always break before it ends, num is just a random limit
			for(int i =0; i<num; i++)
			{
				if(numLeft == 0) // no more cows left
				{
					break;
				}
				else
				{
					if(numLeft == 4 && status.equals("even"))
					{
						count += 1;
						break;
					}
					else
					{
						if(status.equals("even"))
						{
							numLeft -= 2;
							status = "odd";
							count += 1;
						}
						else
						{
							numLeft -= 1;
							status = "even";
							count += 1;
						}
					}
				}
			}
		}
		return count;
	}
}
