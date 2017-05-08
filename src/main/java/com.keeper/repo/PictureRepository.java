package com.keeper.repo;

/*
 * Created by @GoodforGod on 08.05.2017.
 */

import com.keeper.model.dao.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Default Comment
 */
public interface PictureRepository extends JpaRepository<Picture, Long> {

}
