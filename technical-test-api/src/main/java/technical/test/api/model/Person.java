package technical.test.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author Raouf25
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "persons")
public class Person {
    @Id
    private String id;
    private String name;
    private long personNumber;
    private String email;
    private List<String> courseList;

}
