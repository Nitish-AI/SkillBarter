package org.generation.SkillBarter.repositories;

import org.generation.SkillBarter.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill,Long> {
}
