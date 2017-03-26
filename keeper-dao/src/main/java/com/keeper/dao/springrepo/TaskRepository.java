package com.keeper.dao.springrepo;

/*
 * Created by GoodforGod on 23.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Spring Data JPA Repository for Tasks
 *
 * MUST BE EXTENDED TO SUPPORT PICS, COORDINATES
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByTopicStarterIdStartingWith(String start);
}
