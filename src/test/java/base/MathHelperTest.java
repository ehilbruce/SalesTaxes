package base;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import it.bruce.helpers.MathHelper;

public class MathHelperTest {

	@Test
	public void roundTaxesTest() {
		assertEquals(23.60, MathHelper.roundTaxes(23.567d), 0);
	}
	
	@Test
	public void truncateNumberTest() {
		assertEquals(23.56, MathHelper.truncateNumberToSecondDigit(23.56787999d), 0);
	}
	
	@Test
	public void roundTotalTest() {
		assertEquals(23.58, MathHelper.roundTotal(23.5787999d,2), 0);
	}



}
