package com.keeper.dao.repo;

/*
 * Created by GoodforGod on 23.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Spring Data JPA Repository for Locations
 */
public interface LocationRepository extends JpaRepository<Location, Long> {
    Location findByOwnerId(@Param("ownerId") Long ownerId);

    void deleteByOwnerId(@Param("ownerId") Long ownerId);
}
