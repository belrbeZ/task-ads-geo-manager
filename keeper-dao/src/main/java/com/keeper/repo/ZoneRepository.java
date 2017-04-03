package com.keeper.repo;

/*
 * Created by GoodforGod on 26.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */

import com.keeper.entity.Zone;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Default Comment
 */
@Repository
@Qualifier(value = "zoneRepository")
public interface ZoneRepository extends JpaRepository<Zone, Long> {
    Zone findByOwnerId(@Param("ownerId") Long ownerId);
}
