package assign09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.awt.event.ActionEvent;
import java.util.Arrays;

/**
 * This class contains tests for the LightsOutFrame class.
 * 
 * @author Prof. Martin and Adam Wightman
 * @version April 3, 2024
 */
public class LightsOutFrameTest {

	@Test
	public void testToggleLight() {
		LightsOutFrame frame = new LightsOutFrame();
		boolean initialState = frame.lightIsOn(1, 2);
		boolean initialStateNorth = frame.lightIsOn(0, 2);
		boolean initialStateEast = frame.lightIsOn(1, 3);
		boolean initialStateSouth = frame.lightIsOn(2, 2);
		boolean initialStateWest = frame.lightIsOn(1, 1);

		frame.toggleLight(1, 2);
		assertEquals(!initialState, frame.lightIsOn(1, 2));
		assertEquals(!initialStateNorth, frame.lightIsOn(0, 2));
		assertEquals(!initialStateEast, frame.lightIsOn(1, 3));
		assertEquals(!initialStateSouth, frame.lightIsOn(2, 2));
		assertEquals(!initialStateWest, frame.lightIsOn(1, 1));
	}

	@Test
	public void testToggleLightException() {
		LightsOutFrame frame = new LightsOutFrame();
		assertThrows(IndexOutOfBoundsException.class, () -> {
			frame.toggleLight(5, 3);
		});
	}

	@Test
	public void testRandomize() {
		// collect initial on/off info for each button
		LightsOutFrame frame = new LightsOutFrame();
		Boolean[] buttonStates1 = new Boolean[25];
		int index = -1;
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				buttonStates1[++index] = frame.lightIsOn(i, j);

		frame.randomize();
		// collect new on/off info for each button
		Boolean[] buttonStates2 = new Boolean[25];
		index = -1;
		for (int i = 0; i < 5; i++)
			for (int j = 0; j < 5; j++)
				buttonStates2[++index] = frame.lightIsOn(i, j);

		assertFalse(Arrays.deepEquals(buttonStates1, buttonStates2));
	}

	@Test
	public void testButtonClicked() {
		LightsOutFrame frame = new LightsOutFrame();
		boolean initialState = frame.lightIsOn(1, 2);
		frame.actionPerformed(new ActionEvent(new LightsOutButton(1, 2), 0, ""));
		assertEquals(!initialState, frame.lightIsOn(1, 2));
	}

	@Test
	public void testButtonClickedNegative() {
		LightsOutFrame frame = new LightsOutFrame();
		assertThrows(IndexOutOfBoundsException.class, () -> {
			frame.actionPerformed(new ActionEvent(new LightsOutButton(-1, -2), 0, ""));
		}, "failed to throw exception");
	}

	@Test
	public void testButtonClickedTooHigh() {
		LightsOutFrame frame = new LightsOutFrame();
		assertThrows(IndexOutOfBoundsException.class, () -> {
			frame.actionPerformed(new ActionEvent(new LightsOutButton(10, 10), 0, ""));
		}, "failed to throw exception");
	}

	@Test
	public void testManualMode() {
		LightsOutFrame frame = new LightsOutFrame();
		assertFalse(frame.getManualSetupMode());
		frame.actionPerformed(new ActionEvent(frame.getManualSetupButton(), 0, ""));
		assertTrue(frame.getManualSetupMode());
	}
}