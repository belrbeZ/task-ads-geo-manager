package com.keeper.service.modelbased.impl;

/*
 * Created by @GoodforGod on 08.05.2017.
 */

import com.keeper.model.dao.Tag;
import com.keeper.model.dao.Task;
import com.keeper.model.dto.TagDTO;
import com.keeper.service.modelbased.ITagService;
import com.keeper.util.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Default Comment
 */
@Service
public class TagService implements ITagService {

    private final TaskService taskService;

    @Autowired
    public TagService(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public Optional<List<Tag>> getTaskTags(Long taskId) {
        if(taskId == null) {
            taskService.LOGGER.warn("Task ID is NULL");
            return Optional.empty();
        }

        Optional<Task> task = taskService.get(taskId);
        if(task.isPresent())
            return Optional.of(task.get().getTags());
        else
            return Optional.empty();
    }

    @Override
    public Optional<Tag> save(Long taskId, Tag tag) {
        if(taskId == null) {
            taskService.LOGGER.warn("Task ID is NULL");
            return Optional.empty();
        }

        if(tag == null) {
            taskService.LOGGER.warn("Save NULLABLE dto");
            return Optional.empty();
        }

        Optional<Task> task = taskService.get(taskId);
        if(task.isPresent()) {
            task.get().addTag(tag);
            taskService.update(task.get());
            return Optional.of(tag);
        }
        else
            return Optional.empty();
    }

    @Override
    public Optional<Tag> save(Long taskId, TagDTO tag) {
        if(taskId == null) {
            taskService.LOGGER.warn("Task ID is NULL");
            return Optional.empty();
        }

        if(tag == null) {
            taskService.LOGGER.warn("Save NULLABLE dto");
            return Optional.empty();
        }

        Optional<Task> task = taskService.get(taskId);
        if(task.isPresent()) {
            Tag toSave = Translator.toDAO(tag);
            task.get().addTag(toSave);
            taskService.update(task.get());
            return Optional.of(toSave);
        }
        else
            return Optional.empty();
    }

    @Override
    public Optional<Tag> incrementTag(Long taskId, Long tagId) {
        if(taskId == null) {
            taskService.LOGGER.warn("Task ID is NULL");
            return Optional.empty();
        }

        if(tagId == null) {
            taskService.LOGGER.warn("Tag ID is NULL");
            return Optional.empty();
        }

        Optional<Task> task = taskService.get(taskId);
        if(task.isPresent()) {
            Tag tagToSave = null;
            for(Tag tag : task.get().getTags()) {
                if(Objects.equals(tag.getId(), tagId)) {
                    tag.incCounter();
                    tagToSave = tag;
                    break;
                }
            }
            taskService.update(task.get());

            if(tagToSave == null)
                return Optional.empty();

            return Optional.of(tagToSave);
        }
        else
            return Optional.empty();
    }

    @Override
    public Optional<Tag> remove(Long taskId, Tag tag) {
        if(taskId == null) {
            taskService.LOGGER.warn("Task ID is NULL");
            return Optional.empty();
        }

        if(tag == null) {
            taskService.LOGGER.warn("Save NULLABLE dto");
            return Optional.empty();
        }

        Optional<Task> task = taskService.get(taskId);
        if(task.isPresent()) {
            task.get().removeTag(tag);
            taskService.update(task.get());
            return Optional.of(tag);
        }
        else
            return Optional.empty();
    }

    @Override
    public Optional<Tag> remove(Long taskId, TagDTO tag) {
        if(taskId == null) {
            taskService.LOGGER.warn("Task ID is NULL");
            return Optional.empty();
        }

        if(tag == null) {
            taskService.LOGGER.warn("Save NULLABLE dto");
            return Optional.empty();
        }

        Optional<Task> task = taskService.get(taskId);
        if(task.isPresent()) {
            Tag toSave = Translator.toDAO(tag);
            task.get().removeTag(toSave);
            taskService.update(task.get());
            return Optional.of(toSave);
        }
        else
            return Optional.empty();
    }
}
