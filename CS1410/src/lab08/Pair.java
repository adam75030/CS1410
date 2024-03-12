package lab08;

public class Pair<LeftType, RightType> {
	private LeftType left;
	private RightType right;

	public Pair(LeftType initLeft, RightType initRight) {
		this.left = initLeft;
		this.right = initRight;
	}

	public String toString() {
		return "(" + this.left + ", " + this.right + ")";
	}
}
