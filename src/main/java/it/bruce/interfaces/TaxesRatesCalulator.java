package it.bruce.interfaces;

public interface TaxesRatesCalulator {
	
    public static enum Type {
        ORDINARY, BOOK, FOOD, MEDICAL
    };
	
	double getBaseTaxesAmount();
	double getImportTaxesAmount();
	double getTotalTaxesAmount();

}
