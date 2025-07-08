package quantumbookstore.model;

import quantumbookstore.service.MailService;

public class EBook extends Book {
    private String fileType;

    public EBook(String isbn, String title, int year, double price, String fileType) {
        super(isbn, title, year, price);
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    @Override
    public double purchase(int quantity, String email, String address) {
        MailService.send(email);

        return price * quantity;
    }
}
