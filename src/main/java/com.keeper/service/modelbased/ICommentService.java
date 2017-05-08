package com.keeper.service.modelbased;

/*
 * Created by @GoodforGod on 08.05.2017.
 */

import com.keeper.model.dao.Comment;
import com.keeper.model.dto.CommentDTO;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
public interface ICommentService extends IModelDTOService<Comment, CommentDTO> {
    Optional<List<Comment>> getByTaskId(Long taskId);

    Optional<List<Comment>> getTaskSpecificUserThread(Long taskId, Long userId);

    /** TRANSACTIONAL */
    void removeByTaskId(Long taskId);
}
