package ru.rumter.samples.quartz.currentTime;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class CurrentTimeJobScheduler {

    public void schedule() throws SchedulerException {
        JobDetail job = makeJob();
        Trigger trigger = makeTrigger();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }

    private JobDetail makeJob() {
        return JobBuilder.newJob(CurrentTimeLoggingJob.class)
                .withIdentity("currentTimeJob")
                .build();
    }

    private Trigger makeTrigger() {
        return TriggerBuilder.newTrigger()
                .withIdentity("currentTimeTrigger")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2)
                        .repeatForever())
                .build();
    }

}
