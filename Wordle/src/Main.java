import java.io.File; 
import java.io.FileNotFoundException;  
import java.util.Scanner; 
import java.util.ArrayList;



class Main {
  public static void main(String[] args) {
   

    ArrayList<String> allTheWords = importFile("englishwords.txt");

    ArrayList<String> fiveLetters = fiveLetterWords(allTheWords);

    System.out.println(fiveLetters);
    
    Scanner keyboard = new Scanner(System.in);

    boolean isCorrect = false;
    
    System.out.println("***Welcome to Wordle!***");

    int r = (int)(Math.random() * fiveLetters.size() + 1);

    Word word = new Word(fiveLetters.get(r));

    while(word.getCount() < 6 && !word.getIsCorrect()) {
      System.out.print("Please enter in your guess: ");
      String guess = keyboard.nextLine();
      if (isValid(guess.toLowerCase(), fiveLetters)) {
        word.guess(guess);
        word.printHint();
        if (word.getIsCorrect()) {
          System.out.println("YOU GOT IT!");
          System.out.println("You used " + word.getCount() + " guesses.");
          isCorrect = true;
          word.setCount(6);
        }
      
      } else {
        System.out.println("Not a valid word.");
      }
      System.out.print("Letters left:");
      word.printLetters();
      System.out.println();
    }
    if (!isCorrect) {
      System.out.println("You didn't get it.");
    }
    System.out.println("The word was " + word.getAnswer() + ".");
    
    

    
  }

  public static boolean isValid(String s, ArrayList<String> words) {
    for (int i = 0; i < words.size(); i++) {
      if (words.get(i).equals(s)) {
        return true;
      }
    }

    return false;
  }

    
  public static ArrayList<String> fiveLetterWords(ArrayList<String> words){
    ArrayList<String> fiveLetter = new ArrayList<>();
    for (int i = 0; i < words.size(); i++) {
      if (words.get(i).length() == 5) {
        fiveLetter.add(words.get(i));
      }
    }

    return fiveLetter;
    
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