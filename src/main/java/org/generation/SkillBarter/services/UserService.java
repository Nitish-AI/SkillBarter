package org.generation.SkillBarter.services;

import org.generation.SkillBarter.model.User;
import org.generation.SkillBarter.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveUser(String fullName,
                         String email,
                         String password,
                         String bio,
                         String address,
                         String image){
        User user=new User(fullName,email,password,bio,address,image);
        userRepository.save(user);
    }
}
