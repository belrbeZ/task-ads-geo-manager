package com.keeper.repo;

/*
 * Created by @GoodforGod on 17.04.2017.
 */

import com.keeper.model.dao.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Default Comment
 */
public interface TagRepository extends JpaRepository<Task, Long> {

}
