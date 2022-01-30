import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;

public class closest {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter (new OutputStreamWriter(System.out)));
		StringTokenizer in = new StringTokenizer(f.readLine());
		int k = Integer.valueOf(in.nextToken());
		int m = Integer.valueOf(in.nextToken());
		int n = Integer.valueOf(in.nextToken());
		Patches[] patches = new Patches[k];
		for(int i=0;i<k;i++) {	
			StringTokenizer in2 = new StringTokenizer(f.readLine());
			patches[i] = new Patches(Integer.valueOf(in2.nextToken()),Long.valueOf(in2.nextToken()));
		}
		int[] blocks = new int[m];
		for(int i=0;i<m;i++) {
			blocks[i]=Integer.valueOf(f.readLine());
		}
		Arrays.sort(patches);
		Arrays.sort(blocks);
		ArrayList<Long> vals = new ArrayList<Long>();
		
		// add last and the first patches
		long max=0;
		int curr=k-1;
		while(blocks[m-1]<patches[curr].pos) {
			max+=patches[curr].taste;
			curr-=1;
		}
		vals.add(max);
		
		max=0;
		curr=0;
		while(blocks[0]>patches[curr].pos) {
			max+=patches[curr].taste;
			curr+=1;
		}
		vals.add(max);
		
		// go thru every interval
		for(int i=0;i<m-1;i++) {
			if(curr<k) {
				if(!(patches[curr].pos>blocks[i+1])) {
					// calc total
					int tot=0;
					int index=curr;
					while(index<k && patches[index].pos<blocks[i+1]) {
						tot+=patches[index].taste;
						index+=1;
					}
					
					// calc oneMax
					int l=curr;
					int r=curr+1;
					long lb = blocks[i];
					long rb = blocks[i+1];
					long oneMax=patches[curr].taste;
					long currTot=patches[curr].taste;
					while(r<k && patches[r].pos<rb) {
						if(l==r) {
							r+=1;
						}
						// dist 1 + dist 2 has to be greater than dist between two patches to accumulate
						else if(patches[l].pos-lb+rb-patches[r].pos > patches[r].pos-patches[l].pos) {
							currTot+=patches[r].taste;
							oneMax=Math.max(oneMax, currTot);
							r+=1;
						}
						else {
							currTot-=patches[l].taste;
							l+=1;
						}
					}
					vals.add(oneMax);
					vals.add(tot-oneMax);
					// for next interval 
					curr=r;	
				}
			}
		}
		
		long res=0;
		int index=vals.size()-1;
		int count=0;
		Collections.sort(vals);
		while(index!=-1 && count<n) {
			res+=vals.get(index);
			index-=1;
			count+=1;
		}
		System.out.println(res);
		out.close();	
	}
	
	static class Patches implements Comparable<Patches>{
		int pos;
		long taste;
		public Patches(int pos, long taste) {
			this.pos=pos;
			this.taste=taste;
		}
		@Override
		public int compareTo(Patches o) {
			return pos-o.pos;
		}
		
	}
}