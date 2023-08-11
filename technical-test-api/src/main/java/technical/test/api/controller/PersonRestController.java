package technical.test.api.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import technical.test.api.dto.PersonDTO;
import technical.test.api.model.Person;
import technical.test.api.service.PersonService;
import technical.test.api.util.ObjectMapperUtils;

import java.util.List;


/**
 * @author Raouf25
 */

@RestController
@RequestMapping("/persons")

@RequiredArgsConstructor
public class PersonRestController {


    private final PersonService studentService;

    @GetMapping(value = "")
    public List<PersonDTO> getAllPersons() {
        return ObjectMapperUtils.mapAll(studentService.findAll(), PersonDTO.class);
    }

    @PostMapping(value = "/upsert")
    public Person saveOrUpdatePerson(@RequestBody PersonDTO studentDTO) {
        return studentService.saveOrUpdatePerson(ObjectMapperUtils.map(studentDTO, Person.class));
    }

    @PostMapping("/list-upsert")
    public List<Person> saveOrUpdatePersons(@RequestBody List<PersonDTO> studentDTOList) {
        List<Person> students = ObjectMapperUtils.mapAll(studentDTOList, Person.class);
        return studentService.saveOrUpdatePersons(students);
    }

}
