package com.keeper.repo;

/*
 * Created by @GoodforGod on 17.04.2017.
 */

import com.keeper.model.dao.Tag;
import com.keeper.model.dao.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Default Comment
 */
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {


    Optional<Tag> findOneByTag(@Param("tag") String tag);

}
