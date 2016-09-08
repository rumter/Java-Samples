package ru.rumter.samples.quartz.misfire;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SchedulerMetaData;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.listeners.TriggerListenerSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.quartz.DateBuilder.nextGivenSecondDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;
import static ru.rumter.samples.quartz.misfire.StatefulDumbJob.EXECUTION_DELAY;

public class MisfireSample {

    private static final Logger LOGGER = LoggerFactory.getLogger(MisfireSample.class);

    private final long INTERVAL_MS = 3000L;
    private final long EXECUTION_DELAY_MS = 10000L;
    private final long SLEEP_MS = 600 * 1000L;

    public void run() throws Exception {

        LOGGER.info("------- Initializing -------------------");

        // First we must get a reference to a scheduler
        SchedulerFactory sf = new StdSchedulerFactory();

        Scheduler sched = sf.getScheduler();

        sched.getListenerManager().addTriggerListener(new TriggerListenerSupport() {
            @Override
            public String getName() {
                return "misfired logging";
            }

            @Override
            public void triggerMisfired(Trigger trigger) {
                super.triggerMisfired(trigger);

                getLog().info("trigger misfired: {}", trigger);
            }
        });

        LOGGER.info("------- Initialization Complete -----------");

        LOGGER.info("------- Scheduling Jobs -----------");

        // jobs can be scheduled before start() has been called

        // get a "nice round" time a few seconds in the future...
        Date startTime = nextGivenSecondDate(null, 15);

        // statefulJob1 will run every three seconds
        // (but it will delay for ten seconds)
        JobDetail job = newJob(StatefulDumbJob.class)
                .withIdentity("statefulJob1", "group1")
                .usingJobData(EXECUTION_DELAY, EXECUTION_DELAY_MS)
                .build();

        SimpleTrigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .startAt(startTime)
                .withSchedule(simpleSchedule()
                        .withIntervalInMilliseconds(INTERVAL_MS)
                        .repeatForever())
                .build();

        Date ft = sched.scheduleJob(job, trigger);
        LOGGER.info(job.getKey() + " will run at: " + ft + " and repeat: " + trigger.getRepeatCount() + " times, every "
                + trigger.getRepeatInterval() + " milliseconds");

        // statefulJob2 will run every three seconds
        // (but it will delay for ten seconds - and therefore purposely misfire after a few iterations)
        job = newJob(StatefulDumbJob.class)
                .withIdentity("statefulJob2", "group1")
                .usingJobData(EXECUTION_DELAY, EXECUTION_DELAY_MS)
                .build();

        trigger = newTrigger()
                .withIdentity("trigger2", "group1")
                .startAt(startTime)
                .withSchedule(simpleSchedule()
                        .withIntervalInMilliseconds(INTERVAL_MS)
                        .repeatForever()
                        .withMisfireHandlingInstructionNowWithExistingCount()) // set misfire instructions
                .build();

        ft = sched.scheduleJob(job, trigger);
        LOGGER.info(job.getKey() + " will run at: " + ft + " and repeat: " + trigger.getRepeatCount() + " times, every "
                + trigger.getRepeatInterval() + " milliseconds");

        LOGGER.info("------- Starting Scheduler ----------------");

        // jobs don't start firing until start() has been called...
        sched.start();

        LOGGER.info("------- Started Scheduler -----------------");

        try {
            // sleep for ten minutes for triggers to file....
            Thread.sleep(SLEEP_MS);
        } catch (Exception e) {
            //
        }

        LOGGER.info("------- Shutting Down ---------------------");

        sched.shutdown(true);

        LOGGER.info("------- Shutdown Complete -----------------");

        SchedulerMetaData metaData = sched.getMetaData();
        LOGGER.info("Executed " + metaData.getNumberOfJobsExecuted() + " jobs.");
    }

}
