package org.generation.SkillBarter.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "match_table") // Use a different name than "Match" to avoid SQL reserved word conflict
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "teach_user_id", nullable = false)// Foreign key to teach_user_id
    private User teachUser;
    @ManyToOne
    @JoinColumn(name = "learn_user_id", nullable = false)// Foreign key to learn_user_id
    private User learnUser;
    @ManyToOne
    @JoinColumn(name = "teach_skill_id", nullable = false)// Foreign key to teach_skill_id
    private Skill teachSkill;
    @ManyToOne
    @JoinColumn(name = "learn_skill_id", nullable = false)// Foreign key to learn_skill_id
    private Skill learnSkill;
    @Enumerated(EnumType.STRING)
    private MatchStatus status = MatchStatus.PENDING;
    @Column(name = "match_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime matchDate = LocalDateTime.now();
}
