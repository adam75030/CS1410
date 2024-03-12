package meeting08;

// import because Fraction is in a different package
import meeting07.Fraction;

public class FractionDemo {

	public static void main(String[] args) {
		Fraction f = new Fraction();
		System.out.println(f.getNumerator());

		Fraction half = new Fraction(1, 2);
		System.out.println(half.toDouble());

		// Objects need the .equals method
		Fraction otherHalf = new Fraction(1, 2);
		boolean areEqual = otherHalf.equals(half);
		System.out.println(areEqual);
	}
}
