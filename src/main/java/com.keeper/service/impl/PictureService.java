package com.keeper.service.impl;

/*
 * Created by @GoodforGod on 08.05.2017.
 */

import com.keeper.model.dao.Picture;
import com.keeper.model.dto.PictureDTO;
import com.keeper.repo.GeoPointRepository;
import com.keeper.service.IPictureService;
import com.keeper.util.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Default Comment
 */
public class PictureService extends ModelService<Picture> implements IPictureService {

    private final GeoPointRepository repository;

    @Autowired
    public PictureService(GeoPointRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Picture> getByUserId(Long userId) {
        return null;
    }

    @Override
    public Optional<Picture> getByTaskId(Long taskId) {
        return null;
    }

    @Transactional
    @Override
    public Optional<Picture> saveDTO(PictureDTO model) {
        return super.save(Translator.toDAO(model));
    }

    @Transactional
    @Override
    public Optional<Picture> updateDTO(PictureDTO model) {
        return null;
    }

    @Transactional
    @Override
    public Optional<Picture> removeByUserId(Long userId) {
        return null;
    }

    @Transactional
    @Override
    public Optional<Picture> removeByTaskId(Long taskId) {
        return null;
    }
}
