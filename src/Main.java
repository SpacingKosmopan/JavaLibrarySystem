import Classes.Book;
import Classes.ConsoleFormatter;

import java.util.ArrayList;

void main() {
    ArrayList<Book> books = new ArrayList<>();

    String menuDisplay = ConsoleFormatter.GREEN + """
            ===== LIBRARY MANAGEMENT =====
            1. Add book
            2. Display all books
            3. Search book
            4. Borrow book
            5. Save books to file
            6. Load books from file
            0. Exit
            Choose an option:""";

    Scanner scanner = new Scanner(System.in);

    int choice = -1;
    do {
        System.out.println(menuDisplay);
        choice = scanner.nextInt();
    } while (choice != 0);
}