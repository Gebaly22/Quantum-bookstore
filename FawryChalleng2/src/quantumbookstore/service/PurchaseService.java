package quantumbookstore.service;

import quantumbookstore.exception.BookNotForSaleException;
import quantumbookstore.exception.OutOfStockException;
import quantumbookstore.model.Book;

public class PurchaseService {

    private final Inventory inventory;

    public PurchaseService(Inventory inventory) {
        this.inventory = inventory;
    }

    public void buyBook(String isbn, int quantity, String email, String address) {
        Book book = inventory.getBookByISBN(isbn);

        if (book == null) {
            System.out.println("Book with ISBN " + isbn + " not found.");
            return;
        }

        try {
            double total = book.purchase(quantity, email, address);
            System.out.printf("Purchase successful. Total: $%.2f%n", total);
        } catch (OutOfStockException | BookNotForSaleException e) {
            System.out.println("Purchase failed: " + e.getMessage());
        }
    }
}
