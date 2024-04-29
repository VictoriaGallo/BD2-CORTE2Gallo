package Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


// Modelo de Tutor
@Document(collection = "tutors")
public class Tutor {
    @Id
    private String id;
    private String name;
    private List<Course> courses;
    // getters y setters
}
