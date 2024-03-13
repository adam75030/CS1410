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
		Pixel tan = new Pixel(210, 180, 140);
		assertEquals(210, tan.getRedAmount());
	}

	@Test
	public void testGetPackedRGBZero() {
		Pixel black = new Pixel(0, 0, 0);
		assertEquals(0, black.getPackedRGB());
	}
	
	@Test
	public void testGetPackedRGBSienna() {
		Pixel sienna = new Pixel(160,82,45);
		int packedSienna = sienna.getPackedRGB();  // should be 10506797
		assertEquals(10506797, sienna.getPackedRGB());
	}
}
