package hust.soict.hedspi.aims.media.disc;
import java.lang.Comparable;
public class Track implements Playable,Comparable{
	private String title;
	private int length;
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	public Track(String title,int length) {
		this.title = title;
		this.length = length;
	}
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	public boolean equals(Object obj) {
		String titleEqual = ((Track)obj).title;
		int lengthEqual = ((Track)obj).length;
		if(this.title.equals(titleEqual) && this.length == lengthEqual)
				return true;
		return false;
	}
	@Override
	public int compareTo(Object o) {
		if(this.title.compareTo(((Track)o).title) > 0)
			return 1;
		else if(this.title.compareTo(((Track)o).title) < 0)
			return -1;
		return 0;
	}
}