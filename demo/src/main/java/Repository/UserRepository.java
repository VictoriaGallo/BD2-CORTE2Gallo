package Repository;

import Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


// Repositorio de Usuarios
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByDocument(String document);
}

