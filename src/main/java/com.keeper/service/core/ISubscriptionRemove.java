package com.keeper.service.core;

import java.util.Optional;

/**
 * Default Comment
 *
 * @author @GoodforGod
 * @since 13.05.2017
 */
public interface ISubscriptionRemove {

    /** TRANSACTIONAL */
    Optional<Long> removeUserSubscriptions(Long userId);

    /** TRANSACTIONAL */
    Optional<Long> removeTaskSubscribers(Long userId);
}
