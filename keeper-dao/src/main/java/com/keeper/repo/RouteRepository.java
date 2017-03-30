package com.keeper.repo;

/*
 * Created by GoodforGod on 26.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */

import com.keeper.entity.Route;
import com.keeper.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Default Comment
 */
public interface RouteRepository extends JpaRepository<Route, Long> , QueryDslPredicateExecutor<Task> {
}
