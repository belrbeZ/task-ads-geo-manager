package com.keeper.repo;

/*
 * Created by @GoodforGod on 18.04.2017.
 */

import com.keeper.model.dao.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    Optional<List<Route>> findAllByUserId(Long userId);
}
