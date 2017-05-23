package com.keeper.service.modelbased.impl;

/*
 * Created by @GoodforGod on 08.05.2017.
 */

import com.keeper.model.dao.Comment;
import com.keeper.model.dto.CommentDTO;
import com.keeper.repo.CommentRepository;
import com.keeper.service.core.ISubscription;
import com.keeper.service.core.impl.SubscriptionService;
import com.keeper.service.modelbased.ICommentService;
import com.keeper.util.ModelTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.keeper.util.resolvers.ErrorMessageResolver.*;

/**
 * Default Comment
 */
@Service
public class CommentService extends PrimeModelService<Comment, Long> implements ICommentService {

    private final CommentRepository repository;
    private final ISubscription subsService;

    @Autowired
    public CommentService(CommentRepository repository, SubscriptionService subsService) {
        this.repository = repository;
        setup(repository);
        this.subsService = subsService;
    }

    @Transactional
    @Override
    public Optional<Comment> saveDTO(CommentDTO model) {
        if(model == null) {
            logger.warn(CREATE_MODEL_NULLABLE);
            return Optional.empty();
        }

        Optional<Comment> comment = super.save(ModelTranslator.toDAO(model));
        comment.ifPresent(comm -> subsService.modifyTask(comm.getTaskId()));
        return comment;
    }

    @Transactional
    @Override
    public Optional<Comment> updateDTO(CommentDTO model) {
        if(model == null) {
            logger.warn(UPDATE_MODEL_NULLABLE);
            return Optional.empty();
        }

        Optional<Comment> toSave = get(model.getId());

        if(!toSave.isPresent()) {
            logger.warn(UPDATE_NOT_FOUND);
            return Optional.empty();
        }

        return super.save(ModelTranslator.updateDAO(toSave.get(), model));
    }

    @Override
    public Optional<List<Comment>> getByTaskId(Long taskId) {
        if(invalidId(taskId, GET_NULLABLE_ID + "TASK"))
            return Optional.empty();

        return repository.findAllByTaskId(taskId);
    }

    @Override
    public Optional<List<Comment>> getTaskSpecificUserThread(Long taskId, Long userId) {
        if(invalidId(taskId, CREATE_NULLABLE_ID + "TASK") || invalidId(userId, CREATE_NULLABLE_ID + "USER"))
            return Optional.empty();

        return repository.findAllByTaskIdAndUserId(taskId, userId);
    }

    @Transactional
    @Override
    public void removeByTaskId(Long taskId) {
        if(invalidId(taskId, GET_NULLABLE_ID + "TASK"))
            return;

        repository.removeAllByTaskId(taskId);
    }
}
