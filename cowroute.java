import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;


public class cowroute {
	static ArrayList<Edge>[] adj;
	static long[] prices;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("cowroute.in"));
		PrintWriter out = new PrintWriter(new FileWriter("cowroute.out"));
		StringTokenizer in = new StringTokenizer(f.readLine());
		int a = Integer.valueOf(in.nextToken())-1;
		int b = Integer.valueOf(in.nextToken())-1;
		int n = Integer.valueOf(in.nextToken());
		adj = new ArrayList[1000];
		for(int i=0;i<1000;i++) {
			adj[i] = new ArrayList<Edge>();
		}	
		int num=0;
		for(int i=0;i<n;i++) {
			StringTokenizer in2 = new StringTokenizer(f.readLine()); 
			int cost = Integer.valueOf(in2.nextToken());
			int numCities = Integer.valueOf(in2.nextToken());
			
			StringTokenizer in3 = new StringTokenizer(f.readLine()); 
			int curr=Integer.valueOf(in3.nextToken())-1;
			for(int j=0;j<numCities-1;j++) {
				int temp=Integer.valueOf(in3.nextToken())-1;
				num=Integer.max(Integer.max(temp, num),curr);
				adj[curr].add(new Edge(temp,cost,i));
				curr=temp;
			}
		}
		// number of total cities  
		num+=1;
		// initialize lists 
		visited = new boolean[num];
		ArrayList<Data> route = new ArrayList<Data>(num);
		ArrayList<Integer> unsettledNodes = new ArrayList<Integer>(num);
		long[] prices = new long[num];
		Arrays.fill(prices, Long.MAX_VALUE);
		Arrays.fill(visited, false);
		prices[a]=0L;
		for(int i=0;i<num;i++) {
			unsettledNodes.add(i);
			route.add(new Data(-1,0));
	    }
	    // dijkstra's algorithm
	    // stores indexes 
	    while (unsettledNodes.size()!= 0) {
	        int currentNode = getMinIndex(unsettledNodes, prices);
	        // unreachable cities
	        if(currentNode==-1) {
	        	break;
	        }
	        for (Edge val : adj[currentNode]) {
	            if (!visited[val.to]) {
	            	// accounting if you're on the same route
	            	int cost = (route.get(currentNode).route==val.airline) ? 0 : val.weight;
	            	if(prices[val.to]>prices[currentNode]+cost) {
	            		prices[val.to]=prices[currentNode]+cost;
	            		route.get(val.to).route=val.airline;
		        		route.get(val.to).flights=route.get(currentNode).flights+1;
	            	}
	            }
	        }
	        unsettledNodes.remove(new Integer(currentNode));
	        visited[currentNode]=true;
	    }
	    int noSol = -1;
	    if(prices[b]==Long.MAX_VALUE) {
	    	out.println(noSol+" "+noSol);
	    }
	    else {
		    out.println(prices[b]+" "+route.get(b).flights);
	    }
	    out.close();
	}
	static int getMinIndex(ArrayList<Integer> unsettledNodes, long[] distances) {
		int minIndex=Integer.MAX_VALUE;
		long dist = Long.MAX_VALUE;
		// visit all unvisited nodes
		for(int node : unsettledNodes) {
			if(dist>distances[node]) {
				dist=distances[node];
				minIndex=node;
			}
		}
		if(minIndex==Integer.MAX_VALUE) {
			return -1;
		}
		return minIndex;
	}
	static class Edge{
	    int to;
	    int weight;
	    int airline;
	    public Edge(int to, int weight, int airline){
	    	this.to = to;
	    	this.weight = weight; 	
	    	this.airline = airline;
	    }   
	}
	static class Data {
		long route;
		int flights;
		public Data(long route, int flights) {
			this.route=route;
			this.flights=flights;
		}
	}
}