package hust.soict.hedspi.aims.media.disc;

import java.util.ArrayList;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.book.Book;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	public String getArtist() {
		return artist;
	}
	public CompactDisc(int id,String title,String category,float cost,int length,String director,String artist) {
		super(id,title,category,cost,length,director);
		this.artist = artist;
	}
	public CompactDisc(int id,String title,String category,float cost,int length,String director,String artist,ArrayList<Track> tracks) {
		super(id,title,category,cost,length,director);
		this.artist = artist;
		this.tracks = tracks;
	}
	public int getLength() {
		int totalLength = 0;
		for(Track track: tracks) {
			totalLength += track.getLength();
		}
		return totalLength;
	}
	public void addTrack(Track track) {
		if(tracks.contains(track)) {
			System.err.println("The track want to add is exist");
			return;
		}
		else {
			tracks.add(track);
			this.length = this.getLength();
		}
	}
	public void removeTrack(Track track) {
		if(!tracks.contains(track)) {
			System.err.println("The track want to remove is not exist");
			return;
		}
		else {
			tracks.remove(track);
			this.length = this.getLength();
		}
	}
	
	public void play() {
		System.out.println("CompactDisc's name: "+this.getTitle());
		for(Track track : tracks) {
			track.play();
		}
		System.out.println("Length of CD: "+this.length);
		System.out.println("CD cost: "+ this.getCost());
//		System.out.println("---------------------------------");
	}
	// sap xep theo so luong cac tracks cua CD, roi den tong do dai cua CD
	public int compareTo(Media obj) {
		if((obj instanceof Book))
			return 1;
		else if((obj instanceof DigitalVideoDisc))
			return -1;
		else {
			if(this.tracks.size() > ((CompactDisc)obj).tracks.size())
				return 1;
			else if(this.tracks.size() < ((CompactDisc)obj).tracks.size())
				return -1;
			else {
				if(this.length > ((CompactDisc)obj).length)
					return 1;
				else if(this.length < ((CompactDisc)obj).length)
					return -1;
				return 0;
			}
		}
		
	}

}