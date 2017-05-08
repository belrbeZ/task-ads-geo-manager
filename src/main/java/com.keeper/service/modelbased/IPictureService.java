package com.keeper.service.modelbased;

/*
 * Created by @GoodforGod on 08.05.2017.
 */

import com.keeper.model.dao.Picture;
import com.keeper.model.dto.PictureDTO;

import java.util.Optional;

/**
 * Default Comment
 */
public interface IPictureService extends IModelDTOService<Picture, PictureDTO> {
    Optional<Picture> getByUserId(Long userId);
    Optional<Picture> getByTaskId(Long taskId);

    /** TRANSACTIONAL */
    Optional<Picture> removeByUserId(Long userId);

    /** TRANSACTIONAL */
    Optional<Picture> removeByTaskId(Long taskId);
}
