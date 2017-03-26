package com.keeper.dao.springrepo;

/*
 * Created by GoodforGod on 26.03.2017.
 */

import com.keeper.entity.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Default Comment
 */
public interface CoordinateRepository extends JpaRepository<Coordinate, Long> {

}
