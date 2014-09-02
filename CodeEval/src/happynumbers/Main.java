package happynumbers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//https://www.codeeval.com/open_challenges/39/

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner in = new Scanner(file);
		int num;
		List<Integer> list;
		while (in.hasNext()) {
			num = in.nextInt();
			list = new ArrayList<Integer>();
			while (true) {
				if (num == 1) {
					System.out.println(1);
					break;
				} else if (list.contains(num)) {
					System.out.println(0);
					break;
				} else {
					list.add(num);
					num = happify(num);
				}
			}
		}
		
		in.close();
	}
	
	private static int happify(int n) {
		LinkedList<Integer> stack = new LinkedList<Integer>();
		while (n > 0) {
			stack.push(n % 10);
			n = n / 10;
		}
		n = 0;
		while (!stack.isEmpty()) {
			n += (int) Math.pow(stack.pop(), 2);
		}
		return n;
	}
}
