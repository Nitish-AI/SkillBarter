package org.generation.SkillBarter.dto;

import lombok.Getter;
import lombok.Setter;
import org.generation.SkillBarter.enums.Category;
import org.generation.SkillBarter.enums.SessionFormat;
import org.generation.SkillBarter.enums.SkillLevel;

import java.util.List;
@Getter
@Setter
public class SkillRequest {
    private String title;
    private String description;
    private Category category;
    private List<String> tags;
    private String intent;
    private SkillLevel skillLevel;
    private String prerequisites;
    private String equipment;
    private SessionFormat sessionFormat;

}
