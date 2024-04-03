package assign08;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * This class contains tests for the Tool, Armor, Magic, and Upgrade classes.
 * 
 * @author Adam Wightman
 * @version March 29, 2024
 */
class ItemTest {

	/////////////////
	// Tool Tests: //
	/////////////////
	@Test
	public void testCompareTwoToolsLessThan() {
		Tool testTool = new Tool("testTool", 30);
		Tool greaterTool = new Tool("greaterTool", 31);
		assertTrue(testTool.compareTo(greaterTool) < 0);
	}

	@Test
	public void testCompareTwoToolsGreaterThan() {
		Tool testTool = new Tool("testTool", 20);
		Tool lessTool = new Tool("lessTool", 19);
		assertTrue(testTool.compareTo(lessTool) > 0);
	}

	@Test
	public void testCompareTwoToolsEqual() {
		Tool testTool = new Tool("testTool", 20);
		Tool equalTool = new Tool("equalTool", 20);
		assertEquals(testTool.compareTo(equalTool), 0);
	}

	@Test
	public void testCompareToolToArmor() {
		Tool testTool = new Tool("testTool", 25);
		Armor testArmor = new Armor("testArmor", 50);
		assertTrue(testTool.compareTo(testArmor) > 0);
	}

	@Test
	public void testCompareToolToMagic() {
		Tool testTool = new Tool("testTool", 25);
		Magic testMagic = new Magic("testMagic", 50, 5);
		assertTrue(testTool.compareTo(testMagic) > 0);
	}

	@Test
	public void testCompareToolToUpgrade() {
		Tool testTool = new Tool("testTool", 25);
		Upgrade testUpgrade = new Upgrade();
		assertTrue(testTool.compareTo(testUpgrade) > 0);
	}

	/////////////////
	// Armor Tests //
	/////////////////
	@Test
	public void testCompareTwoArmorsLessThan() {
		Armor testArmor = new Armor("testArmor", 30);
		Armor greaterArmor = new Armor("greaterArmor", 31);
		assertTrue(testArmor.compareTo(greaterArmor) < 0);
	}

	@Test
	public void testCompareTwoArmorsGreaterThan() {
		Armor testArmor = new Armor("testArmor", 30);
		Armor lessArmor = new Armor("lessArmor", 29);
		assertTrue(testArmor.compareTo(lessArmor) > 0);
	}

	@Test
	public void testCompareTwoArmorsEqual() {
		Armor testArmor = new Armor("testArmor", 30);
		Armor equalArmor = new Armor("equalArmor", 30);
		assertEquals(testArmor.compareTo(equalArmor), 0);
	}

	@Test
	public void testCompareArmorToTool() {
		Armor testArmor = new Armor("testArmor", 30);
		Tool testTool = new Tool("testTool", 15);
		assertTrue(testArmor.compareTo(testTool) < 0);
	}

	@Test
	public void testCompareArmorToMagic() {
		Armor testArmor = new Armor("testArmor", 30);
		Magic testMagic = new Magic("testMagic", 50, 5);
		assertTrue(testArmor.compareTo(testMagic) > 0);
	}

	@Test
	public void testCompareArmorToUpgrade() {
		Armor testArmor = new Armor("testArmor", 30);
		Upgrade testUpgrade = new Upgrade();
		assertTrue(testArmor.compareTo(testUpgrade) > 0);
	}

	//////////////////
	// Magic Tests: //
	//////////////////
	@Test
	public void testCompareTwoMagicsLessThan() {
		Magic testMagic = new Magic("testMagic", 30, 5);
		Magic greaterMagic = new Magic("greater", 31, 5);
		assertTrue(testMagic.compareTo(greaterMagic) < 0);
	}

	@Test
	public void testCompareTwoMagicsGreaterThan() {
		Magic testMagic = new Magic("testMagic", 30, 5);
		Magic lessMagic = new Magic("less", 29, 5);
		assertTrue(testMagic.compareTo(lessMagic) > 0);
	}

	@Test
	public void testCompareTwoMagicsEqual() {
		Magic testMagic = new Magic("testMagic", 30, 5);
		Magic equalMagic = new Magic("equal", 30, 5);
		assertEquals(testMagic.compareTo(equalMagic), 0);
	}

	@Test
	public void testCompareMagicToTool() {
		Magic testMagic = new Magic("testMagic", 30, 5);
		Tool testTool = new Tool("testTool", 30);
		assertTrue(testMagic.compareTo(testTool) < 0);
	}

	@Test
	public void testCompareMagicToArmor() {
		Magic testMagic = new Magic("testMagic", 30, 5);
		Armor testArmor = new Armor("testArmor", 30);
		assertTrue(testMagic.compareTo(testArmor) < 0);
	}

	@Test
	public void testCompareMagicToUpgrade() {
		Magic testMagic = new Magic("testMagic", 30, 5);
		Upgrade testUpgrade = new Upgrade();
		assertTrue(testMagic.compareTo(testUpgrade) > 0);
	}

	////////////////////
	// Upgrade Tests: //
	////////////////////
	@Test
	public void testCompareTwoUpgradesLessThan() {
		Upgrade testUpgrade = new Upgrade();
		Upgrade greaterUpgrade = new Upgrade();
		testUpgrade.useUpgrade();
		assertTrue(testUpgrade.compareTo(greaterUpgrade) < 0);
	}

	@Test
	public void testCompareTwoUpgradesGreaterThan() {
		Upgrade testUpgrade = new Upgrade();
		Upgrade lessUpgrade = new Upgrade();
		lessUpgrade.useUpgrade();
		assertTrue(testUpgrade.compareTo(lessUpgrade) > 0);
	}

	@Test
	public void testCompareTwoUpgradesEqualUnused() {
		Upgrade testUpgrade = new Upgrade();
		Upgrade otherUpgrade = new Upgrade();
		assertEquals(testUpgrade.compareTo(otherUpgrade), 0);
	}

	@Test
	public void testCompareTwoUpgradesEqualUsed() {
		Upgrade testUpgrade = new Upgrade();
		Upgrade otherUpgrade = new Upgrade();
		testUpgrade.useUpgrade();
		otherUpgrade.useUpgrade();
		assertEquals(testUpgrade.compareTo(otherUpgrade), 0);
	}

	@Test
	public void testCompareUpgradeToTool() {
		Upgrade testUpgrade = new Upgrade();
		Tool testTool = new Tool("testTool", 50);
		assertTrue(testUpgrade.compareTo(testTool) < 0);
	}

	@Test
	public void testCompareUpgradeToArmor() {
		Upgrade testUpgrade = new Upgrade();
		Armor testArmor = new Armor("testArmor", 50);
		assertTrue(testUpgrade.compareTo(testArmor) < 0);
	}

	@Test
	public void testCompareUpgradeToMagic() {
		Upgrade testUpgrade = new Upgrade();
		Magic testMagic = new Magic("testMagic", 50, 5);
		assertTrue(testUpgrade.compareTo(testMagic) < 0);
	}
}
