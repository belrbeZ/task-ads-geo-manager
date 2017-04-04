package com.keeper.repo;

/*
 * Created by GoodforGod on 26.03.2017.
 */

import com.keeper.model.dao.GeoPoint;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Default Comment
 */
public interface GeoPointRepository extends JpaRepository<GeoPoint, Long> {

}
