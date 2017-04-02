package com.keeper.repo;

/*
 * Created by GoodforGod on 23.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */

import com.keeper.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

/**
 * Spring Data JPA Repository for Tasks
 */
public interface TaskRepository extends JpaRepository<Task, Long> {//, QueryDslPredicateExecutor<Task> {
    List<Task> findAllByTags(Set<String> tags);

    List<Task> findAllByTopicStarterId(@Param("userId") Long userId);

    List<Task> findAllByTheme(@Param("theme") String theme);

    List<Task> findByTopicStarterId(@Param("ownerId") Long ownerId);
}
