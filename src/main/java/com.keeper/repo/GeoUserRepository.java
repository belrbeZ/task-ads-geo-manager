package com.keeper.repo;

/*
 * Created by @GoodforGod on 02.05.2017.
 */

import com.keeper.model.dao.GeoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
@Repository
public interface GeoUserRepository extends JpaRepository<GeoUser, Long> {
    Optional<List<GeoUser>> findAllByUserId(@Param("userId") Long userId);
}
