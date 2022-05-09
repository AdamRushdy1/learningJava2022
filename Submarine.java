package adventOfCode2021;

public class Submarine {

	  private int depth;
	  private int horizontal;

	  public Submarine() {
	    depth = 0;
	    horizontal = 0;
	  }

	  public void move(String s) {
	    if (s.toLowerCase().charAt(0) == 'f') {
	      horizontal += s.charAt(s.indexOf(" ") + 1) - 48;
	    } else if (s.toLowerCase().charAt(0) == 'u') {
	      depth -= s.charAt(s.indexOf(" ") + 1) - 48;
	    } else {
	      depth += s.charAt(s.indexOf(" ") + 1) - 48;
	    }
	  }

	  public int getDepth() {
	    return depth;
	  }

	  public int getHorizontal() {
	    return horizontal;
	  }

	  public String toString(){
	    return "Depth: " + depth + "\nHorizontal Position: " + horizontal;
	  }

	}