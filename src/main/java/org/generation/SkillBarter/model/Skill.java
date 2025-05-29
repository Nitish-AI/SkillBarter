package org.generation.SkillBarter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title",nullable = false,unique = true)
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)//("BEGINNER","INTERMEDIATE","EXPERT")
    @Column(nullable = false)
    private SkillLevel level;
}
