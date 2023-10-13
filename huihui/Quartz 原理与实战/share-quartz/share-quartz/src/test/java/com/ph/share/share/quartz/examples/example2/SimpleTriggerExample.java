/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy
 * of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 */

package com.ph.share.share.quartz.examples.example2;

import static org.quartz.DateBuilder.futureDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.JobKey.jobKey;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import com.ph.share.share.quartz.tools.DFUtil;
import org.junit.jupiter.api.Test;
import org.quartz.*;
import org.quartz.DateBuilder.IntervalUnit;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * This Example will demonstrate all of the basics of scheduling capabilities of Quartz using Simple Triggers.
 *
 * @author Bill Kratzer
 */
public class SimpleTriggerExample {
    SchedulerFactory sf = new StdSchedulerFactory();
    Scheduler sched;

    {
        try {
            sched = sf.getScheduler();
            sched.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void job1() throws SchedulerException, InterruptedException {
        Date startTime = DateBuilder.nextGivenSecondDate(null, 15);

        // job1 will only fire once at date/time "ts"
        JobDetail job = newJob(SimpleJob.class).withIdentity("job1", "group1").build();

        SimpleTrigger trigger = (SimpleTrigger) newTrigger().withIdentity("trigger1", "group1").startAt(startTime).build();
        // schedule it to run!
        Date ft = sched.scheduleJob(job, trigger);

        System.out.println(job.getKey() + " will run at: " + DFUtil.format(ft) + " and repeat: " + trigger.getRepeatCount() + " times, every "
                + trigger.getRepeatInterval() / 1000 + " seconds");

        Thread.sleep(16*1000);
        sched.shutdown();
    }


    @Test
    public void job2() throws SchedulerException, InterruptedException {
                // job2 will only fire once at date/time "ts"
        Date startTime = DateBuilder.nextGivenSecondDate(null, 15);
        JobDetail job = newJob(SimpleJob.class).withIdentity("job2", "group1").build();
        SimpleTrigger trigger = (SimpleTrigger) newTrigger().withIdentity("trigger2", "group1").startAt(startTime).build();
        Date ft = sched.scheduleJob(job, trigger);
        System.out.println(job.getKey() + " will run at: " + DFUtil.format(ft) + " and repeat: " + trigger.getRepeatCount() + " times, every "
                + trigger.getRepeatInterval() / 1000 + " seconds");
        Thread.sleep(16*1000);
    }


    /**
     * 多 trigger
     */
    @Test
    public void job3() throws SchedulerException, InterruptedException {
        // job3 will run 11 times (run once and repeat 10 more times)
        // job3 will repeat every 10 seconds
        Date startTime = DateBuilder.nextGivenSecondDate(null, 15);
        JobDetail job = newJob(SimpleJob.class).withIdentity("job3", "group1").build();

        SimpleTrigger trigger = newTrigger().withIdentity("trigger3", "group1").startAt(startTime)
                .withSchedule(simpleSchedule().withIntervalInSeconds(10).withRepeatCount(10)).build();

        Date ft = sched.scheduleJob(job, trigger);
        System.out.println(job.getKey() + " will run at: " + DFUtil.format(ft) + " and repeat: " + trigger.getRepeatCount() + " times, every "
                + trigger.getRepeatInterval() / 1000 + " seconds");

        // the same job (job3) will be scheduled by a another trigger
        // this time will only repeat twice at a 70 second interval

        trigger = newTrigger().withIdentity("trigger3", "group2").startAt(startTime)
                .withSchedule(simpleSchedule().withIntervalInSeconds(10).withRepeatCount(2)).forJob(job).build();

        ft = sched.scheduleJob(trigger);
        System.out.println(job.getKey() + " will [also] run at: " + ft + " and repeat: " + trigger.getRepeatCount()
                + " times, every " + trigger.getRepeatInterval() / 1000 + " seconds");

        Thread.sleep(110*1000);
    }


    /**
     * withIntervalInSeconds
     * withRepeatCount
     */

    @Test
    public void job4() throws SchedulerException, InterruptedException {
        Date startTime = DateBuilder.nextGivenSecondDate(null, 15);
                // job4 will run 6 times (run once and repeat 5 more times)
        // job4 will repeat every 10 seconds
        JobDetail job = newJob(SimpleJob.class).withIdentity("job4", "group1").build();

        SimpleTrigger trigger = newTrigger().withIdentity("trigger4", "group1").startAt(startTime)
                .withSchedule(simpleSchedule().withIntervalInSeconds(10).withRepeatCount(5)).build();

        Date ft = sched.scheduleJob(job, trigger);
        System.out.println(job.getKey() + " will run at: " + ft + " and repeat: " + trigger.getRepeatCount() + " times, every "
                + trigger.getRepeatInterval() / 1000 + " seconds");
    }

    @Test
    public void futureDateTest() {
        Date date = futureDate(5, IntervalUnit.HOUR);
        System.out.println(DFUtil.format(date));
    }

    /**
     * futureDate
     */
    @Test
    public void job5() throws SchedulerException, InterruptedException {
                // job5 will run once, five minutes in the future
        JobDetail job = newJob(SimpleJob.class).withIdentity("job5", "group1").build();

        SimpleTrigger trigger = (SimpleTrigger) newTrigger().withIdentity("trigger5", "group1")
                .startAt(futureDate(5, IntervalUnit.MINUTE)).build();

        Date ft = sched.scheduleJob(job, trigger);
        System.out.println(job.getKey() + " will run at: " + ft + " and repeat: " + trigger.getRepeatCount() + " times, every "
                + trigger.getRepeatInterval() / 1000 + " seconds");
    }

    /**
     * repeatForever
     */
    @Test
    public void job6() throws SchedulerException, InterruptedException {
        Date startTime = DateBuilder.nextGivenSecondDate(null, 15);
        // job6 will run indefinitely, every 40 seconds
        JobDetail job = newJob(SimpleJob.class).withIdentity("job6", "group1").build();

        SimpleTrigger trigger = newTrigger().withIdentity("trigger6", "group1").startAt(startTime)
                .withSchedule(simpleSchedule().withIntervalInSeconds(40).repeatForever()).build();

        Date ft = sched.scheduleJob(job, trigger);
        System.out.println(job.getKey() + " will run at: " + ft + " and repeat: " + trigger.getRepeatCount() + " times, every "
                + trigger.getRepeatInterval() / 1000 + " seconds");

    }


    /**
     * withIntervalInMinutes
     *
     */
    @Test
    public void job7() throws SchedulerException, InterruptedException {
        Date startTime = DateBuilder.nextGivenSecondDate(null, 15);
        // jobs can also be scheduled after start() has been called...
        // job7 will repeat 20 times, repeat every five minutes
        JobDetail job = newJob(SimpleJob.class).withIdentity("job7", "group1").build();

        SimpleTrigger trigger = newTrigger().withIdentity("trigger7", "group1").startAt(startTime)
                .withSchedule(simpleSchedule().withIntervalInMinutes(5).withRepeatCount(20)).build();

        Date ft = sched.scheduleJob(job, trigger);
        System.out.println(job.getKey() + " will run at: " + ft + " and repeat: " + trigger.getRepeatCount() + " times, every "
                + trigger.getRepeatInterval() / 1000 + " seconds");


    }

    /**
     * !!! rescheduleJob
     */
    @Test
    public void job7_() throws SchedulerException, InterruptedException {
        // jobs can also be scheduled after start() has been called...
        // job7 will repeat 20 times, repeat every five minutes
        JobDetail job = newJob(SimpleJob.class).withIdentity("job7", "group1").build();

        SimpleTrigger trigger = newTrigger().withIdentity("trigger7", "group1").startNow()
                .withSchedule(simpleSchedule().withIntervalInSeconds(5).withRepeatCount(3)).build();

        Date ft = sched.scheduleJob(job, trigger);
        System.out.println(job.getKey() + " will run at: " + DFUtil.format(ft) + " and repeat: " + trigger.getRepeatCount() + " times, every "
                + trigger.getRepeatInterval() / 1000 + " seconds");

        //--- 会输出3次
        TimeUnit.SECONDS.sleep(10);

        // jobs can be re-scheduled...
        // job 7 will run immediately and repeat 10 times for every second
        System.out.println("------- Rescheduling... --------------------");
        trigger = newTrigger().withIdentity("trigger7", "group1").startNow()
                .withSchedule(simpleSchedule().withIntervalInSeconds(1).withRepeatCount(3)).build();

        ft = sched.rescheduleJob(trigger.getKey(), trigger);
        System.out.println("job7 rescheduled to run at: " + DFUtil.format(ft));

        //--- 会输出4次
        TimeUnit.SECONDS.sleep(4);

        // display some stats about the schedule that just ran
        SchedulerMetaData metaData = sched.getMetaData();
        System.out.println("Executed " + metaData.getNumberOfJobsExecuted() + " jobs.");


    }


    /**
     * 如果只需要触发一次，trigger都不用生成
     * sched.triggerJob
     */
    @Test
    public void job8() throws SchedulerException, InterruptedException {

        // jobs can be fired directly... (rather than waiting for a trigger)
        JobDetail job = newJob(SimpleJob.class).withIdentity("job8", "group1").storeDurably().build();

        sched.addJob(job, true);

        System.out.println("'Manually' triggering job8...");
        sched.triggerJob(jobKey("job8", "group1"));

    }



}
