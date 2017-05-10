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
    Optional<Participant> findOneByTaskIdAndUserId(@Param("userId") Long userId,
                                                @Param("taskId") Long taskId);

    Optional<List<Participant>> findAllByTaskId(@Param("taskId") Long taskId);

    Optional<List<Participant>> findAllByUserId(@Param("userId") Long userId);

    void removeByTaskIdAndUserId(@Param("userId") Long userId,
                                 @Param("taskId") Long taskId);

    void removeByUserId(@Param("userId") Long userId);

    void removeByTaskId(@Param("taskId") Long taskId);

}
