package com.keeper.service.core;

/*
 * Created by @GoodforGod on 09.05.2017.
 */

import java.util.Optional;

/**
 * Default Comment
 */
public interface ISubscriptionService {

    /** TRANSACTIONAL */
    Optional<Long> subscribe(Long userId, Long tasId);

    /** TRANSACTIONAL */
    Optional<Long> unSubscribe(Long userId, Long tasId);
}
