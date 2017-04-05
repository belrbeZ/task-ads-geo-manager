package com.keeper.repo;

import com.keeper.entity.Zone;
import com.keeper.entity.ZoneTest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Alexandr Vasiliev on 05.04.2017.
 *
 * @author Alexandr Vasiliev
 */

@Repository
@Qualifier(value = "zoneTestRepository")
public interface ZoneTestRepository extends JpaRepository<ZoneTest, Long> {
    ZoneTest findByUserId(@Param("userId") Long userId);
}