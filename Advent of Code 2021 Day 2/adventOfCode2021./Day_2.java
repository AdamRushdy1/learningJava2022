package adventOfCode2021;


import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day_2 {
  public static void main(String[] args) {

    ArrayList<String> directions = importFile("directions.txt");
    Submarine s = new Submarine();
    for (int i = 0; i < directions.size(); i++) {
      s.move(directions.get(i));
    }
    System.out.println(s);
    System.out.println(s.getDepth() * s.getHorizontal());

    
  }

   public static ArrayList<String> importFile(String fileName){
    ArrayList<String> words = new ArrayList<>();
    try {
      File myObj = new File(fileName);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        words.add(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return words;
  }
  
}
