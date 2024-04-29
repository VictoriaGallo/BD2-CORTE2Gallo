package Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


// Modelo
@Document(collection = "courses")
public class Course {
    @Id
    private String id;
    private String name;
    private String category;
    private double price;
    private int totalHours;
    private boolean certification;

    public void setId(String id) {
    }
    // getters y setters
}

