package com.keeper.service.modelbased;

import com.keeper.model.dao.Participant;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 *
 * @since 09.05.2017
 * @author @GoodforGod
 */
public interface IParticipantService {
    Optional<List<Participant>> getParticipantByTask(Long taskId);
    Optional<List<Participant>> getParticipantByUser(Long userId);

    Optional<Participant> getSpecificParticipant(Long userId, Long taskId);

    /** TRANSACTIONAL */
    Optional<Participant> saveParticipant(Long userId, Long taskId);

    /** TRANSACTIONAL */
    Optional<Participant> updateParticipant(Participant model);

    /** TRANSACTIONAL */
    Optional<Long> removeParticipantsByTask(Long taskId);
    /** TRANSACTIONAL */
    Optional<Long> removeParticipantsByUser(Long userId);
    /** TRANSACTIONAL AND RETURN TASK_ID*/
    Optional<Long> removeSpecificParticipant(Long userId, Long taskId);
}
