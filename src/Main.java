import Classes.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
    Scanner scanner = new Scanner(System.in);

    Books booksManager = new Books(scanner);

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
                    booksManager.addBook();
                    break;
                case 2:
                    booksManager.displayBooks();
                    break;
                case 3:
                    booksManager.searchBook();
                    break;
                case 4:
                    booksManager.borrowBook();
                    break;
                case 5:
                    FilesManager.saveBooksToFile(booksManager.getBooks());
                    break;
                case 6:
                    booksManager.setBooks(FilesManager.loadBooksFromFile());
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

}