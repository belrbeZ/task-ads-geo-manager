package com.keeper.repo;

/*
 * Created by GoodforGod on 26.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */

import com.keeper.entity.GeoPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Default Comment
 */
public interface GeoPointRepository extends JpaRepository<GeoPoint, Long> {//, QueryDslPredicateExecutor<GeoPoint>

}
