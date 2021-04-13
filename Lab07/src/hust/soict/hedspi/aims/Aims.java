package hust.soict.hedspi.aims;

import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.order.Order;

public class Aims {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice = 1, option, optionId, optionType;
		String title, category, director;
		float cost;
		int length;
		ArrayList <Order> orders = new ArrayList <Order>();
		Scanner sc = new Scanner(System.in);
		do {
			showMenu();
			choice = sc.nextInt();
			switch(choice) {
			case 1: // create new order
				Order order = new Order();
				if(orders.size()<=5) {
					orders.add(order);
					System.out.println("The order is created!");
				}
				else {
					System.out.println("The orders is full! Cannot add more order!");
				}
				System.out.println("-------------------");
				break;
			case 2: // Add item to the order
				if(orders.size() == 0) {
					System.out.println("List orders is empty!");
				}
				else {
					System.out.print("Please enter the order id: ");
					optionId = sc.nextInt() - 1;
					System.out.println(optionId);
					if(optionId < 0 || optionId >= orders.size()) {
						System.out.println("the id is not exist!");
					}
					else {
						do{
							selectTypeMenu();
							optionType = sc.nextInt();
							sc.nextLine();
							switch(optionType) {
							case 1: //add dvd
								System.out.print("Create new Dvd\nInput title: ");
								title = sc.nextLine();
								System.out.print("Input category: ");
								category = sc.nextLine();
								System.out.print("Input director: ");
								director = sc.nextLine();
								System.out.print("Input length: ");
								length = sc.nextInt();
								sc.nextLine();
								System.out.print("Input cost: ");
								cost = sc.nextFloat();
								sc.nextLine();
								DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost, length, director);
								orders.get(optionId).addMedia(dvd);
								System.out.print("Do you want to play this dvd? enter 0 to back");
								option = sc.nextInt();
								sc.nextLine();
								if(option != 0) {
									dvd.play();
								}
								System.out.println("-------------------------");
								break;
							case 2: //add book
								String author;
								sc.nextLine();
								option = 1;
								System.out.print("Create new Book\nInput title: ");
								title = sc.nextLine();
								System.out.print("Input category: ");
								category = sc.nextLine();
								System.out.print("Input cost: ");
								cost = sc.nextFloat();
								Book book = new Book(title, category, cost);
								while (option != 0){
									sc.nextLine();
									System.out.print("Input author: ");
									author = sc.nextLine();
									book.addAuthor(author);
									System.out.print("Do you want add more author? enter 0 to stop!");
									option = sc.nextInt();
								}
								orders.get(optionId).addMedia(book);
								System.out.println("The book is added");
								System.out.println("--------------------------");
								break;
							case 3: //add compact disc
								option = 1;
								String artist;
								System.out.println("Create new Compact Disc");
								System.out.print("Input title: ");
								title = sc.nextLine();
								System.out.print("Input category: ");
								category = sc.nextLine();
								System.out.print("Input cost: ");
								cost = sc.nextFloat();
								sc.nextLine();
								System.out.print("Input director: ");
								director = sc.nextLine();
								System.out.print("Input artist: ");
								artist = sc.nextLine();
								String track_title;
								CompactDisc cd = new CompactDisc(title, category, cost);
								cd.setDirector(director);
								cd.setArtist(artist);
								int track_length = 0;
								while (option != 0) {
									System.out.print("Input track title: ");
									track_title = sc.nextLine();
									System.out.print("Input track length: ");
									track_length = sc.nextInt();
									sc.nextLine();
									Track track = new Track(track_title, track_length);
									cd.addTrack(track);
									System.out.print("Do you want add track?(enter 0 to stop)");
									option = sc.nextInt();
									sc.nextLine();
								}
								cd.setLength(cd.getLength());
								orders.get(optionId).addMedia(cd);
								System.out.println("The CD is added");
								System.out.print("Do you want to play this CD? enter 0 to back");
								option = sc.nextInt();
								sc.nextLine();
								if(option != 0) {
									cd.play();
								}
								System.out.println("--------------------------");
								break;
							case 0:
								break;
							default:
								System.out.println("Please enter true option!");
								break;
							}
						} while (optionType != 0);
					}
				}
				break;
			case 3: // Delete item by id
				System.out.println(orders.size() + "Enter id of order to delete item: " );
				optionId = sc.nextInt() - 1;
				if( optionId < 0 || optionId > orders.size() ) {
					System.out.println("Id not exists");
				}
				else {
					System.out.println("Enter id of the item: ");
					option = sc.nextInt() -1 ;
					if( option < 0 || option > orders.get(optionId).getItemsOrdered().size() ) {
						System.out.println("Id not exists");
					}
					else {
						orders.get(optionId).removeMediaById(option);
					}
				}
				System.out.println("Remove success");
				if(orders.size() == 0) {
					System.out.println("The order is empty!");
				}
				System.out.println("----------------------------------");
				break;
			case 4: // Display the items lisit of order
				System.out.println("------------------");
				System.out.println("List of orders: ");
				if(orders.size() == 0) {
					System.out.println("The order is empty");
				}
				for(int i=0; i<orders.size();i++) {
					System.out.println("ID orders: " + (i+1) );
					orders.get(i).printListOrderedItems();
				}
				System.out.println("******************");
				break;
			case 0: // exit
				System.out.println("Ban da chon thoat khoi chuong trinh!");
				break;
			default:
				System.out.println("Moi ban lai nhap lai lua chon!");
				System.out.println("-------------------------");
				break;
			}
		} while (choice != 0);
		sc.close();
}

	public static void showMenu() {
		System.out.println("Order Management Application: ");
		System.out.println("--------------------------------");
		System.out.println("1. Create new order");
		System.out.println("2. Add item to the order");
		System.out.println("3. Delete item by id");
		System.out.println("4. Display the items list of order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	public static void selectTypeMenu() {
		System.out.println("Select type of media");
		System.out.println("1.Digital Video Disc");
		System.out.println("2.Book");
		System.out.println("3.Compact Disc");
		System.out.println("0. Exit");
		System.out.println("Please choose a number of Type Media!");
	}
}
