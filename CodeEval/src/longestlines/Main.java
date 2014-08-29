package longestlines;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {
	public static void main (String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String input;
		int N = Integer.parseInt(in.readLine());
		TreeSet<String> ts = new TreeSet<String>(new Comp());
		
		while ((input = in.readLine()) != null) {
			ts.add(input);
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(ts.pollLast());
		}
		
		in.close();
	}
}

class Comp implements Comparator<String> {
	@Override
	public int compare(String lhs, String rhs) {
		if (lhs.length() > rhs.length()) return +1;
		if (lhs.length() == rhs.length()) return 0;
		return -1;
	}
}