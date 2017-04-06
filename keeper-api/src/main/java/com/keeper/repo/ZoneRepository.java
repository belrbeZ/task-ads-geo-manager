package com.keeper.repo;

/*
 * Created by GoodforGod on 26.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */

import com.keeper.entity.dao.Zone;
import org.springframework.data.repository.query.Param;

/**
 * Default Comment
 */
//@Repository
//@Qualifier(value = RepositoryResolver.QUALIFIER_ZONE)
public interface ZoneRepository{// extends JpaRepository<Zone, Long> {
    Zone findByUserId(@Param("userId") Long userId);
}
