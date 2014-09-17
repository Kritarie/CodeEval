package sequencetransformation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Main {

//https://www.codeeval.com/open_challenges/130/
	
	public static void main(String[] args) throws IOException {
		File file = new File("txts/sequencetransformation.txt");
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		String[] params;
		StringBuilder sb;
		while ((line = in.readLine()) != null) {
			params = line.split("\\s");
			sb = new StringBuilder();
			for (int i = 0; i < params[0].length(); i++) {
				sb.append(Character.getNumericValue(params[0].charAt(i)) == 1 ? "([A]+|[B]+)" : "[A]+");
			}
			
			Pattern p = Pattern.compile(sb.toString(), Pattern.MULTILINE);
			if (p.matcher(params[1]).find()) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
		
		in.close();
	}
}