package edu.hm.shareit.model;

/**
 * The Book class.
 */
public class Book extends Medium {
    private String author;
    private String isbn;

    @Override
    public String toString() {
        return "{"
                + "title='" + getTitle() + '\''
                + ", author='" + author + '\''
                + ", isbn='" + isbn + '\''
                + '}';
    }

    /**
     * Creates a new book.
     */
    public Book() {
        super("");
    }

    /**
     * Creates a new book.
     * @param title - The title of the book.
     * @param author - The author of the book.
     * @param isbn - the ISBN10 or ISBN13 of the book.
     */
    public Book(String title, String author, String isbn) {
        super(title);
        this.author = author;
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        Book book = (Book) o;

        if (author != null ? !author.equals(book.author) : book.author != null) {
            return false;
        }
        return isbn != null ? isbn.equals(book.isbn) : book.isbn == null;
    }

    /**
     * Returns the author of the book.
     * @return author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns the ISBN of the book.
     * @return ISBN of the book.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Sets the ISBN of the book.
     * @param isbn new isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        return result;
    }

}
