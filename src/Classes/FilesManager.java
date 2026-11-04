package Classes;

import java.io.*;
import java.util.ArrayList;



public class FilesManager {
    public static void saveBooksToFile(ArrayList<Book> books) throws IOException {
        System.out.println(ConsoleFormatter.YELLOW + " SAVING... " + ConsoleFormatter.RESET);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("books.txt"))) {

            //books.forEach(book -> bw.printf("%s;%s;%d\n", book.getTitle(), book.getAuthor(),book.getPublicationYear()));

            for (Book book : books) {
                String writeReader = book.borrowedBy != null ? (";" + book.borrowedBy.id + ";" + book.borrowedBy.firstName + ";" + book.borrowedBy.lastName) : "";

                bw.write(book.getTitle() + ';' + book.getAuthor() + ';' + book.getPublicationYear() + ';' + book.isBorrowed() + writeReader);
                bw.newLine();
            }

            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Book> loadBooksFromFile() throws IOException {
        System.out.println(ConsoleFormatter.YELLOW + " LOADING... " + ConsoleFormatter.RESET);

        ArrayList<Book> books = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] bookData = line.split(";");

                Reader readerData = bookData[4] != null ? new Reader(Integer.parseInt(bookData[4]), bookData[5], bookData[6]) : null;
                books.add(
                        new Book(
                                bookData[0],
                                bookData[1],
                                Integer.parseInt(bookData[2]),
                                Boolean.parseBoolean(bookData[3]),
                                readerData
                        )
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(ConsoleFormatter.YELLOW + " Loaded " + books.stream().count() + " books" + ConsoleFormatter.RESET);
        return books;
    }
}