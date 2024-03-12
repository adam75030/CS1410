package meeting05;

public class ExceptionDemo {

	public static void main(String[] args) {
		System.out.println(charInSecretPhrase(30));
	}

	/**
	 * Returns the character at the provided index in the secret phrase.
	 * @param index the index we want to look in the secret string
	 * @return a character at the index, or X if no character exists
	 */
	public static char charInSecretPhrase(int index) {
		String secretPhrase = "My password is PASSWORD";
		try {
			char returnChar = secretPhrase.charAt(index);
			// Note: we jump directly to the catch block if an exception happens
			return returnChar;
		} catch (StringIndexOutOfBoundsException myException) {
			System.out.println("Invalid index, returning X" + myException);
			//we keep running code if there is no return
		} catch (ArithmeticException e) {
			System.out.println("division by zero");
		}
		return 'X';
	}
}
