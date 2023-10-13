package com.ph.share.share.quartz.jobconfig;

import com.ph.share.share.quartz.job.SpringJob1;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Set;

//@Component
public class JobClusterInit {

    @Autowired
    private Scheduler scheduler;

    @PostConstruct
    public void initjob() throws SchedulerException {

        System.out.println("=-=-=-" + scheduler.getMetaData().getThreadPoolSize());

        startSpringJob("job-2", "trigger-2");
        startSpringJob("job-3", "trigger-3");
        startSpringJob("job-1", "trigger-1");
    }

    private void startSpringJob(String jobName, String triggerName) throws SchedulerException {

        JobDetail detail = JobBuilder.newJob(SpringJob1.class)
                .usingJobData("key0","b")
                .withIdentity(jobName)
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(triggerName)
                .startNow()
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5))
                .build();


        scheduler.scheduleJob(detail, trigger);
    }

}
