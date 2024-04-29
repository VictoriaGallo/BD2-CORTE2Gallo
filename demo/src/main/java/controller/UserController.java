package controller;

import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


// Controlador de Usuarios
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping
    public User addUser(@RequestBody User user) {
        Model.User User;
        return (User) service.saveUser(User);
    }

    @GetMapping("/{document}")
    public Model.User getUserByDocument(@PathVariable String document) {
        return service.getUserByDocument(document);
    }
}

