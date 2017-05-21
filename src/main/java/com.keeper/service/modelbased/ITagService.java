package com.keeper.service.modelbased;

/*
 * Created by @GoodforGod on 08.05.2017.
 */

import com.keeper.model.dao.Tag;
import com.keeper.model.dto.TagDTO;

import java.util.Optional;
import java.util.Set;

/**
 * Default Comment
 */
public interface ITagService {

    Optional<Set<Tag>> getTaskTags(Long taskId);

    Optional<Tag> save(Long taskId, Tag tag);
    Optional<Tag> save(Long taskId, TagDTO tag);

    Optional<Tag> incrementTag(Long taskId, Long tagId);

    Optional<Tag> remove(Long taskId, Tag tag);
    Optional<Tag> remove(Long taskId, TagDTO tag);
}
