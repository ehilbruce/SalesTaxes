package base;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import it.bruce.helpers.PropFileTaxesReaderImpl;
import it.bruce.interfaces.TaxesRatesCalulator;
import it.bruce.interfaces.TaxesReader;
import it.bruce.interfaces.TaxesRatesCalulator.Type;
import junit.framework.TestCase;

public class BaseTest extends TestCase {
	

	final static Logger logger = Logger.getLogger(BaseTest.class);

	
	TaxesReader reader;
	protected Map<TaxesRatesCalulator.Type, Float> specialRatesMap;
	protected TaxesRatesCalulator printerService;
	
	@BeforeClass
	protected void setUp() throws Exception {
		
		 logger.debug("Setting up basic objects");
		 specialRatesMap = new HashMap<TaxesRatesCalulator.Type, Float>();
		 specialRatesMap.put(Type.BOOK, 0f);
		 specialRatesMap.put(Type.MEDICAL, 0f);
		 specialRatesMap.put(Type.FOOD, 0f);
		 specialRatesMap.put(Type.ORDINARY, 0.1f);
	       		
		 reader =Mockito.mock(TaxesReader.class);
		 Mockito.when(reader.importTaxesRates("test")).thenReturn(specialRatesMap);
	
		 printerService = Mockito.mock(TaxesRatesCalulator.class);
	}
	
	
	@Test
	public void test() {
		logger.debug("just warming up");
	}


}
