package com.langfeiyes.batch._15_job_start_restful;

import org.springframework.batch.core.*;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Map;
import java.util.Properties;

//@RestController
public class HelloController {
    @Autowired
    private JobLauncher launcher;

    @Autowired
    private Job job;

    @Autowired
    private JobExplorer jobExplorer;  //job相关对象的-展示对象

    //@GetMapping("/job/start")
    public ExitStatus startJob(String name) throws Exception {

        //run.id 自增前提：先获取到之前jobparameter中run.id 才能进行自增
        // 也就是说， 当前请求想要让run.id 自增，需要获取之前jobparameter才能加-

        //启动job作业
        JobParameters parameters = new JobParametersBuilder(jobExplorer)
                .getNextJobParameters(job)
                .addString("name", name)
                .toJobParameters();

        JobExecution jobExet = launcher.run(job, parameters);
        return jobExet.getExitStatus();
    }
}
