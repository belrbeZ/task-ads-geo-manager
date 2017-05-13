package com.keeper.service.core.impl;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Default Comment
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
