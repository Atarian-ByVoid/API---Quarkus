package com.example.service;

import com.example.representatios.UpdateUserDTO;
import com.example.representatios.CreateUserDTO;
import com.example.entitys.User;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserService {
    @Transactional
    public User create(CreateUserDTO createUserDTO) {
        User user = new User();
        user.age = createUserDTO.getAge();
        user.name = createUserDTO.getName();
        user.username = createUserDTO.getUsername();

        user.persist();
        return user;

    }

    @Transactional
    public User update(Long id, UpdateUserDTO updateUserDTO) {
        User user = new User();
        Optional<User> userOptional = User.findByIdOptional(id);
        if (userOptional.isEmpty()) {
            throw new NullPointerException("User not found, please try again");
        }
        user = userOptional.get();
        user.username = updateUserDTO.getUsername();
        user.persist();

        return user;

    }

    public List<User> getAllUsers() {
        return User.listAll();
    }

    public User getUserByid(Long id) {
        return User.findById(id);

    }

    @Transactional
    public void deleteUserById(Long id) {
        Optional<User> userOptional = User.findByIdOptional(id);
        if (userOptional.isEmpty()) {
            throw new NullPointerException("User not found, please try again");
        }
        User user = userOptional.get();
        user.delete();


    }


}
