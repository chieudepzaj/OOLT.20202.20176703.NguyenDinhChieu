package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
	public DigitalVideoDisc() {
		super();
	}
	public DigitalVideoDisc(String title) {
		super(title);
	}
	public DigitalVideoDisc(String title, String category) {
		super(title, category);
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	public DigitalVideoDisc(String title, String category, float cost, int length) {
		super(title, category, cost, length);
	}
	public DigitalVideoDisc(String title, String category, float cost, int length, String director) {
		super(title, category, cost, length, director);
	}
	
	public boolean search(String title) {
		String str1, str2;
		str1 = this.getTitle().toUpperCase();
		str2 = title.toUpperCase();
		if(str1.equalsIgnoreCase(str2)) 
			return true;
		else 
			return false;
	}
	@Override
	public String toString() {
		String string;
		System.out.println(this.getTitle());
		string = "DVD  - Title: " + this.getTitle() + " - Category: " + this.getCategory() + " - Cost: " + this.getCost() +
				" - Length: " + this.getLength() + " - Director: " + this.getDirector();
		return string;
	}

	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
}
