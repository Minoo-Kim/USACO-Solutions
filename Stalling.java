import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Stalling {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(f.readLine());
		StringTokenizer input = new StringTokenizer(f.readLine());
		List<Integer> nums = new ArrayList<Integer>();
		for(int i = 0; i<n; i++)
		{
			nums.add(Integer.valueOf(input.nextToken()));
		}
		StringTokenizer input2 = new StringTokenizer(f.readLine());

		List<Integer> limits = new ArrayList<Integer>();
		for(int i = 0; i<n; i++)
		{
			limits.add(Integer.valueOf(input2.nextToken()));
		}
		
		// only for size
		List<Integer> res = new ArrayList<Integer>();
		permute(nums, 0, res, limits);
		PrintWriter out = new PrintWriter(new BufferedWriter (new OutputStreamWriter(System.out)));
		System.out.println(res.size());

	}
	// generate every permutation --> check for limits --> add 1 to ArrayList if successful 
	static void permute(List<Integer> arr, int k, List<Integer> res, List<Integer> limits){
        for(int i = k; i < arr.size(); i++){
            java.util.Collections.swap(arr, i, k);
            permute(arr, k+1, res, limits);
            java.util.Collections.swap(arr, k, i);
        }
        if (k == arr.size() -1){
            for(int i =0; i<arr.size(); i++)
            {
            	if(arr.get(i) > limits.get(i)) // height is above limit
            	{
            		break;
            	}
            	if(i == arr.size()-1)
            	{
                	res.add(1);
            	}
            }       
        }
    }
}
