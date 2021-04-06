package hust.soict.hedspi.aims.order;

import java.util.List;
import java.util.ArrayList;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public Book() {
        super();
    }

    public void addAuthor(String authorName) {
        if (this.authors.indexOf(authorName) == -1) {
            this.authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        if (this.authors.indexOf(authorName) != -1) {
            this.authors.remove(this.authors.indexOf(authorName));
        }
    }

    public List<String> getAuthors() {
        return this.authors;
    }
}