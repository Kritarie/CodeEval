package even;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

//https://www.codeeval.com/open_challenges/100/
	
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner in = new Scanner(file);
		while (in.hasNext()) {
			System.out.println((in.nextInt() % 2) == 0 ? 1 : 0);
		}
		
		in.close();
	}
}