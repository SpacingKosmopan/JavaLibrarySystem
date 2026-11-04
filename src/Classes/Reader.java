package Classes;

import java.util.Random;

public class Reader {
    public static int nextId = 0;

    int id;
    String firstName;
    String lastName;

    public Reader(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Reader(String firstName, String lastName) {
        this.id = nextId;
        this.firstName = firstName;
        this.lastName = lastName;

        System.out.println(toString());

        nextId++;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void displayInfo() {
        System.out.println("#" + id + "\n\t╭ First Name: " + firstName + "\n\t╰ Last Name: " + lastName);
    }

    @Override
    public String toString() {
        return "#" + id + "\n\t╭ First Name: " + firstName
                + "\n\t╰ Last Name: " + lastName;
    }
}