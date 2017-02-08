package it.bruce.calculators;

import java.util.Map;

import it.bruce.helpers.MathHelper;
import it.bruce.interfaces.TaxesRatesCalulator;
import it.bruce.model.Item;

/**
 * For a single item
 * @author MB
 *
 */
public class TaxesCalculatorImpl implements TaxesRatesCalulator {
	
	private float baseTaxesRate = 0.1f;
	private float importTaxesRate = 0.05f;
	private Type type;
	
	private Map<TaxesRatesCalulator.Type, Float> specialRates;
	private boolean isImportedGood;
	
	public TaxesCalculatorImpl() {		
	}
	
	public TaxesCalculatorImpl(Type type, Map<TaxesRatesCalulator.Type, Float> specialRates, boolean isImportedGood) {
		this.type = type;
		this.specialRates = specialRates;
		this.isImportedGood = isImportedGood;
	}

	@Override
	public double getBaseTaxesAmount(Item item) {
		return item.getBasePrice() * getCorrectBaseTaxesRate();
	}

	@Override
	public double getImportTaxesAmount(Item item) {
		return isImportedGood? item.getBasePrice() * importTaxesRate : 0d;
	}

	@Override
	public double getTotalTaxesAmount(Item item) {
		return MathHelper.roundTaxes(getBaseTaxesAmount(item) + getImportTaxesAmount(item));		
	}
	
	/**
	 * Assuming that every item not mapped will be taxed with default rate
	 * @return
	 */
	private double getCorrectBaseTaxesRate(){
		return specialRates.get(type) != null ? specialRates.get(type) : baseTaxesRate;		
	}

}
