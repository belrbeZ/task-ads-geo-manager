package com.keeper.service.core;

/*
 * Created by @GoodforGod on 09.05.2017.
 */

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Default Comment
 */
public interface ISubscriptionService {

    Optional<List<Long>> getTaskSubscribers(Long taskId);

    Optional<Map<Long, LocalDateTime>> getUserSubscriptions(Long userId);

    /** TRANSACTIONAL */
    Optional<Long> viewTask(Long userId, Long taskId);

    /** TRANSACTIONAL */
    Optional<Long> modifyTask(Long userId, Long taskId);

    /** TRANSACTIONAL */
    Optional<Long> subscribe(Long userId, Long taskId);

    /** TRANSACTIONAL */
    Optional<Long> unSubscribe(Long userId, Long taskId);
}
