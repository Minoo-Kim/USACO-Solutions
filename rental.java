import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// note: timed out on last case
public class rental {
	public static void main(String[] args) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("rental.in"));
		PrintWriter out = new PrintWriter(new FileWriter("rental.out"));
		StringTokenizer input = new StringTokenizer(f.readLine()); 
		int n = Integer.valueOf(input.nextToken());
		int m = Integer.valueOf(input.nextToken());
		int r = Integer.valueOf(input.nextToken());
		ArrayList<Integer> milk= new ArrayList<Integer>(n);
		for(int i =0; i<n; i++) {
			milk.add(Integer.valueOf(f.readLine()));
		}
		ArrayList<Seller> seller = new ArrayList<Seller>(m);
		for(int i =0; i<m; i++) {
			StringTokenizer input2 = new StringTokenizer(f.readLine()); 
			seller.add(new Seller(Integer.valueOf(input2.nextToken()), Integer.valueOf(input2.nextToken())));
		}
		ArrayList<Integer> rent = new ArrayList<Integer>(r);
		for(int i =0; i<r; i++) {
			rent.add(Integer.valueOf(f.readLine()));
		}
		// Sort all three datasets
		Collections.sort(milk, Collections.reverseOrder());
		Collections.sort(seller);
		Collections.sort(rent, Collections.reverseOrder());
		// if optimal value of milk option is less/equal to i'th lowest rental, everything after will be unprofitable, use full rental for the rest
		// if it isn't less, add the milk option
		// Key: if rental (adjusted) > milk, then every next cow must be rented for max profit
		
		int used = 0;
		long total = 0;
		for(int i =0; i<n; i++) {
			long milkNum = tempMilk(milk.get(i), seller); // doesn't mess up the seller in-case milk opt doens't get used
			if(rent.size() ==0) {
				total += maxMilk(milk.get(i), seller);
			}
			else if(seller.size() ==0) {
				total += rent.get(0);
				rent.remove(0);
			}
			else if(milkNum < rent.get(Math.min(n-used-1,rent.size()-1))){
				int index = Math.min(n-used-1,rent.size()-1);
				total += rent.get(index);
				rent.remove(index);
				used +=1;
			}
			else {
				total += maxMilk(milk.get(i), seller);
				used +=1;
			}
			//System.out.println("Num:" + milk.get(i)+ " Total: " + total);
		}	
		out.println(total);
		out.close();
	}
	public static long maxMilk(int num, ArrayList<Seller> array) {
		int res = 0;
		while(num>0) {
			if(array.size()==0) {
				return res;
			}
			if(num < array.get(0).amount) {
				res += array.get(0).price*num;
				array.get(0).decrease(num); 
				num = 0;
			}
			else {
				res += array.get(0).price*(array.get(0).amount);
				num -= array.get(0).amount;
				array.remove(0); // milk gone
			}
		}
		return res;
	}
	public static long tempMilk(int num, ArrayList<Seller> array) {
		int res = 0;
		int index = 0;
		while(num>0) {
			if(array.size()<=index) {
				return res;
			}
			if(num < array.get(index).amount) {
				res += array.get(index).price*num;
				num = 0;
			}
			else {
				res += array.get(index).price*(array.get(index).amount);
				num -= array.get(index).amount;
				index +=1;
			}
		}
		return res;
	}
	static class Seller implements Comparable<Seller>{
		int amount, price;
		public Seller(int a, int p) {
			amount = a;
			price = p;	
		}
		public int compareTo(Seller o) {
			return -Integer.compare(price, o.price);
		}
		public void decrease(int a) {
			this.amount -= a;
		}
	}
}