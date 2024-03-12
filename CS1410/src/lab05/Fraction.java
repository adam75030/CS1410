package lab05;

/**
 * This class represents a fraction; e.g., 1/2.
 *
 * @author Drs. Kabir and Martin
 * @version Lab 5
 */
public class Fraction {

	private int numerator;
	private int denominator;

	/**
	 * This constructor builds a "default" Fraction object 0/1.
	 */
	public Fraction() {
		this.numerator = 0;
		this.denominator = 1;
	}

	/**
	 * This constructor builds a Fraction object, given a numerator and denominator.
	 *
	 * @param numerator   - value for initializing the numerator
	 * @param denominator - value for initializing the denominator
	 */
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	/**
	 * This constructor builds a Fraction object, with given numerator and
	 * denominator as 1.
	 *
	 * @param numerator - value for initializing the numerator
	 */
	public Fraction(int numerator) {
		this.numerator = numerator;
		this.denominator = 1;
	}

	/**
	 * Getter method for accessing the numerator of this Fraction object.
	 *
	 * @return the numerator
	 */
	public int getNumerator() {
		return this.numerator;
	}

	/**
	 * Getter method for accessing the denominator of this Fraction object.
	 *
	 * @return the denominator
	 */
	public int getDenominator() {
		return this.denominator;
	}

	/**
	 * This method calculates the decimal-point equivalent of this Fraction object.
	 *
	 * @return the decimal-point equivalent
	 */
	public double toDouble() {
		return this.numerator / (double) this.denominator;
	}

	/**
	 * This method generates a textual representation of this Fraction object.
	 *
	 * @return a string containing the textual representation
	 */
	public String toString() {
		return this.numerator + "/" + this.denominator;
	}

	/**
	 * This method adds 1 to a fraction by adding the denominator value to the
	 * numerator
	 */
	public void addOne() {
		int num = this.denominator;
		this.numerator += num;
	}

	/**
	 * This method computes the GCD of this Fraction object's numerator and
	 * denominator.
	 * 
	 * @return the GCD
	 */
	private int gcd() {
		// a = numerator
		int a = numerator;
		// b = denominator
		int b = denominator;

		// while b is not 0
		while (b != 0) {
			// set t to b
			int t = b;
			// set b to a mod b
			b = a % b;
			// set a to t
			a = t;
		}
		// when the loop terminates, a is the GCD
		return a;
	}

	/**
	 * This method reduced this Fraction object to its simplest form.
	 */
	public void reduce() {
		int gcd = this.gcd();
		this.numerator /= gcd;
		this.denominator /= gcd;
	}

	/**
	 * This method determines whether this Fraction object and the given object are
	 * equal.
	 *
	 * @param other - the other object to compare
	 * @return true if the two objects are equal, false otherwise
	 */
	public boolean equals(Object other) {
		if (!(other instanceof Fraction))
			return false;
		Fraction otherFraction = (Fraction) other;
		return this.numerator == otherFraction.numerator && this.denominator == otherFraction.denominator;
	}
}
