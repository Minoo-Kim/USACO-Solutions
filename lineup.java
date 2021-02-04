import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class lineup {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new FileReader("lineup.in"));
		int n = Integer.valueOf(f.readLine());
		List<String> arr = new ArrayList<String>(n*2);
		for (int i = 0; i<n; i++)
		{
			output(arr, f.readLine());
		}
		
		PrintWriter out = new PrintWriter(new FileWriter("lineup.out"));
				
		List<String> names = new ArrayList<String>(8);
		names.add("Beatrice");
		names.add("Belinda");
		names.add("Bella");
		names.add("Bessie");
		names.add("Betsy");
		names.add("Blue");
		names.add("Buttercup");
		names.add("Sue");
		
		for (int i = 0; i<8; i++)
		{
	        int freq = Collections.frequency(arr, names.get(i)); 
			if(freq == 2)
			{
				// first index of the name in arr
				int num1 = arr.indexOf(names.get(i));
				// second index of the name in arr
				int num2 = 0;
				for(int j = 0; j<arr.size(); j++)
				{
					if(arr.get(j).equals(names.get(i)) && j != num1)
					{
						num2 = j;
					}
				}
				// find pairs of num1 and num2 in arr
				if(num1 % 2 == 0)
				{
					num1 += 1;
				}
				else
				{
					num1 -= 1;
				}
				if(num2 % 2 == 0)
				{
					num2 += 1;
				}
				else
				{
					num2 -= 1;
				}
				String pair = arr.get(num1);
				String pair2 = arr.get(num2);
				

				int newInd = names.indexOf(pair);
				int newInd2 = names.indexOf(pair2);
				int fin = Math.min(newInd, newInd2);
				if(fin < i)
				{
					// first pair is already printed (on index i - 1 according to freq == 1), swap next one 
					out.println(names.get(i));
					String last = names.get(i-1);
					String num = new String();
					if(last.equals(pair))
					{
						num = pair2;
					}
					else
					{
						num = pair;
					}
														
					String temp = names.get(i+1);
					int index = names.indexOf(num);
					names.set(i + 1, num);
					names.set(index, temp);
				}
				else // both pairs are behind the cow, shift this cow back one space for alphabetically correct order.
				{
					String element = names.get(i);
					names.remove(i);
					names.add(element);
					i = i - 1;
				}
				
				// check if there's already a pair printed, if so, repeat freq = 1
				// if there are no pairs printed, shift one backwards 
			}
			else if(freq == 1)
			{
				out.println(names.get(i));
				// index of where the current name is in arr
				int ind = arr.indexOf(names.get(i));
				int pairInd = 0;
				// find the pairing
				String pair = new String();	
				if(ind % 2 == 0)
				{
					pairInd = ind + 1;
				}
				else
				{
					pairInd = ind - 1;
				}
				pair = arr.get(pairInd);
				// index of where the pair is in names
				int newInd = names.indexOf(pair);
				if(newInd < i)
				{
					// pair was already printed, ignore
					continue;
				}
				else 
				{
					// swap
					// remove Sue
					names.remove(newInd);
					// add Sue next to Beatrice
					names.add(i+1, pair);
				}				
			}
			else
			{
				out.println(names.get(i));
			}
		}
		out.close();
	}
	
	public static void output(List<String> arr, String input)
	{
		 StringTokenizer sent = new StringTokenizer(input);   
		 arr.add(sent.nextToken());
		 String discard = sent.nextToken();
		 String discard2 = sent.nextToken();
		 String discard3 = sent.nextToken();
		 String discard4 = sent.nextToken();
		 arr.add(sent.nextToken());
	}
}
