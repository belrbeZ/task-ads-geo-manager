package com.keeper.repo;

/*
 * Created by @GoodforGod on 9.04.2017.
 */

import com.keeper.model.dao.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
@Repository
public interface ZoneRepository extends JpaRepository<Zone, Long> {
    Optional<Zone> findByUserId(Long userId);

    Optional<List<Zone>> findByCity(String city);

    Optional<List<Zone>> findByCountry(String country);

    void removeByUserId(Long userId);
}
