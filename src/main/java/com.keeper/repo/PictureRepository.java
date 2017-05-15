package com.keeper.repo;

/*
 * Created by @GoodforGod on 08.05.2017.
 */

import com.keeper.model.dao.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Default Comment
 */
@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {
    Optional<Picture> findByUserId(Long userId);

    Optional<Picture> findByTaskId(Long taskId);
}
