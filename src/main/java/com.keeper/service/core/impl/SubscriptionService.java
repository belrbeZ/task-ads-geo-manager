package com.keeper.service.core.impl;

/*
 * Created by @GoodforGod on 09.05.2017.
 */

import com.keeper.model.dao.Participant;
import com.keeper.model.dao.Task;
import com.keeper.service.core.ISubscriptionService;
import com.keeper.service.modelbased.impl.ParticipantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Default Comment
 */
@Service
public class SubscriptionService implements ISubscriptionService {

    private final Logger LOGGER = LoggerFactory.getLogger(SubscriptionService.class);

    private final ParticipantService participantService;

    // UserID | Set<TaskID>
    private final Map<Long, Set<Long>> userSubscriptions = new ConcurrentHashMap<>();

    @Autowired
    public SubscriptionService(ParticipantService participantService) {
        this.participantService = participantService;
    }

    private Set<Long> getTaskSet(Long taskId) {
        return new HashSet<Long>() {{ add(taskId); }};
    }

    @PostConstruct
    public void setup() {
        Optional<List<Participant>> participants = Optional.empty();

        try {
            participants = participantService.getAll();
        }
        catch (Exception e) {
            participants = participantService.getAll();
            LOGGER.error("NO PARTICIPANTS LOADED! [SUBSCRIPTION SERVICE]", e);
        }
        finally {
            if(participants.isPresent()) {
                for(Participant participant : participants.get()) {
                    Set<Long> userSubs = userSubscriptions.putIfAbsent(participant.getUserId(), getTaskSet(participant.getTaskId()));

                    if(userSubs != null) {
                        userSubs.add(participant.getTaskId());
                        userSubscriptions.replace(participant.getUserId(), userSubs);
                    }
                }
            }
            else LOGGER.error("NO PARTICIPANTS LOADED! [SUBSCRIPTION SERVICE]");
        }
    }

    @Override
    public Optional<List<Long>> getTaskSubscribers(Long taskId) {
//        List<Long> result = null;

//        if(Validator.isIdValid(taskId))
//            result = userSubscriptions.entrySet().stream()
//                    .filter(entry -> entry.getValue().contains(taskId))
//                    .map(Map.Entry::getKey).collect(Collectors.toList());
//        else
//            return Optional.empty();
//
//        if(result != null && !result.isEmpty())
//            return Optional.of(result);

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
