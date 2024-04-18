package ejercicioa.ejercicioa.services;

import java.util.List;
import java.util.Optional;

import ejercicioa.ejercicioa.model.User;

public interface UserService {


    List<User> getUsers();


    Optional<User> getUserById(int id);


    User createUser(User user);

    User updateUser(int id, User user);

    void deleteUser(int id);


    Optional<User> findUserByEmail(String correo);

}
