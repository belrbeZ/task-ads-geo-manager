package com.keeper.service.impl;

/*
 * Created by @GoodforGod on 17.04.2017.
 */

import com.keeper.model.dao.Tag;
import com.keeper.repo.TagRepository;
import com.keeper.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Default Comment
 */
@Service
public class TagRepoService extends ModelRepoService<Tag> implements ITagService {

    private final TagRepository repository;

    @Autowired
    public TagRepoService(TagRepository repository) {
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



}
