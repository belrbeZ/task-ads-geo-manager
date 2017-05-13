package com.keeper.service.core.impl;

/*
 * Created by @GoodforGod on 09.05.2017.
 */

import com.keeper.model.dao.Participant;
import com.keeper.model.util.TaskModification;
import com.keeper.service.core.ISubscriptionService;
import com.keeper.service.modelbased.impl.ParticipantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Default Comment
 */
@Service
public class SubscriptionService implements ISubscriptionService {

    private final Logger LOGGER = LoggerFactory.getLogger(SubscriptionService.class);
    private final ParticipantService partService;

    @Autowired
    public SubscriptionService(ParticipantService partService) {
        this.partService = partService;
    }

    @Override
    public Optional<List<Long>> getTaskSubscribers(Long taskId) {
        Optional<List<Participant>> participants = partService.getParticipantByTask(taskId);
        if(participants.isPresent())
            return Optional.of(participants.get().stream().map(Participant::getUserId).collect(Collectors.toList()));
        return Optional.empty();
    }

    @Override
    public Optional<Set<Long>> getUserSubscriptions(Long userId) {
        Optional<List<Participant>> participants = partService.getParticipantByUser(userId);
        return (participants.isPresent())
                ? Optional.of(participants.get().stream().map(Participant::getTaskId).collect(Collectors.toSet()))
                : Optional.empty();
    }

    @Transactional
    @Override
    public Optional<Long> viewTask(Long userId, Long taskId) {
        Optional<Participant> participant = partService.getSpecificParticipant(userId, taskId);

        participant.ifPresent(p -> {
            p.reset();
            partService.save(p);
        });

        return (participant.isPresent())
                ? Optional.of(taskId)
                : Optional.empty();
    }

    @Transactional
    @Override
    public Optional<Long> modifyTask(Long taskId) {
        Optional<List<Participant>> participant = partService.getParticipantByTask(taskId);
        participant.ifPresent(p -> {
            p.forEach(Participant::modify);
            partService.save(p);
        });
        return (participant.isPresent())
                ? Optional.of(taskId)
                : Optional.empty();
    }

    @Transactional
    @Override
    public Optional<Long> subscribe(Long userId, Long taskId) {
        return (partService.saveParticipant(userId, taskId).isPresent())
                ? Optional.of(taskId)
                : Optional.empty();
    }

    @Transactional
    @Override
    public Optional<Long> unSubscribe(Long userId, Long taskId) {
        return (partService.removeSpecificParticipant(userId, taskId).isPresent())
                ? Optional.of(taskId)
                : Optional.empty();
    }
}
