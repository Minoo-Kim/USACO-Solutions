import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class alphabet {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer input = new StringTokenizer(f.readLine());
		int[] nums = new int[7];
		for (int i = 0; i<7; i++)
		{
			nums[i] = Integer.valueOf(input.nextToken());
		}
		int a;
		int b;
		int c;
		int min = getMin(nums);
		int nextMin = nextMin(nums, min);
		int max = getMax(nums);
		if(frq(nums, min) == 1)
		{
			a = getMin(nums);
			if(frq(nums, nextMin)== 1)
			{
				b = nextMin;
				c = max - a - b;
			}
			else
			{
				b = nextMin;
				c = nextMin;
			}
		}
		else if(frq(nums, min) == 2)
		{
			a = min;
			b = min;
			c = max - a -b;
		}
		else
		{
			a = min;
			b = min;
			c = min;
		}
		PrintWriter out = new PrintWriter(new BufferedWriter (new OutputStreamWriter(System.out)));
		System.out.println(a + " " + b + " " + c);
	}
	
	// returns frequency of any num in an array
	public static int frq(int[] arr, int num)
    {
        int count = 0;
        for (int i = 0; i<arr.length; i++)
        {
        	if(arr[i] == num) 
        	{
        		count++; 
        	}
        }
        return count;
    }
	
	
	public static int getMin(int[] arr)
    {
        int res = arr[0];
         
        for (int i = 1; i < arr.length; i++)
        {
            res = Math.min(res, arr[i]);
        }
        return res;
    }
	public static int nextMin(int[] arr, int n)
    {
        int res = getMax(arr);
        int min = getMin(arr);
        for (int i = 0; i < arr.length; i++)
        {
        	if(arr[i] != min)
        	{
                res = Math.min(res, arr[i]);
        	}
        }
        return res;
    }
     
   
    
    public static int getMax(int[] arr)
    {
        int res = arr[0];
         
        for (int i = 1; i < arr.length; i++)
            res = Math.max(res, arr[i]);
        return res;
    }
}
