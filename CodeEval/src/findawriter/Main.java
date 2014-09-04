package findawriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
//https://www.codeeval.com/open_challenges/97/

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		String[] data, key, code;
		while ((line = in.readLine()) != null) {
			data = line.split("\\|");
			code = data[0].split("");
			key = data[1].split("\\s+");
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i < key.length; i++) {
				sb.append(code[Integer.parseInt(key[i]) - 1]);
			}
			System.out.println(sb.toString());
		}
		
		in.close();
	}
}
