package sumof1000primes;

//https://www.codeeval.com/open_challenges/4/

public class Main {

	public static void main(String[] args) {
		int sum = 0;
		int currentNum = 2;
		int numPrimesFound = 0;
		while (numPrimesFound < 1000) {
			if (isPrime(currentNum)) {
				sum += currentNum;
				numPrimesFound++;
			}
			currentNum++;
		}
		
		System.out.print(sum);
		
	}
	
	static boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt((double)num); i++) {
			if (num % i == 0) return false;
		}
		return true;
	}
}