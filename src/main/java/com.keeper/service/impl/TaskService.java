package com.keeper.service.impl;

/*
 * Created by GoodforGod on 19.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */

import com.keeper.model.dao.*;
import com.keeper.model.dto.*;
import com.keeper.repo.*;
import com.keeper.service.IFeedSubmiter;
import com.keeper.service.ITaskService;
import com.keeper.util.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Repository Service to work with Tasks
 */
@Service
public class TaskService extends ModelRepoService<Task> implements ITaskService {

    private final TaskRepository repository;
    private final CommentRepository commentRepository;
    private final GeoPointRepository geoPointRepository;
    private final TagRepository tagRepository;
    private final UserRepository userRepository;

    private final IFeedSubmiter feedSubmitService;

    @Autowired
    public TaskService(TaskRepository repository,
                       CommentRepository commentRepository,
                       GeoPointRepository geoPointRepository,
                       TagRepository tagRepository,
                       UserRepository userRepository, FeedService feedSubmitService) {
        this.repository = repository;
        this.primeRepository = repository;
        this.commentRepository = commentRepository;
        this.geoPointRepository = geoPointRepository;
        this.tagRepository = tagRepository;
        this.userRepository = userRepository;
        this.feedSubmitService = feedSubmitService;
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
    public Optional<Task> add(Task model) {
        Optional<Task> task = super.add(model);
        task.ifPresent(feedSubmitService::submit);
        return task;
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

    @Transactional
    @Override
    public Task removeByUserId(Long topicStarterId) {
        return (topicStarterId != null && topicStarterId > 0L)
                ? repository.removeByTopicStarterId(topicStarterId).orElse(getEmpty())
                : getEmpty();
    }

    @Transactional
    public Task updateTaskDAO(Optional<Task> task, TaskDTO dto) {
        if(!task.isPresent())
            throw new NullPointerException("NO SUCH TASK");
        if(dto.getDescr() == null || dto.getDescr().isEmpty())
            throw new NullPointerException("NO SUCH DESCR");

        Task upUser = task.get();
        System.out.println(upUser);
        upUser.setLastModifyDate(Timestamp.valueOf(LocalDateTime.now()));
        upUser.setDescr(dto.getDescr());
        return upUser;
    }

    /*---PICTURE---*/
    @Override
    public PictureDTO getPicture(Long taskId) {
        Task task = repository.findOne(taskId);
        if((task)==null)
            throw new IllegalArgumentException("No such task!");
        return Translator.toDTO(task.getPicture());
    }

    @Override
    public TaskDTO setPicture(Long taskId, PictureDTO picture) {
        Task task = repository.findOne(taskId);
        if((task)==null)
            throw new IllegalArgumentException("No such task!");
        Picture existPic = task.getPicture();
        if(existPic != null && (existPic.getUserId()!=null || existPic.getTaskId()!=null)){
            existPic.setInfo(picture.getInfo());
            existPic.setPic(picture.getPic());
            task.setPicture(existPic);
        } else {
            picture.setTaskId(taskId);
            task.setPicture(Translator.toDAO(picture));
        }
        primeRepository.save(task);
        return Translator.toDTO(task);
    }
    /*---END PICTURE---*/

    /*---ORIGIN GEO POINT---*/
    public GeoPointDTO getOriginGeoPoint(Long taskId) {
        Task task = repository.findOne(taskId);
        if((task)==null)
            throw new IllegalArgumentException("No such task!");
        return Translator.toDTO(task.getOriginGeoPoint());
    }

    @Transactional
    public TaskDTO setOriginGeoPoint(Long taskId, GeoPointDTO modelGeo) {
        Task task = repository.findOne(taskId);
        if((task)==null)
            throw new IllegalArgumentException("No such task!");
        GeoPoint addedGeo = geoPointRepository.save(Translator.toDAO(modelGeo));
        task.setOriginGeoPoint(addedGeo);
        task.setOriginGeoPointId(addedGeo.getId());
        primeRepository.save(task);
        return Translator.toDTO(task);
    }
    /*---END ORIGIN GEO POINT---*/

    /*---COMMENTS---*/
    @Override
    public List<CommentDTO> getComments(Long taskId) {
        Task task;
        if((task = repository.findOne(taskId))==null)
            throw new IllegalArgumentException("No such task!");
        return Translator.commentsToDTO(task.getComments());
    }

    @Transactional
    @Override
    public TaskDTO addComment(Long taskId, Long userId, CommentDTO comment) {
        Task task;
        if((task = repository.findOne(taskId))==null)
            throw new IllegalArgumentException("No such task!");
        comment.setTaskId(taskId);
        comment.setUserId(userId);

        Comment commentDAO = Translator.toDAO(comment);
        commentDAO.setCreateDate(Timestamp.valueOf(LocalDateTime.now()));
        task.addComment(commentDAO);
        primeRepository.save(task);
        return Translator.toDTO(task);
    }

    //This works programmic only! remove check on links.
    @Transactional
    @Override
    public TaskDTO removeComment(Long taskId, CommentDTO comment) {
        Task task;
        if((task = repository.findOne(taskId))==null)
            throw new IllegalArgumentException("No such task!");
        task.removeComment(Translator.toDAO(comment));
        primeRepository.save(task);
        return Translator.toDTO(task);
    }

    @Transactional
    @Override
    public TaskDTO removeCommentById(Long taskId, Long commentId) {
        Task task = repository.findOne(taskId);
        if((task)==null)
            throw new IllegalArgumentException("No such task!");
        Comment comment = commentRepository.findOne(commentId);
        if(comment==null)
            throw new IllegalArgumentException("No such comment!");
//        if(task.hasComment(comment)>0)
        task.removeComment(comment);
        primeRepository.save(task);
        return Translator.toDTO(task);
    }

    /*---END COMMENTS---*/

    /*---TAGS---*/
    public List<TagDTO> getTags(Long taskId) {
        Task task;
        if((task = repository.findOne(taskId))==null)
            throw new IllegalArgumentException("No such task!");
        return Translator.tagsToDTO(task.getTags());
    }

    @Transactional
    public TaskDTO addTag(Long taskId, TagDTO tag) {
        Task task;
        if((task = repository.findOne(taskId))==null)
            throw new IllegalArgumentException("No such task!");

        Tag tagDAO = tagRepository.findOneByTag(tag.getTag()).get();

        if(tagDAO==null){
            System.out.println("NEW TAG");

            task.addTag(Translator.toDAO(tag));
        }
        else{
            System.out.println("exist tag");
            task.addTag(tagDAO);
        }

        primeRepository.save(task);
        return Translator.toDTO(task);
    }

    //This works programmic only! remove check on links.
    @Transactional
    public TaskDTO removeTag(Long taskId, TagDTO tag) {
        Task task;
        if((task = repository.findOne(taskId))==null)
            throw new IllegalArgumentException("No such task!");

        Tag tagDAO = tagRepository.findOneByTag(tag.getTag()).get();
        if(tagDAO!=null) {
            task.removeTag(tagDAO);
            primeRepository.save(task);
        } else {
            System.err.println("No such tag");
        }

        return Translator.toDTO(task);
    }

    @Transactional
    public TaskDTO removeTagById(Long taskId, Long tagId) {
        Task task = repository.findOne(taskId);
        if((task)==null)
            throw new IllegalArgumentException("No such task!");
        Tag tagDAO = tagRepository.getOne(tagId);
        if(tagDAO!=null) {
            task.removeTag(tagDAO);
            primeRepository.save(task);
        } else {
            System.err.println("No such tag");
        }
        return Translator.toDTO(task);
    }

    /*---END TAGS---*/


    /*---PARTICIPANTS---*/
    public List<UserDTO> getParticipants(Long taskId) {
        Task task;
        if((task = repository.findOne(taskId))==null)
            throw new IllegalArgumentException("No such task!");
        return Translator.usersToDTO(task.getParticipants());
    }

    @Transactional
    public TaskDTO addParticipant(Long taskId, Long userId /*, UserDTO participant*/) {
        Task task;
        if((task = repository.findOne(taskId))==null)
            throw new IllegalArgumentException("No such task!");

//        User participantDAO = userRepository.findOneByEmail(participant.getEmail()).get();
        User userDAO = userRepository.findOne(userId);
        if(userDAO!=null){
            System.out.println("exist suer");
            task.addParticipant(userDAO);
            primeRepository.save(task);
        }
        else{
            System.err.println("No such user!");
        }
        return Translator.toDTO(task);
    }

//    //This works programmic only! remove check on links.
//    @Transactional
//    public TaskDTO removeParticipant(Long taskId, UserDTO participant) {
//        Task task;
//        if((task = repository.findOne(taskId))==null)
//            throw new IllegalArgumentException("No such task!");
//
//        User participantDAO = userRepository.findOneByEmail(participant.getEmail()).get();
//        if(participantDAO!=null) {
//            task.removeParticipant(participantDAO);
//            primeRepository.save(task);
//        } else {
//            System.err.println("No such participant");
//        }
//
//        return Translator.toDTO(task);
//    }

    @Transactional
    public TaskDTO removeParticipantById(Long taskId, Long participantId) {
        Task task = repository.findOne(taskId);
        if((task)==null)
            throw new IllegalArgumentException("No such task!");
        User participantDAO = userRepository.findOne(participantId);
        if(participantDAO!=null) {
            task.removeParticipant(participantDAO);
            primeRepository.save(task);
        } else {
            System.err.println("No such participant");
        }
        return Translator.toDTO(task);
    }

    /*---END PARTICIPANTS---*/

}
