package technical.test.api.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import technical.test.api.model.Person;
import technical.test.api.repository.PersonRepository;
import technical.test.api.service.PersonService;

import java.util.List;

/**
 * @author Raouf25
 */

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }


    @Override
    public Person saveOrUpdatePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> saveOrUpdatePersons(List<Person> persons) {
        return personRepository.saveAll(persons);
    }
}
