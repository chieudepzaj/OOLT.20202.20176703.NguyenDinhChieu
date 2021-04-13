package hust.soict.hedspi.aims.order;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.hedspi.aims.media.Media;

public class Order {
	public static final int MAX_NUMBER_ORDERED = 3;
	public static final int MAX_LIMITED_ORDERS = 3;
	private static int nbOrders = 0;
	private ArrayList<Media> itemsOrdered =  new ArrayList<Media>();
//	private MyDate dateOrdered;
	private int id;
	public int getId() {
		return id;
	}
	
	public ArrayList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public Order() {
		super();
		if(nbOrders>=1)
			System.out.println("-----------Create Order--------------");
		if(Order.nbOrders <  MAX_LIMITED_ORDERS) {
//			this.dateOrdered = new MyDate();
			Order.nbOrders++;
		}
		else
			System.out.println("Cannot create more order");
	}
	
	
	public void addMedia(Media media) {
		if(itemsOrdered.size() >= MAX_NUMBER_ORDERED) {
			System.out.println("The order is full");
		}
		else {
		//	itemsOrdered[this.getQtyOrdered()] = disc;
			System.out.println("The order is added ");
			itemsOrdered.add(media);
		}	
	}
	
	public void addMedia(Media [] medias) {
		if(itemsOrdered.size() >= MAX_NUMBER_ORDERED) {
			System.out.println("The order is full");
	    }
		else {
			for(int i = 0; i < medias.length; i++) {
				if(itemsOrdered.size() == MAX_NUMBER_ORDERED) {
					System.out.println("The order is full");
					System.out.println("----------------------");
					System.out.println("Oder cannot be added: ");
					do {
						System.out.println(medias[i].getTitle());
						i++;
					} while (i < medias.length);
				}
				else {
					itemsOrdered.add(medias[i]);
					System.out.println("DVD " + medias[i].getTitle() + " is added");
					// this.setQtyOrdered(this.getQtyOrdered()+1);
				}
			}
		}
		System.out.println("----------------------");
	}
	
	public void addMedias(Media media1, Media media2) {
		if(itemsOrdered.size() >= MAX_NUMBER_ORDERED) {
			System.out.println("The order is full");
			System.out.println("----------------------");
			System.out.println("Oder cannot be added!");
		}
		else {
			itemsOrdered.add(media1);
			System.out.println("DVD " + media1.getTitle() + " is added");
			// this.setQtyOrdered(this.getQtyOrdered()+1);
			if(itemsOrdered.size() >= MAX_NUMBER_ORDERED) {
				System.out.println("The order is full");
				System.out.println("Oder cannot be added: " + media2.getTitle());
			}
			else {
				itemsOrdered.add(media2);
				System.out.println("DVD " + media2.getTitle() + " is added");
				// this.setQtyOrdered(this.getQtyOrdered()+1);
			}
		}
		System.out.println("----------------------");
	}
	
	public void removeMedia(Media media) {
		if(itemsOrdered.size() <= 0) {
			System.out.println("The order is empty");
		}
		else {
			int count = 0;
			while(count < itemsOrdered.size() && itemsOrdered.get(count) != media) {
				count++;
			} 
			for(int i = count; i < itemsOrdered.size(); i++) {
				itemsOrdered.remove(i);
				itemsOrdered.add(itemsOrdered.get(i+1));
			}
			System.out.println("The order is removied");
			// this.setQtyOrdered(this.getQtyOrdered()-1);
		}
	}
	public void removeMediaById(int id) {
		itemsOrdered.remove(id);
	}
	
	public Media getALuckyItem() {
		double rand = Math.random()*itemsOrdered.size();
		return itemsOrdered.get((int)rand);
	}

//	public float totalCostWithLuckyItem() {
//		Media luckyItem = new Media();
//		float totalCost = 0;
//		for(int i = 0; i < itemsOrdered.size(); i++) {
//			totalCost += itemsOrdered.get(i).getCost();
//		}
//		luckyItem = this.getALuckyItem();
//		System.out.println("The lucky item: " + luckyItem.getTitle());
//		totalCost = this.totalCost()- luckyItem.getCost();
//		//search(anOrdered.getLuckyItem().title)
//		return totalCost;
//	}
	
	public float totalCost() {
		float totalCost = 0;
		for(int i = 0; i < itemsOrdered.size(); i++) {
			totalCost += itemsOrdered.get(i).getCost();
		}
		return totalCost;
	}

	public void printListOrderedItems() {
		Collections.sort(itemsOrdered);
		for(int i = 0; i< this.itemsOrdered.size(); i++) {
			System.out.println(itemsOrdered.get(i).toString());
		}
		System.out.println("----------");
		System.out.println("Total cost: " +  this.totalCost());
	}
	public Media searchMedia(String title) {
		for(int i=0; i<itemsOrdered.size(); i++) {
			if(itemsOrdered.get(i).getTitle().equals(title))
				return itemsOrdered.get(i);
		}
		return null;
	}
}