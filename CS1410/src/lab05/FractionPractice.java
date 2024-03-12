package lab05;

public class FractionPractice {

	public static void main(String[] args) {
		// create four fractions: 0/1, 1/2, 3/4, and 1/1.
		Fraction zero = new Fraction();
		Fraction oneHalf = new Fraction(1, 2);
		Fraction threeFourths = new Fraction(3, 4);
		Fraction one = new Fraction(1, 1);

		System.out.println(zero.toString());
		System.out.println(oneHalf.toDouble());
		System.out.println(threeFourths.toString());
		System.out.println(one.toDouble());
		
		oneHalf.addOne();
		System.out.println(oneHalf);
		
		Fraction f = new Fraction(21, 6);
		f.reduce();
		System.out.println(f.toString());
	}

}
