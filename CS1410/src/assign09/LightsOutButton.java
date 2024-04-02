package assign09;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * This class represents a LightsOutButton object. It extends JButton for button
 * functionality, and is used to control the lights for the game.
 * 
 * @author Adam Wightman
 * @version March 30, 2024
 */
public class LightsOutButton extends JButton {
	private int row;
	private int column;
	private boolean isOn;

	/**
	 * This constructor builds a default LightsOutButton given row and column
	 * parameters. The default value of the button is "off".
	 * 
	 * @param row    - the row index of the Button
	 * @param column - the column index of the Button
	 */
	public LightsOutButton(int row, int column) {
		super();
		this.row = row;
		this.column = column;
		this.isOn = false;
	}

	/**
	 * This method turns the light on if it was off, and turns the light off if it
	 * was on.
	 */
	void toggle() {
		Icon lightOn = new ImageIcon("light_on-1(1).jpg");
		Icon lightOff = new ImageIcon("light_off(1).jpg");
		if (isOn) {
			this.isOn = false;
			this.setIcon(lightOff);
		} else {
			this.isOn = true;
			this.setIcon(lightOn);
		}
	}

	/**
	 * Getter method to get the row index of this LightsOutButton.
	 * 
	 * @return row - the row index of the button
	 */
	public int getRow() {
		return this.row;
	}

	/**
	 * Getter method to get the column index of this LightsOutButton.
	 * 
	 * @return column - the column index of the button
	 */
	public int getColumn() {
		return this.column;
	}

	/**
	 * Getter method to get the current state of the LightsOutButton: (either on or
	 * off).
	 * 
	 * @return isOn - boolean representing the current state
	 */
	public boolean isOn() {
		return this.isOn;
	}

	private static final long serialVersionUID = 1L;
}
