package stackimplementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

//https://www.codeeval.com/open_challenges/9/

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner in = new Scanner(file);
		String input;
		String[] splitInput;
		Stack stack;
		StringBuilder sb;
		while (in.hasNext()) {
			input = in.nextLine();
			splitInput = input.split("\\s");
			stack = new Stack();
			sb = new StringBuilder();
			
			for (String s : splitInput) {
				stack.push(Integer.parseInt(s));
			}
			
			while (!stack.isEmpty()) {
				sb.append(stack.pop() + " ");
				stack.pop();
			}
			
			System.out.println(sb.toString().trim());
		}
		
		in.close();
	}
}

class Stack {
	private Node topNode;
	private int size;
	
	public Stack() {
		size = 0;
	}
	
	public void push(int n) {
		Node newNode = new Node(n);
		if (topNode == null) {
			topNode = newNode;
		} else {
			newNode.nodeBelow = topNode;
			topNode = newNode;
		}
		size++;
	}
	
	public Node pop() {
		if (topNode == null) {
			return null;
		} else {
			Node temp = topNode;
			topNode = topNode.nodeBelow;
			size--;
			return temp;
		}
	}
	
	public boolean isEmpty() {
		return (topNode == null);
	}
	
	public int size() {
		return size;
	}
}

class Node {
	int key;
	Node nodeBelow;
	
	public Node(int key) {
		this.key = key;
	}
	
	@Override
	public String toString() {
		return String.valueOf(key);
	}
}