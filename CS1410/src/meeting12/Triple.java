package meeting12;

/**
 * A generic Triple class for Meeting 12
 */
public class Triple<X>{
	private X item1;
	private X item2;
	private X item3;
	
	public Triple(X i1, X i2, X i3) {
		item1 = i1;
		item2 = i2;
		item3 = i3;
	}
	
	public X getItem1() {
		return item1;
	}
	
	public String toString() {
		return "(" + item1 + ", " + item2 + ", " + item3 + ")";
	}
}
