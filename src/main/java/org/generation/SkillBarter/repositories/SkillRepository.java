package org.generation.SkillBarter.repositories;

import org.generation.SkillBarter.enums.Category;
import org.generation.SkillBarter.model.Skill;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SkillRepository extends JpaRepository<Skill,Long> {
    List<Skill> findByCategory(Category category);
    List<Skill> findByUserId(Long userId);
    List<Skill> findByUserIdAndIntent(Long userId,String Intent);
}
