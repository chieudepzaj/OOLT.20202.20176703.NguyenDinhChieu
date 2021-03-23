
public class Order {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static final int MAX_NUMBERS_ORDERED = 10;
	private int qtyOrdered;
	private DigitalVideoDisc itemsOrdered[]= 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	public int getQtyOrdered() {
		return qtyOrdered;
	}
	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}
	public void addDigitalVideoDisc(DigitalVideoDisc disc)
	{
		int x;
	     for (x=0; x < itemsOrdered.length; x++)
	           if (itemsOrdered[x]!=null) {
	        	   itemsOrdered[x] = disc;
	        	   break;
	           }       	   
	     if (x == itemsOrdered.length)
	    	 System.out.println("The array is full");
		
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc)
	{
		for (int x=0; x < itemsOrdered.length; x++)
	           if (itemsOrdered[x]== disc) {
	        	   itemsOrdered[x] = null;
	           } 
	}
	public float totalCost() {
		float a = 0;
		for (int x=0; x < itemsOrdered.length; x++) {
			a += itemsOrdered[x].getCost();
		}
		return a;
	}
}