package hust.soict.hedspi.aims.media;

public abstract class Media implements Comparable<Media>{
	private String title;
	private String category;
	private float cost;
	private int id;
	
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
	public Media() {
		super();
	}
	public Media(String title) {
		this.title = title;
	}
	public Media(String title, String category) {
		this(title);
		this.category = category;
	}
	public Media(String title, String category, float cost) {
		this(title, category);
		this.cost = cost;
	}
	@Override
	public boolean equals(Object obj) {
		Media temp = (Media)obj;
		if(this.id == temp.getId())
			return true;
		return false;
	}
	
	public int compareTo(Media item) {
		if(this.getCost() > item.getCost())
			return 1;
		if(this.getCost() < item.getCost())
			return -1;
		return 0;
	}
}
