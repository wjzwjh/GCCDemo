package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import GCCDemoCalculator.IOhmValueCalculator;

class OhmCalculateTest {

	@Test
	void test() {
		IOhmValueCalculator calculator = new IOhmValueCalculator();
		String OhmValue = calculator.CalculateOhmValue("yellow", "blue", "brown", "gold");
		assertTrue(OhmValue.contains("460"));
		assertTrue(OhmValue.contains("5%"));
		
		String OhmValue2 = calculator.CalculateOhmValue("yellow", "blue", "red", "silver");
		assertTrue(OhmValue2.contains("4.6K"));
		assertTrue(OhmValue2.contains("10%"));
		
		String OhmValue3 = calculator.CalculateOhmValue("orange", "blue", "orange", "silver");
		assertTrue(OhmValue3.contains("36.0K"));
		assertTrue(OhmValue3.contains("10%"));
		
		String OhmValue4 = calculator.CalculateOhmValue("wHITE", "orange", "green", "silver");
		assertTrue(OhmValue4.contains("9.3M"));
		assertTrue(OhmValue4.contains("10%"));
		
		String OhmValue5 = calculator.CalculateOhmValue("violet", "white", "blue", "brown");
		assertTrue(OhmValue5.contains("79.0M"));
		assertTrue(OhmValue5.contains("1%"));
		
		String OhmValue6 = calculator.CalculateOhmValue("violet", "blue", "gray", "blue");
		assertTrue(OhmValue6.contains("7.6G"));
		assertTrue(OhmValue6.contains(".25%"));
		
		String OhmValue7 = calculator.CalculateOhmValue("orange", "wHITE", "wHITE", "green");
		assertTrue(OhmValue7.contains("39.0G"));
		assertTrue(OhmValue7.contains(".5%"));
		
		
	}

}
