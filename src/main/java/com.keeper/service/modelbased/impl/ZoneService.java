package com.keeper.service.modelbased.impl;

/*
 * Created by @GoodforGod on 9.04.2017.
 */

import com.keeper.model.dao.Zone;
import com.keeper.model.dto.ZoneDTO;
import com.keeper.repo.ZoneRepository;
import com.keeper.service.modelbased.IZoneService;
import com.keeper.util.ModelTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.keeper.util.resolvers.ErrorMessageResolver.*;

/**
 * Default Comment
 */
@Service
public class ZoneService extends PrimeModelService<Zone, Long> implements IZoneService {

    private final ZoneRepository repository;

    @Autowired
    public ZoneService(ZoneRepository repository) {
        this.repository = repository;
        this.primeRepository = repository;
    }

    @Override
    public Optional<Zone> getByUserId(Long userId) {
        if(invalidId(userId, GET_NULLABLE_ID + "TASK"))
            return Optional.empty();

        return repository.findByUserId(userId);
    }

    @Override
    public Optional<List<Zone>> getByCountry(String country) {
        if (country == null || country.isEmpty()) {
            logger.warn("Get by NULLABLE country");
            return Optional.empty();
        }

        return repository.findByCountry(country);
    }

    @Override
    public Optional<List<Zone>> getByCity(String city) {
        if (city == null || city.isEmpty()) {
            logger.warn("Get by NULLABLE city");
            return Optional.empty();
        }

        return repository.findByCity(city);
    }

    @Transactional
    @Override
    public Optional<Zone> saveDTO(ZoneDTO model) {
        if(model == null) {
            logger.warn(CREATE_MODEL_NULLABLE);
            return Optional.empty();
        }

        return super.save(ModelTranslator.toDAO(model));
    }

    @Transactional
    @Override
    public Optional<Zone> updateDTO(ZoneDTO model) {
        if(model == null) {
            logger.warn(UPDATE_MODEL_NULLABLE);
            return Optional.empty();
        }
        Optional<Zone> toSave = get(model.getProfileId());

        if(!toSave.isPresent()) {
            logger.warn(UPDATE_NOT_FOUND);
            return Optional.empty();
        }

        return super.save(ModelTranslator.updateDAO(toSave.get(), model));
    }

    @Transactional
    @Override
    public void removeByUserId(Long userId) {
        if(invalidId(userId, REMOVE_NULLABLE_ID + "TASK"))
            return;

        repository.removeByUserId(userId);
    }
}
