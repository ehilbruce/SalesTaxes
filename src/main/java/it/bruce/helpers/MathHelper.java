package it.bruce.helpers;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Small helper to manipulate numbers
 * @author MB
 *
 */
public class MathHelper {

	/**
	 * up to the nearest 0.05
	 * @param number
	 * @return
	 */
	public static double roundTaxes(double number){
		double partial = (double) Math.ceil(number / 0.05f) * 0.05f;
		return truncateNumberToSecondDigit(partial);
	}

	public static double truncateNumberToSecondDigit(double inputDouble){
		return (double)(Math.floor(inputDouble * 100) / 100);
	}
	
	public static double roundTotal(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

	
}
