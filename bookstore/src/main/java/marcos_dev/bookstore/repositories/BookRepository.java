package marcos_dev.bookstore.repositories;

import marcos_dev.bookstore.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;
import java.util.UUID;

public interface BookRepository extends JpaRepository<BookModel, UUID> {


}
