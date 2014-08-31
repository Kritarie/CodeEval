package selfdescribingnumber;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

//https://www.codeeval.com/open_challenges/40/
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			System.out.println(isSelfDescribing(line) ? 1 : 0);
		}
		
		in.close();
		System.out.print("\n");
	}
	
	private static boolean isSelfDescribing(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (Character.getNumericValue(s.charAt(i)) != numOccurences(i, s)) {
				return false;
			}
		}
		
		return true;
	}
	
	private static int numOccurences(int i, String s) {
		int count = 0;
		for (int x = 0; x < s.length(); x++) {
			if (Character.getNumericValue(s.charAt(x)) == i) {
				count++;
			}
		}
		
		return count;
	}
}