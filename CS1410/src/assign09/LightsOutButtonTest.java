package assign09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This class contains tests for the LightsOutButton class.
 * 
 * @author Prof. Martin and Adam Wightman
 * @version April 3, 2024
 */
public class LightsOutButtonTest {

	@Test
	public void testGetRow() {
		LightsOutButton button = new LightsOutButton(3, 4);
		assertEquals(3, button.getRow());
	}

	@Test
	public void testGetRowZero() {
		LightsOutButton button = new LightsOutButton(0, 0);
		assertEquals(0, button.getRow());
	}

	@Test
	public void testGetRowTooHigh() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			LightsOutButton button = new LightsOutButton(10, 10);
			button.getRow();
		}, "failed to throw exception");
	}

	@Test
	public void testGetRowNegative() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			LightsOutButton button = new LightsOutButton(-10, 10);
			button.getRow();
		}, "failed to throw exception");
	}

	@Test
	public void testGetColumn() {
		LightsOutButton button = new LightsOutButton(3, 4);
		assertEquals(4, button.getColumn());
	}

	@Test
	public void testGetColumnZero() {
		LightsOutButton button = new LightsOutButton(0, 0);
		assertEquals(0, button.getColumn());
	}

	@Test
	public void testGetColumnTooHigh() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			LightsOutButton button = new LightsOutButton(10, 10);
			button.getColumn();
		}, "failed to throw exception");
	}

	@Test
	public void testGetColumnNegative() {
		assertThrows(IndexOutOfBoundsException.class, () -> {
			LightsOutButton button = new LightsOutButton(-10, 10);
			button.getColumn();
		}, "failed to throw exception");
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