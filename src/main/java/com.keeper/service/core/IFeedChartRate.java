package com.keeper.service.core;

/**
 * Private Contracts To Work With FeedService
 * Used to Rate Tasks
 *
 * @author @GoodforGod
 * @since 16.05.2017
 */
public interface IFeedChartRate {
    void upTask(Long taskId);

    void downTask(Long taskId);
}
