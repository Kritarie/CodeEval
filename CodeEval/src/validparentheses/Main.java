package validparentheses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Main {

//https://www.codeeval.com/open_challenges/68/

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			System.out.println(isValid(line) ? "True" : "False");
		}
		
		in.close();
	}

	private static boolean isValid(String line) {
		LinkedList<Character> stack = new LinkedList<Character>();
		for (int i = 0; i < line.length(); i++) {
			try {
				switch (line.charAt(i)) {
				case '(':
					stack.push('(');
					break;
				case '{':
					stack.push('{');
					break;
				case '[':
					stack.push('[');
					break;
				case ')':
					if (stack.pop() != '(') return false;
					break;
				case '}':
					if (stack.pop() != '{') return false;
					break;
				case ']':
					if (stack.pop() != '[') return false;
					break;
				default:
					break;
				}
			} catch (NoSuchElementException e) {
				return false;
			}
		}
		return stack.isEmpty();
	}
}
