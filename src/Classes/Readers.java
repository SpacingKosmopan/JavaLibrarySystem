package Classes;

import java.util.ArrayList;

public class Readers {
    ArrayList<Reader> readers;

    public void addReader(Reader r) {
        readers.add(r);
    }

    public void displayReaders() {
        readers.forEach(reader -> {
            System.out.println(reader);
        });
    }

    public Reader findReaderById(int id) {
        return readers.stream().filter(reader -> reader.getId() == id).findFirst().orElse(null);
    }
}