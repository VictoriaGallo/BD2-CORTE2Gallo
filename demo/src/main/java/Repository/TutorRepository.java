package Repository;

import Model.Tutor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


// Repositorio de Tutores
public interface TutorRepository extends MongoRepository<Tutor, String> {

    List<Tutor> findByCoursesRatingGreaterThan(int N);

}
