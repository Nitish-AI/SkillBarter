package org.generation.SkillBarter.dto;

import lombok.Getter;
import lombok.Setter;
import org.generation.SkillBarter.enums.Category;
import org.generation.SkillBarter.enums.SessionFormat;
import org.generation.SkillBarter.enums.SkillLevel;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
public class SkillRequest {
    private Long id;
    private String title;
    private String description;
    private Category category;
    private List<String> tags;
    private String intent;
    private SkillLevel skillLevel;
    private String prerequisites;
    private String equipment;
    private SessionFormat sessionFormat;
    private LocalDate postedDate;
    private String postedBy;

}
