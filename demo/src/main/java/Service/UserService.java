package Service;

import Model.User;
import Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;


// Servicio de Usuarios
@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
        return repository.save(user);
    }

    public User getUserByDocument(String document) {
        return repository.findByDocument(document);
    }
}