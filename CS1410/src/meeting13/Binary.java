package meeting13;

public class Binary {
	public static void main(String[] args) {
		int rgb = 0b00000000_11001100_10101010_11110000;
		System.out.println(rgb);
		System.out.println((rgb >> 8) & 255);
		System.out.println(0b10101010);
	}
}
