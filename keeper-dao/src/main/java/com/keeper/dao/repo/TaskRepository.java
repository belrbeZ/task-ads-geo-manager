package com.keeper.dao.repo;

/*
 * Created by GoodforGod on 23.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 * Updated by AlexVasil on 28.03.2017.
 *
 */

import com.keeper.entity.Task;
import com.keeper.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Spring Data JPA Repository for Tasks
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByTags(@Param("tags") List<String> tags);

    List<Task> findAllByUser(@Param("user") User user);

    List<Task> findAllByTheme(@Param("theme") String theme);

    List<Task> findByOwnerId(@Param("ownerId") Long ownerId);
}
