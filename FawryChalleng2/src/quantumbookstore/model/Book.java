package quantumbookstore.model;

public abstract class Book {
    protected String isbn;
    protected String title;
    protected int year;
    protected double price;

    public Book(String isbn, String title, int year, double price) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    // Abstract method to be implemented by subclasses
    public abstract double purchase(int quantity, String email, String address);
}
