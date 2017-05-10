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

    Optional<Map<Long, LocalDateTime>> getUserSubscribtions(Long userId);

    /** TRANSACTIONAL */
    Optional<Long> viewedTask(Long userId);

    /** TRANSACTIONAL */
    Optional<Long> modifyTask(Long taskId);

    /** TRANSACTIONAL */
    Optional<Long> subscribe(Long userId, Long taskId);

    /** TRANSACTIONAL */
    Optional<Long> unSubscribe(Long userId, Long taskId);
}
