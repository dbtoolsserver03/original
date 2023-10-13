package com.ph.share.share.quartz.jobconfig;

import com.ph.share.share.quartz.job.SpringJob1;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

//@Component
public class JobClusterPartitionInit {


    @Value("${spring.quartz.properties.org.quartz.scheduler.instanceName}")
    private String instanceName;


    @Autowired
    private Scheduler scheduler;

    @PostConstruct
    public void initjob() throws SchedulerException {
        /**
         * JobInitController{
         *      @PostMapping
         *     init_20200830(String token){
         *      // 新增、修改、移除 job
         *     }
         *
         *     init_20200910(String token){
         *      // 新增、修改、移除 job
         *     }
         * }
         */

        System.out.println("=-=-=-" + scheduler.getMetaData().getThreadPoolSize());

        startSpringJob("job-2", "trigger-2", "OrderService-1");
        startSpringJob("job-3", "trigger-3", "OrderService-2");
        startSpringJob("job-1", "trigger-1", "OrderService-1");
    }

    private void startSpringJob(String jobName, String triggerName, String partition) throws SchedulerException {
        //        String instanceName = scheduler.getMetaData().getSchedulerName();
        if (!instanceName.equals(partition)) {
            return;
        }
        JobDetail detail = JobBuilder.newJob(SpringJob1.class)
                .usingJobData("partition", partition)
                .withIdentity(jobName)
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(triggerName)
                .startNow()
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5))
                .build();


        scheduler.scheduleJob(detail, trigger);
//        scheduler.scheduleJob(detail,Set.of(trigger),true);
    }

}
