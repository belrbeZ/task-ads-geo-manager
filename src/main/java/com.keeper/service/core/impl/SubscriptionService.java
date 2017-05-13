package com.keeper.service.core.impl;

/*
 * Created by @GoodforGod on 09.05.2017.
 */

import com.keeper.model.dao.Participant;
import com.keeper.model.dao.Task;
import com.keeper.model.dto.TaskDTO;
import com.keeper.service.core.ISubscription;
import com.keeper.service.core.ISubscriptionModify;
import com.keeper.service.core.ISubscriptionSubmit;
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
import java.util.stream.Collectors;

/**
 * Default Comment
 */
@Service
public class SubscriptionService implements ISubscription, ISubscriptionSubmit, ISubscriptionModify {

    private final Logger logger = LoggerFactory.getLogger(SubscriptionService.class);
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

    public List<Task> withTaskModifications(List<Task> tasks) {
        for(Task task : tasks) {
            try {

            }
            catch (Exception e) {

            }
        }
        return tasks;
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
    public List<TaskDTO> modifyTasksCounter(final List<TaskDTO> tasks) {
        partService.getAllByIds(tasks.stream()
                .map(TaskDTO::getId)
                .collect(Collectors.toList())).ifPresent(part ->  {
            Map<Long, Long> partiCounters = part.stream()
                    .collect(Collectors.toMap(Participant::getTaskId, Participant::getModifyCounter));
            tasks.forEach(t -> t.setModifyCount(partiCounters.get(t.getId())));
        });

        return tasks;
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

    @Transactional
    @Override
    public Optional<Long> removeUserSubscriptions(Long userId) {
        return (partService.removeParticipantsByUser(userId).isPresent())
                ? Optional.of(userId)
                : Optional.empty();
    }

    @Transactional
    @Override
    public Optional<Long> removeTaskSubscribers(Long taskId) {
        return (partService.removeParticipantsByTask(taskId).isPresent())
                ? Optional.of(taskId)
                : Optional.empty();
    }
}
