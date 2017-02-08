package base;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import it.bruce.interfaces.TaxesRatesCalulator.Type;
import it.bruce.managers.PropFileTaxesReaderImpl;

public class TaxesReaderTest {

	@Test
	public void test() {
		
		PropFileTaxesReaderImpl reader = new PropFileTaxesReaderImpl();
		Map<Type, Float> rates = reader.importTaxesRates();
		
		fail("Not yet implemented");
	}

}
