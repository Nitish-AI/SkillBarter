package org.generation.SkillBarter.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;


@Setter
@Getter
@Entity
@Table(name = "register_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String fullName;
    @Column(name = "email",unique = true,nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(columnDefinition = "TEXT")
    private String bio;
    private String address;
    @Column(name = "date_of_join", nullable = false)
    private LocalDate dateOfJoin = LocalDate.now();
    private String imageUrl;

    public User() {
    }

    public User(String fullName, String email, String password, String bio, String address,String imageUrl) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.bio = bio;
        this.address = address;
        this.imageUrl = imageUrl;
    }
}
