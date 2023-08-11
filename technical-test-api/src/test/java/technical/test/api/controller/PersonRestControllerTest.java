package technical.test.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import technical.test.api.model.Person;
import technical.test.api.service.PersonService;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.util.Arrays.asList;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author ragcrix
 */
@RunWith(SpringRunner.class)
@WebMvcTest
public class PersonRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PersonService personService;


    private ObjectMapper objectMapper = new ObjectMapper();

    private Person ragcrix;
    private Person yigit;

    private final Long ragcrixPersonNumber = 23L;
    private final Long yigitPersonNumber = 91L;

    @Before
    public void setup() {
        ragcrix = new Person();
        ragcrix.setId("aBc123");
        ragcrix.setName("ragcrix");
        ragcrix.setEmail("ragcrix@rg.com");
        ragcrix.setPersonNumber(ragcrixPersonNumber);
        ragcrix.setCourseList(Arrays.asList("Math", "Science"));

        yigit = new Person();
        yigit.setId("dEf345");
        yigit.setName("yigit");
        yigit.setEmail("yigit@ygt.com");
        yigit.setPersonNumber(yigitPersonNumber);
        yigit.setCourseList(Arrays.asList("Turkish", "German"));
    }

    @Test
    public void givenPersons_whenGetAllPersons_thenReturnJsonArray() throws Exception {
        given(personService.findAll()).willReturn(Arrays.asList(ragcrix, yigit));

        mvc.perform(get("/persons/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is(ragcrix.getName())))
                .andExpect(jsonPath("$[1].name", is(yigit.getName())));
    }

    @Test
    public void givenPersons_whenPostSaveOrUpdatePersons_thenReturnJsonArray() throws Exception {
        given(personService.findAll()).willReturn(Arrays.asList(ragcrix, yigit));

        String jsonString = objectMapper.writeValueAsString(Arrays.asList(ragcrix,yigit));


        mvc.perform(post("/persons/list-upsert")
                        .contentType(MediaType.APPLICATION_JSON).content(jsonString))
                .andExpect(status().isOk());
    }

}
