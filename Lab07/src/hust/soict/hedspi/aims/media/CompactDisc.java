package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks  =  new ArrayList<Track>();
	public ArrayList<Track> getTracks() {
		return tracks;
	}
	public void setTracks(ArrayList<Track> tracks) {
		this.tracks = tracks;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getArtist() {
		return artist;
	}
	public CompactDisc() {
		super();
	}
	public int getLength() {
		int totalLength = 0;
		for(int i=0; i<tracks.size(); i++) {
			totalLength += tracks.get(i).getLength();
		}
		return totalLength;
	}
	
	public CompactDisc(String title) {
		super(title);
	}
	public CompactDisc(String title, String category) {
		super(title, category);
	}
	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	public CompactDisc(String title, String category, float cost, int length) {
		super(title, category, cost, length);
	}
	public CompactDisc(String title, String category, float cost, int length, String director) {
		super(title, category, cost, length, director);
	}
	public CompactDisc(String title, String category, float cost, int length, String director, String artist) {
		super(title, category, cost, length, director);
		this.artist = artist;
	}
	public CompactDisc(String title, String category, float cost, int length, String director, String artist, ArrayList<Track> tracks) {
		super(title, category, cost, length, director);
		this.artist = artist;
		this.tracks = tracks;
	}
	public void addTrack(Track track) {
		if(tracks.contains(track)) {
			System.out.println("Tracks is already exists");
		}
		else {
			tracks.add(track);
			System.out.println("Add track success");
		}
	}
	public void removeTrack(Track track) {
		if(!tracks.contains(track)) {
			System.out.println("Track is not exit");
		}
		else {
			tracks.remove(track);
			System.out.println("Remove success!");
		}
	}
	@Override
	public String toString() {
		String string;
		int i;
		System.out.println(this.getTitle());
		string = "CD   - Title: " + this.getTitle() + " - Category: " + this.getCategory() + " - Cost: " + this.getCost() +
				" - Length: " + this.getLength() + " - Director: " + this.getDirector() + " - Artist: " + this.getArtist() + " - Track list: ";
		for(i = 0; i < this.tracks.size() - 1; i++) {
			string = string + this.tracks.get(i).toString() + ", ";
		}
		string = string + this.tracks.get(i).toString() ;
		return string;
	}
	@Override
	public void play() {
		System.out.println("Playing CD: \t" + this.getTitle());
		System.out.println("Director: \t" + this.getDirector());
		System.out.println("Artist: \t" + this.getArtist());
		for(int i=0; i<this.tracks.size(); i++) {
			System.out.println("Playing " + tracks.get(i).getTitle() + "...");
			System.out.println("Length: "+ tracks.get(i).getLength() +"...");
		}
	}
	
	@Override
	public int compareTo(Media media) {
		CompactDisc cd = (CompactDisc)media;
			if(this.getTracks().size() > cd.getTracks().size())
				return 1;
			else if(this.getTracks().size() > cd.getTracks().size())
				return -1;
			else {
				if(this.getLength() > cd.getLength()) 
					return 1;
				else if(this.getLength() < cd.getLength()) {
					return -1;
				}
				else return 0;
			}
	}
}

