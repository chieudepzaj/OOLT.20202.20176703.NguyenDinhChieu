package hust.soict.hedspi.aims.media.disc;

import hust.soict.hedspi.aims.media.Media;

public class Disc extends Media{
	protected int length = 0;
	protected	String director;
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return this.length;
	}
	public Disc(int id,String title,String category,float cost,int length,String director) {
		super(id,title,category,cost);
		this.length = length;
		this.director = director;
	}
	

}