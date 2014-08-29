package discountoffers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//INCOMPLETE
public class Main {

	public static void main(String[] args) throws IOException {
		File file = new File("discounts.txt");
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line = in.readLine();
		List<String> semicolonSplit = Arrays.asList(line.split("\\s*;\\s*"));
		
		List<String> first = Arrays.asList(semicolonSplit.get(0).split("\\s*,\\s*"));
		List<String> products = Arrays.asList(semicolonSplit.get(0).split("\\s*,\\s*"));		
		List<Customer> customers = new ArrayList<Customer>();
		
		for (String s : first) {
			customers.add(new Customer(s, products));
		}

	}
}

class Customer {
	private double SS = 0;
	private String name;
	
	public Customer(String name, List p) {
		this.name = name;
		SS = calculateSS(p);
	}
	
	public void setSS(int SS) {
		this.SS = SS;
	}
	
	private int calculateSS(List products) {
		return 0;
	}
}
