package quantumbookstore;

import quantumbookstore.model.*;
import quantumbookstore.service.Inventory;
import quantumbookstore.service.PurchaseService;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        PurchaseService purchaseService = new PurchaseService(inventory);
        inventory.addBook(new PaperBook("978-001", "Java Fundamentals", 2020, 250.0, 5));
        inventory.addBook(new EBook("978-002", "Clean Code (EBook)", 2018, 150.0, "PDF"));
        inventory.addBook(new ShowcaseBook("978-003", "The Lost Codex", 2015, 0.0));
        inventory.addBook(new PaperBook("978-004", "Old Tech Book", 2010, 180.0, 2));

        System.out.println("=== Inventory Setup Complete ===\n");

        // Remove outdated books (older than 10 years)
        System.out.println("Removing books older than 10 years...\n");
        inventory.removeOutdatedBooks(10);

        // Try successful PaperBook purchase
        System.out.println("→ Buying 2 copies of 'Java Fundamentals'");
        purchaseService.buyBook("978-001", 2, "user@example.com", "123 Main St");

        // Try successful EBook purchase
        System.out.println("\n→ Buying 'Clean Code (EBook)'");
        purchaseService.buyBook("978-002", 1, "user@example.com", "123 Main St");

        // Try exceeding stock
        System.out.println("\n→ Buying 10 copies of 'Java Fundamentals'");
        purchaseService.buyBook("978-001", 10, "user@example.com", "123 Main St");

        // Try buying ShowcaseBook
        System.out.println("\n→ Trying to buy 'The Lost Codex' (Showcase)");
        purchaseService.buyBook("978-003", 1, "user@example.com", "123 Main St");

        // Try invalid ISBN
        System.out.println("\n→ Trying to buy a book that doesn't exist");
        purchaseService.buyBook("978-999", 1, "user@example.com", "123 Main St");
    }
}
