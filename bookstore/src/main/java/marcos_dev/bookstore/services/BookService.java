package marcos_dev.bookstore.services;

import jakarta.transaction.Transactional;
import marcos_dev.bookstore.dtos.BookDTO;
import marcos_dev.bookstore.models.BookModel;
import marcos_dev.bookstore.models.ReviewModel;
import marcos_dev.bookstore.repositories.AuthorRepository;
import marcos_dev.bookstore.repositories.BookRepository;
import marcos_dev.bookstore.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BookService(
            BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }


    public List<BookModel> getAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public BookModel createBook(BookDTO bookDTO) {
        BookModel book = new BookModel();

        book.setTitle(bookDTO.title());
        book.setPublisher(publisherRepository.findById(bookDTO.publisherId()).get());
        book.setAuthors(authorRepository.findAllById(bookDTO.authorIds()).stream().collect(Collectors.toSet()));

        ReviewModel review = new ReviewModel();
        review.setComment(bookDTO.review());
        review.setBooks(book);

        book.setReview(review);

        return bookRepository.save(book);


    }
}
