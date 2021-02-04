/*
ID: minooki1
LANG: JAVA
TASK : friday
 */

import java.util.*;
import java.io.*;

public class friday {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new FileReader("friday.in"));
		int year = Integer.valueOf(f.readLine());
		
		//amount of dates in months
		int[] month = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int[] leapMonth = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		// date adder
		int[] results = new int[7];
		int lastYear = year + 1900;
		
		// Key: if monday(jan) = 0. To find the date of the 13th next month, (0+(# days in jan) + 12) % 7
		int firstDate = 0;
		for(int start = 1900; start < lastYear; start++)
		{
			for(int m = 0; m<12; m++)
			{
				int date = (12+firstDate)%7;
				results[date] += 1;
				firstDate += leapYear(start) ? leapMonth[m] : month[m];
			}
		}
		
		PrintWriter out = new PrintWriter(new BufferedWriter (new FileWriter("friday.out")));
		out.print(results[5]);
		out.print(" ");
		out.print(results[6]);
		out.print(" ");
		out.print(results[0]);
		out.print(" ");
		out.print(results[1]);
		out.print(" ");
		out.print(results[2]);
		out.print(" ");
		out.print(results[3]);
		out.print(" ");
		out.print(results[4] + "\n");

		out.close();
		System.exit(0);	
	}
	
	public static boolean leapYear(int year)
	{
		boolean leap = false;
		if(year%4 == 0 && year != 1900 && year != 2100 && year != 2200 && year != 2300)
		{
			leap = true;
		}
			else
		{
			leap = false;
		}	
		return leap;
	}
}
