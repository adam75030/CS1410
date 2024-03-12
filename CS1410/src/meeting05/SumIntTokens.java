package meeting05;

import java.util.Scanner;

public class SumIntTokens {

	public static void main(String[] args) {
		System.out.println(sumIntTokens("1 2 3 hello"));
	}

	public static int sumIntTokens(String text) {
		Scanner scanner = new Scanner(text);
		int sum = 0;
		while (scanner.hasNext()) {
			if (scanner.hasNextInt()) {
				sum += scanner.nextInt();
			} else {
				scanner.next();
			}
		}
		scanner.close();
		return sum;
	}
}
