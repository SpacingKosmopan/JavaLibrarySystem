package Classes;

public class Book {
    String title;
    String author;
    int publicationYear;
    boolean isBorrowed = false;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public void displayInfo() {
        System.out.println("Title: " + title + "\nAuthor: " + author + "\nPublication Year: " + publicationYear);
    }

    public void borrowBook() {
        isBorrowed = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }
}