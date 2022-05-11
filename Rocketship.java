package chapter8;

import java.util.Scanner;

public class Rocketship {
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Scale: ");
		final int SCALE = keyboard.nextInt();
		keyboard.nextLine();
		tip(SCALE);
		line(SCALE);
		mid(SCALE);
		line(SCALE);
		mid(SCALE);
		line(SCALE);
		tip(SCALE);
	}
	
//-------------------------------------------------------------------
	
	public static void mid(int SCALE) {
		int a = 1;
		for (int x = 1; x <= 3; x++) {
			System.out.print("|");
			for (int s = 2; s <= SCALE; s++) System.out.print(" ");
			for (int h = 1; h <= 2; h++) {
				for (int y = 2; y >= x; y--) {
					System.out.print(".");
					for (int s = 2; s <= SCALE; s++) System.out.print(" ");
				}
				for (int i = 1; i <= a; i++) {
					System.out.print("/");
					for (int s = 2; s <= SCALE; s++) System.out.print(" ");
					System.out.print("\\");
					for (int s = 2; s <= SCALE; s++) System.out.print(" ");
				}
				for (int y = 2; y >= x; y--) {
					System.out.print(".");
					for (int s = 2; s <= SCALE; s++) System.out.print(" ");
				}
				
			}
			System.out.println("|");
			for (int s = 2; s <= SCALE; s++) System.out.println();
			a++;
		}	
		a = 3;
		for (int x = 1; x <= 3; x++) {
			System.out.print("|");
			for (int s = 2; s <= SCALE; s++) System.out.print(" ");
			for (int h = 1; h <= 2; h++) {
				for (int y = 2; y <= x; y++) {
					System.out.print(".");
					for (int s = 2; s <= SCALE; s++) System.out.print(" ");
				}
				
				for (int i = 1; i <= a; i++) {
					System.out.print("\\");
					for (int s = 2; s <= SCALE; s++) System.out.print(" ");
					System.out.print("/");
					for (int s = 2; s <= SCALE; s++) System.out.print(" ");
				}
				for (int y = 2; y <= x; y++) {
					System.out.print(".");
					for (int s = 2; s <= SCALE; s++) System.out.print(" ");
				}
				
			}
			System.out.println("|");
			for (int s = 2; s <= SCALE; s++) System.out.println();
			a--;
		}	
	}
	
	
//-------------------------------------------------------------------
	
	public static void line(int SCALE) {
		System.out.print("+");
		for (int s = 2; s <= SCALE; s++) System.out.print(" ");
		for (int i = 1; i <= 6; i++) {
			System.out.print("=");
			for (int s = 2; s <= SCALE; s++) System.out.print(" ");
			System.out.print("*");
			for (int s = 2; s <= SCALE; s++) System.out.print(" ");
		}
		System.out.println("+");
		for (int s = 2; s <= SCALE; s++) System.out.println();
		
			
	}
	
//-------------------------------------------------------------------
	
	public static void tip(int SCALE) {
		int a = 5;
		for (int i = 1; i <= 5; i++) {
				for (int y = a; y >= 1; y--) {
					System.out.print(" ");
					for (int s = 2; s <= SCALE; s++) System.out.print(" ");
				}
				for (int x = 1; x <= i; x++) {
					System.out.print("/");
					for (int s = 2; s <= SCALE; s++) System.out.print(" ");
				}	
				a--;
			System.out.print("*");
			for (int s = 2; s <= SCALE; s++) System.out.print(" ");
			System.out.print("*");
			for (int s = 2; s <= SCALE; s++) System.out.print(" ");
			for (int b = 1; b <= i; b++) {
				System.out.print("\\");
				for (int s = 2; s <= SCALE; s++) System.out.print(" ");
			}
			for (int s = 1; s <= SCALE; s++) System.out.println();
		}
	}
}

//-------------------------------------------------------------------
/*  public static void tip() {
		System.out.println("  	 /**\\     ");
		System.out.println("    //**\\\\    ");
		System.out.println("   ///**\\\\\\   ");
		System.out.println("  ////**\\\\\\\\  ");
		System.out.println(" /////**\\\\\\\\\\ ");
	}
	public static void mid() {
		System.out.println("|../\\..../\\..|");
		System.out.println("|./\\/\\../\\/\\.|");
		System.out.println("|/\\/\\/\\/\\/\\/\\|");
		System.out.println("|\\/\\/\\/\\/\\/\\/|");
		System.out.println("|.\\/\\/..\\/\\/.|");
		System.out.println("|..\\/....\\/..|");
	}
	public static void line() {
		System.out.print("+=*=*=*=*=*=*+);
	} 
	*/