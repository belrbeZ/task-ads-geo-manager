package com.keeper.dao.springrepo;

/*
 * Created by GoodforGod on 23.03.2017.
 *
 * Updated by AlexVasil on 26.03.2017.
 *
 */

import com.keeper.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Spring Data JPA Repository for Locations
 *
 * MUST BE EXTENDED TO SUPPORT ROUTES, COORDINATES
 */
public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findByUserIdStartingWith(String start);

}
