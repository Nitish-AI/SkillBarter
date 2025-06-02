package org.generation.SkillBarter.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title",nullable = false,unique = true)
    private String title;
    @Column(columnDefinition = "text", nullable = false)
    private String description;
    @Enumerated(EnumType.STRING)//BUSINESS,TECHNOLOGY,LANGUAGE,PERSONAL_GROWTH,OTHER
    private Category category;
    @Enumerated(EnumType.STRING)//("BEGINNER","INTERMEDIATE","EXPERT")
    @Column(nullable = false)
    private SkillLevel level;

    public Skill() {
    }

    public Skill(String title, String description, SkillLevel level) {
        this.title = title;
        this.description = description;
        this.level = level;
    }
}
