package meeting18;

import javax.swing.JButton;

/**
 * This class represents a button in the Memory Game with GUI.
 * 
 * @author Prof. Martin
 * @version Mar 27, 2024
 */
public class MemoryButton extends JButton {

	// Need an instance variable to store the hidden value
	private int secretValue;
	
	/** 
	 * Create a button for the Memory Game.
	 * 
	 * @param secretValue - the value to hide under a ?
	 */
	public MemoryButton(int secretValue) {
		super("?");
		this.secretValue = secretValue;
	}

	/**
	 * Make the secret value visible to the player.
	 */
	public void showValue() {
		// How to change the text of a button??
		this.setText("" + secretValue);
	}
	
	/**
	 * Hide the secret value from the player.
	 */
	public void hideValue() {
		this.setText("?");
	}
	
	/**
	 * Getter for the secret value.
	 */
	public int getValue() {
		return secretValue;
	}
	
	/**
	 * A string representation of this button.
	 */
	public String toString() {
		return "" + secretValue;
	}
	
	// Required by a serializable class (ignore for now)
	private static final long serialVersionUID = 1L;
}