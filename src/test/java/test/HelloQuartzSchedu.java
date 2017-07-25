package test;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;

import java.text.ParseException;

/**
 * Created by Administrator on 2017-7-24.
 */
public class HelloQuartzSchedu {
    public static void main(String[] args) throws SchedulerException, ParseException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        JobDetail jobDetail = JobBuilder.newJob(HelloQuartz.class).withIdentity("hello", Scheduler.DEFAULT_GROUP).build();
        String cronExpression = "30/5 * * * * ?";
        CronTrigger trigger = new CronTriggerImpl("crontrigger", Scheduler.DEFAULT_GROUP, cronExpression);

        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }
}
