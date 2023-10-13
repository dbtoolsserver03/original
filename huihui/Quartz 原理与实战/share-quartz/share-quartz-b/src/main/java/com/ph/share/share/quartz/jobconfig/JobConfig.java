package com.ph.share.share.quartz.jobconfig;

import com.ph.share.share.quartz.job.SpringJob1;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

//@Configuration
public class JobConfig {
//
//    @Bean
//    @QuartzDataSource
//    public DataSource qdataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUsername("");
//        dataSource.setPassword("");
//        dataSource.setUrl("");
//        return dataSource;
//    }

    @Bean
    public JobDetail springJob1Detail() {
        return JobBuilder.newJob(SpringJob1.class)
                .withIdentity("springJob1Detail")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger springJob1Trigger() {
        return TriggerBuilder.newTrigger()
                .forJob("springJob1Detail")
                .startNow()
                .build();
    }
}
