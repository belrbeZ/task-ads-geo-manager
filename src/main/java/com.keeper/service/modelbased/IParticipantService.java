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
    Optional<List<Participant>> getParticipantByTask();
    Optional<List<Participant>> getParticipantByUser();


}
