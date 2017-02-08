package it.bruce.interfaces;

import java.util.Map;

/**
 * This is for getting every tax rates, supposing I've got 
 * them in any different type of sources (DB, prop files, xml....)
 * @author MB
 *
 */
public interface TaxesReader {
	
	Map<TaxesRatesCalulator.Type, Float> importTaxesRates(String sourcePath);

}
