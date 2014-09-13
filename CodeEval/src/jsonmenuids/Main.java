package jsonmenuids;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

//https://www.codeeval.com/open_challenges/102/

	public static void main(String[] args) throws IOException {
	    File file = new File(args[0]);
	    BufferedReader in = new BufferedReader(new FileReader(file));
	    String line;
	    String[] items;
	    int sum, searchIndex;
	    while ((line = in.readLine()) != null) {
	    	sum = 0;
	    	items = line.substring(37).split(",");
	    	
	    	for (int i = 0; i < items.length; i++) {
	    		if (items[i].contains("Label")) {
	    			sum += Integer.parseInt(items[i].replaceAll("[\\D]", ""));
	    		}
	    	}
	    	
	    	System.out.println(sum);
	    }
	    
	    in.close();
	}
}