package minimumcoins;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

//https://www.codeeval.com/open_challenges/74/
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("txts\\minimumcoins.txt");
		Scanner in = new Scanner(file);
		int num, count;
		while (in.hasNext()) {
			num = in.nextInt();
			count = 0;
			while (num > 0) {
				if (num >= 5) {
					num -= 5;
					count++;
				} else if (num >= 3) {
					num -= 3;
					count++;
				} else if (num >= 1) {
					num -= 1;
					count++;
				}
			}
			System.out.println(count);
		}
		
		in.close();
	}
}