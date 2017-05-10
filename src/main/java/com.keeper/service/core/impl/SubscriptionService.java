package com.keeper.service.core.impl;

/*
 * Created by @GoodforGod on 09.05.2017.
 */

import com.keeper.model.dao.Participant;
import com.keeper.service.core.ISubscriptionService;
import com.keeper.service.modelbased.impl.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Default Comment
 */
@Service
public class SubscriptionService implements ISubscriptionService {

    private final ParticipantService participantService;

    private final Map<Long, Set<Long>> userSubscriptions = new ConcurrentHashMap<>();

    @Autowired
    public SubscriptionService(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @Override
    public Optional<List<Long>> getTaskSubscribers(Long taskId) {
//        List<Long> result = null;
//        if(taskId != null)
//            result = userSubscriptions.entrySet().stream()
//                    .filter(entry -> entry.getValue().contains(taskId))
//                    .map(Map.Entry::getKey).collect(Collectors.toList());
//
//        if(result != null)
//            return Optional.of(result);
//
//        return Optional.empty();

        Optional<List<Participant>> participants = participantService.getParticipantByTask(taskId);
        if(participants.isPresent())
            return Optional.of(participants.get().stream().map(Participant::getUserId).collect(Collectors.toList()));
        return Optional.empty();
    }

    @Override
    public Optional<Map<Long, LocalDateTime>> getUserSubscriptions(Long userId) {
        Optional<List<Participant>> participants = participantService.getParticipantByUser(userId);
        if(participants.isPresent())
            return Optional.of(participants.get().stream().collect(HashMap<Long, LocalDateTime>::new,
                    (k, v) -> k.put(v.getId(), v.getLastModifyDate().toLocalDateTime()),
                    (k, v) -> {}));
        return Optional.empty();
    }

    @Override
    public Optional<Long> viewTask(Long userId, Long taskId) {
        Optional<Participant> participant = participantService.getSpecificParticipant(userId, taskId);
        if(participant.isPresent()) {
            participant.get().reset();
            return Optional.of(taskId);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Long> modifyTask(Long userId, Long taskId) {
        Optional<Participant> participant = participantService.getSpecificParticipant(userId, taskId);
        if(participant.isPresent()) {
            participant.get().modify();
            return Optional.of(taskId);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Long> subscribe(Long userId, Long taskId) {
        Optional<Participant> participant = participantService.saveParticipant(userId, taskId);
        if(participant.isPresent())
            return Optional.of(taskId);
        return Optional.empty();
    }

    @Override
    public Optional<Long> unSubscribe(Long userId, Long taskId) {
        Optional<Long> participant = participantService.removeSpecificParticipant(userId, taskId);
        if(participant.isPresent())
            return Optional.of(taskId);
        return Optional.empty();
    }
}
