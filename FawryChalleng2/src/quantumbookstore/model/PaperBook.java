package quantumbookstore.model;

import quantumbookstore.exception.OutOfStockException;
import quantumbookstore.service.ShippingService;

public class PaperBook extends Book {
    int stock;

    public PaperBook(String isbn, String title, int year, double price, int stock) {
        super(isbn, title, year, price);
        this.stock = stock;
    }

    @Override
    public double purchase(int quantity, String email, String address) {
        if (quantity > stock)
            throw new OutOfStockException("Sorry, there isn't enough stock available to complete your request.");

        stock -= quantity;
        ShippingService.send(address);
        return price * quantity;
    }

}
