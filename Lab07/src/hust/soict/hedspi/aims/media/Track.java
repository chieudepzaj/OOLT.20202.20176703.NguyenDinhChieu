package hust.soict.hedspi.aims.media;

public class Track implements Playable{
	private String title;
	private int length;
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	public Track() {
		super();
	}
	public Track(String title) {
		this.title = title;
	}
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	@Override
	public String toString() {
		return this.getTitle() +"(" +this.getLength() + "\')";
	}
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());	
	}
	@Override
	public boolean equals(Object obj) {
		Track temp = (Track)obj;
		if(this.getTitle().equals(temp.getTitle()) && this.getLength() == temp.getLength())
			return true;
		return false;
	}
}
