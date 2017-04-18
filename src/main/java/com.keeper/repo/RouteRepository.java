package com.keeper.repo;

/*
 * Created by @GoodforGod on 18.04.2017.
 */

import com.keeper.model.dao.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Default Comment
 */
public interface RouteRepository extends JpaRepository<Route, Long> {
    List<Route> findAllByEmailUserId(@Param("id") Long userId);
}
