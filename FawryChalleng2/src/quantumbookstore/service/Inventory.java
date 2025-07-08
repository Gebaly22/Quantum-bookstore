package quantumbookstore.service;

import quantumbookstore.model.Book;

import java.util.*;

public class Inventory {

    private final Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public void removeOutdatedBooks(int maxAgeYears) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        Iterator<Map.Entry<String, Book>> iterator = books.entrySet().iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next().getValue();
            int bookAge = currentYear - book.getYear();

            if (bookAge > maxAgeYears) {
                iterator.remove();
            }
        }
    }

    public Book getBookByISBN(String isbn) {
        return books.get(isbn);
    }

    public Collection<Book> getAllBooks() {
        return books.values();
    }
}
