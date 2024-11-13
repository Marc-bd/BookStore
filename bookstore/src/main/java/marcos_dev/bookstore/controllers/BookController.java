package marcos_dev.bookstore.controllers;

import marcos_dev.bookstore.dtos.BookDTO;
import marcos_dev.bookstore.models.BookModel;
import marcos_dev.bookstore.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookstore/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookModel>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PostMapping
    public ResponseEntity<BookModel> createBook(@RequestBody
                                                BookDTO book) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(book));
    }
}
