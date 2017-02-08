package it.bruce.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import it.bruce.helpers.MathHelper;
import it.bruce.interfaces.ReceiptPrinter;

/**
 * Contains a list of purchased items
 * @author MB
 *
 */
public class Order {
	List<Item> itemsList;
	private ReceiptPrinter printer;
	double totalNetAmount = 0d;
	double totalTaxesAmount = 0d;

	public Order(ReceiptPrinter printer) {
		this.printer = printer;
		itemsList = new MyArrayList();		
	}
	
	/**
	 * Every change to the item list will update totals
	 * @author MB
	 *
	 */
	public class MyArrayList extends ArrayList<Item>{
		/**
		 * 
		 */
		private static final long serialVersionUID = -7521679399590085208L;

		@Override
		public boolean add(Item e) {
			boolean res = super.add(e);
			totalNetAmount+= e.getBasePrice();			
			totalTaxesAmount+= e.getTotalTaxesAmount();
		    return res;
		}
		
		@Override
		public boolean remove(Object o) {
			boolean res = super.remove(o);
			totalNetAmount-= ((Item)o).getBasePrice();
			totalTaxesAmount-= ((Item)o).getTotalTaxesAmount();
		    return res;
	    }
		
	}	

	
	public void addItem(Item item){
		itemsList.add(item);
	}
	
	public void removeItem(Item item){
		itemsList.remove(item);
	}
	
	public List<Item> getItemsList() {
		return itemsList;
	}	
	
	public double getTotalNetAmount(){
		return totalNetAmount;
	}
	
	public double getTotalTaxes(){
		return MathHelper.roundTotal(totalTaxesAmount,2);
	}
	
	/**
	 * including taxes
	 * @return
	 */
	public double getTotalAmount(){
		return MathHelper.roundTotal((totalNetAmount + totalTaxesAmount),2);
	}
	
	public void printReciept(){
		printer.printReciept(this);
	}

	
}
