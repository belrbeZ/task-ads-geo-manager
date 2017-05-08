package com.keeper.repo;

/*
 * Created by @GoodforGod on 08.05.2017.
 */

import com.keeper.model.dao.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

/**
 * Default Comment
 */
public interface PictureRepository extends JpaRepository<Picture, Long> {
    Optional<Picture> findByUserId(@Param("userId") Long userId);

    Optional<Picture> findByTaskId(@Param("taskId") Long taskId);
}
