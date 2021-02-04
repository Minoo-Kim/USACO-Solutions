import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

public class outofplace {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new FileReader("outofplace.in"));
		int n = Integer.valueOf(f.readLine());
		int[] nums = new int[n];
		for(int i = 0; i<n; i++)
		{
			nums[i] = Integer.valueOf(f.readLine());
		}
		HashSet<Integer> result = new HashSet<Integer>();
		int outlier = 0;
		//find outlier
		for(int i = 0; i<n; i++)
		{
			if(i == n-2)
			{
				outlier = nums[i+1];
				for(int j = i; j>=0; j--)
				{
					if(nums[j] > outlier)
					{
						result.add(nums[j]);
					}
				}
				break;
			}
			else if(nums[i] > nums[i+1]) // next number is smaller
			{
				if(nums[i+2] >= nums[i]) 
				{
					outlier = nums[i+1];
					for(int j = i; j>=0; j--)
					{
						if(nums[j] > outlier)
						{
							result.add(nums[j]);
						}
					}
				}
				else
				{
					outlier = nums[i];
					for(int j = i; j<n; j++)
					{
						if(nums[j] < outlier)
						{
							result.add(nums[j]);
						}
					}
				}
				break;
			}	
		}
		PrintWriter out = new PrintWriter(new FileWriter("outofplace.out"));
		out.println(result.size());
		out.close();
	}

}
