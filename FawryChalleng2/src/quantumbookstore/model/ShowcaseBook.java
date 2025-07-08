package quantumbookstore.model;

import quantumbookstore.exception.BookNotForSaleException;

public class ShowcaseBook extends Book {

    public ShowcaseBook(String isbn, String title, int year, double price) {
        super(isbn, title, year, price);
    }

    @Override
    public double purchase(int quantity, String email, String address) {
        throw new BookNotForSaleException("These showcase books are for display only and cannot be purchased.");
    }
}
