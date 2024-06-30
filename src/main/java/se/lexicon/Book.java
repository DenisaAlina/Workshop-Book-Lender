package se.lexicon;

public class Book {
    private String id;
    private String title;
    private String author;
    private boolean available;
    private Person borrower;

    public Book(String title, String author) {
        this.id = generateId();
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Book title cannot be null or empty.");
        }
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Book author cannot be null or empty.");
        }

        this.title = title;
        this.author = author;
        this.available = true;
        this.borrower = null;
    }

    public Book(String title, String author, Person borrower) {
        this(title, author);
        this.borrower = borrower;
        this.available = false;
    }

    private String generateId() {
        // Generate a unique ID for the book
        return "BOOK" + System.currentTimeMillis();
    }

    public String getBookInformation() {
        return "Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Available: " + available;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Person getBorrower() {
        return borrower;
    }

    public void setBorrower(Person borrower) {
        this.borrower = borrower;
    }
}
