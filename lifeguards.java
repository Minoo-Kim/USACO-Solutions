import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class lifeguards {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new FileReader("lifeguards.in"));
		int n = Integer.valueOf(f.readLine());
		List<Integer> min = new ArrayList<Integer>(n);
		List<Integer> max = new ArrayList<Integer>(n);
		for(int i = 0; i<n; i++)
		{
			StringTokenizer input = new StringTokenizer(f.readLine());  
			min.add(Integer.valueOf(input.nextToken()));
			max.add(Integer.valueOf(input.nextToken()));
		}
		
		
		// find cow to fire
		List<Integer> fire = new ArrayList<Integer>(n);
		for(int i = 0; i<n; i++)
		{
			int x1 = min.get(i);
			int y1 = max.get(i);

			List<Integer> overlap = new ArrayList<Integer>(n-1);
			// loop that compares the cow in the i for loop with every other cow
			for(int j = 0; j<n; j++)
			{
				if (i == j)
				{
					continue;
				}
				else
				{				
					int x2 = min.get(j);
					int y2 = max.get(j);

					if(Math.max(y1, y2) - Math.min(x1, x2) < (y1 - x1) + (y2 - x2)) // it overlaps
					{
						overlap.add(Math.min(y1, y2) - Math.max(x1, x2));
					}
				}		
			}
			// total length - largest overlap = the # of hours each cow actually covers 
			fire.add((y1 - x1) - Collections.max(overlap));
			System.out.println(fire.get(i));
		}
		int low = Collections.min(fire);
		int indexFire = fire.indexOf(low);
		// size is now n-1
		min.remove(indexFire);
		max.remove(indexFire);
		// sort list
		Map<Integer, Integer> myLocalMap = new HashMap<Integer, Integer>();
	      for(int indx=0; indx < min.size(); indx++){
	           myLocalMap.put(min.get(indx), max.get(indx));
	      }
	      Collections.sort(min);; 
	      for(int indx=0; indx < min.size(); indx++){
	          max.set(indx, myLocalMap.get(min.get(indx)).intValue());
	      }
	      //System.out.println(max.get(1));
	
		// count total time
		int count = 0;
		int tempCount = 0;
		int list = 0;
		for(int i = min.get(list); i<=Collections.max(max); i++)
		{
			if(i == min.get(list)) // beginning of hour
			{
				count += tempCount;
				tempCount = 0;
			}
			else if(i == max.get(list)) //list ended
			{
				tempCount +=1;
				if(i == Collections.max(max))
				{
					count += tempCount;
				}
				else
				{
					list += 1; // start new list
				}					
			}
			else if(i > min.get(list) && i<max.get(list))
			{
				tempCount +=1;
			}
		}
		PrintWriter out = new PrintWriter(new FileWriter("lifeguards.out"));
		System.out.println(count);
		System.out.close();
	}
}
