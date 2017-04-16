package com.keeper.test.repo;

import com.keeper.test.model.dao.ZoneTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Alexandr Vasiliev on 05.04.2017.
 *
 * @author Alexandr Vasiliev
 */

@Repository
//@Qualifier(value = "zoneTestRepository")
public interface ZoneTestRepository extends JpaRepository<ZoneTest, Long> {
    List<ZoneTest> findByCity(@Param("city") String city);

    List<ZoneTest> findByCountry(@Param("country") String country);
}