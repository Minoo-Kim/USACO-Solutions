/*
ID: minooki1
LANG: JAVA
TASK : gift1
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class gift1 {
	

	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
		
		int NP = Integer.valueOf(f.readLine());
		String[] nameList = new String[NP];
		HashMap<String, Integer> fullList = new HashMap<String, Integer>();
		
		// first loop to put into HashMap
		for(int i = 0; i<NP; i++)
		{
			nameList[i] = f.readLine();
			fullList.put(nameList[i], 0);
		}
		
		// big forloop
		for(int i = 0; i<NP; i++)
		{
			String person = f.readLine();
			StringTokenizer mon = new StringTokenizer(f.readLine());
			int giftAmount = Integer.valueOf(mon.nextToken());
			int personCount = Integer.valueOf(mon.nextToken());
			
			// distribute the money
			for(int j = 0; j<personCount; j++)
			{
				if(personCount != 0)
				{
					String tempName = f.readLine();
					int tempMoney = fullList.get(tempName);
					fullList.put(tempName, tempMoney + (giftAmount/personCount));
				}
			}
			if(personCount != 0)
			{
				int tempMoney2 = fullList.get(person);
				fullList.put(person, tempMoney2 - giftAmount + (giftAmount%personCount));
			}
		}
		f.close();
		
		PrintWriter out = new PrintWriter(new BufferedWriter (new FileWriter("gift1.out")));
		for(int i = 0; i<NP; i++)
		{
			out.println(nameList[i] + " " + fullList.get(nameList[i]));
		}
		out.close();
		System.exit(0);	
	}

}
