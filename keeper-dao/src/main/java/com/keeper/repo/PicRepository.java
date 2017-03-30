package com.keeper.repo;

/*
 * Created by GoodforGod on 26.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */

import com.keeper.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Default Comment
 */
public interface PicRepository extends JpaRepository<Picture, Long> {
}
