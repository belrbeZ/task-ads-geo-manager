package com.keeper.repo;

import com.keeper.model.dao.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by AlexVasil on 23.04.2017.
 *
 * @author AlexVasil
 */

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
