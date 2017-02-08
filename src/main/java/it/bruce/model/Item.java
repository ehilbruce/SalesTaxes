package it.bruce.model;
import it.bruce.interfaces.TaxesRatesCalulator;

public class Item {
	
	private Double basePrice;//using doubles assuming we've got no memory usage issues
	private TaxesRatesCalulator ratesCalcHelper;

	public Item(Double basePrice, TaxesRatesCalulator ratesCalcHelper) {
		this.basePrice = basePrice;
		this.ratesCalcHelper = ratesCalcHelper;
	}

	public Double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Double basePrice) {
		this.basePrice = basePrice;
	}
	
	public double getTotalTaxesAmount(){
		//implement using taxesHelper
		return 0;
	}

	public double getTotalCostAmount(){
		//implement using taxesHelper
		return 0;
	}
	
}
