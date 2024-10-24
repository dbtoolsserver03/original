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

package com.ph.share.share.quartz.examples.example8;

import com.ph.share.share.quartz.tools.DFUtil;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;
import org.quartz.impl.calendar.DailyCalendar;
import org.quartz.impl.calendar.HolidayCalendar;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.quartz.DateBuilder.dateOf;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * This example will demonstrate how calendars can be used to exclude periods of time when scheduling should not take
 * place.
 */
public class CalendarExample {

    public void run() throws Exception {

        System.out.println("------- Initializing ----------------------");

        // First we must get a reference to a scheduler
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();

        System.out.println("------- Initialization Complete -----------");

        System.out.println("------- Scheduling Jobs -------------------");

//        HolidayCalendar holidayCalendar = new HolidayCalendar();
//        Calendar instance = Calendar.getInstance();
//        instance.set(2020,3,4);
//        holidayCalendar.addExcludedDate(instance.getTime());

        // Add the holiday calendar to the schedule
        AnnualCalendar holidays = new AnnualCalendar();


        // fourth of July (July 4)
        Calendar fourthOfJuly = new GregorianCalendar(2005, 6, 4);
        holidays.setDayExcluded(fourthOfJuly, true);
        // halloween (Oct 31)
        Calendar halloween = new GregorianCalendar(2005, 9, 31);  // 2005-10-31
        holidays.setDayExcluded(halloween, true);
        // christmas (Dec 25)
        Calendar christmas = new GregorianCalendar(2005, 11, 25);
        holidays.setDayExcluded(christmas, true);

        // tell the schedule about our holiday calendar
        sched.addCalendar("holidays", holidays, false, false);

        // schedule a job to run hourly, starting on halloween
        // at 10 am
        // xxxx-10-31
        Date runDate = dateOf(0, 0, 10, 31, 10);

        JobDetail job = newJob(SimpleJob.class).withIdentity("job1", "group1").build();

        SimpleTrigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runDate)
                .withSchedule(simpleSchedule().withIntervalInHours(1).repeatForever())
                .modifiedByCalendar("holidays").build();

        // schedule the job and print the first run date
        Date firstRunTime = sched.scheduleJob(job, trigger);

        // print out the first execution date.
        // Note: Since Halloween (Oct 31) is a holiday, then
        // we will not run until the next day! (Nov 1)
        System.out.println(job.getKey() + " will run at: " + DFUtil.format(firstRunTime) + " and repeat: " + trigger.getRepeatCount()
                + " times, every " + trigger.getRepeatInterval() / 1000 + " seconds");

        // All of the jobs have been added to the scheduler, but none of the jobs
        // will run until the scheduler has been started
        System.out.println("------- Starting Scheduler ----------------");
        sched.start();

        // wait 30 seconds:
        // note: nothing will run
        System.out.println("------- Waiting 30 seconds... --------------");
        try {
            // wait 30 seconds to show jobs
            Thread.sleep(30L * 1000L);
            // executing...
        } catch (Exception e) {
            //
        }

        // shut down the scheduler
        System.out.println("------- Shutting Down ---------------------");
        sched.shutdown(true);
        System.out.println("------- Shutdown Complete -----------------");

        SchedulerMetaData metaData = sched.getMetaData();
        System.out.println("Executed " + metaData.getNumberOfJobsExecuted() + " jobs.");

    }

    public static void main(String[] args) throws Exception {

        CalendarExample example = new CalendarExample();
        example.run();
    }

}
