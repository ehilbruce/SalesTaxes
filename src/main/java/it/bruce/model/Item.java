package it.bruce.model;
import it.bruce.helpers.MathHelper;
import it.bruce.interfaces.TaxesRatesCalulator;

public class Item {
	
	private double basePrice;//using doubles assuming we've got no memory usage issues
	private TaxesRatesCalulator ratesCalcHelper;
	private String description;

	public Item(Double basePrice, TaxesRatesCalulator ratesCalcHelper, String description) {
		this.basePrice = basePrice;
		this.ratesCalcHelper = ratesCalcHelper;
		this.description = description;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	
	public double getTotalTaxesAmount(){
		//implement using taxesHelper
		return	ratesCalcHelper.getTotalTaxesAmount(this);
	}

	public double getTotalCostAmount(){ 
		return MathHelper.roundTotal((basePrice +  ratesCalcHelper.getTotalTaxesAmount(this)),2);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "1 " + description + ": " + getTotalCostAmount();
	}
	
	
	
}
