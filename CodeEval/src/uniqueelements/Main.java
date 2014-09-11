package uniqueelements;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

//https://www.codeeval.com/open_challenges/29/

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		String[] a;
		StringBuilder sb;
		String previous;
		while ((line = in.readLine()) != null) {
			previous = "";
			sb = new StringBuilder();
			a = line.split(",");
			for (int i = 0; i < a.length; i++) {
				if (!a[i].equals(previous)) {
					sb.append(a[i] + ",");
				}
				previous = a[i];
			}
			sb.deleteCharAt(sb.length() - 1);
			System.out.println(sb.toString());
		}
		
		in.close();
	}
}