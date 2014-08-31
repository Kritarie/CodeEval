package largestprimepalindrome;

//https://www.codeeval.com/open_challenges/3/

public class Main {

	public static void main(String[] args) {
		
		for (int i = 1000; i > 0; i--) {
			if (isPrime(i) && isPalindrome(i)) {
				System.out.print(i);
				break;
			}
		}
	}
	
	static boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt((double)num); i++) {
			if (num % i == 0) return false;
		}
		return true;
	}
	
	static boolean isPalindrome(int num) {
		String one = String.valueOf(num);
		StringBuilder two = new StringBuilder(one);
		two.reverse();
		if (one.equals(two.toString())) {
			return true;
		}
		return false;
	}
}