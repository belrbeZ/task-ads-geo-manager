package com.keeper.repo;

/*
 * Created by GoodforGod on 23.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */

import com.keeper.entity.dao.Task;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Spring Data JPA Repository for Tasks
 */
//@Repository
//@Qualifier(value = RepositoryResolver.QUALIFIER_TASK)
public interface TaskRepository {//extends JpaRepository<Task, Long> {
    List<Task> findAllByTags(@Param("tagId") List<Long> tagsId);

    List<Task> findAllByTopicStarterId(@Param("userId") Long userId);

    List<Task> findAllByTheme(@Param("theme") String theme);

    List<Task> findByTopicStarterId(@Param("userId") Long userId);
}
