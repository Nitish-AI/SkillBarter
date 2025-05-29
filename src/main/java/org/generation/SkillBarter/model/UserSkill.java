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
@Table(name = "user_skill")
public class UserSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//primary key with auto increment
    private Long id;
    @ManyToOne          //many user associated with multiple skills
    @JoinColumn(name = "user_id",nullable = false)
    private User user;//Foreign key
    @ManyToOne
    @JoinColumn(name = "skill_id",nullable = false)
    private Skill skill;//Foreign key
    private UserType type;//('TEACH','LEARN')
    private Long experience;
    private String availability;
}
