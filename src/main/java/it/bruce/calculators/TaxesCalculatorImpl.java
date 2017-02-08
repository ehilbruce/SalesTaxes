package it.bruce.calculators;

import java.util.HashMap;
import java.util.Map;

import it.bruce.interfaces.TaxesRatesCalulator;

public class TaxesCalculatorImpl implements TaxesRatesCalulator {
	
	private float baseTaxesRate = 0.1f;
	private float importTaxesRate = 0.05f;
	private Type type;
	
	private Map<TaxesRatesCalulator.Type, Float> specialRates;
	
	public TaxesCalculatorImpl() {		
	}
	
	public TaxesCalculatorImpl(Type type, Map<TaxesRatesCalulator.Type, Float> specialRates) {
		this.type = type;
		this.specialRates = specialRates;
	}

	public double getBaseTaxesAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getImportTaxesAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getTotalTaxesAmount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * Assuming that every item not mapped will be taxed with default rate
	 * @return
	 */
	private float getCorrectBaseTaxesRate(){
		return specialRates.get(type) != null ? specialRates.get(type) : baseTaxesRate;		
	}

}
