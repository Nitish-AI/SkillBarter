package org.generation.SkillBarter.services;

import org.generation.SkillBarter.model.User;
import org.generation.SkillBarter.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

//    public void saveUser(String firstName,
//                         String lastName,
//                         String email,
//                         String password,
//                         String bio,
//                         String address,
//                         String image){
//        User user=new User(firstName,lastName,email,password,bio,address,image);
//        userRepository.save(user);
//    }
    public User registerUser(User user){
        if(userRepository.existsByEmail(user.getEmail())){
            throw new RuntimeException("Email already registered.");
        }
        user.setDateOfJoin(LocalDate.now());
        return userRepository.save(user);
    }
    public User login(String email,String password){
        User user=userRepository.findByEmail(email).orElseThrow(()-> new RuntimeException("User not found"));
        if (!user.getPassword().equals(password)){
            throw new RuntimeException("Invalid password");
        }
        return user;
    }


//
//
//    public boolean isEmailTaken(String email){
//        return userRepository.existsByEmail(email);
//    }
//    public void registerUser(User user) {
//        if (isEmailTaken(user.getEmail())) {
//            throw new IllegalArgumentException("Email already registered.");
//        }
//        userRepository.save(user);
//    }
}
