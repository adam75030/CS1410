package assign09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This class contains tests for the LightsOutButton class.
 * 
 * @author Prof. Martin and ?
 * @version ?
 */
public class LightsOutButtonTest {
	
	@Test
	public void testGetRow() {
		LightsOutButton button = new LightsOutButton(3, 4);
		assertEquals(3, button.getRow());
	}
	
	@Test
	public void testIsOn() {
		LightsOutButton button = new LightsOutButton(0, 3);
		assertFalse(button.isOn());
	}	
	
	@Test
	public void testToggle() {
		LightsOutButton button = new LightsOutButton(1, 1);
		button.toggle();
		assertTrue(button.isOn());
	}	
}