package Classes;

import java.io.*;
import java.util.ArrayList;



public class FilesManager {
    public static void saveBooksToFile(ArrayList<Book> books) throws IOException {
        System.out.println(ConsoleFormatter.YELLOW + " SAVING... " + ConsoleFormatter.RESET);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("books.txt"))) {

            //books.forEach(book -> bw.printf("%s;%s;%d\n", book.getTitle(), book.getAuthor(),book.getPublicationYear()));

            for (Book book : books) {
                bw.write(book.getTitle() + ';' + book.getAuthor() + ';' + book.getPublicationYear() + ';' + book.isBorrowed());
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
                books.add(new Book(bookData[0], bookData[1], Integer.parseInt(bookData[2]), Boolean.parseBoolean(bookData[3])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return books;
    }
}