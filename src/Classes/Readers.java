package Classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Readers {
    ArrayList<Reader> readers= new  ArrayList<>();
    Scanner scanner;

    public Readers(Scanner scanner) {
        this.scanner = scanner;
    }

    public void addReader() {
        scanner.nextLine();
        System.out.print("Enter reader first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter reader last name: ");
        String lastName = scanner.nextLine();

        readers.add(new Reader(firstName, lastName));
    }

    public void displayReaders() {
        if (readers.isEmpty()) {
            System.out.println("+=====" + ConsoleFormatter.GREEN + " READERS " + ConsoleFormatter.RESET + "=====+" + ConsoleFormatter.WHITE);
            System.out.println("There are no readers");
            System.out.println(ConsoleFormatter.RESET + "+=================+");

            return;
        }

        System.out.println("+=====" + ConsoleFormatter.GREEN + " READERS " + ConsoleFormatter.RESET + "=====+" + ConsoleFormatter.WHITE);
        readers.forEach(System.out::println);
        System.out.println(ConsoleFormatter.RESET + "+=================+");
    }

    public Reader findReaderById(int id) {
        return readers.stream().filter(reader -> reader.getId() == id).findFirst().orElse(null);
    }
}