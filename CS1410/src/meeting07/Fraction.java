package meeting07;

public class Fraction {

	// instance variables
	private int numerator;
	private int denominator;

	// constructors
	public Fraction() {
		numerator = 1;
		denominator = 1;
	}

	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	// instance methods
	public double toDouble() {
		return numerator / (double) denominator;
	}

	public String toString() {
		return numerator + "/" + denominator;
	}

	// getter
	public int getNumerator() {
		return numerator;
	}

	// setter
	public void setNumerator(int number) {
		numerator = number;
	}

	public void printTwoObjects(Fraction otherFrac) {
		System.out.println("This object's variables: " + this.numerator + " " + this.denominator);
		System.out.println("Other object's variables " + otherFrac.numerator + " " + otherFrac.denominator);
	}

	public boolean equals(Object other) {
		if (!(other instanceof Fraction)) {
			return false;
		}
		Fraction otherFraction = (Fraction) other;
		return this.numerator == otherFraction.numerator && this.denominator == otherFraction.denominator;
	}
}
