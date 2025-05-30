//package org.generation.SkillBarter.model;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.time.LocalDateTime;
//@Getter
//@Setter
//@Entity
//@Table(name = "reviews")
//public class Reviews {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @ManyToOne
//    @JoinColumn(name = "from_user_id",nullable = false)
//    private User fromuser;
//    @ManyToOne
//    @JoinColumn(name = "to_user_id",nullable = false)
//    private User touser;
//    @ManyToOne
//    @JoinColumn(name = "match_id",nullable = false)
//    private Match match;
//    @Column(nullable = false)
//    private Integer rating;// will be validate in service
//    private LocalDateTime feedbackDate=LocalDateTime.now();
//
//    public Reviews() {
//    }
//
//    public Reviews(User fromuser, User touser, Match match, Integer rating) {
//        this.fromuser = fromuser;
//        this.touser = touser;
//        this.match = match;
//        this.rating = rating;
//    }
//}
