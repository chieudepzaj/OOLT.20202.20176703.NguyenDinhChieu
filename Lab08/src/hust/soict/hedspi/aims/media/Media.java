package hust.soict.hedspi.aims.media;

public class Media implements Comparable<Media>{
	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}
	public Media(String title,String category,float cost) {
		this.cost = cost;
		this.title = title;
		this.category = category;
	}
	public Media(int id,String title,String category,float cost) {
		this(title,category,cost);
		this.id = id;
	}
	public boolean equals(Object obj) {
		if(this.id == ((Media)obj).id)
			return true;
		return false;
	}
	@Override
	public int compareTo(Media obj) {
		if(this.title.compareTo(((Media)obj).title) > 0)
			return 1;
		else if(this.title.compareTo(((Media)obj).title) < 0)
			return -1;
		return 0;
	}

}