package meeting18;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class implements a Memory Game GUI.
 * 
 * This is the fourth version of the GUI built in class, 
 * with buttons included, listening for when each button 
 * is selected, and detection of when matches are made.
 * 
 * @author Prof. Martin
 * @version Mar 27, 2024
 */
public class MemoryFrame4 extends JFrame implements ActionListener {
	
	// buttons on game board currently selected
	private ArrayList<MemoryButton> buttonsSelected;

	/**
	 * Creates a Memory Game GUI.
	 */
	public MemoryFrame4() {
		
		// Exit on close
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Create a container to hold and organize the 16 buttons
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4));
		
		// Create 16 buttons and for each button: 
		//    --construct the button and hide a secret value
		//    --add the button to the container (so it can be seen)
		//    --add a listener for the button (what to do when user selects)
		
		ArrayList<Integer> secretValues = generateSecretValues(8);
	
		for(int i = 0; i < 16; i++) {
			MemoryButton button = new MemoryButton(secretValues.get(i));
			button.setFont(new Font("Dialog", Font.PLAIN, 100));
			panel.add(button);
			button.addActionListener(this);
		}
		
		// Keep track of buttons selected by the user, none yet
		buttonsSelected = new ArrayList<MemoryButton>();
		
		// Set up the JFrame
		this.setTitle("Memory");
		this.setContentPane(panel);
		this.setPreferredSize(new Dimension(600, 600));
		this.pack();
	}
	
	/**
	 * This is the method that is invoked when a button is selected.
	 * 
	 * @param -- an object the represents the event of the button 
	 *           being selected
	 */
	public void actionPerformed(ActionEvent e) {	
		
		// Get the button just selected by user
		MemoryButton button = (MemoryButton)e.getSource();
		
		// Show the value for the button
		button.showValue();
		
		// Keep track of this button for future rounds, print list
		this.buttonsSelected.add(button);
		
		System.out.println("Buttons selected " + buttonsSelected);
		
		// If this is the second button of a pair, check for a match, then clear
		if (this.buttonsSelected.size() == 2) {
			if (button.getValue() == buttonsSelected.get(0).getValue()) {
				System.out.println("MATCH!!!");
			}
			buttonsSelected.clear();
		}
		
		// Poll Q: What would be the impact of making buttonsSelected a local variable
		// instead of a class instance variable?
		// A) The code would not compile
		// B) There would be no effect on gameplay, but it would be less efficient
		// C) The game would never detect a match
		// D) The game would detect a match for every click no matter what
	}
	
	/** 
	 * Generates a list of integers 1 to limit, two of each, 
	 * randomly shuffled.
	 * 
	 * (This is a helper method for the constructor -- make private.)
	 * 
	 * @param limit -- the largest integer generated
	 * @returns an ArrayList of integers
	 */
	private ArrayList<Integer> generateSecretValues(int limit) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= limit; i++) {
			list.add(i);
			list.add(i);
		}	
		Collections.shuffle(list);
		return list;
	}
	
	// Required by a serializable class (ignore for now)
	private static final long serialVersionUID = 1L;
}