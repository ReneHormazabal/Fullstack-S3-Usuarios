package ejercicioa.ejercicioa.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;

import ejercicioa.ejercicioa.model.ErrorResponse;
import ejercicioa.ejercicioa.model.User;
import ejercicioa.ejercicioa.services.UserService;
import ejercicioa.ejercicioa.services.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getUsers() {
        List<User> users = userService.getUsers();
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAASDASDASDASD1231231231248912938128939812"+ users);
        if (users.isEmpty()) {
            System.out.println("Se ingresa a /users/id, no se encuentra el usuario");
            ErrorResponse err = new ErrorResponse("No se encontraron usuarios", 404);
            return ResponseEntity.status(404).body(err);
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        Optional<User> userOptional = userService.getUserById(id);
        if (!userOptional.isPresent()) {  // Cambio aquí para verificar si el Optional está vacío
            System.out.println("Se ingresa a /users/" + id + ", no se encuentra el usuario");
            ErrorResponse err = new ErrorResponse("Usuario no encontrado", 404);
            return ResponseEntity.status(404).body(err);
        }
        System.out.println("Se ingresa a /users/" + id + ", se encuentra el usuario");
        User user = userOptional.get();
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, User user) {
        User updatedUser = userService.updateUser(id, user);
        if (updatedUser == null) {
            System.out.println("Se ingresa a /users/id, no se encuentra el usuario ❌");
            ErrorResponse err = new ErrorResponse("Usuario no encontrado", 404);
            return ResponseEntity.status(404).body(err);
        }
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        User user = userService.findUserByEmail(email).orElse(null);
        if (user == null) {
            System.out.println("Se ingresa a /users/login, no se encuentra el usuario ❌");
            ErrorResponse err = new ErrorResponse("Usuario no encontrado", 404);
            return ResponseEntity.status(404).body(err);
        }
        if (!user.getPassword().equals(password)) {
            System.out.println("Se ingresa a /users/login, contraseña incorrecta ❌");
            ErrorResponse err = new ErrorResponse("Contraseña incorrecta", 401);
            return ResponseEntity.status(401).body(err);
        }
        return ResponseEntity.ok("Login exitoso ✅");
    }





    

}
