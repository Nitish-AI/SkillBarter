package org.generation.SkillBarter.services;

import org.generation.SkillBarter.dto.SkillRequest;
import org.generation.SkillBarter.model.Skill;
import org.generation.SkillBarter.model.User;
import org.generation.SkillBarter.repositories.SkillRepository;
import org.generation.SkillBarter.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private UserRepository userRepository;

    public Skill createSkill(Long userId, SkillRequest request){
        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
        Skill skill =new Skill();
        skill.setTitle(request.getTitle());
        skill.setDescription(request.getDescription());
        skill.setCategory(request.getCategory());
//        skill.setTags(request.getTags());
        skill.setTags(Collections.singletonList(String.join(", ", request.getTags())));
        skill.setIntent(request.getIntent());
        skill.setLevel(request.getSkillLevel());
        skill.setPrerequisites(request.getPrerequisites());
        skill.setEquipment(request.getEquipment());
        skill.setSessionFormat(request.getSessionFormat());
        skill.setUser(user);
        return skillRepository.save(skill);
    }

    public List<Skill> getSkillByUserId(Long userId) {
        List<Skill> skills = skillRepository.findByUserId(userId);
        if (skills == null || skills.isEmpty()) {
            throw new NoSuchElementException("No skills found for user ID: " + userId);
        }
        return skills;
    }
    public List<Skill> getAllSkills() {     //fetch all posted skill
        return skillRepository.findAll();
    }
    public List<Skill> getSkillTeachByUser(Long userId){        //fetch skills by intent and userId
        return skillRepository.findByUserIdAndIntent(userId,"teach");
    }



}
