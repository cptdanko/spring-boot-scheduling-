package com.mydaytodo.scheduling.service;

import com.mydaytodo.scheduling.model.PrintTask;
import com.mydaytodo.scheduling.model.Schedule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

@Service
@Slf4j
public class ScheduleService {

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * For now, set schedule to 10 seconds in the future
     * @param schedule
     * @return
     */
    public Object setSchedule(Schedule schedule) throws ParseException {
        log.info("Received a request to set schedule");
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, 20);
        // schedule.setScheduleDate(cal.getTime());
        ThreadPoolTaskScheduler taskScheduler = applicationContext.getBean(ThreadPoolTaskScheduler.class);
        var printTask = PrintTask.builder()
                        .schedule(schedule)
                                .build();
        log.info("About to set schedule for {} ", cal.getTime().toInstant().toString());
        taskScheduler.schedule(printTask, schedule.scheduleToDate().toInstant());
        log.info("Task scheduled");
        return printTask;
    }
}