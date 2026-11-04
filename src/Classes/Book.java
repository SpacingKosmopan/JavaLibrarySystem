package Classes;

public class Book {
    String title;
    String author;
    int publicationYear;
    boolean isBorrowed = false;
    Reader borrowedBy;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public Book(String title, String author, int publicationYear, boolean isBorrowed, Reader borrowedBy) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isBorrowed = isBorrowed;
        this.borrowedBy = borrowedBy;
    }

    public void displayInfo() {
        System.out.println("╭ Title: " + title
                + "\n│ Author: " + author
                + "\n│ Publication Year: " + publicationYear
                + "\n╰ Borrowed: " + (isBorrowed ? "yes, by " + borrowedBy : "no"));
    }

    public void borrowBook(Reader currentReader) {
        isBorrowed = true;
        borrowedBy = currentReader;
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

    @Override
    public String toString() {
        return "╭ Title: " + title
                + "\n│ Author: " + author
                + "\n│ Publication Year: " + publicationYear
                + "\n╰ Borrowed: " + (isBorrowed ? "yes, by " + borrowedBy : "no");
    }
}