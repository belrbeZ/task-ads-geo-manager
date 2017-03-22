package com.keeper.dao.springrepo;

/*
 * Created by GoodforGod on 23.03.2017.
 */

import com.keeper.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA Repository for Tasks
 *
 * MUST BE EXTENDED TO SUPPORT PICS, COORDS
 */
public interface TaskRepository extends JpaRepository<Task, Long> {

}
