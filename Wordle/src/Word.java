import java.util.ArrayList;

public class Word {
  private String answer;
  private String[][] hints = new String[12][5];
  private boolean isCorrect;
  private int count;
  private char[] letters;

  public Word(String a) {
    this.answer = a;
    this.isCorrect = false;
    this.letters = new char[26];
    letters = fillChar(letters);
    this.count = 0;
  }

  public String getAnswer() {
    return answer;
  }

  public void printLetters() {
    for(int i = 0; i < letters.length; i++) {
      System.out.print(" " + letters[i]);
    }
  }

  public void guess(String g) {
    String guess = g.toLowerCase();
    String hint = "";
    if (guess.equals(this.answer)) {
      hint = "*****";
      isCorrect = true;
    } else {
      for (int i = 0; i < 5; i++) {
        if (guess.charAt(i) == this.answer.charAt(i)) {
          hint += "*";
          letters[guess.charAt(i) - 97] = '#';
        } else if (answer.indexOf(guess.charAt(i)) >= 0) {
          hint += "@";
          letters[guess.charAt(i) - 97] = '#';
        } else {
          hint += "x";
          letters[guess.charAt(i) - 97] = '#';
        }
      }
    }
    addHint(hint, guess);
    count++;
    
  }

  public void printHint() {
    for (int r = 0; r < count * 2; r++) {
      System.out.print("|");
      for (int c = 0; c < hints[0].length; c++) {
        System.out.print(this.hints[r][c]);
      }
      System.out.print("|");
      System.out.println();
    }
  }

  public void addHint(String s, String g) {
    
    for (int c = 0; c < 5; c++) {
      hints[count * 2][c] = g.substring(c, c + 1);
    }
    
    for (int c = 0; c < 5; c++) {
      hints[count * 2 + 1][c] = s.substring(c, c + 1);
    }
    
  }

  public int getCount() {
    return this.count;
  }

  public void setCount(int c) {
    this.count = c;
  }

  public boolean getIsCorrect() {
    return isCorrect;
  }

  public char[] fillChar(char[] c) {
    c[0] = 'A';
    c[1] = 'B';
    c[2] = 'C';
    c[3] = 'D';
    c[4] = 'E';
    c[5] = 'F';
    c[6] = 'G';
    c[7] = 'H';
    c[8] = 'I';
    c[9] = 'J';
    c[10] = 'K';
    c[11] = 'L';
    c[12] = 'M';
    c[13] = 'N';
    c[14] = 'O';
    c[15] = 'P';
    c[16] = 'Q';
    c[17] = 'R';
    c[18] = 'S';
    c[19] = 'T';
    c[20] = 'U';
    c[21] = 'V';
    c[22] = 'W';
    c[23] = 'X';
    c[24] = 'Y';
    c[25] = 'Z';
    return c;
    
  }

}