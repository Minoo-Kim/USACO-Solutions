import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class measurement {
	public static void main(String[] args) throws IOException 
	{
		BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
		int n = Integer.valueOf(f.readLine());
        ArrayList<Integer> days = new ArrayList<Integer>(n); 
        ArrayList<Integer> days2 = new ArrayList<Integer>(n); 
        ArrayList<String> names = new ArrayList<String>(n); 
        ArrayList<Integer> change = new ArrayList<Integer>(n); 
        ArrayList<Integer> amount = new ArrayList<Integer>(n); 
		for(int i = 0; i<n; i++)
		{
			StringTokenizer input = new StringTokenizer(f.readLine());
			int num = Integer.valueOf(input.nextToken());
			days.add(num);
			days2.add(num);
			amount.add(0);
			names.add(input.nextToken());
			change.add(Integer.valueOf(input.nextToken()));
		}
		// sort change
		Map<Integer, Integer> myLocalMap = new HashMap<Integer, Integer>();
        for(int indx=0; indx < days.size(); indx++){
             myLocalMap.put(days.get(indx), change.get(indx));
        }
        Collections.sort(days);
        for(int indx=0; indx < days.size(); indx++){
            change.add(indx, myLocalMap.get(days.get(indx)).intValue());
        }

        // sort names
        Map<Integer, String> myLocalMap2 = new HashMap<Integer, String>(n);
        for(int indx=0; indx < days2.size(); indx++){
             myLocalMap2.put(days2.get(indx), names.get(indx));
        }
        Collections.sort(days2);
        for(int indx=0; indx < days2.size(); indx++){
            names.add(indx, myLocalMap2.get(days2.get(indx)));
        }
     
        int count = 0;
        String highName = new String();
        int top = numHigh(amount);

        for(int i = 0; i<n; i++)
        {
        	String name = names.get(i);
        	int high = Collections.max(amount);
        	int index = names.indexOf(name);
        	amount.set(index, amount.get(index)+change.get(i));

        	if((numHigh(amount) ==1 && highName.contains(name) == false) && amount.get(index) > high)
        	{
        		count += 1;
        		highName = name;
        		top = numHigh(amount);

        	}
        	else if(top != numHigh(amount))
        	{
        		count += 1;
        		top = numHigh(amount);
        	}
        }
        PrintWriter out = new PrintWriter(new FileWriter("measurement.out"));
		out.println(count);
		out.close();
	}
	public static int numHigh(ArrayList<Integer> list)
	{
		int max = Collections.max(list);
		int count = 0;
		for(int i = 0; i<list.size(); i++)
		{
			if(list.get(i) == max)
			{
				count += 1;
			}
		}
		return count;
	}

}
