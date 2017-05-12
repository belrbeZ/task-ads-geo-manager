package com.keeper.service.modelbased.impl;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */

import com.keeper.model.dao.Task;
import com.keeper.model.dto.TaskDTO;
import com.keeper.repo.TaskRepository;
import com.keeper.service.core.IFeedSubmitService;
import com.keeper.service.core.impl.FeedService;
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
public class TaskService extends ModelService<Task> implements ITaskService {

    private final TaskRepository repository;
    private final IFeedSubmitService feedSubmitService;

    @Autowired
    public TaskService(TaskRepository repository,
                       FeedService feedSubmitService) {
        this.repository = repository;
        this.primeRepository = repository;
        this.feedSubmitService = feedSubmitService;
    }

    @PostConstruct
    public void setup() {
        feedSubmitService.loadTasks(getAll().orElse(getEmptyList()));
    }

    @Override
    public Task getEmpty() {
        return Task.EMPTY;
    }

    @Override
    public Optional<List<Task>> getByTheme(String theme) {
        if(Validator.isStrEmpty(theme)) {
            LOGGER.warn("Theme to Search is NULL or EMPTY");
            return Optional.empty();
        }

        return  repository.findAllByTheme(theme);
    }

    @Override
    public Optional<List<Task>> getByTags(List<String> tags) {
        if(tags == null || tags.isEmpty()) {
            LOGGER.warn("Tags to Search is NULL or EMPTY");
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
            LOGGER.warn(CREATE_MODEL_NULLABLE);
            return Optional.empty();
        }

        return save(ModelTranslator.toDAO(model));
    }

    @Transactional
    @Override
    public Optional<Task> updateDTO(TaskDTO model) {
        if(model == null) {
            LOGGER.warn(UPDATE_MODEL_NULLABLE);
            return Optional.empty();
        }

        Optional<Task> toSave = get(model.getId());

        // OR SAVE AS A NEW ONE, THAT IS A QUESTION
        if(!toSave.isPresent()) {
            LOGGER.warn(UPDATE_NOT_FOUND);
            return Optional.empty();
        }

        model.setLastModifyDate(LocalDateTime.now());

        return save(ModelTranslator.updateDAO(toSave.get(), model));
    }

    @Transactional
    @Override
    public Optional<Task> save(Task model) {
        if(model == null) {
            LOGGER.warn(CREATE_MODEL_NULLABLE);
            return Optional.empty();
        }

        model.setCreateDate((model.getCreateDate() == null || model.getCreateDate().before(Timestamp.valueOf(LocalDateTime.now())))
                ? Timestamp.valueOf(LocalDateTime.now())
                : model.getCreateDate());
        model.setLastModifyDate((model.getLastModifyDate() == null || model.getLastModifyDate().before(Timestamp.valueOf(LocalDateTime.now())))
                ? Timestamp.valueOf(LocalDateTime.now())
                : model.getCreateDate());

        Optional<Task> task = super.save(model);
        task.ifPresent(feedSubmitService::submit);
        return task;
    }

    @Transactional
    @Override
    public Optional<Task> update(Task model) {
        return save(model);
    }

    @Transactional
    @Override
    public void remove(Long id) {
        super.remove(id);
        feedSubmitService.removeTask(id);
    }
}
