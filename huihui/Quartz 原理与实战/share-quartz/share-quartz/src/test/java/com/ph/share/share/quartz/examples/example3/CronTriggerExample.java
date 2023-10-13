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

package com.ph.share.share.quartz.examples.example3;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import com.ph.share.share.quartz.tools.DFUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * This Example will demonstrate all of the basics of scheduling capabilities of Quartz using Cron Triggers.
 *
 * org.quartz.CronTrigger
 *
 * @author Bill Kratzer
 */
public class CronTriggerExample {
    private static SchedulerFactory sf = new StdSchedulerFactory();
    private static Scheduler sched;

    @BeforeAll
    public static void beforeClass() throws SchedulerException {
        sched = sf.getScheduler();
        sched.start();
    }


    @Test
    public void job1() throws SchedulerException, InterruptedException {
        // job 1 will run every 20 seconds
        JobDetail job = newJob(SimpleJob.class).withIdentity("job1", "group1").build();

        CronTrigger trigger = newTrigger().withIdentity("trigger1", "group1").withSchedule(cronSchedule("0/20 * * * * ?"))
                .build();

        Date ft = sched.scheduleJob(job, trigger);
        System.out.println(job.getKey() + " has been scheduled to run at: " + DFUtil.format(ft) + " and repeat based on expression: "
                + trigger.getCronExpression());

        TimeUnit.MINUTES.sleep(1);
    }

    @Test
    public void job2() throws SchedulerException {
        // job 2 will run every other minute (at 15 seconds past the minute)
        JobDetail job = newJob(SimpleJob.class).withIdentity("job2", "group1").build();

        CronTrigger trigger = newTrigger().withIdentity("trigger2", "group1").withSchedule(cronSchedule("15 0/2 * * * ?")).build();

        Date ft = sched.scheduleJob(job, trigger);
        System.out.println(job.getKey() + " has been scheduled to run at: " + DFUtil.format(ft) + " and repeat based on expression: "
                + trigger.getCronExpression());
    }

    @Test
    public void job3() throws SchedulerException {
        // job 3 will run every other minute but only between 8am and 5pm
        JobDetail job = newJob(SimpleJob.class).withIdentity("job3", "group1").build();

        CronTrigger trigger = newTrigger().withIdentity("trigger3", "group1").withSchedule(cronSchedule("0 0/2 8-17 * * ?")).build();

        Date ft = sched.scheduleJob(job, trigger);
        System.out.println(job.getKey() + " has been scheduled to run at: " + DFUtil.format(ft) + " and repeat based on expression: "
                + trigger.getCronExpression());
    }

    @Test
    public void job4() throws SchedulerException {
        // job 4 will run every three minutes but only between 5pm and 11pm
        JobDetail job = newJob(SimpleJob.class).withIdentity("job4", "group1").build();

        CronTrigger trigger = newTrigger().withIdentity("trigger4", "group1").withSchedule(cronSchedule("0 0/3 17-23 * * ?")).build();

        Date ft = sched.scheduleJob(job, trigger);
        System.out.println(job.getKey() + " has been scheduled to run at: " + DFUtil.format(ft) + " and repeat based on expression: "
                + trigger.getCronExpression());
    }

    @Test
    public void job5() throws SchedulerException {
        // job 5 will run at 10am on the 1st and 15th days of the month
        JobDetail job = newJob(SimpleJob.class).withIdentity("job5", "group1").build();

        CronTrigger trigger = newTrigger().withIdentity("trigger5", "group1").withSchedule(cronSchedule("0 0 10am 1,15 * ?")).build();

        Date ft = sched.scheduleJob(job, trigger);
        System.out.println(job.getKey() + " has been scheduled to run at: " + DFUtil.format(ft) + " and repeat based on expression: "
                + trigger.getCronExpression());
    }

    @Test
    public void job6() throws SchedulerException {
        // job 6 will run every 30 seconds but only on Weekdays (Monday through Friday)
        JobDetail job = newJob(SimpleJob.class).withIdentity("job6", "group1").build();

        CronTrigger trigger = newTrigger().withIdentity("trigger6", "group1").withSchedule(cronSchedule("0,30 * * ? * MON-FRI"))
                .build();

        Date ft = sched.scheduleJob(job, trigger);
        System.out.println(job.getKey() + " has been scheduled to run at: " + DFUtil.format(ft) + " and repeat based on expression: "
                + trigger.getCronExpression());

    }

    @Test
    public void job7() throws SchedulerException {
        // job 7 will run every 30 seconds but only on Weekends (Saturday and Sunday)
        JobDetail job = newJob(SimpleJob.class).withIdentity("job7", "group1").build();

        CronTrigger trigger = newTrigger().withIdentity("trigger7", "group1").withSchedule(cronSchedule("0,30 * * ? * SAT,SUN"))
                .build();

        Date ft = sched.scheduleJob(job, trigger);
        System.out.println(job.getKey() + " has been scheduled to run at: " + DFUtil.format(ft) + " and repeat based on expression: "
                + trigger.getCronExpression());
    }


}
