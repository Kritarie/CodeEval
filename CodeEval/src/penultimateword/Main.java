package penultimateword;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//https://www.codeeval.com/open_challenges/92/

public class Main {
    public static void main (String[] args) throws IOException {
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while ((line = in.readLine()) != null) {
        String[] lineArray = line.split("\\s+");
        System.out.println(lineArray[lineArray.length-2]);
    }
    
    in.close();
    System.out.print("\n");
  }
}