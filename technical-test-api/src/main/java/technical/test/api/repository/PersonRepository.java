package technical.test.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import technical.test.api.model.Person;

/**
 * @author Raouf25
 */

public interface PersonRepository extends MongoRepository<Person, String> {
}
