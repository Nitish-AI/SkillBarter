package org.generation.SkillBarter.model;

import jakarta.persistence.*;
import lombok.*;
import org.generation.SkillBarter.enums.MatchStatus;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "match_table") // "match" is a reserved SQL keyword, so this is good
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "teach_user_id", nullable = false)
    private User teachUser;

    @ManyToOne(optional = false)
    @JoinColumn(name = "learn_user_id", nullable = false)
    private User learnUser;

    @ManyToOne(optional = false)
    @JoinColumn(name = "teach_skill_id", nullable = false)
    private Skill teachSkill;

    @ManyToOne(optional = false)
    @JoinColumn(name = "learn_skill_id", nullable = false)
    private Skill learnSkill;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MatchStatus status = MatchStatus.PENDING;

    @Column(name = "match_date", nullable = false)
    private LocalDateTime matchDate = LocalDateTime.now();

    @PrePersist
    protected void onCreate() {
        this.matchDate = LocalDateTime.now();
    }
}
