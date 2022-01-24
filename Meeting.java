
import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Meeting {
	static ArrayList<Times>[] adj;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("meeting.in"));
		PrintWriter out = new PrintWriter(new FileWriter("meeting.out"));
		StringTokenizer in = new StringTokenizer(f.readLine());
		int n = Integer.valueOf(in.nextToken());
		int m = Integer.valueOf(in.nextToken());
		adj = new ArrayList[n];
		for(int i=0;i<n;i++) {
			adj[i]=new ArrayList<Times>();
		}
		for(int i=0;i<m;i++) {
			StringTokenizer in2 = new StringTokenizer(f.readLine());
			adj[Integer.valueOf(in2.nextToken())-1]
					.add(new Times(Integer.valueOf(in2.nextToken())-1,Integer.valueOf(in2.nextToken()),Integer.valueOf(in2.nextToken())));
		}
		
		boolean[] isVisited = new boolean[n];
		int[] res = new int[2];
        ArrayList<Times> fin = new ArrayList<Times>();
        calc(0,n-1,isVisited,res,fin);
 
		// calculate bessie --> keep track of all possible times in a set
		// calculate elsie --> keep track of all possible times in a set 
		// find common time 
		// if empty or common time is impossible --> print "IMPOSSIBLE" 
        ArrayList<Integer> b= new ArrayList<Integer>();
        ArrayList<Integer> e= new ArrayList<Integer>();
        for(int i=0;i<fin.size();i++) {
        	b.add(fin.get(i).b);
        	e.add(fin.get(i).e);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
	    for (int i=0; i<b.size(); i++) {
	    	for (int j = 0; j<e.size(); j++) {
	    		if (b.get(i) == e.get(j)) {
	    			pq.add(b.get(i));
	                break;
	            }
	        }
	    }
	    
	    if(pq.isEmpty()) {
	    	System.out.println("IMPOSSIBLE");
	    }
	    else {
	    	System.out.println(Collections.min(b));
	    }
        out.close();
	}
 
    static void calc(int u, int d, boolean[] isVisited, int[] res, ArrayList<Times> fin){
        if (u==d) {
        	// don't care about "to" because it's only used for initial graph structure  
            fin.add(new Times(-1,res[0],res[1]));
            return;
        }
        for (Times obj : adj[u]) {
            	res[0]+=obj.b;
            	res[1]+=obj.e;
                calc(obj.to, d, isVisited, res, fin);
                // reset for next traversals 
                res[0]-=obj.b;
            	res[1]-=obj.e;
            
        }
    }
    
    static class Times{
    	int to;
    	int b;
    	int e;
    	public Times(int to, int b, int e){
    		this.to=to;
    		this.b=b;
    		this.e=e;
    	}
    }
}