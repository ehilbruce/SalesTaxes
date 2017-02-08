package it.bruce.interfaces;

import it.bruce.model.Item;

public interface TaxesRatesCalulator {
	
    public static enum Type {
        ORDINARY, BOOK, FOOD, MEDICAL
    };
	
    double getBaseTaxesAmount(Item item);
    double getImportTaxesAmount(Item item);
    double getTotalTaxesAmount(Item item);

}
