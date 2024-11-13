package marcos_dev.bookstore.dtos;

import java.util.Set;
import java.util.UUID;

public record BookDTO(String title,
                      UUID publisherId,
                      Set<UUID> authorIds,
                      String review) {


}
