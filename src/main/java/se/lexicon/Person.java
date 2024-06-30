package se.lexicon;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private static int sequencer = 0;
    private final int id;
    private String firstName;
    private String lastName;
    private final List<Book> loanedBooks;

    public Person(String firstName, String lastName) {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or empty.");
        }
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty.");
        }

        this.id = getNextId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.loanedBooks = new ArrayList<>();
    }

    private int getNextId() {
        return ++sequencer;
    }

    public void loanBook(Book book) {
        if (book.isAvailable()) {
            loanedBooks.add(book);
            book.setAvailable(false);
            book.setBorrower(this);
        } else {
            System.out.println("Book is already loaned.");
        }
    }

    public void returnBook(Book book) {
        if (loanedBooks.remove(book)) {
            book.setAvailable(true);
            book.setBorrower(null);
        } else {
            System.out.println("This book was not loaned by this person.");
        }
    }

    public String getPersonInformation() {
        return "Person ID: " + id + ", Name: " + firstName + " " + lastName;
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or empty.");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty.");
        }
        this.lastName = lastName;
    }

    public List<Book> getLoanedBooks() {
        return loanedBooks;
    }
}
