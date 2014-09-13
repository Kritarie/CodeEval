package multtables;

public class Main {

//https://www.codeeval.com/open_challenges/23/

	public static void main(String[] args) {
		int[][] t = new int[12][12];
		
		for (int i = 1; i <= t[0].length; i++) {
			for (int j = 1; j <= t[0].length; j++) {
				t[i-1][j-1] = i*j;
				System.out.printf("%4d", t[i-1][j-1]);
			}
			System.out.println();
		}
	}
}