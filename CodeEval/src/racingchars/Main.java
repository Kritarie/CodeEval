package racingchars;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

//https://www.codeeval.com/open_challenges/136/

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line = in.readLine();
		int previous = -1;
		
		line = line.replace("C", "|");
		if (!line.contains("|")) {
			line = line.replace("_", "|");
		}
		
		previous = line.indexOf("|");
		
		while ((line = in.readLine()) != null) {
			if (line.contains("C")) {
				if (line.indexOf("C") > previous) {
					previous = line.indexOf("C");
					line = line.replace("C", "\\");
				} else if (line.indexOf("C") < previous) {
					previous = line.indexOf("C");
					line = line.replace("C", "/");
				} else {
					previous = line.indexOf("C");
					line = line.replace("C", "|");
				}
				//line does not contain checkpoint, must contain gate
			} else {
				if (line.indexOf("_") > previous) {
					previous = line.indexOf("_");
					line = line.replace("_", "\\");
				} else if (line.indexOf("_") < previous) {
					previous = line.indexOf("_");
					line = line.replace("_", "/");
				} else {
					previous = line.indexOf("_");
					line = line.replace("_", "|");
				}
			}
			
			System.out.println(line);
		}
		
		in.close();
	}
}
