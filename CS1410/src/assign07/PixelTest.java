package assign07;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This class contains tests for the Pixel class.
 *
 * @author Drs. Kabir, Martin and Adam Wightman
 * @version March 12, 2024
 */
public class PixelTest {

	@Test
	public void testGetRedAmount() {
		Pixel test = new Pixel(210, 180, 140);
		assertEquals(210, test.getRedAmount());
	}

	@Test
	public void testGetRedAmountZero() {
		Pixel test = new Pixel(0, 180, 140);
		assertEquals(0, test.getRedAmount());
	}

	@Test
	public void testGetRedAmount255() {
		Pixel test = new Pixel(255, 180, 140);
		assertEquals(255, test.getRedAmount());
	}

	@Test
	public void testGetGreenAmount() {
		Pixel test = new Pixel(255, 180, 140);
		assertEquals(180, test.getGreenAmount());
	}

	@Test
	public void testGetGreenAmountZero() {
		Pixel test = new Pixel(255, 0, 140);
		assertEquals(0, test.getGreenAmount());
	}

	@Test
	public void testGetGreenAmount255() {
		Pixel test = new Pixel(255, 255, 140);
		assertEquals(255, test.getGreenAmount());
	}

	@Test
	public void testGetBlueAmount() {
		Pixel test = new Pixel(210, 180, 140);
		assertEquals(140, test.getBlueAmount());
	}

	@Test
	public void testGetBlueAmountZero() {
		Pixel test = new Pixel(210, 180, 0);
		assertEquals(0, test.getBlueAmount());
	}

	@Test
	public void testGetBlueAmount255() {
		Pixel test = new Pixel(210, 180, 255);
		assertEquals(255, test.getBlueAmount());
	}

	@Test
	public void testGetPackedRGB() {
		Pixel test = new Pixel(210, 180, 140);
		assertEquals(13808780, test.getPackedRGB());
	}

	@Test
	public void testGetPackedRGBMaximum() {
		Pixel white = new Pixel(255, 255, 255);
		assertEquals(16777215, white.getPackedRGB());
	}

	@Test
	public void testGetPackedRGBZero() {
		Pixel black = new Pixel(0, 0, 0);
		assertEquals(0, black.getPackedRGB());
	}
}
