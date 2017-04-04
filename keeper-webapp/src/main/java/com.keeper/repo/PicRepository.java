package com.keeper.repo;

/*
 * Created by GoodforGod on 26.03.2017.
 */

import com.keeper.model.dao.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Default Comment
 */
public interface PicRepository extends JpaRepository<Picture, Long> {
}
