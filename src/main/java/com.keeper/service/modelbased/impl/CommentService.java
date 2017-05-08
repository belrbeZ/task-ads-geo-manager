package com.keeper.service.modelbased.impl;

/*
 * Created by @GoodforGod on 08.05.2017.
 */

import com.keeper.model.dao.Comment;
import com.keeper.model.dto.CommentDTO;
import com.keeper.repo.CommentRepository;
import com.keeper.service.modelbased.ICommentService;
import com.keeper.util.Translator;
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
        if(model == null) {
            LOGGER.warn("Save NULLABLE dto");
            return Optional.empty();
        }

        return super.save(Translator.toDAO(model));
    }

    @Transactional
    @Override
    public Optional<Comment> updateDTO(CommentDTO model) {
        if(model == null) {
            LOGGER.warn("Update NULLABLE dto");
            return Optional.empty();
        }

        Optional<Comment> toSave = get(model.getId());

        if(!toSave.isPresent()) {
            LOGGER.warn("Update model which doesn't exist");
            return Optional.empty();
        }

        return super.save(Translator.updateDAO(toSave.get(), model));
    }

    @Override
    public Optional<List<Comment>> getByTaskId(Long taskId) {
        if(taskId == null) {
            LOGGER.warn("Get with NULLABLE ID");
            return Optional.empty();
        }

        return repository.findAllByTaskId(taskId);
    }

    @Override
    public Optional<List<Comment>> getTaskSpecificUserThread(Long taskId, Long userId) {
        if(taskId == null || userId == null) {
            LOGGER.warn("Get with NULLABLE ID");
            return Optional.empty();
        }

        return repository.findAllByTaskIdAndUserId(taskId, userId);
    }

    @Transactional
    @Override
    public void removeByTaskId(Long taskId) {
        if(taskId == null) {
            LOGGER.warn("Remove with NULLABLE ID");
            return;
        }

        repository.removeAllByTaskId(taskId);
    }
}
