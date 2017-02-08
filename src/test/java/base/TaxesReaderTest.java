package base;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Properties;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import it.bruce.helpers.PropFileTaxesReaderImpl;
import it.bruce.interfaces.TaxesRatesCalulator.Type;

public class TaxesReaderTest extends BaseTest{

	
	@BeforeClass
	protected void setUp() throws Exception {
		
		Properties prop = new Properties();
		try (OutputStream output = new FileOutputStream("test.properties");) {

			prop.setProperty("book", "6");
			// save properties to project root folder
			prop.store(output, null);

		} catch (IOException io) {
			logger.error("Can't write prop file");
		}
	}
	
	@Test
	public void testReader() {
		PropFileTaxesReaderImpl reader = new PropFileTaxesReaderImpl();
		Map<Type, Float> rates = reader.importTaxesRates("test.properties");
		assertEquals(rates.get(Type.BOOK), 6.0f);
	}

	
	

	 @AfterClass
	 protected  void tearDown() {
	        File file = new File("test.properties");

    		if(file.delete()){
    			logger.debug("Test prop file deleted");
    		}else{
    			logger.error("Can't delete test prop file");
    		}
	        
	 }
}
