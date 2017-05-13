package com.keeper.service.core;

/*
 * Created by @GoodforGod on 09.05.2017.
 */

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Default Comment
 */
public interface ISubscriptionService {

    Optional<List<Long>> getTaskSubscribers(Long taskId);

    Optional<Set<Long>> getUserSubscriptions(Long userId);

    /** TRANSACTIONAL */
    Optional<Long> viewTask(Long userId, Long taskId);

    /** TRANSACTIONAL */
    Optional<Long> modifyTask(Long taskId);

    /** TRANSACTIONAL */
    Optional<Long> subscribe(Long userId, Long taskId);

    /** TRANSACTIONAL */
    Optional<Long> unSubscribe(Long userId, Long taskId);
}
