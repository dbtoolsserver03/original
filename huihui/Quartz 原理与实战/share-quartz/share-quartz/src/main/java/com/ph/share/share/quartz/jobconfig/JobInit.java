package com.ph.share.share.quartz.jobconfig;

import com.ph.share.share.quartz.job.SpringJob1;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Component
public class JobInit {

    @Autowired
    public Scheduler scheduler;

    @PostConstruct
    public void initjob() throws SchedulerException {
        System.out.println("=-=-=-"+scheduler.getMetaData().getThreadPoolSize());

        JobDetail detail = JobBuilder.newJob(SpringJob1.class)
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .startNow()
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5))
                .build();

        scheduler.scheduleJob(detail, trigger);
    }

}
