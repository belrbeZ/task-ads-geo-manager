package com.keeper.dao.repo;

/*
 * Created by GoodforGod on 23.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Spring Data JPA Repository for Tasks
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByTags(@Param("tags") List<String> tags);

    List<Task> findAllByTheme(@Param("theme") String theme);

    Task findByOwnerId(@Param("ownerId") Long ownerId);
}
