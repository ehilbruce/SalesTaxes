package taxes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.mockito.Mockito;

import base.BaseTest;
import it.bruce.calculators.TaxesCalculatorImpl;
import it.bruce.helpers.MathHelper;
import it.bruce.interfaces.TaxesRatesCalulator;
import it.bruce.interfaces.TaxesRatesCalulator.Type;
import it.bruce.model.Item;

public class TaxesCalculatorTest extends BaseTest {

//	 Map<TaxesRatesCalulator.Type, Float> specialRatesMap;
//	 TaxesRatesCalulator printerService;

	 @Override
	 protected  void setUp() {
		 System.out.println("BRUCEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
		 specialRatesMap = new HashMap<TaxesRatesCalulator.Type, Float>();
		 specialRatesMap.put(Type.BOOK, 0f);
		 specialRatesMap.put(Type.MEDICAL, 0f);
		 specialRatesMap.put(Type.FOOD, 0f);
		 specialRatesMap.put(Type.ORDINARY, 0.1f);
	       
		   
					Item item = new Item(12.49d, new TaxesCalculatorImpl(Type.BOOK,  specialRatesMap, false), "testBook");
				
		 
		   printerService = Mockito.mock(TaxesRatesCalulator.class);

		  // define return value for method getUniqueId()

	 }
	
	@Test
	public void testRound() {
		
		double toRound = 23.02d;
		double result = MathHelper.roundTaxes(toRound);
		assertEquals(23.05d, result, 0);
		
		toRound = 23.05d;
		result = MathHelper.roundTaxes(toRound);
		assertEquals(23.05d, result, 0);
		
		
		toRound = 23.051d;
		result = MathHelper.roundTaxes(toRound);
		assertEquals(23.10d, result, 0);
		
		
		toRound = 23.11d;
		result = MathHelper.roundTaxes(toRound);
		assertEquals(23.15d, result, 0);
		
		
		toRound = 23.00005d;
		result = MathHelper.roundTaxes(toRound);
		assertEquals(23.05d, result, 0);
		
		toRound = 1.899d;
		result = MathHelper.roundTaxes(toRound);
		assertEquals(1.9d, result, 0);
		
	}
	
	
	@Test
	public void testItemTaxes() {
		Item item = new Item(12.49d, new TaxesCalculatorImpl(Type.BOOK,  specialRatesMap, false), "testBook");
		
//		 Mockito.when(printerService.getTotalTaxesAmount(item)).thenReturn(43d);
      
//		 System.out.println("BRUCE " + printerService.getTotalTaxesAmount(item));
	 
		
	
//		 System.out.println(item.getTotalCostAmount());
		assertEquals(12.49d, item.getTotalCostAmount(), 0);
		
		item = new Item(14.99d, new TaxesCalculatorImpl(Type.ORDINARY,  specialRatesMap, false), "musicCd");
		
		assertEquals(16.49d, item.getTotalCostAmount(), 0);
		
		item = new Item(47.50d, new TaxesCalculatorImpl(Type.ORDINARY,  specialRatesMap, true), "imported bottle parfume");
		
		assertEquals(54.65d, item.getTotalCostAmount(), 0);
		
		item = new Item(18.99d,  new TaxesCalculatorImpl(Type.ORDINARY,  specialRatesMap, false), "bottle of perfume ");

		assertEquals(20.89d, item.getTotalCostAmount(), 0);
		
	}
	
	
	@Test
	public void testItemTaxesMock() {
		Item item = new Item(12.49d, new TaxesCalculatorImpl(Type.BOOK,  specialRatesMap, false), "testBook");
		
		 Mockito.when(printerService.getTotalTaxesAmount(item)).thenReturn(0d);
      
		 System.out.println("BRUCE " + printerService.getTotalTaxesAmount(item));
	 
		
	
		 System.out.println(item.getTotalCostAmount());
		assertEquals(12.49d, item.getTotalCostAmount(), 0);
		
		item = new Item(14.99d, printerService , "musicCd");
		
		 Mockito.when(printerService.getTotalTaxesAmount(item)).thenReturn(1.5d);
		
		assertEquals(16.49d, item.getTotalCostAmount(), 0);
		
		
		item = new Item(47.50d,printerService, "imported bottle parfume");
		Mockito.when(printerService.getTotalTaxesAmount(item)).thenReturn(7.15d);
		
		assertEquals(54.65d, item.getTotalCostAmount(), 0);
		
		item = new Item(18.99d, printerService, "bottle of perfume ");
		Mockito.when(printerService.getTotalTaxesAmount(item)).thenReturn(1.9d);
		
		assertEquals(20.89d, item.getTotalCostAmount(), 0);
		
	}

}
