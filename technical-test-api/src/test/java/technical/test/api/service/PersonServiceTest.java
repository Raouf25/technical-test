package technical.test.api.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import technical.test.api.model.Person;
import technical.test.api.repository.PersonRepository;
import technical.test.api.service.impl.PersonServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
public class PersonServiceTest {


    @InjectMocks
    private PersonServiceImpl personService;

    @Mock
    private PersonRepository personRepository;

    private Person sami;
    private Person anis;

    private final Long samiPersonNumber = 23L;
    private final Long anisPersonNumber = 91L;
    private final String samiEmail = "sami@rg.com";
    private final String anisEmail = "anis@ygt.com";
    private final List<Person> persons = new ArrayList<>();

    @Before
    public void setup() {
        sami = new Person();
        sami.setId("aBc123");
        sami.setName("sami");
        sami.setEmail(samiEmail);
        sami.setPersonNumber(samiPersonNumber);
        sami.setCourseList(Arrays.asList("Math", "Science"));

        anis = new Person();
        anis.setId("dEf345");
        anis.setName("anis");
        anis.setEmail(anisEmail);
        anis.setPersonNumber(anisPersonNumber);
        anis.setCourseList(Arrays.asList("Turkish", "German"));

        persons.add(sami);
        persons.add(anis);

        Mockito.when(personRepository.findAll()).thenReturn(persons);

        Mockito.when(personRepository.save(sami)).thenReturn(sami);

        Mockito.when(personRepository.saveAll(persons)).thenReturn(persons);
    }

    @Test
    public void testFindAll_thenPersonListShouldBeReturned() {
        List<Person> foundPersons = personService.findAll();

        assertNotNull(foundPersons);
        assertEquals(2, foundPersons.size());
    }

    @Test
    public void testSaveOrUpdatePerson_thenPersonShouldBeReturned() {
        Person found = personService.saveOrUpdatePerson(sami);

        assertNotNull(found);
        assertEquals(sami.getName(), found.getName());
        assertEquals(sami.getId(), found.getId());
    }

    @Test
    public void testSaveOrUpdatePersons_thenPersonListShouldBeReturned() {
        List<Person> foundPersons = personService.saveOrUpdatePersons(persons);

        assertNotNull(foundPersons);
        assertEquals(2, foundPersons.size());
    }

}
