package com.keeper.dao.repo;

/*
 * Created by GoodforGod on 26.03.2017.
 */

import com.keeper.entity.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Default Comment
 */
public interface ZoneRepository extends JpaRepository<Zone, Long> {
    Zone findByOwnerId(@Param("ownerId") Long ownerId);
}
