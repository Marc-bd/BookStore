package marcos_dev.bookstore.controllers;

import marcos_dev.bookstore.dtos.AuthorDTO;
import marcos_dev.bookstore.models.AuthorModel;
import marcos_dev.bookstore.services.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/bookstore/authors")
public class AuthorController {

    public AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<AuthorModel> createAuthor(@RequestBody
                                                    AuthorDTO authorDTO) {
        return ResponseEntity.ok(authorService.createAuthor(authorDTO));
    }

    @GetMapping
    public ResponseEntity<List<AuthorModel>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorModel> updateAuthor(@PathVariable("id")
                                                    UUID id, @RequestBody AuthorDTO authorDTO) {
        return ResponseEntity.ok(authorService.updateAuthor(id, authorDTO.name()));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable("id")
                                                   UUID id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.ok("Deleted Author");
    }

}
