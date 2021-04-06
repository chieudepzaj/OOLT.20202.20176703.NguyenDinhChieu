package hust.soict.hedspi.aims.order;

import javax.print.attribute.standard.Media;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.utils.MyDate;

// import org.apache.commons.lang.ArrayUtils;

public class Order {
    public static final int MAX_LIMITTED_ITEMS = 10;
    public static final int MAX_LIMITTED_ORDERS = 5;
    private static int nbOrders = 0;
    private int nbItem = 0;
    private float cost = 0;
    private MyDate dateOrdered = new MyDate("tenth", "May", 1999);
    private Media itemOrdered[] = new Media[MAX_LIMITTED_ITEMS];

    public Order() {
        super();
    }

    public static void main(String[] args) {

    }

    public static Order createOrder() {
        if (Order.nbOrders >= Order.MAX_LIMITTED_ORDERS) {
            System.out.println("Max number of order reached");
            return null;
        } else {
            return new Order();
        }
    }
    // public void addMedia(Media dvd) {
    // this.itemOrdered[this.nbItem] = dvd;
    // this.nbItem++;
    // this.cost += dvd.getCost();
    // }

    // public void removeDigialVideoDisc(String title) {
    // for (int i = 0; i < this.nbItem; i++) {
    // if (this.itemOrdered[i].title.compareTo(title) == 0) {
    // this.itemOrdered = ArrayUtils.remove(this.itemOrdered, i);
    // return;
    // }
    // }
    // }

    public void addMedia(Media med) {
        this.itemOrdered[this.nbItem] = med;
        if (Book.class.isInstance(med)) {
            // Book media = (Book) med;
            Book media = Book.class.cast(med);
            this.nbItem++;
            this.cost += media.getCost();
        } else if (DigitalVideoDisc.class.isInstance(med)) {
            DigitalVideoDisc media = DigitalVideoDisc.class.cast(med);
            // DigitalVideoDisc media = (DigitalVideoDisc) med;
            // this.itemOrdered[this.nbItem] = media;
            this.nbItem++;
            this.cost += media.getCost();
        }
    }

    public float totalCost() {
        return this.cost;
    }

    public int numberOfItem() {
        return this.nbItem;
    }

    public Media getItem(int num) {
        return this.itemOrdered[num];
    }

    public void setDate(MyDate date) {
        this.dateOrdered = date;
    }

    public static void printItem(Media med) {
        int i = 0;
        if (DigitalVideoDisc.class.isInstance(med)) { // is DVD
            i++;
            DigitalVideoDisc media = DigitalVideoDisc.class.cast(med);
            System.out.println(i + ". " + media.getTitle() + " - " + media.getCategory() + " - " + media.getDirector()
                    + " - " + media.getLength() + " - " + media.getCost());
        } else if (Book.class.isInstance(med)) {
            i++;
            Book media = Book.class.cast(med);
            System.out.print(i + ". " + media.getTitle() + " - " + media.getCategory() + " - " + media.getCost());
            for (int j = 0; j < media.getAuthors().size(); j++) {
                System.out.print(" - " + media.getAuthors().get(j));
            }
            System.out.println();
        }
    }

    public void printOrder() {
        System.out.println("***************ORDER***************");
        this.dateOrdered.printWithFormat("mmm dd,yyyy");
        System.out.println("Order Items:");
        for (int i = 0; i < this.nbItem; i++) {
            Order.printItem(this.itemOrdered[i]);
            // System.out.println(i + 1 + ". " + this.itemOrdered[i].getTitle() + " - " +
            // this.itemOrdered[i].getCategory()
            // + " - " + this.itemOrdered[i].getDirector() + " - " +
            // this.itemOrdered[i].getLength() + " - "
            // + this.itemOrdered[i].getCost());
        }
        System.out.println("Total cost:" + this.cost);
        Media luckyItem = this.getALuckyItem();
        // this.cost -= luckyItem.getCost();
        System.out.print("Lucky item: ");
        Order.printItem(luckyItem);
        // System.out.println("Lucky item: " + luckyItem.getTitle() + " - " +
        // luckyItem.getCategory() + " - "
        // + luckyItem.getDirector() + " - " + luckyItem.getLength() + " - " +
        // luckyItem.getCost());
        System.out.println("Final cost:" + this.cost);
        System.out.println("***********************************");
    }

    private Media getALuckyItem() {
        double ran = java.lang.Math.random() * this.nbItem;
        int rani = (int) ran;
        return this.itemOrdered[rani];
    }
}