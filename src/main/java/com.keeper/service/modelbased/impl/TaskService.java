package com.keeper.service.modelbased.impl;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */

import com.keeper.model.dao.Task;
import com.keeper.model.dao.User;
import com.keeper.model.dto.TaskDTO;
import com.keeper.repo.TaskRepository;
import com.keeper.service.core.IFeedSubmit;
import com.keeper.service.core.ISubscription;
import com.keeper.service.core.impl.FeedService;
import com.keeper.service.core.impl.SubscriptionService;
import com.keeper.service.modelbased.ITaskService;
import com.keeper.util.ModelTranslator;
import com.keeper.util.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.keeper.util.resolvers.ErrorMessageResolver.*;

/**
 * Repository Service to work with Tasks
 */
@Service
public class TaskService extends PrimeModelService<Task, Long>
        implements ITaskService {

    private final UserService userService;
    private final TaskRepository repository;
    private final IFeedSubmit feedSubmitService;
    private final ISubscription subscriptionService;

    @Autowired
    public TaskService(TaskRepository repository,
                       FeedService feedSubmitService,
                       SubscriptionService subscriptionService,
                       UserService userService) {

        this.repository = repository;
        this.primeRepository = repository;
        this.feedSubmitService = feedSubmitService;
        this.subscriptionService = subscriptionService;
        this.userService = userService;
    }

    @PostConstruct
    public void load() {
        try {
            getAll().ifPresent(feedSubmitService::loadTasks);
        }
        catch (Exception e) {
            logger.error("NO TASKS LOADED! [FEED SERVICE]", e);
        }
    }

    @Override
    public Optional<List<Task>> getByTheme(String theme) {
        if(Validator.isStrEmpty(theme)) {
            logger.warn("Theme to Search is NULL or EMPTY");
            return Optional.empty();
        }

        return  repository.findAllByTheme(theme);
    }

    @Override
    public Optional<List<Task>> getByTags(List<String> tags) {
        if(tags == null || tags.isEmpty()) {
            logger.warn("Tags to Search is NULL or EMPTY");
            return Optional.empty();
        }

        return Optional.empty();
    }

    @Override
    public Optional<List<Task>> getByUserId(Long userId) {
        if(invalidId(userId, GET_NULLABLE_ID + "USER"))
            return Optional.empty();

        return repository.findAllByTopicStarterId(userId);
    }

    @Transactional
    @Override
    public Optional<Task> saveDTO(TaskDTO model) {
        if(model == null) {
            logger.warn(CREATE_MODEL_NULLABLE);
            return Optional.empty();
        }

        return save(ModelTranslator.toDAO(model));
    }

    @Transactional
    @Override
    public Optional<Task> updateDTO(TaskDTO model) {
        if(model == null) {
            logger.warn(UPDATE_MODEL_NULLABLE);
            return Optional.empty();
        }

        Optional<User> user = userService.getAuthorized();
        if(!user.isPresent() || !user.get().getId().equals(model.getTopicStarterId()))
            throw new NullPointerException("USER ID NOT MATCH TOPIC STARTER");

        Optional<Task> toSave = get(model.getId());

        // OR SAVE AS A RECENT ONE, THAT IS A QUESTION
        if(!toSave.isPresent()) {
            logger.warn(UPDATE_NOT_FOUND);
            return Optional.empty();
        }

        return save(ModelTranslator.updateDAO(toSave.get(), model));
    }

    @Transactional
    @Override
    public Optional<Task> save(Task model) {
        if(model == null) {
            logger.warn(CREATE_MODEL_NULLABLE);
            return Optional.empty();
        }

        Optional<User> user = userService.getAuthorized();
        if(!user.isPresent() || !user.get().getId().equals(model.getTopicStarterId()))
            throw new NullPointerException("USER ID NOT MATCH TOPIC STARTER");

        model.setCreateDate((model.getCreateDate() == null)
                ? Timestamp.valueOf(LocalDateTime.now())
                : model.getCreateDate());

        model.setLastModifyDate((model.getLastModifyDate() == null || model.getLastModifyDate().before(Timestamp.valueOf(LocalDateTime.now())))
                ? Timestamp.valueOf(LocalDateTime.now())
                : model.getLastModifyDate());

        Optional<Task> task = super.save(model);

        task.ifPresent(t -> {
            feedSubmitService.submit(t);
            subscriptionService.modifyTask(task.get().getId());
        });

        return task;
    }

    @Transactional
    @Override
    public Optional<Task> update(Task model) {
        if(model == null) {
            logger.warn(UPDATE_MODEL_NULLABLE);
            return Optional.empty();
        }

        Optional<User> user = userService.getAuthorized();
        if(!user.isPresent() || !user.get().getId().equals(model.getTopicStarterId()))
            throw new NullPointerException("USER ID NOT MATCH TOPIC STARTER");

        Optional<Task> toSave = get(model.getId());

        // OR SAVE AS A RECENT ONE, THAT IS A QUESTION
        if(!toSave.isPresent()) {
            logger.warn(UPDATE_NOT_FOUND);
            return Optional.empty();
        }

        model.setLastModifyDate(Timestamp.valueOf(LocalDateTime.now()));

        return save(model);
    }

    @Transactional
    @Override
    public void removeByCheckUserId(Long id, Long userId) {
        repository.removeByIdAndTopicStarterId(id, userId);
        feedSubmitService.removeTask(id);
    }

    @Transactional
    @Override
    public void remove(Long id) {
        Optional<User> user = userService.getAuthorized();

        if(user.isPresent())
            repository.removeByIdAndTopicStarterId(id, user.get().getId());
        else
            throw new NullPointerException("USER ID NOT MATCH TOPIC STARTER ID");
    }
}
