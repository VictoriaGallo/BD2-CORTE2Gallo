package controller;

import Model.Tutor;
import Service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// Controlador de Tutores
@RestController
@RequestMapping("/tutors")
public class TutorController {
    @Autowired
    private TutorService service;

    @PostMapping
    public Tutor addTutor(@RequestBody Tutor tutor) {
        return service.saveTutor(tutor);
    }

    // Puedes agregar más métodos de controlador según sea necesario
}
