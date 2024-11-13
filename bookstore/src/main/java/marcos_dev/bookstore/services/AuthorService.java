package marcos_dev.bookstore.services;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import marcos_dev.bookstore.dtos.AuthorDTO;
import marcos_dev.bookstore.models.AuthorModel;
import marcos_dev.bookstore.repositories.AuthorRepository;
import org.hibernate.mapping.Set;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;


@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }



    public AuthorModel createAuthor(AuthorDTO authorDTO) {
        AuthorModel author = new AuthorModel();
        author.setName(authorDTO.name());
       return authorRepository.save(author);

    }

    @Transactional
    public List<AuthorModel> getAllAuthors() {
        return authorRepository.findAll();
    }


    @Transactional
   public AuthorModel updateAuthor(UUID id, String newName) {
        AuthorModel author = authorRepository.findById(id).orElse(null);

        if (author != null) {
            author.setName(newName);
            return authorRepository.save(author);
        } else {
            throw new EntityNotFoundException("Author not found");
        }
    }

    @Transactional
    public void deleteAuthor(UUID id) {
        AuthorModel author = authorRepository.findById(id).orElse(null);
        if (author != null) {
            authorRepository.delete(author);
        } else {
            throw new EntityNotFoundException("Author not found");
        }

    }

}
