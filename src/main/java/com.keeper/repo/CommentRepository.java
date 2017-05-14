package com.keeper.repo;

import com.keeper.model.dao.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by AlexVasil on 23.04.2017.
 *
 * @author AlexVasil
 */

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<List<Comment>> findAllByTaskId(Long taskId);

    Optional<List<Comment>> findAllByTaskIdAndUserId(Long taskId, Long userId);

    void removeAllByTaskId(Long taskId);
}
