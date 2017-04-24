package com.keeper.service;

/*
 * Created by GoodforGod on 23.03.2017.
 *
 * Updated by AlexVasil on 30.03.2017.
 *
 */

import com.keeper.model.dao.Task;
import com.keeper.model.dto.CommentDTO;
import com.keeper.model.dto.PictureDTO;
import com.keeper.model.dto.TaskDTO;

import java.util.List;
import java.util.Set;

public interface ITaskService {

    List<Task> getByTheme(String theme);
    List<Task> getByTags(List<String> tags);
    List<Task> getByEmailOrPhone(String email, String phone);
    List<Task> getByUserId(Long userId);

    Task removeByUserId(Long topicStarterId);

    /*---PICTURE---*/
    PictureDTO getPicture(Long taskId);
    TaskDTO setPicture(Long taskId, PictureDTO picture);
    /*---END PICTURE---*/

    /*---COMMENTS---*/

    List<CommentDTO> getComments(Long taskId);
    TaskDTO addComment(Long taskId, Long userId, CommentDTO comment);
    TaskDTO removeComment(Long taskId, CommentDTO comment);
    TaskDTO removeCommentById(Long taskId, Long commentId);

    /*---END COMMENTS---*/

}
