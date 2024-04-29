package Service;

import Model.Tutor;

import Repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;


// Servicio de Tutores
@Service
public class TutorService {
    @Autowired
    private TutorRepository repository;

    public Tutor saveTutor(Tutor tutor) {
        return repository.save(tutor);
    }

    // Puedes agregar más métodos de servicio según sea necesario
}
