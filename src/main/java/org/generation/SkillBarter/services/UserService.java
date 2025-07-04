package org.generation.SkillBarter.services;

import org.generation.SkillBarter.dto.UserProfile;
import org.generation.SkillBarter.dto.UserProfileUpdate;
import org.generation.SkillBarter.model.User;
import org.generation.SkillBarter.repositories.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(@NotNull User user){
        if(userRepository.existsByEmail(user.getEmail())){          //post the all information of user to database
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
    public UserProfile getUserProfile(Long userId){
        User user=userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not Found"));
        return new UserProfile(
                user.getFirstName(),                //Display this data of user on profile page
                user.getLastName(),
                user.getUserName(),
                user.getBio(),
                user.getAddress(),
                user.getDateOfJoin(),
                user.getImageUrl()
        );
    }
    public UserProfile updateUserProfile(Long userId,UserProfileUpdate update){
        User user=userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User not Found"));
        if(!user.getPassword().equals(update.getCurrentPassword())){
            throw new RuntimeException("Incorrect Password");
        }
        user.setFirstName(update.getFirstName());            //this will verify the password and then user can edit the user details
        user.setLastName(update.getLastName());
        user.setUserName(update.getUserName());
        user.setBio(update.getBio());
        user.setAddress(update.getAddress());
        user.setImageUrl(update.getImageUrl());
        userRepository.save(user);

        return new UserProfile(
                user.getFirstName(),
                user.getLastName(),
                user.getUserName(),
                user.getBio(),
                user.getAddress(),
                user.getDateOfJoin(),
                user.getImageUrl()
        );

    }



}
