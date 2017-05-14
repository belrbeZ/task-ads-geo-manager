package com.keeper.repo;

/*
 * Created by GoodforGod on 23.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */

import com.keeper.model.dao.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA Repository for Tasks
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<List<Task>> findAllByTopicStarterId(Long userId);

    Optional<List<Task>> findAllByTheme(String theme);

    void removeByIdAndTopicStarterIdIs(Long id, Long topicStarterId);
}
