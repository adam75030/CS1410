package lab02;

import java.util.Scanner;

public class ScannerPractice {

	public static void main(String[] args) {
//		Scanner classInfo = new Scanner("CS1410 2024");
//
//		boolean stringAvailable = classInfo.hasNext();
//		String token = classInfo.next();
//		System.out.println(stringAvailable + " " + token);
//
//		stringAvailable = classInfo.hasNext();
//		token = classInfo.next();
//		System.out.println(stringAvailable + " " + token);
//
//		stringAvailable = classInfo.hasNextInt();
//		int year = classInfo.nextInt();
//		System.out.println(stringAvailable + " " + year);
//		
		Scanner input = new Scanner(System.in);
		while(input.hasNext()) {
		   System.out.println(input.next());
		}

	}
}
