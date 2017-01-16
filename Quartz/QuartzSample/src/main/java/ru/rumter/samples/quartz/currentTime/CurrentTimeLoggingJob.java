package ru.rumter.samples.quartz.currentTime;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Пример джобы - пишет в лог текущее время
 */
public class CurrentTimeLoggingJob implements Job {

    private static final Logger LOGGER = LoggerFactory.getLogger(CurrentTimeLoggingJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        LOGGER.info("Current time: {}", new Date());
    }

}
