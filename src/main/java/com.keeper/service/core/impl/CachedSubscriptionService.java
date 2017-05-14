package com.keeper.service.core.impl;

import com.keeper.model.dao.Participant;
import com.keeper.model.util.TaskModification;
import com.keeper.service.modelbased.impl.ParticipantService;
import com.keeper.util.ModelTranslator;
import com.keeper.util.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 13.05.2017
 */
public class CachedSubscriptionService extends SubscriptionService {

    private final Logger logger = LoggerFactory.getLogger(CachedSubscriptionService.class);

    private final Map<Long, Set<TaskModification>> userSubscriptions = new ConcurrentHashMap<>();

    private final ParticipantService partService;

    @Autowired
    public CachedSubscriptionService(ParticipantService partService){
        super(partService);
        this.partService = partService;
    }

    private Set<TaskModification> getModifySet(Participant participant) {
        return new HashSet<TaskModification>() {{ add(ModelTranslator.toDTO(participant)); }};
    }

    @PostConstruct
    public void setup() {
        Optional<List<Participant>> participants = Optional.empty();

        try {
            participants = partService.getAll();
        }
        catch (Exception e) {
            participants = Optional.empty();
            logger.error("NO PARTICIPANTS LOADED! [SUBSCRIPTION SERVICE]", e);
        }
        finally {
            if(participants.isPresent()) {
                for(Participant participant : participants.get()) {
                    Set<TaskModification> userSubs = userSubscriptions.putIfAbsent(participant.getUserId(), getModifySet(participant));

                    if(userSubs != null) {
                        userSubs.add(ModelTranslator.toDTO(participant));
                        userSubscriptions.replace(participant.getUserId(), userSubs);
                    }
                }
            }
            else logger.error("NO PARTICIPANTS LOADED! [SUBSCRIPTION SERVICE]");
        }
    }

    @Override
    public Optional<List<Long>> getTaskSubscribers(Long taskId) {
        List<Long> result = null;

        if(Validator.isIdValid(taskId))
            result = userSubscriptions.entrySet().stream()
                    .filter(entry -> entry.getValue().stream().noneMatch(taskModification -> taskModification.getTaskId().equals(taskId)))
                    .map(Map.Entry::getKey).collect(Collectors.toList());

        return (result != null && !result.isEmpty()) ? Optional.of(result) : super.getTaskSubscribers(taskId);
    }

    @Override
    public Optional<Set<Long>> getUserSubscriptions(Long userId) {
        Set<Long> result = null;

        if(Validator.isIdValid(userId)) {
            Set<TaskModification> modifications = userSubscriptions.get(userId);
            if(modifications != null)
                result = modifications.stream().map(TaskModification::getTaskId).collect(Collectors.toSet());
        }

        return (result != null && !result.isEmpty()) ? Optional.of(result) : super.getUserSubscriptions(userId);
    }

    @Override
    public Optional<Long> viewTask(Long userId, Long taskId) {
        Optional<TaskModification> modification = userSubscriptions.get(userId).stream().filter(ent -> ent.getTaskId().equals(taskId)).findFirst();

        if(modification.isPresent()) {
            modification.get().reset();
            partService.save(ModelTranslator.toDAO(modification.get(), userId));
        }
        else {
            Optional<Participant> repoParticipant = partService.getSpecificParticipant(userId, taskId);

            if(repoParticipant.isPresent()) {
                repoParticipant.get().reset();
                partService.save(repoParticipant.get());
                Set<TaskModification> modifications = userSubscriptions.putIfAbsent(userId, getModifySet(repoParticipant.get()));

                if(modifications != null) {
                    modifications.add(ModelTranslator.toDTO(repoParticipant.get()));
                    userSubscriptions.replace(userId, modifications);
                }
            }
        }

        return super.viewTask(userId, taskId);
    }

    @Override
    public Optional<Long> modifyTask(Long taskId) {
        return super.modifyTask(taskId);
    }

    @Override
    public Optional<Long> subscribe(Long userId, Long taskId) {
        return super.subscribe(userId, taskId);
    }

    @Override
    public Optional<Long> unSubscribe(Long userId, Long taskId) {
        return super.unSubscribe(userId, taskId);
    }
}
