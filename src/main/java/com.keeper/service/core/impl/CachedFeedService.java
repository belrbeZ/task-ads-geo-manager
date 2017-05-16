package com.keeper.service.core.impl;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * This class should be as Original Feed Service, with ConcurrentMaps (As Cache for DTOs)
 * where the Origin Will Use ModelService to manipulate objects via Database layer
 *
 * @author @GoodforGod
 * @since 13.05.2017
 */
public class CachedFeedService extends FeedService {

    @Autowired
    public CachedFeedService(SubscriptionService subsService) {
        super(subsService);
    }
}
