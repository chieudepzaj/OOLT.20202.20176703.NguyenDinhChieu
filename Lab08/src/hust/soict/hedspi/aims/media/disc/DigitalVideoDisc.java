package hust.soict.hedspi.aims.media.disc;

import hust.soict.hedspi.aims.media.Media;

public class DigitalVideoDisc extends Disc implements Playable{
	//constructor
	public DigitalVideoDisc(int id,String title,String category,float cost,int length,String director) {
		super(id,title,category,cost,length,director);
	}
	
	//find out the corresponding disk of the current object contains the title
	public boolean search(String title) {
		int check = 0;
		title = title.toLowerCase().trim();
		String titleCurrentObj = this.title.toLowerCase().trim();
		String[] words = title.split("\\s");
		for(int i = 0;i< words.length;i++) {
			if(titleCurrentObj.contains(words[i]))
				check++;
		}
		if(check == words.length) 
			return true;
		else return false;
	}
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
		System.out.println("DVD cost: "+ this.getCost());
//		System.out.println("--------------------------------");
	}
	//sap xep theo cost cua DVD, roi den do dai cua DVD
	public int compareTo(Media obj) {
		if(obj instanceof DigitalVideoDisc) {
			if(this.cost > ((DigitalVideoDisc)obj).cost)
				return 1;
			else if(this.cost < ((DigitalVideoDisc)obj).cost)
				return -1;
			else {
				if(this.length > ((DigitalVideoDisc)obj).length)
					return 1;
				else if(this.length < ((DigitalVideoDisc)obj).length)
					return -1;
				return 0;
			}
		}
		else if(obj instanceof CompactDisc)
			return 1;
		else return -1;
	}
}