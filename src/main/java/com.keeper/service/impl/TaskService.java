package com.keeper.service.impl;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */

import com.keeper.model.dao.Comment;
import com.keeper.model.dao.Task;
import com.keeper.model.dto.CommentDTO;
import com.keeper.model.dto.GeoPointDTO;
import com.keeper.model.dto.PictureDTO;
import com.keeper.model.dto.TaskDTO;
import com.keeper.repo.CommentRepository;
import com.keeper.repo.TaskRepository;
import com.keeper.service.ITaskService;
import com.keeper.util.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Repository Service to work with Tasks
 */
@Service
public class TaskService extends ModelRepoService<Task> implements ITaskService {

    private final TaskRepository repository;
    private final CommentRepository commentRepository;

    @Autowired
    public TaskService(TaskRepository repository, CommentRepository commentRepository) {
        this.repository = repository;
        this.primeRepository = repository;
        this.commentRepository = commentRepository;
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
                ? repository.findAllByTheme(theme).orElse(getEmptyList())
                : getEmptyList();
    }

    @Override
    public List<Task> getByTags(List<String> tags) {
//        return (tags != null && !tags.isEmpty())
//                ? repository.findAllByTags(tags).orElse(getEmptyList())
//                : getEmptyList();
        return null;
    }

    @Override
    public List<Task> getByEmailOrPhone(String email, String phone) {
        return getEmptyList();
//        return (email != null && !email.isEmpty())
//                ? repository.findAllByEmail(email).orElse(getEmptyList())
//                : (phone != null && !phone.isEmpty()) ? repository.findAllByPhone(phone).orElse(getEmptyList()) : getEmptyList();
    }

    @Override
    public List<Task> getByUserId(Long userId) {
        return (userId != null && userId > 0L)
                ? repository.findAllByTopicStarterId(userId).orElse(getEmptyList())
                : getEmptyList();
    }

    @Override
    public Task removeByUserId(Long topicStarterId) {
        return (topicStarterId != null && topicStarterId > 0L)
                ? repository.removeByTopicStarterId(topicStarterId).orElse(getEmpty())
                : getEmpty();
    }

    /*---PICTURE---*/
    @Override
    public PictureDTO getPicture(Long taskId) {
        Task task = repository.findOne(taskId);
        if((task)==null)
            throw new IllegalArgumentException("No such task!");
        return Translator.convertToDTO(task.getPicture());
    }

    @Override
    public TaskDTO setPicture(Long taskId, PictureDTO picture) {
        Task task = repository.findOne(taskId);
        if((task)==null)
            throw new IllegalArgumentException("No such task!");
        task.setPicture(Translator.convertToDAO(picture));
        primeRepository.save(task);
        return Translator.convertToDTO(task);
    }
    /*---END PICTURE---*/

    /*---ORIGIN GEO POINT---*/
    public GeoPointDTO getOriginGeoPoint(Long taskId) {
        Task task = repository.findOne(taskId);
        if((task)==null)
            throw new IllegalArgumentException("No such task!");
        return Translator.convertToDTO(task.getOriginGeoPoint());
    }
    /*---END ORIGIN GEO POINT---*/

    /*---COMMENTS---*/
//    @Override
//    public List<CommentDTO> getComments(Long taskId) {
//        Task task;
//        if((task = repository.findOne(taskId))==null)
//            throw new IllegalArgumentException("No such task!");
//        return Translator.convertCommentsToDTO(task.getComments());
//    }
//
//    @Override
//    public TaskDTO addComment(Long taskId, CommentDTO comment) {
//        Task task;
//        if((task = repository.findOne(taskId))==null)
//            throw new IllegalArgumentException("No such task!");
//        task.addComment(Translator.convertToDAO(comment));
//        primeRepository.save(task);
//        return Translator.convertToDTO(task);
//    }
//
//    //This works programmic only! remove check on links.
//    @Override
//    public TaskDTO removeComment(Long taskId, CommentDTO comment) {
//        Task task;
//        if((task = repository.findOne(taskId))==null)
//            throw new IllegalArgumentException("No such task!");
//        task.removeComment(Translator.convertToDAO(comment));
//        primeRepository.save(task);
//        return Translator.convertToDTO(task);
//    }
//
//    @Override
//    public TaskDTO removeCommentById(Long taskId, Long commentId) {
//        Task task = repository.findOne(taskId);
//        if((task)==null)
//            throw new IllegalArgumentException("No such task!");
//        Comment comment = commentRepository.findOne(commentId);
//        if(comment==null)
//            throw new IllegalArgumentException("No such comment!");
////        if(task.hasComment(comment)>0)
//        task.removeComment(comment);
//        primeRepository.save(task);
//        return Translator.convertToDTO(task);
//    }
    /*---END COMMENTS---*/
}
