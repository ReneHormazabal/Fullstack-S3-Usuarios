package ejercicioa.ejercicioa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ejercicioa.ejercicioa.model.User;
import ejercicioa.ejercicioa.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }


    @Override
    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public User updateUser(int id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id);
            return userRepository.save(user);
        } else {
            return null;
        }
    }


    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }


    @Override
    public Optional<User> findUserByEmail(String correo) {
        return userRepository.findUserByEmail(correo);
    }

    
}
