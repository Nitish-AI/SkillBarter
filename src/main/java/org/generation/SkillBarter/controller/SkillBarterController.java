package org.generation.SkillBarter.controller;

import org.generation.SkillBarter.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/skill-barter")
public class SkillBarterController {
    @Autowired
    private UserService userService;

    public String sddUser(@RequestParam String fullName,
                          @RequestParam String email,
                          @RequestParam String password,
                          @RequestParam String bio,
                          @RequestParam String address,
                          @RequestParam String image){
        userService.saveUser(fullName, email, password, bio, address, image);
        return "User Added";
    }
}
