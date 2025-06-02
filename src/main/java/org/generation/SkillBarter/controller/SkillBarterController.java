package org.generation.SkillBarter.controller;

import lombok.Getter;
import org.generation.SkillBarter.dto.SkillRequest;
import org.generation.SkillBarter.model.Skill;
import org.generation.SkillBarter.model.User;
import org.generation.SkillBarter.services.SkillService;
import org.generation.SkillBarter.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/skill-barter")
public class SkillBarterController {
    @Autowired
    private UserService userService;
    @Autowired
    private SkillService skillService;

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
            return ResponseEntity.ok(user);//200 ok
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());//401 unauthorised
        }
    }

    @PostMapping("/post/{userId}")
    public ResponseEntity<Skill>postSkill(@PathVariable Long userId,
                                          @RequestBody SkillRequest request){
        Skill skill =skillService.createSkill(userId,request);
        return ResponseEntity.ok(skill);
    }
    @GetMapping("/skills/{userId}")
    public ResponseEntity<?> getSkill(@PathVariable Long userId) {
        try {
            List<Skill> skills = skillService.getSkillByUserId(userId);
            return ResponseEntity.ok(skills);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
    @GetMapping("/all-skills")
    public ResponseEntity<?> getAllSkills() {
        List<Skill> skills = skillService.getAllSkills();

        // Return selected fields only
        List<Map<String, Object>> response = skills.stream().map(skill -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", skill.getId());
            map.put("title", skill.getTitle());
            map.put("description", skill.getDescription());
            map.put("postedDate", skill.getPostedDate());
            map.put("tags", Collections.singletonList(skill.getTags()));
            return map;
        }).toList();

        return ResponseEntity.ok(response);
    }
    @GetMapping("/user/{userId}/teach-skills")      // fetch specific user all teach skills
    public ResponseEntity<?> getUserSkills(@PathVariable Long userId){
        List<Skill> userSkill=skillService.getSkillTeachByUser(userId);
        if(userSkill.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Skills Found for this user.");
        }
        return ResponseEntity.ok(userSkill);
    }

}
