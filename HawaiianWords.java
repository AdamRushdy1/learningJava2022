package hawaiianWords;

//makeWord(String s) --> creates the response listed on the documentation

import java.util.Scanner;

class HawaiianWords {
	public static void main(String[] args) {
	  boolean bool = true;
	  while (bool) {
	    Scanner keyboard = new Scanner(System.in);
	    System.out.println("Word: ");
	    String word = keyboard.nextLine();
	    String pronunciation = makeWord(word);
	    if (pronunciation.equals("That is not a hawaiian word")) {
	      System.out.println(pronunciation);
	    } else {
	      System.out.println(word + " is pronounced " + makeWord(word));
	    }
	    System.out.println("Would you like to continue (y or n)");
	    String loop = keyboard.nextLine();
	    if (loop.toLowerCase().equals("n")) {
	      bool = false; 
	    } else {
	      bool = true;
	    }
	  }
	  
	  
	}
	
	public static String makeWord(String s){
	  String response = "";
	
	  //tests if there are non hawaiian characters
	  s = s.toLowerCase();
	  boolean isValid = true;
	  for (int i = 0; i < s.length(); i++) {
	    if (!isHawaiian(s.charAt(i))) {
	      isValid = false;
	    }
	  }
	  if (!isValid)
	  {
	    response = "That is not a hawaiian word";
	  } else {
	
	    
	    int a = 0;
	    int c = 1;
	    
	    if (s.length() % 2 == 0 || (s.length() % 2 != 0 && 
	        s.indexOf("ai") >= 0 || 
	        s.indexOf("ae") >= 0 || 
	        s.indexOf("ao") >= 0 || 
	        s.indexOf("au") >= 0 || 
	        s.indexOf("ei") >= 0 || 
	        s.indexOf("eu") >= 0 || 
	        s.indexOf("iu") >= 0 || 
	        s.indexOf("oi") >= 0 || 
	        s.indexOf("ou") >= 0 || 
	        s.indexOf("ui") >= 0)) c = 0; 
	
	
	    //forms syllables
	    
	    if (true) {
	      String[] syllables = new String[s.length()];
	      fill(syllables);
	      int x = 0;
	      if (isVowel(s.charAt(0)) && !isPair(s.substring(0, 2))) {
	        x = 1;
	        a = 1;
	        syllables[0] = s.substring(0, 1);
	      }
	      if (isVowel(s.charAt(0)) && isPair(s.substring(0, 2))) {
	        x = 2;
	        a = 1;
	        syllables[0] = s.substring(0, 2);
	      }
	
	      
	      for (int i = x; i < s.length(); i ++) {
	        if (i + 1 != s.length() && isVowel(s.charAt(i)) && !isPair(s.substring(i, i + 2))) {
	          syllables[a] += s.charAt(i);
	          if (syllables[a].indexOf(" ") >= 0) {
	            syllables[a] = s.substring(i, i + 1);
	          }
	          a++;
	        } else if (i + 1 != s.length() && isVowel(s.charAt(i)) && isPair(s.substring(i, i + 2))) {
	          syllables[a] += s.substring(i, i + 2);
	          if (syllables[a].indexOf(" ") >= 0) {
	            syllables[a] = s.substring(i, i + 2);
	          }
	          i++;
	          a++;
	        } else if (i + 1 != s.length()) {
	          syllables[a] = s.substring(i, i + 1);
	        } else {
	          syllables[a] += s.substring(i, i + 1);
	          if (syllables[a].indexOf(" ") >= 0) {
	            syllables[a] = s.substring(i, i + 1);
	          }
	        }
	      }
	      
	      
	      
	      response = pronounce(syllables);
	    }
	
	  }
	
	
	  
	  return response;
	  
	}
	
	
	//formats syllables
	
	public static String pronounce(String[] syllables) {
	  String word = "";
	  
	  for (int i = 0; i < syllables.length; i++) {
	    if (true) {
	      
	      for (int x = 0; x < syllables[i].length(); x++) {
	        if (x < syllables[i].length() - 1 && isPair(syllables[i].substring(x, x + 2))) {
	          word += pronunciationPair(syllables[i].substring(x, x + 2));
	          x++;
	        } else if (isVowel(syllables[i].charAt(x))) {
	          word += pronunciation(syllables[i].charAt(x));
	        } else {
	          word += syllables[i].charAt(x);
	        }
	      }
	
	      if (i < syllables.length - 2) {
	        if (!syllables[i + 1].equals(" ")){
	          word += "-";
	        }
	      }
	      
	    }
	  }
	  return word;
	}
	
	//---------------- methods to help
	
	public static String pronunciation(char c) {
	  String letter = "";
	  if (c == 'a') letter = "ah";
	  if (c == 'e') letter = "eh";
	  if (c == 'i') letter = "ee";
	  if (c == 'o') letter = "oh";
	  if (c == 'u') letter = "oo";
	  return letter;
	}
	
	public static String pronunciationPair(String s) {
	  String letter = "";
	  if (s.equals("ai")) letter = "eye";
	  if (s.equals("ae")) letter = "eye";
	  if (s.equals("ao")) letter = "ow";
	  if (s.equals("au")) letter = "ow";
	  if (s.equals("ei")) letter = "ay";
	  if (s.equals("eu")) letter = "eh-oo";
	  if (s.equals("iu")) letter = "ew";
	  if (s.equals("oi")) letter = "oy";
	  if (s.equals("ou")) letter = "ow";
	  if (s.equals("ui")) letter = "ooey";
	  return letter;
	}
	
	public static String[] fill(String[] words) {
	  for (int i = 0; i < words.length; i++) {
	    words[i] = " ";
	  }
	  return words;
	}
	
	
	public static void print(String[] s) { //for testing stuff
	  for (int i = 0; i < s.length; i++) {
	    System.out.println(s[i]);
	  }
	}
	
	
	
	public static boolean isVowel(char c) {
	  if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
	  return false;
	}
	
	public static boolean isPair(String s) {
	  if (s.equals("ai") || s.equals("ae") || s.equals("ao") || s.equals("au") || s.equals("ei") || s.equals("eu") || s.equals("iu") || s.equals("oi") || s.equals("ou") || s.equals("ui")) return true;
	  return false;
	}
	
	public static boolean isHawaiian(char c) {
	  if (c == 'a' ||
	      c == 'e' ||
	      c == 'h' ||
	      c == 'i' ||
	      c == 'k' ||
	      c == 'l' ||
	      c == 'm' ||
	      c == 'n' ||
	      c == 'o' ||
	      c == 'p' ||
	      c == 'u' ||
	      c == 'w' ||
	      c == '\'') return true;
	  return false;
	}



}
