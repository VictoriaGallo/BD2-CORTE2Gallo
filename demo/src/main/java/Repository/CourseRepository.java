package Repository;

import Model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;


// Repositorio
@Repository
public interface CourseRepository extends MongoRepository<Course, String> {
    List<Course> findByTotalHoursGreaterThan(int totalHours);
}
