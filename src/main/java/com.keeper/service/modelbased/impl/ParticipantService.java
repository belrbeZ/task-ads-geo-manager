package com.keeper.service.modelbased.impl;

import com.keeper.model.dao.Participant;
import com.keeper.repo.ParticipantRepository;
import com.keeper.service.modelbased.IParticipantService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static com.keeper.util.resolve.ErrorMessageResolver.*;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 09.05.2017
 */
public class ParticipantService extends ModelService<Participant> implements IParticipantService {

    public final ParticipantRepository repository;

    @Autowired
    public ParticipantService(ParticipantRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<List<Participant>> getParticipantByTask(Long taskId) {
        if(invalidId(taskId, GET_NULLABLE_ID + "TASK"))
            return Optional.empty();

        return repository.findAllByTaskId(taskId);
    }

    @Override
    public Optional<List<Participant>> getParticipantByUser(Long userId) {
        if(invalidId(userId, GET_NULLABLE_ID + "USER"))
            return Optional.empty();

        return repository.findAllByUserId(userId);
    }

    @Override
    public Optional<Participant> getSpecificParticipant(Long userId, Long taskId) {
        if(invalidId(taskId, GET_NULLABLE_ID + "TASK") || invalidId(userId, GET_NULLABLE_ID + "USER"))
            return Optional.empty();

        return null;
    }

    @Override
    public Optional<Participant> saveParticipant(Long taskId, Long userId) {
        if(invalidId(taskId, CREATE_NULLABLE_ID + "TASK") || invalidId(userId, CREATE_NULLABLE_ID + "USER"))
            return Optional.empty();

        return null;
    }

    @Override
    public Optional<Participant> updateParticipant(Participant model) {
        if(invalidModel(model, UPDATE_MODEL_NULLABLE))
            return Optional.empty();

        return null;
    }

    @Override
    public Optional<Long> removeParticipantsByTask(Long taskId) {
        if(invalidId(taskId, REMOVE_NULLABLE_ID + "TASK"))
            return Optional.empty();

        return null;
    }

    @Override
    public Optional<Long> removeParticipantsByUser(Long userId) {
        if(invalidId(userId, REMOVE_NULLABLE_ID + "USER"))
            return Optional.empty();

        return null;
    }

    @Override
    public Optional<Long> removeSpecificParticipant(Long userId, Long taskId) {
        if(invalidId(taskId, REMOVE_NULLABLE_ID + "TASK") || invalidId(userId, REMOVE_NULLABLE_ID + "USER"))
            return Optional.empty();

        return null;
    }
}
