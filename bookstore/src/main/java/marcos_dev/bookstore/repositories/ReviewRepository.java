package marcos_dev.bookstore.repositories;

import marcos_dev.bookstore.models.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<ReviewModel, UUID> {
}