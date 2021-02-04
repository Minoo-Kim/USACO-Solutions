import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class traffic {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new FileReader("traffic.in"));
		int n = Integer.valueOf(f.readLine());
		
		String[] ramp = new String[n];
		int[] min = new int[n];
		int [] max = new int[n];
		for (int i = 0; i<n; i++)
		{
			StringTokenizer input = new StringTokenizer(f.readLine());
			ramp[i] = input.nextToken();
			min[i] = Integer.valueOf(input.nextToken());
			max[i] = Integer.valueOf(input.nextToken());
		}
		
		// calculate initial value
		int endInd = lastNone(ramp);
		int initMin = min[endInd];
		int initMax = max[endInd];
		
		for(int i = endInd-1; i>=0; i--)
		{	
			if(stringCompare(ramp[i], "none") == 0)
			{
				initMin = Math.max(initMin, min[i]);
				initMax = Math.min(initMax, max[i]);
			}
			else if(stringCompare(ramp[i], "on") == 0)
			{
				initMin = initMin - max[i];
				initMax = initMax - min[i];
				if(initMin < 0)
				{
					initMin = 0;
				}
				if(initMax < 0)
				{
					initMax = 0;
				}
			}
			// for "off"
			else 
			{
				initMin = initMin + min[i];
				initMax = initMax + max[i];
			}
		}
		
		// calculate final value	
		int startInd = firstNone(ramp);
		int finalMin = 0;
		int finalMax = 0;

		
		// if the first "none" is all the way at the end.
		if (startInd == (n-1))
		{
			finalMin = min[startInd];
			finalMax = max[startInd];
		}
		else
		{	
			finalMin = min[startInd];
			finalMax = max[startInd];
			for (int i = startInd + 1; i<n; i++)
			{
				if(stringCompare(ramp[i], "none") == 0)
				{
					finalMin = Math.max(finalMin, min[i]);
					finalMax = Math.min(finalMax, max[i]);
				}
				else if(stringCompare(ramp[i], "on") ==0)
				{
					finalMin = min[i] + finalMin;
					finalMax = max[i] + finalMax;
				}
				// for "off"
				else 
				{
					finalMin = finalMin - max[i];
					finalMax = finalMax - min[i];
					if(finalMin < 0)
					{
						finalMin = 0;
					
					if(finalMax < 0)
					{
						finalMax = 0;
					}
				}
			}
		}
		
		PrintWriter out = new PrintWriter(new BufferedWriter (new FileWriter("traffic.out")));
		out.println(initMin + " " + initMax);
		out.println(finalMin + " " + finalMax);
		out.close();
		
		}
	}
	
	public static int firstNone(String[] array)
	{
		int ans = 0;
		for(int i = 0; i<array.length; i++)
		{
			if(stringCompare(array[i], "none") == 0)
			{
				ans = i;
				break;
			}
		}
		return ans;
	}
	
	public static int lastNone(String[] array) {
		int ans = 0;
		for(int i = array.length-1; i>=0; i--)
		{
			if(stringCompare(array[i], "none") == 0)
			{
				ans = i;
				break;
			}
		}
		return ans;
	}
	
	public static int stringCompare(String str1, String str2) 
    { 
  
        int l1 = str1.length(); 
        int l2 = str2.length(); 
        int lmin = Math.min(l1, l2); 
  
        for (int i = 0; i < lmin; i++) { 
            int str1_ch = (int)str1.charAt(i); 
            int str2_ch = (int)str2.charAt(i); 
  
            if (str1_ch != str2_ch) { 
                return str1_ch - str2_ch; 
            } 
        } 
  
        // Edge case for strings like 
        // String 1="Geeks" and String 2="Geeksforgeeks" 
        if (l1 != l2) { 
            return l1 - l2; 
        } 
  
        // If none of the above conditions is true, 
        // it implies both the strings are equal 
        else { 
            return 0; 
        } 
    } 	
}
