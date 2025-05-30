package org.generation.SkillBarter.controller;

import org.generation.SkillBarter.model.User;
import org.generation.SkillBarter.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/skill-barter")
public class SkillBarterController {
    @Autowired
    private UserService userService;

//    @PostMapping("/signup")
//    public String createUser(@RequestParam String firstName,
//                             @RequestParam String lastname,
//                             @RequestParam String email,
//                             @RequestParam String password,
//                             @RequestParam String bio,
//                             @RequestParam String address,
//                             @RequestParam String image){
//        userService.saveUser(firstName, lastname, email, password, bio, address, image);
//        return "User Added";
//    }
//
//    @GetMapping("/login")
//    public String registeredUser(@PathVariable String email){
//        userService.isEmailTaken(email);
//        return "Already Exist";
//    }
    @PostMapping("/signup")
    public ResponseEntity<?>signup(@RequestBody User user){
        try{
            User newUser=userService.registerUser(user);
            return ResponseEntity.ok(newUser);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?>login(@RequestBody Map<String, String> credentials){
        try{
            String email= credentials.get("email");
            String password= credentials.get("password");
            User user =userService.login(email,password);
            return ResponseEntity.ok(user);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
