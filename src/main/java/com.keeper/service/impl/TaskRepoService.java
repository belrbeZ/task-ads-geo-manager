package com.keeper.service.impl;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */

import com.keeper.model.dao.Task;
import com.keeper.repo.TaskRepository;
import com.keeper.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Repository Service to work with Tasks
 */
@Service
public class TaskRepoService extends ModelRepoService<Task> implements ITaskService {

    private final TaskRepository repository;

    @Autowired
    public TaskRepoService(TaskRepository repository) {
        this.repository = repository;
        this.primeRepository = repository;
    }

    @Override
    public Task getEmpty() {
        return Task.EMPTY;
    }

    @Override
    public List<Task> getEmptyList() {
        return new ArrayList<Task>() {{ add(getEmpty()); }};
    }

    @Override
    public List<Task> getByTheme(String theme) {
        return (theme != null && !theme.isEmpty())
                ? repository.findAllByTheme(theme)
                : getEmptyList();
    }

    @Override
    public List<Task> getByTags(Set<Long> tags) {
        return (tags != null && !tags.isEmpty())
                ? repository.findAllByTags(tags)
                : getEmptyList();
    }

    @Override
    public List<Task> getByEmailOrPhone(String email, String phone) {
        return (email != null && !email.isEmpty())
                ? repository.findAllByEmail(email)
                : (phone != null && !phone.isEmpty()) ? repository.findAllByPhone(phone) : getEmptyList();
    }

    @Override
    public List<Task> getByUserId(Long userId) {
        return (userId != null && userId > 0L)
                ? repository.findAllByTopicStarterId(userId)
                : getEmptyList();
    }

    @Override
    public Task removeByUserId(Long topicStarterId) {
        return (topicStarterId != null && topicStarterId > 0L)
                ? repository.removeByTopicStarterId(topicStarterId)
                : getEmpty();
    }
}
