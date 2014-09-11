package calculatedistance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

//https://www.codeeval.com/open_challenges/99/

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		int x1, y1, x2, y2;
		while ((line = in.readLine()) != null) {
			x1 = getX1(line);
			y1 = getY1(line);
			x2 = getX2(line);
			y2 = getY2(line);
			
			System.out.println((int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
		}
		
		in.close();
	}

	private static int getY2(String line) {
		return Integer.parseInt(line.substring(line.lastIndexOf(",".charAt(0)) + 2, line.length() - 1));
	}

	private static int getX2(String line) {
		return Integer.parseInt(line.substring(line.lastIndexOf("(".charAt(0)) + 1, line.lastIndexOf(",".charAt(0))));
	}

	private static int getY1(String line) {
		return Integer.parseInt(line.substring(line.indexOf(",".charAt(0)) + 2, line.indexOf(")".charAt(0))));
	}

	private static int getX1(String line) {
		return Integer.parseInt(line.substring(1, line.indexOf(",".charAt(0))));
	}
}
