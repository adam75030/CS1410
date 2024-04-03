package assign09;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * This class builds the frame for the LightsOut game. It contains the 5x5 grid
 * of LightsOutButtons, and the other "randomize" and "manual setup" buttons.
 * 
 * @author Adam Wightman
 * @version March 30, 2024
 */
public class LightsOutFrame extends JFrame implements ActionListener {
	private LightsOutButton[][] gridLights;
	private JButton randomizeButton;
	private JButton manualSetupButton;
	private Boolean inManualSetupMode;

	/**
	 * This constructor creates the frame for the LightsOutGame. It adds lights to
	 * the 5x5 grid, and creates the panels to hold the setup buttons.
	 */
	public LightsOutFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Create the panel to hold the LightsOutButtons
		JPanel lightsPanel = new JPanel();
		lightsPanel.setLayout(new GridLayout(5, 5));

		gridLights = new LightsOutButton[5][5];
		Icon lightOff = new ImageIcon("light_off(1).jpg");

		// Add new LightsOutButtons to the lightsPanel
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				LightsOutButton button = new LightsOutButton(i, j);
				lightsPanel.add(button);
				button.setIcon(lightOff);
				button.addActionListener(this);
				gridLights[i][j] = button;
			}
		}

		// Create the panel to hold the randomize and manual setup buttons
		JPanel randomizeAndManualSetupPanel = new JPanel();
		randomizeAndManualSetupPanel.setLayout(new GridLayout(1, 2));
		randomizeButton = new JButton();
		randomizeButton.setText("Randomize");
		randomizeAndManualSetupPanel.add(randomizeButton);
		randomizeButton.addActionListener(this);

		manualSetupButton = new JButton();
		manualSetupButton.setText("Enter Manual Setup");
		randomizeAndManualSetupPanel.add(manualSetupButton);
		manualSetupButton.addActionListener(this);

		// Create the panel to house the lightsPanel and randomizeAndManualSetupPanel
		JPanel panelHolder = new JPanel();
		panelHolder.setLayout(new BorderLayout());
		panelHolder.add(lightsPanel, BorderLayout.CENTER);
		panelHolder.add(randomizeAndManualSetupPanel, BorderLayout.SOUTH);

		this.setContentPane(panelHolder);
		this.setTitle("Lights Out");
		this.setPreferredSize(new Dimension(600, 600));
		this.pack();

		this.inManualSetupMode = false;
		this.randomize();
	}

	void randomize() {
		Random random = new Random();
		// Repeat 9 times
		for (int i = 0; i < 9; i++) {
			// Use toggleLight and select a random row and column index
			int row = random.nextInt(5);
			int column = random.nextInt(5);
			toggleLight(row, column);
		}
	}

	/**
	 * Checks if the light at the given row and column is on. Returns true if the
	 * light is on.
	 * 
	 * @param row    - the row index of the light
	 * @param column - the column index of the light
	 * @return true if the light is on
	 */
	boolean lightIsOn(int row, int column) {
		if (row > 4 || row < 0 || column > 4 || column < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (gridLights[row][column].isOn()) {
			return true;
		}
		return false;
	}

	void toggleLight(int row, int column) {
		if (row > 4 || row < 0 || column > 4 || column < 0) {
			throw new IndexOutOfBoundsException();
		}
		// Center
		gridLights[row][column].toggle();
		// North
		if (gridLights[row][column].getRow() != 0) {
			gridLights[row - 1][column].toggle();
		}
		// South
		if (gridLights[row][column].getRow() != gridLights[0].length - 1) {
			gridLights[row + 1][column].toggle();
		}
		// East
		if (gridLights[row][column].getColumn() != gridLights.length - 1) {
			gridLights[row][column + 1].toggle();
		}
		// West
		if (gridLights[row][column].getColumn() != 0) {
			gridLights[row][column - 1].toggle();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Get the source of the button click
		Object button = (Object) e.getSource();
		// Manual Mode LightsOutButton click
		if (button instanceof LightsOutButton && inManualSetupMode) {
			int row = ((LightsOutButton) button).getRow();
			int column = ((LightsOutButton) button).getColumn();
			gridLights[row][column].toggle();
			// Regular game mode LightsOutButton click
		} else if (button instanceof LightsOutButton && !inManualSetupMode) {
			int row = ((LightsOutButton) button).getRow();
			int column = ((LightsOutButton) button).getColumn();
			toggleLight(row, column);
			win();
			// Randomize button click
		} else if (button instanceof JButton && ((JButton) button).equals(randomizeButton)) {
			randomize();
			// Manual Setup button click
		} else if (button instanceof JButton && ((JButton) button).equals(manualSetupButton) && inManualSetupMode) {
			manualSetupButton.setText("Enter Manual Setup");
			this.inManualSetupMode = false;
			// Manual Setup button click
		} else if (button instanceof JButton && ((JButton) button).equals(manualSetupButton) && !inManualSetupMode) {
			manualSetupButton.setText("Exit Manual Setup");
			this.inManualSetupMode = true;
		}
	}

	void win() {
		for (int i = 0; i < gridLights.length; i++) {
			for (int j = 0; j < gridLights[0].length; j++) {
				if (gridLights[i][j].isOn()) {
					return;
				}
			}
		}
		JOptionPane.showMessageDialog(this, "You Win!");
		this.setSize(350, 350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		System.exit(ABORT);
	}

	private static final long serialVersionUID = 1L;
}
