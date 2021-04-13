package hust.soict.hedspi.aims.media;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Book extends Media{
	private List<String> authors = new ArrayList<String>();
	private String content;
    private List<String> contentTokens = new ArrayList<>();
    private Map<String, Integer> wordFrequency = new TreeMap<>();

    public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public Book() {
		super();
	}
	public Book(String title) {
		super(title);
	}
	public Book(String title, String category) {
		super(title, category);
	}
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}

	public Book(String title, String category, float cost, List<String> authors) {
		super(title,category, cost);
		this.authors = authors;
		//to do check author condition
		for(int i = 0; i< authors.size(); i++) {
			if(this.authors.contains(authors.get(i))) {
				System.out.println("The author " + authors.get(i) + " has already exist!");
			}
			else {
				this.authors.add(authors.get(i));
				System.out.println("The author " + authors.get(i) + " is added success!");
			}
		}
	}

	public void addAuthor(String AuthorName) {
		if(this.authors.contains(AuthorName)) {
			System.out.println("The author " + AuthorName + " is duplicate!");
			return;
		}
		else {
			authors.add(AuthorName);
			System.out.println("The author " + AuthorName + " is added success!");
		}
	}
	public void removeAuthor(String AuthorName) {
		if(!this.authors.contains(AuthorName)) {
			System.out.println("The author " + AuthorName + " isn't exist!");
			return;
		}		
		else {
			this.authors.remove(AuthorName);
			System.out.println("Remove author " + AuthorName + " success!");
		}
	}
	
	public void processContent() {
    	int n;
        int count  = 1;
        String[] tempStr = content.split("[\\p{Punct}\\s]+", 0); //hard to understand regex here
        for(String tmp : tempStr) {
            if(!tmp.isEmpty())
                contentTokens.add(tmp.toLowerCase());
        }
        Collections.sort(contentTokens);
        n = contentTokens.size();
        if(contentTokens.isEmpty()) {
            System.out.println("No content.");
            return;
        }
        if(n == 1) {
            wordFrequency.put(contentTokens.get(0), 1);
            return;
        }
        for(int i = 1; i < n ; i++) {
            if(!contentTokens.get(i-1).equals(contentTokens.get(i))) {
                wordFrequency.put(contentTokens.get(i-1), count);
                count = 0;
            }
            else if(i == n - 1) {// check last element.
                wordFrequency.put(contentTokens.get(i), count + 1);
            }
            count++;
        }
    }
	
	@Override
	public String toString() {
		String string;
		int i;
		string = "Book - Title: " + this.getTitle() + " - Category: " + this.getCategory() + " - Cost: " + this.getCost() +
				" - List authors: ";
		for(i = 0; i < this.authors.size() - 1; i++) {
			string = string + this.authors.get(i) + ", ";
		}
		string = string + this.authors.get(i) ;
		return string;
	}
	public String stringTo() {
        StringBuilder str = new StringBuilder();
        String temp;
        temp = this.getTitle() + "\n" + this.getCategory() + "\n" + Float.toString(this.getCost()) + "\n";
        str.append(temp);
        str.append(content);
        temp = ("\n" + contentTokens.size() + " word.\n");
        str.append(temp);
        for(Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            temp = "[" + entry.getKey() + "," + entry.getValue() + "]" + "\n";
            str.append(temp);
        }
        
        return str.toString();
    }
}
