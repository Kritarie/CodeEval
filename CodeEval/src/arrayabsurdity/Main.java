package arrayabsurdity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

//https://www.codeeval.com/open_challenges/41/

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner in = new Scanner(file);
		in.useDelimiter("\\D");
		int n, ele;
		int[] occurrences;
		while (in.hasNext()) {
			n = in.nextInt();
			occurrences = new int[n-1];
			for (int i = 0; i < n; i++) {
				ele = in.nextInt();
				if (occurrences[ele] == 1) {
					System.out.println(ele);
					in.nextLine();
					break;
				} else {
					occurrences[ele]++;
				}
			}
		}
		
		in.close();
	}
}