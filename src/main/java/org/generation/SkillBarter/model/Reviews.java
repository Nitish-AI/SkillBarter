package org.generation.SkillBarter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reviews")
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "from_user_id",nullable = false)
    private User fromuser;
    @ManyToOne
    @JoinColumn(name = "to_user_id",nullable = false)
    private User touser;
    @JoinColumn(name = "match_id",nullable = false)
    private Match match;
    @Column(nullable = false)
    private Integer rating;// will be validate in service
    private LocalDateTime feedbackDate=LocalDateTime.now();
}
