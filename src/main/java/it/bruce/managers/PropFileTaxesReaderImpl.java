package it.bruce.managers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import it.bruce.interfaces.TaxesRatesCalulator.Type;
import it.bruce.interfaces.TaxesReader;

/**
 * Maps taxes rates form properties file to map
 * @author MB
 *
 */
public class PropFileTaxesReaderImpl implements TaxesReader {

	public Map<Type, Float> importTaxesRates() {
		
		
		Map<Type, Float> rates =  new HashMap<Type, Float>();
		Properties prop = new Properties();

		
			try(InputStream input = new FileInputStream("resources/config.properties");) {

			// load a properties file
			prop.load(input);

			rates.put(Type.BOOK,Float.valueOf(prop.getProperty("book")));
			rates.put(Type.MEDICAL,Float.valueOf(prop.getProperty("medical")));
			rates.put(Type.FOOD,Float.valueOf(prop.getProperty("food")));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		
		return rates;
	}

}
