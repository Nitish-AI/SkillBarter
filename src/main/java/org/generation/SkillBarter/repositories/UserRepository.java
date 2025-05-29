package org.generation.SkillBarter.repositories;

import org.generation.SkillBarter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
