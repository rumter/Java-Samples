package ru.rumter.samples.quartz.reschedule;

import java.util.Date;
import java.util.Random;

import org.quartz.DateBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.listeners.TriggerListenerSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Пример работы джобы, которая сама себя решедулит.
 */
public class SelfRescheduleSample {


    public static class SelfRescheduleJob implements Job {

        public SelfRescheduleJob() {
        }

        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {

            LOGGER.info("execute job");

            rescheduler.reschedule(context);

        }

    }


    private static final Logger LOGGER = LoggerFactory.getLogger(SelfRescheduleSample.class);

    private static SelfRescheduleSample rescheduler;

    private static final int TIMEOUT_MILLIS = 1000;

    private Scheduler scheduler;

    public void run() throws SchedulerException {
        rescheduler = this;

        scheduler = createScheduler();
        scheduler.start();

        JobDetail job = createJob();

        schedule(createJob(), createTrigger(job, TIMEOUT_MILLIS));
    }

    private void schedule(JobDetail job, Trigger trigger) throws SchedulerException {
        Date result = scheduler.scheduleJob(job, trigger);

        LOGGER.info("schedule result: {}", result);

        if (result == null) {
            throw new IllegalStateException("scheduleJob return null");
        }
    }

    private void reschedule(JobExecutionContext context) {
        LOGGER.info("start reschedule");

        Trigger oldTrigger = context.getTrigger();

        try {
            LOGGER.info("old trigger: {}", scheduler.getTrigger(oldTrigger.getKey()));
            LOGGER.info("old trigger state: {}", scheduler.getTriggerState(oldTrigger.getKey()));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

        int timeout = TIMEOUT_MILLIS;

        if (new Random().nextInt(10) == 9) {
            timeout = -1000;
            LOGGER.info("emulate delay before reschedule, timeout = {}", timeout);
        }

        Trigger newTrigger = createTrigger(context.getJobDetail(), timeout);

        try {
            Date result = scheduler.rescheduleJob(oldTrigger.getKey(), newTrigger);
            LOGGER.info("reschedule result: {}", result);
            if (result == null) {
                LOGGER.warn("rescheduleJob return null, newTrigger: {}", newTrigger);

                schedule(context.getJobDetail(), newTrigger);
            }
        } catch (SchedulerException e) {
            LOGGER.error(e.getMessage(), e);
        }

        try {
            LOGGER.info("rescheduled trigger: {}", scheduler.getTrigger(oldTrigger.getKey()));
            LOGGER.info("rescheduled trigger state: {}", scheduler.getTriggerState(oldTrigger.getKey()));
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

        LOGGER.info("end reschedule");
    }

    private Scheduler createScheduler() throws SchedulerException {
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();

        scheduler.getListenerManager().addTriggerListener(new TriggerListenerSupport() {
            @Override
            public String getName() {
                return "misfired trigger logger";
            }

            @Override
            public void triggerMisfired(Trigger trigger) {
                super.triggerMisfired(trigger);

                LOGGER.warn("Trigger misfired: {}", trigger);
            }
        });

        return scheduler;
    }

    private JobDetail createJob() {
        return JobBuilder.newJob(SelfRescheduleJob.class)
                .withIdentity("selfRescheduleJob")
                .build();
    }

    private Trigger createTrigger(JobDetail job, int timeoutMillis) {
        return TriggerBuilder.newTrigger()
                .withIdentity("selfRescheduleTrigger")
                .forJob(job)
                .startAt(DateBuilder.futureDate(timeoutMillis, DateBuilder.IntervalUnit.MILLISECOND))
                .build();
    }

}
