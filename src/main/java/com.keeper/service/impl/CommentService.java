package com.keeper.service.impl;

/*
 * Created by @GoodforGod on 08.05.2017.
 */

import com.keeper.model.dao.Comment;
import com.keeper.model.dto.CommentDTO;
import com.keeper.repo.CommentRepository;
import com.keeper.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
public class CommentService extends ModelService<Comment> implements ICommentService {

    public final CommentRepository repository;

    @Autowired
    public CommentService(CommentRepository repository) {
        this.repository = repository;
        this.primeRepository = repository;
    }

    @Transactional
    @Override
    public Optional<Comment> saveDTO(CommentDTO model) {
        return null;
    }

    @Transactional
    @Override
    public Optional<Comment> updateDTO(CommentDTO model) {
        return null;
    }

    @Override
    public Optional<List<Comment>> getByTaskId(Long taskId) {
        return null;
    }

    @Override
    public Optional<List<Comment>> getSpecificUser(Long taskId, Long userId) {
        return null;
    }

    @Transactional
    @Override
    public void removeByTaskId(Long taskId) {

    }
}
