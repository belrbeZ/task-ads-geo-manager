package com.keeper.service.modelbased;

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

public interface ITaskService extends IModelDTOService<Task, TaskDTO> {

    List<Task> getByTheme(String theme);
    List<Task> getByTags(List<String> tags);
    List<Task> getByEmail(String email);
    List<Task> getByPhone(String phone);
    List<Task> getByUserId(Long userId);

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
