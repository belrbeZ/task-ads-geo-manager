package com.keeper.dao.repo;

/*
 * Created by GoodforGod on 26.03.2017.
 */

import com.keeper.entity.GeoPoint;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Default Comment
 */
public interface GeoPointRepository extends JpaRepository<GeoPoint, Long> {

}
