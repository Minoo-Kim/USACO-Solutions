/*
ID: minooki1
LANG: JAVA
TASK : beads
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class beads 
{
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new FileReader("beads.in"));
		int beadsNum = Integer.valueOf(f.readLine());
		String temp = f.readLine();
		String beadsRow = temp + temp + temp;
		
		
		int totalCount = 0;
		
		
		
		// for loop that "splits" the neckless n amount of times
		for(int i = beadsNum; i<beadsNum *2; i++)
		{
			int maxRight = 0;
			int maxLeft = 0;
			
			// right loop
			char current = beadsRow.charAt(i);

			for(int j = i; j<beadsNum + i; j++)
			{
				if(current == beadsRow.charAt(j) || beadsRow.charAt(j) == 'w' || current == 'w')
				{
					maxRight += 1;
				}
				else
				{
					break;
				}
				if(current == 'w' && beadsRow.charAt(j) != 'w')
				{
					current = beadsRow.charAt(j);
				}
			}
			
			
			// left loop
			char current2 = beadsRow.charAt(i-1);
			for(int j = i-1; j>i-beadsNum; j--)
			{ 
				if(current2 == beadsRow.charAt(j) || beadsRow.charAt(j) == 'w' || current2 == 'w')
				{
					maxLeft += 1;					
				}
				else
				{
					break;
				}
				
				if(current2 == 'w' && beadsRow.charAt(j) != 'w')
				{
					current2 = beadsRow.charAt(j);
				}
			}

			int tempTotal = maxRight + maxLeft;
			if (tempTotal > totalCount)
			{
				totalCount = tempTotal;
			}
			
		}
		
		PrintWriter out = new PrintWriter(new BufferedWriter (new FileWriter("beads.out")));
		if (totalCount > beadsNum)
		{
			totalCount = beadsNum;
		}
		out.println(totalCount);
		out.close();
		System.exit(0);	
	}
}
