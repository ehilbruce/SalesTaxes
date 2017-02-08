package it.bruce.interfaces;

import it.bruce.model.Order;

/**
 * This should print out receipt for a single order on ehich output depends on implementation
 * @author MB
 *
 */
public interface ReceiptPrinter {
	
	void printReciept(Order order);

}
