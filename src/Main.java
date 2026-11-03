import Classes.Book;
import Classes.ConsoleFormatter;

import java.util.ArrayList;
import java.util.Scanner;

class Main {
    ArrayList<Book> books = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    void main() {

        String menuDisplay = ConsoleFormatter.GREEN + "===== LIBRARY MANAGEMENT ====="
                + ConsoleFormatter.WHITE + """
                1. Add book
                2. Display all books
                3. Search book
                4. Borrow book
                5. Save books to file
                6. Load books from file
                0. Exit
                Choose an option:""";

        int choice = -1;
        do {
            System.out.println(menuDisplay);
            choice = scanner.nextInt();
        } while (choice != 0);
    }

    public void addBook() {
        String title = scanner.nextLine();
        String author = scanner.nextLine();
        int publicationYear = scanner.nextInt();

        if(title.isEmpty() || author.isEmpty() || publicationYear < 0){
            System.out.println(ConsoleFormatter.RED + "Invalid input!");
            return;
        }

        bppls
    }
}