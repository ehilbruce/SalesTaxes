package it.bruce.main;

import java.util.Map;

import org.apache.log4j.PropertyConfigurator;

import it.bruce.calculators.TaxesCalculatorImpl;
import it.bruce.helpers.PropFileTaxesReaderImpl;
import it.bruce.helpers.StOutReceiptPrinter;
import it.bruce.interfaces.TaxesRatesCalulator.Type;
import it.bruce.model.Item;
import it.bruce.model.Order;

public class Main {

	public static void main(String[] args) {
		
		PropertyConfigurator.configure("log4j.properties");
		
		
		PropFileTaxesReaderImpl reader = new PropFileTaxesReaderImpl();
		Map<Type, Float> rates = reader.importTaxesRates("resources/taxes.properties");
		
		Order order =  new Order(new StOutReceiptPrinter());
		order.addItem(new Item(12.49d,  new TaxesCalculatorImpl(Type.BOOK,  rates, false), "book"));
		order.addItem(new Item(14.99d,  new TaxesCalculatorImpl(Type.ORDINARY,  rates, false), "music CD"));
		order.addItem(new Item(0.85d,  new TaxesCalculatorImpl(Type.FOOD,  rates, false), "chocolate bar"));
		
		order.printReciept();		
			
		order =  new Order(new StOutReceiptPrinter());
		
		order.addItem(new Item(10.00d,  new TaxesCalculatorImpl(Type.FOOD, rates, true), "imported box of chocolates"));
		order.addItem(new Item(47.50d,  new TaxesCalculatorImpl(Type.ORDINARY,  rates, true), "imported bottle of perfume"));
			
		order.printReciept();
		
		
		order =  new Order(new StOutReceiptPrinter());
		order.addItem(new Item(27.99d,  new TaxesCalculatorImpl(Type.ORDINARY,  rates, true), "imported bottle of perfume "));
		order.addItem(new Item(18.99d,  new TaxesCalculatorImpl(Type.ORDINARY,  rates, false), "bottle of perfume "));
		order.addItem(new Item(9.75d,  new TaxesCalculatorImpl(Type.MEDICAL,  rates, false), "packet of headache pills "));
		order.addItem(new Item(11.25d,  new TaxesCalculatorImpl(Type.FOOD,  rates, true), "box of imported chocolates"));
		
		order.printReciept();
	}

}
