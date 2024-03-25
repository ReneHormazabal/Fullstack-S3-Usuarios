package ejercicioa.ejercicioa.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import ejercicioa.ejercicioa.classes.Rol;
import ejercicioa.ejercicioa.classes.User;
import ejercicioa.ejercicioa.classes.ErrorResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class UserController {
    
    private List<User> users = new ArrayList<User>();

    public UserController() {
        users.add(new User(0, "Franco", "franco@franco.cl", "losfrancos123", Arrays.asList(new Rol(0, "admin"))));
        users.add(new User(1, "Italo", "italo@italo.cl", "lositalos123", Arrays.asList(new Rol(1, "comun"))));
        users.add(new User(2, "Giovanni", "giovanni@giovanni.cl", "losgiovannis", Arrays.asList(new Rol(2, "superUser"))));
    }


    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {

        //Si la lista no viene vacía, se retornan los usuarios
        if (!users.isEmpty()) { 
            System.out.println("Se ingresa a /users y se retornan los usuarios 🚀");
            return ResponseEntity.ok(users);
        //Si la lista viene vacía, se retorna un error
        } else { 
            System.out.println("Se ingresa a /users y no se encontraron usuarios ❌");
            ErrorResponse err = new ErrorResponse("No se encontraron usuarios", 404);
            return ResponseEntity.status(404).body(err);
            
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        //Se recorre la lista de usuarios y se compara el id, si se encuentra se retorna el usuario
        for (User user : users) { 
            if (user.getId() == id) {
                System.out.println("Se ingresa a /users/id y se retorna el usuario: " + user.getId() + " 🙍‍♂️");
                return ResponseEntity.ok(user);
            }
        }
        //Si no se encuentra el usuario, se retorna un error
        System.out.println("Se ingresa a /users/id, no se encuentra el usuario ❌");
        ErrorResponse err = new ErrorResponse("No se encontraron usuarios", 404);
        return ResponseEntity.status(404).body(err);
    }


    

}
