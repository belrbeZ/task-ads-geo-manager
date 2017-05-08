package com.keeper.service.modelbased.impl;

/*
 * Created by @GoodforGod on 08.05.2017.
 */

import com.keeper.model.dao.Picture;
import com.keeper.model.dto.PictureDTO;
import com.keeper.repo.GeoPointRepository;
import com.keeper.repo.PictureRepository;
import com.keeper.service.modelbased.IPictureService;
import com.keeper.util.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Default Comment
 */
public class PictureService extends ModelService<Picture> implements IPictureService {

    private final PictureRepository repository;

    @Autowired
    public PictureService(PictureRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Picture> getByUserId(Long userId) {
        if(userId == null) {
            LOGGER.warn("Save NULLABLE dto");
            return Optional.empty();
        }

        return repository.findByUserId(userId);
    }

    @Override
    public Optional<Picture> getByTaskId(Long taskId) {
        if(taskId == null) {
            LOGGER.warn("Save NULLABLE dto");
            return Optional.empty();
        }

        return repository.findByTaskId(taskId);
    }

    @Transactional
    @Override
    public Optional<Picture> saveDTO(PictureDTO model) {
        if(model == null) {
            LOGGER.warn("Save NULLABLE dto");
            return Optional.empty();
        }

        return super.save(Translator.toDAO(model));
    }

    @Transactional
    @Override
    public Optional<Picture> updateDTO(PictureDTO model) {
        if(model == null) {
            LOGGER.warn("Update NULLABLE dto");
            return Optional.empty();
        }

        Optional<Picture> toSave = get(model.getId());

        if(!toSave.isPresent()) {
            LOGGER.warn("Update model which doesn't exist");
            return Optional.empty();
        }

        return super.save(Translator.updateDAO(toSave.get(), model));
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
