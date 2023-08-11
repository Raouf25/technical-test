package technical.test.api.service;

import technical.test.api.model.Person;

import java.util.List;

/**
 * @author Raouf25
 */

public interface PersonService {

    List<Person> findAll();

    Person saveOrUpdatePerson(Person person);


    List<Person> saveOrUpdatePersons(List<Person> persons);
}
