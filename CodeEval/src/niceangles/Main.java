package niceangles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

//https://www.codeeval.com/open_challenges/160/

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner in = new Scanner(file);
		double num, minutes, seconds;
		StringBuilder sb;
		while (in.hasNext()) {
			sb = new StringBuilder();
			num = in.nextDouble();
			sb.append((int) Math.floor(num));
			minutes = 60 * (num - Math.floor(num));
			sb.append("." + String.format("%02d", (int) minutes) + "'");
			seconds = 60 * (minutes - Math.floor(minutes));
			sb.append(String.format("%02d", (int) seconds) + "\"");
			System.out.println(sb.toString());
		}
		
		in.close();
	}
}