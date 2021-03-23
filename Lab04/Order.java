package src;
import java.util.Date;
public class Order {
    public static final int MAX_LIMITTED_ITEMS = 10;
    public static final int MAX_LIMITTED_ORDERS = 5;
    private static int nbOrders = 0;
    private int nbItem = 0;
    private float cost = 0;
    private MyDate dateOrdered = new MyDate("tenth", "May", 1999);
    private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_LIMITTED_ITEMS];

    public Order() {
        super();
        if (Order.nbOrders >= Order.MAX_LIMITTED_ORDERS)
            throw null;
        Order.nbOrders++;
    }

    public static void main(String[] args) {

    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd) {
        this.itemOrdered[this.nbItem] = dvd;
        this.nbItem++;
        this.cost += dvd.getCost();
    }

    public float totalCost() {
        return this.cost;
    }

    public void printOrder() {
        System.out.println("***************ORDER***************");
        this.dateOrdered.print();
        this.dateOrdered.printWithFormat("dd/m/yyyy");
        System.out.println("Order Items:");
        for (int i = 0; i < this.nbItem; i++) {
            System.out.println(i + 1 + ". " + this.itemOrdered[i].getTitle() + " - " + this.itemOrdered[i].getCategory()
                    + " - " + this.itemOrdered[i].getDirector() + " - " + this.itemOrdered[i].getLength() + " - "
                    + this.itemOrdered[i].getCost());
        }
        System.out.println("Total cost:" + this.cost);
        System.out.println("***********************************");
    }
}