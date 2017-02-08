package it.bruce.helpers;

import it.bruce.interfaces.ReceiptPrinter;
import it.bruce.model.Item;
import it.bruce.model.Order;

/**
 * Basic implementation to print receipt to Standrd output
 * @author MB
 *
 */
public class StOutReceiptPrinter implements ReceiptPrinter {

	@Override
	public void printReciept(Order order) {
		System.out.println("Order details: ");
		for(Item item :  order.getItemsList()){
			System.out.println(item.toString());
		}
		System.out.println("Sales Taxes: " + order.getTotalTaxes());
		System.out.println("Total: " + order.getTotalAmount());
	
	}

}
