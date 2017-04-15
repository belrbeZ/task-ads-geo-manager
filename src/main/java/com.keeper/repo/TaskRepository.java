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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Spring Data JPA Repository for Tasks
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByTags(@Param("tagId") Set<Long> tagsId);

    List<Task> findAllByTopicStarterId(@Param("userId") Long userId);

    List<Task> findAllByEmail(@Param("email") String email);

    List<Task> findAllByPhone(@Param("phone") String email);

    List<Task> findAllByTheme(@Param("theme") String theme);

    @Transactional Task removeByTopicStarterId(@Param("topicStarterId") Long topicStarterId);
}
