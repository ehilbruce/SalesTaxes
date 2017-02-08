package it.bruce.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import it.bruce.interfaces.TaxesRatesCalulator.Type;
import it.bruce.interfaces.TaxesReader;

/**
 * Maps taxes rates form properties file to map
 * @author MB
 *
 */
public class PropFileTaxesReaderImpl implements TaxesReader {
	
	final static Logger logger = Logger.getLogger(TaxesReader.class);

	public Map<Type, Float> importTaxesRates(String sourcePath) {
		
		logger.error("Error loading tax rates");
		Map<Type, Float> rates =  new HashMap<Type, Float>();
		Properties prop = new Properties();

		//"resources/config.properties"
			try(InputStream input = new FileInputStream(sourcePath);) {

			// load a properties file
			prop.load(input);

			if(prop.getProperty("book")!=null)
				rates.put(Type.BOOK,Float.valueOf(prop.getProperty("book")));
			if(prop.getProperty("medical")!=null)
				rates.put(Type.MEDICAL,Float.valueOf(prop.getProperty("medical")));
			if(prop.getProperty("food")!=null)
				rates.put(Type.FOOD,Float.valueOf(prop.getProperty("food")));

		} catch (IOException ex) {
			logger.error("Error loading tax rates");
		}
		
		
		return rates;
	}

}
