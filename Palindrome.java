public class Palindrome {
	public static void main(String[] args) {
		System.out.println(PalindromeSolver("abcbc"));
		System.out.println(PalindromeSolver("abccc"));
	}
	public static boolean PalindromeSolver(String word)
	{
		int[] arr = new int[26];
		for(int i=0;i<word.length();i++) {
			arr[word.charAt(i)-'a']+=1;
		}		
		int oddCount =0;
		for(int value : arr) {
			if(value%2==1) {
				oddCount+=1;
			}
		}
		if(oddCount>1) {
			return false;
		}
		else {
			return true;
		}
	}
	
}
