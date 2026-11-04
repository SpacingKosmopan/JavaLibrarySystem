package Classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Books {
    Scanner scanner;

    public Books(Scanner scanner) {
        this.scanner = scanner;
    }

    ArrayList<Book> books = new ArrayList<>();

    public void addBook() {
        scanner.nextLine();
        System.out.print("Enter book name: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book publication year: ");
        int publicationYear = scanner.nextInt();

        if (title.isEmpty() || author.isEmpty() || publicationYear < 0) {
            System.out.println(ConsoleFormatter.RED + "Invalid input!" + ConsoleFormatter.RESET);
            return;
        }

        if (title.contains(";") || author.contains(";")) {
            System.out.println(ConsoleFormatter.RED + "Data cannot contain ';'" + ConsoleFormatter.RESET);
            return;
        }

        books.add(new Book(title, author, publicationYear));
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("+=====" + ConsoleFormatter.GREEN + " BOOKS " + ConsoleFormatter.RESET + "=====+" + ConsoleFormatter.WHITE);
            System.out.println("There are no books in the library");
            System.out.println(ConsoleFormatter.RESET + "+=================+");

            return;
        }

        System.out.println("+=====" + ConsoleFormatter.GREEN + " BOOKS " + ConsoleFormatter.RESET + "=====+" + ConsoleFormatter.WHITE);
        books.forEach(System.out::println);
        System.out.println(ConsoleFormatter.RESET + "+=================+");
    }

    public void searchBook() {
        System.out.println("+=====" + ConsoleFormatter.GREEN + " SEARCHING " + ConsoleFormatter.RESET + "=====+");
        scanner.nextLine();
        System.out.print("Enter book title fragment: ");
        String titleFragment = scanner.nextLine();

        System.out.println("Found books:\n");

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(titleFragment.toLowerCase())) {
                System.out.println(ConsoleFormatter.WHITE + book + ConsoleFormatter.RESET);
            }
        }
    }

    public void borrowBook(Reader currentReader) {
        System.out.println("+=====" + ConsoleFormatter.GREEN + " BORROWING " + ConsoleFormatter.RESET + "=====+");
        scanner.nextLine();
        System.out.print("Enter exact book title you want to borrow: ");
        String title = scanner.nextLine();

        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                if (book.isBorrowed()) {
                    System.out.println("The book has been already borrowed");
                    return;
                }

                book.borrowBook(currentReader);

                System.out.println("Book\n" + ConsoleFormatter.WHITE + book + ConsoleFormatter.RESET + "\nhas been borrowed");
                return;
            } else System.out.println("No book was found!");
        }
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}