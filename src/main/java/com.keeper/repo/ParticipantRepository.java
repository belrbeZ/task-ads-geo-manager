package com.keeper.repo;

import com.keeper.model.dao.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 10.05.2017
 */
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    Optional<Participant> findByTaskIdAndUserId(@Param("taskId") Long taskId,
                                                @Param("userId") Long userId);

    Optional<List<Participant>> findAllByTaskId(@Param("taskId") Long taskId);

    Optional<List<Participant>> findAllByUserId(@Param("userId") Long userId);

    void removeByTaskIdAndUserId(@Param("taskId") Long taskId,
                                 @Param("userId") Long userId);
}
