package com.keeper.service.impl;

/*
 * Created by @GoodforGod on 17.04.2017.
 */

import com.keeper.model.dao.Tag;
import com.keeper.repo.TagRepository;
import com.keeper.service.ITagService;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 */
@Service
public class TagService extends ModelRepoService<Tag> implements ITagService {

    private final TagRepository repository;

    @Autowired
    public TagService(TagRepository repository) {
        this.repository = repository;
//        this.primeRepository = repository;
    }

    @Override
    public Tag getEmpty() {
        return Tag.EMPTY;
    }

    @Override
    public List<Tag> getEmptyList() {
        return new ArrayList<Tag>() {{ add(getEmpty()); }};
    }

    @Transactional
    public Optional<Tag> getByTagValue(@NotEmpty String tag) {
        return repository.findOneByTag(tag);
    }


}
