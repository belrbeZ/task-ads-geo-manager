package com.keeper.service.impl;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */

import com.keeper.model.dao.Tag;
import com.keeper.model.dao.Task;
import com.keeper.repo.TaskRepository;
import com.keeper.repo.UserRepository;
import com.keeper.service.ITaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.TableGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Repository Service to work with Tasks
 */
@Service//(value = "taskService")
public class TaskRepoService extends ModelRepoService<Task> implements ITaskService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeoPointRepoService.class);

    private final TaskRepository repository;

    @Autowired
    public TaskRepoService(TaskRepository repository) {
        this.repository = repository;
        this.primeRepository = repository;
    }

    @Override
    public List<Task> get(String theme) {
        return (theme!=null&&!theme.isEmpty()?repository.findAllByTheme(theme):null);
    }

//    @Override
//    public List<Task> get(Set<Long> tags) {
//        return (!tags.isEmpty() ? repository.findAllByTags(tags) : null);//???
//    }

    @Override
    public List<Task> getUserTask(String email, String phone) {
        return null;
//                (email != null && !email.isEmpty())
//                ? repository.findAllByEmail(email)
//                : (phone != null && !phone.isEmpty()) ? repository.findAllByPhone(phone) : getEmpty();
    }

    @Override
    public List<Task> getUserByIdTask(Long userId) {
        return (userId!=null && userId>0) ? repository.findByTopicStarterId(userId) : null;
    }

    @Override
    public Task removeByTopicStarterId(Long topicStarterId) {
        return (topicStarterId!=null && topicStarterId.compareTo(0L)>0) ? repository.removeByTopicStarterId(topicStarterId) : null;
    }
}
