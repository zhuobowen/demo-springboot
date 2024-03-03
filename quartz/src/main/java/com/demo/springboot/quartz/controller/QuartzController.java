package com.demo.springboot.quartz.controller;

import lombok.RequiredArgsConstructor;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/quartz")
@RequiredArgsConstructor
public class QuartzController {

    private final Scheduler scheduler;

    @PostMapping("add")
    public JobKey add() throws Exception {
        String jobId = UUID.randomUUID().toString();
        String jobGroup = UUID.randomUUID().toString();
        Class job = Class.forName("com.demo.springboot.quartz.job.SimpleJob");
        JobDetail jobDetail = JobBuilder
                .newJob(job)
                .withIdentity(jobId, jobGroup)
                .build();
        jobDetail.getJobDataMap().put("jobId", jobId);
        jobDetail.getJobDataMap().put("jobGroup", jobGroup);
        // 表达式调度构建器（可判断创建SimpleScheduleBuilder）
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("00 0/1 * ? * * *");
        // 按新的cronExpression表达式构建一个新的trigger
        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(jobId, jobGroup).withSchedule(scheduleBuilder).build();
        // 设置job
        scheduler.scheduleJob(jobDetail, trigger);
        return new JobKey(jobId, jobGroup);
    }
    
    @PostMapping("execute")
    public void execute() {
        
    }
}
