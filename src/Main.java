import Classes.*;

import java.io.IOException;
import java.util.Scanner;

class Main {
    Scanner scanner = new Scanner(System.in);

    Books booksManager = new Books(scanner);
    Readers readersManager = new Readers(scanner);

    void main() throws IOException {
        String menuDisplay = ConsoleFormatter.GREEN + "===== LIBRARY MANAGEMENT ====="
                + ConsoleFormatter.WHITE + """
                \n/b1./0 Add book
                /b2./0 Display all books
                /b3./0 Search book
                /b4./0 Borrow book
                /b5./0 Save books to file
                /b6./0 Load books from file
                /b7./0 Add reader
                /b8./0 Display all readers
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
                    borrowBook();
                    break;
                case 5:
                    FilesManager.saveBooksToFile(booksManager.getBooks());
                    break;
                case 6:
                    booksManager.setBooks(FilesManager.loadBooksFromFile());
                    break;
                case 7:
                    readersManager.addReader();
                    break;
                case 8:
                    readersManager.displayReaders();
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

    void borrowBook() {
        readersManager.displayReaders();
        scanner.nextLine();
        System.out.print("Enter reader id: ");
        int id = scanner.nextInt();
        Reader reader = readersManager.findReaderById(id);

        if (reader == null) {
            System.out.println(ConsoleFormatter.RED + "Invalid reader." + ConsoleFormatter.RESET);
            return;
        }

        booksManager.borrowBook(reader);
    }
}