package com.example.SpringBook;

import com.example.SpringBook.models.Book;
import com.example.SpringBook.repository.BookJdbcRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {
    private final BookJdbcRepository repository;

    public BookController(BookJdbcRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @ResponseBody
    public List<Book> getBooks() {
        List<Book> sortedBooks = repository.getAllBooks();
        sortedBooks.sort(Comparator.comparing(Book::getTitle).reversed());
        return sortedBooks;
    }

    @GetMapping("/by-author")
    @ResponseBody
    public Map<String, List<Book>> getBooksByAuthor() {
        List<Book> books = getBooks();
        Map<String, List<Book>> booksByAuthor = books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor));

        return booksByAuthor;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void addBook(@Valid @RequestBody Book book) {
        repository.createBook(book.getTitle(), book.getDescription(), book.getAuthor());
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Book getBookById(@PathVariable int id) {
        return repository.getBook(id);
    }
}
