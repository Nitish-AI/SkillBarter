package org.generation.SkillBarter.controller;

import org.generation.SkillBarter.dto.SkillRequest;
import org.generation.SkillBarter.model.Skill;
import org.generation.SkillBarter.services.SkillService;
import org.generation.SkillBarter.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/skill-barter")
public class SkillController {
    @Autowired
    private UserService userService;
    @Autowired
    private SkillService skillService;

    @PostMapping("/post/{userId}")
    public ResponseEntity<Skill> postSkill(@PathVariable Long userId,//api for posting skill
                                           @RequestBody SkillRequest request){
        Skill skill =skillService.createSkill(userId,request);
        return ResponseEntity.ok(skill);
    }
    @GetMapping("/user/{userId}/skills")
    public ResponseEntity<?> getAllSkills(@PathVariable Long userId){//fetch user posted skills by user id
        return ResponseEntity.ok(skillService.getAllSkillByUser(userId));
    }
    @GetMapping("/skills/{userId}")
    public ResponseEntity<?> getSkill(@PathVariable Long userId) {// get specific user skill by user id
        try {
            List<Skill> skills = skillService.getSkillByUserId(userId);
            return ResponseEntity.ok(skills);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }


}
