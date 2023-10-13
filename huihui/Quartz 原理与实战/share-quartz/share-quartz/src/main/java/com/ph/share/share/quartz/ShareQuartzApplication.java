package com.ph.share.share.quartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.StringJoiner;

@SpringBootApplication
public class ShareQuartzApplication {
    @Autowired
    private Scheduler scheduler;

    @Value("${spring.quartz.properties.org.quartz.scheduler.instanceId}")
    private String sInstanceId;

    @PostConstruct
    public void printInstanceId() {
        String instanceName = "";
        String instanceId = "";
        try {
            instanceName = scheduler.getMetaData().getSchedulerName();
            instanceId = scheduler.getMetaData().getSchedulerInstanceId();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        System.out.println(
                new StringJoiner(" | ")
                        .add("=================")
                        .add(sInstanceId)
                        .add(instanceName)
                        .add(instanceId)
        );
    }

    public static void main(String[] args) {
        SpringApplication.run(ShareQuartzApplication.class, args);
    }

}
