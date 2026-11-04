import Classes.Book;
import Classes.ConsoleFormatter;
import Classes.FilesManager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
    ArrayList<Book> books = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    void main() throws IOException {
        String menuDisplay = ConsoleFormatter.GREEN + "===== LIBRARY MANAGEMENT ====="
                + ConsoleFormatter.WHITE + """
                \n/b1./0 Add book
                /b2./0 Display all books
                /b3./0 Search book
                /b4./0 Borrow book
                /b5./0 Save books to file
                /b6./0 Load books from file
                /b0./0 Exit
                Choose an option:""" + " ";

        menuDisplay = ConsoleFormatter.deregex(menuDisplay);

        int choice = -1;
        do {
            System.out.print(menuDisplay);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    displayBooks();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    FilesManager.saveBooksToFile(books);
                    break;
                case 6:
                    books = FilesManager.loadBooksFromFile();
                    break;
                case 0:
                    System.out.println("Bye bye!");
                    break;

                default:
                    System.out.println(ConsoleFormatter.RED + "Invalid choice." + ConsoleFormatter.RESET);
                    break;
            }
        } while (choice != 0);
    }

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

    public void borrowBook() {
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

                book.borrowBook();

                System.out.println("Book\n" + ConsoleFormatter.WHITE + book + ConsoleFormatter.RESET + "\nhas been borrowed");
                return;
            } else System.out.println("No book was found!");
        }
    }
}