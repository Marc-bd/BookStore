package marcos_dev.bookstore.services;

import jakarta.transaction.Transactional;
import marcos_dev.bookstore.dtos.PublisherDTO;
import marcos_dev.bookstore.models.PublisherModel;
import marcos_dev.bookstore.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PublisherService {

    public final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }


    public List<PublisherModel> getAllPublishers() {
        return publisherRepository.findAll();
    }

    @Transactional
    public PublisherModel createPublisher(PublisherDTO publisherDTO) {
        PublisherModel publisher = new PublisherModel();
        publisher.setName(publisherDTO.name());
        return publisherRepository.save(publisher);
    }

    @Transactional
    public PublisherModel updatePublisher(UUID id, PublisherDTO publisherDTO) {
        PublisherModel publisher = publisherRepository.findById(id).orElse(null);

        if (publisher != null) {
            publisher.setName(publisherDTO.name());
            return publisherRepository.save(publisher);
        }
        else {
            throw new IllegalArgumentException("Publisher not found");
        }

    }

    @Transactional
    public void deletePublisher(UUID id) {
        publisherRepository.deleteById(id);
    }

}
