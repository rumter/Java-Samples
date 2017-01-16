package ru.rumter.samples.quartz;

import ru.rumter.samples.quartz.currentTime.CurrentTimeJobScheduler;
import ru.rumter.samples.quartz.misfire.MisfireSample;
import ru.rumter.samples.quartz.reschedule.SelfRescheduleSample;

public class Application {

    void runCurrentTimeSample() throws Exception {
        new CurrentTimeJobScheduler().schedule();
    }

    void runMisfireSample() throws Exception {
        new MisfireSample().run();
    }

    void runSelfRescheduleSample() throws Exception {
        new SelfRescheduleSample().run();
    }

    public static void main(String[] args) throws Exception {
        new Application()
                //.runCurrentTimeSample();
                //.runMisfireSample();
                .runSelfRescheduleSample();
    }

}
