package meeting18;

/**
 * This class executes the Memory Game GUI program.
 * 
 * @author Prof. Martin
 * @version Mar 27, 2024
 */
public class MemoryProgram {
	
	public static void main(String[] args) {
		// Create and launch the GUI
//		MemoryFrame1 m = new MemoryFrame1(); // An empty Frame with a panel and layout
//		MemoryFrame2 m = new MemoryFrame2(); // Create a Button class, add them to grid
//		MemoryFrame3 m = new MemoryFrame3(); // Make the buttons show their values when clicked
//		MemoryFrame4 m = new MemoryFrame4(); // Detect matches
		MemoryFrame m = new MemoryFrame();
		m.setVisible(true);
	}
}