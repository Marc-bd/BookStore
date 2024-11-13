package marcos_dev.bookstore.controllers;

import marcos_dev.bookstore.dtos.PublisherDTO;
import marcos_dev.bookstore.models.PublisherModel;
import marcos_dev.bookstore.services.PublisherService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bookstore/publishers")
public class PublisherController {

    public final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    public ResponseEntity<List<PublisherModel>> getAllPublishers(){
        List<PublisherModel> publishers = publisherService.getAllPublishers();
        return ResponseEntity.ok(publishers);
    }

    @PostMapping
    public ResponseEntity<PublisherModel> createPublisher(@RequestBody
                                                       PublisherDTO publisherDTO){
        return ResponseEntity.ok(publisherService.createPublisher(publisherDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublisherModel> updatePublisher(@PathVariable
                                                          UUID id, @RequestBody PublisherDTO publisherDTO){
        return ResponseEntity.ok(publisherService.updatePublisher(id, publisherDTO));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePublisher(@PathVariable
                                                      UUID id) {
        publisherService.deletePublisher(id);
        return ResponseEntity.ok("Deleted publisher");
    }

}
